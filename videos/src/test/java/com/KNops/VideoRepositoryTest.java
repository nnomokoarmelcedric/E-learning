package com.KNops;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
class VideoRepositoryTest {

    @Autowired
    private VideoRepository underTest;


    @AfterEach
    void tearDown(){
        underTest.deleteAll();
    }
    String videoName="video";
    @Test
    void checksThePresenceOfAVideo() {
        //given

        Video myVideo = new Video(videoName , "Description de ma vidéo", "video/mp4", new byte[]{1, 2, 3, 4, 5});
        underTest.save(myVideo);
        //when
        Optional<Video> expected = underTest.findByName(videoName);

        //then
        assertThat(expected).isPresent();
        Video expectedVideo = expected.get();
        assertThat(expectedVideo).isEqualTo(myVideo);
    }
}