package com.KNops;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class VideoServiceTest {
    @InjectMocks
    private VideoService videoService;

    @Mock
    private VideoRepository videoRepository;



    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
    // Données de test
    long videoId = 1;
    String videoName = "example.mp4";
    String videoDescription = "Description de la vidéo";
    byte[] videoData = {1, 2, 3, 4, 5};
    MockMultipartFile file = new MockMultipartFile("file", "example.mp4", "video/mp4", videoData);

    Video myVideo = new Video(videoId,videoName , videoDescription, "video/mp4", new byte[]{1, 2, 3, 4, 5});


    @Test

    void uploadVideo() throws IOException {

        // Simuler la méthode findByName
        when(videoRepository.findByName(videoName)).thenReturn(Optional.empty());

        // Appeler la méthode uploadVideo
        videoService.uploadVideo(videoName, videoDescription, file);

        // Vérifier que save a été appelé avec les bonnes données
        verify(videoRepository, times(1)).save(any(Video.class));

        // Récupérer l'argument qui a été passé à save
        ArgumentCaptor<Video> videoArgumentCaptor = ArgumentCaptor.forClass(Video.class);
        verify(videoRepository).save(videoArgumentCaptor.capture());

        // Vérifier que les valeurs de l'objet capturé sont correctes
        Video savedVideo = videoArgumentCaptor.getValue();
        assertThat(savedVideo.getName()).isEqualTo(videoName);
        assertThat(savedVideo.getDescription()).isEqualTo(videoDescription);
        assertThat(savedVideo.getContentType()).isEqualTo("video/mp4");
        assertThat(savedVideo.getData()).isEqualTo(videoData);
    }

    @Test

    public void testUploadVideoWithDuplicateName() throws IOException {

        // Simuler la méthode findByName pour renvoyer un résultat existant
        when(videoRepository.findByName(videoName)).thenReturn(Optional.of(new Video()));

        // Vérifier que l'appel génère une exception IllegalArgumentException
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> videoService.uploadVideo(videoName, videoDescription, file))
                .withMessage("A video with the same name already exists.");

        // Vérifier que save n'a pas été appelé
        verify(videoRepository, never()).save(any(Video.class));
    }

    @Test
    void deleteVideoByIdIfExists() {



        when(videoRepository.findById(videoId)).thenReturn(Optional.of(myVideo));

        boolean result=videoService.deleteVideoById(videoId);

        verify(videoRepository,times(1)).delete(any(Video.class));

        // Récupérer l'argument qui a été passé à save
        ArgumentCaptor<Video> videoArgumentCaptor = ArgumentCaptor.forClass(Video.class);

        verify(videoRepository).delete(videoArgumentCaptor.capture());

        // Vérifier que les valeurs de l'objet capturé sont correctes
        Video deletedVideo = videoArgumentCaptor.getValue();
        assertThat(deletedVideo.getName()).isEqualTo(videoName);
        assertThat(deletedVideo.getId()).isEqualTo(videoId);
        assertThat(deletedVideo.getDescription()).isEqualTo(videoDescription);
        assertThat(deletedVideo.getContentType()).isEqualTo("video/mp4");
        assertThat(deletedVideo.getData()).isEqualTo(videoData);

    }

    @Test
    public void testDeleteVideoById_WhenVideoDoesNotExist_ShouldReturnFalse() {


        when(videoRepository.findById(videoId)).thenReturn(Optional.empty());

        // Act
        boolean result = videoService.deleteVideoById(videoId);

        // Assert
        assertFalse(result);
        verify(videoRepository, never()).delete(any());
    }
    @Test
    public void testGetVideo_WhenVideoExists_ShouldReturnVideoData() {



        when(videoRepository.findById(videoId)).thenReturn(Optional.of(myVideo));

        // Act
        ResponseEntity<byte[]> response = videoService.getVideo(videoId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("video/mp4", response.getHeaders().getContentType().toString());
        assertArrayEquals(new byte[] {1, 2, 3, 4, 5}, response.getBody());
    }

    @Test
    public void testGetVideo_WhenVideoDoesNotExist_ShouldReturnNotFound() {
        // Arrange


        when(videoRepository.findById(videoId)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<byte[]> response = videoService.getVideo(videoId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testUpdateVideo_ShouldUpdateVideo() throws IOException {
        // Arrange
        Long id = 1L;
        String newName = "New Video Name";
        String newDescription = "New Video Description";

        Video existingVideo = new Video();
        existingVideo.setId(id);
        existingVideo.setName("Old Name");
        existingVideo.setDescription("Old Description");

        MultipartFile newFile = mock(MultipartFile.class);
        when(newFile.getContentType()).thenReturn("video/mp4");
        when(newFile.getBytes()).thenReturn(new byte[0]);

        when(videoRepository.findById(id)).thenReturn(Optional.of(existingVideo));

        // Act
        boolean result = videoService.updateVideo(id, newName, newDescription, newFile);

        // Assert
        assertTrue(result);
        assertEquals(newName, existingVideo.getName());
        assertEquals(newDescription, existingVideo.getDescription());
        assertEquals("video/mp4", existingVideo.getContentType());
        assertArrayEquals(new byte[0], existingVideo.getData());
        verify(videoRepository, times(1)).save(existingVideo);
    }

    @Test
    public void testGetAllVideos_ShouldReturnListOfVideos() {


    videoService.getAllVideos();

    verify(videoRepository).findAll();
    }

    @Test
    public void testUpdateVideo_ShouldReturnFalseIfVideoNotFound() throws IOException {
        // Arrange
        MultipartFile newFile = mock(MultipartFile.class);

        when(videoRepository.findById(videoId)).thenReturn(Optional.empty());

        // Act
        boolean result = videoService.updateVideo(videoId, "New Name", "New Description", newFile);

        // Assert
        assertFalse(result);
        verify(videoRepository, never()).save(any(Video.class));
    }





}