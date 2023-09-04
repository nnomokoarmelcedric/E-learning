package com.KNops.Authenticationservice.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AuthenticationResponseTest {
    /**
     * Method under test: {@link AuthenticationResponse#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new AuthenticationResponse("ABC123")).canEqual("Other"));
    }

    /**
     * Method under test: {@link AuthenticationResponse#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse("ABC123");
        assertTrue(authenticationResponse.canEqual(new AuthenticationResponse("ABC123")));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuthenticationResponse#AuthenticationResponse()}
     *   <li>{@link AuthenticationResponse#setToken(String)}
     *   <li>{@link AuthenticationResponse#toString()}
     *   <li>{@link AuthenticationResponse#getToken()}
     * </ul>
     */
    @Test
    void testConstructor() {
        AuthenticationResponse actualAuthenticationResponse = new AuthenticationResponse();
        actualAuthenticationResponse.setToken("ABC123");
        String actualToStringResult = actualAuthenticationResponse.toString();
        assertEquals("ABC123", actualAuthenticationResponse.getToken());
        assertEquals("AuthenticationResponse(token=ABC123)", actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuthenticationResponse#AuthenticationResponse(String)}
     *   <li>{@link AuthenticationResponse#setToken(String)}
     *   <li>{@link AuthenticationResponse#toString()}
     *   <li>{@link AuthenticationResponse#getToken()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        AuthenticationResponse actualAuthenticationResponse = new AuthenticationResponse("ABC123");
        actualAuthenticationResponse.setToken("ABC123");
        String actualToStringResult = actualAuthenticationResponse.toString();
        assertEquals("ABC123", actualAuthenticationResponse.getToken());
        assertEquals("AuthenticationResponse(token=ABC123)", actualToStringResult);
    }

    /**
     * Method under test: {@link AuthenticationResponse#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new AuthenticationResponse("ABC123"), null);
        assertNotEquals(new AuthenticationResponse("ABC123"), "Different type to AuthenticationResponse");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuthenticationResponse#equals(Object)}
     *   <li>{@link AuthenticationResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse("ABC123");
        assertEquals(authenticationResponse, authenticationResponse);
        int expectedHashCodeResult = authenticationResponse.hashCode();
        assertEquals(expectedHashCodeResult, authenticationResponse.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuthenticationResponse#equals(Object)}
     *   <li>{@link AuthenticationResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse("ABC123");
        AuthenticationResponse authenticationResponse1 = new AuthenticationResponse("ABC123");
        assertEquals(authenticationResponse, authenticationResponse1);
        int expectedHashCodeResult = authenticationResponse.hashCode();
        assertEquals(expectedHashCodeResult, authenticationResponse1.hashCode());
    }

    /**
     * Method under test: {@link AuthenticationResponse#equals(Object)}
     */
    @Test
    void testEquals4() {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse("Token");
        assertNotEquals(authenticationResponse, new AuthenticationResponse("ABC123"));
    }

    /**
     * Method under test: {@link AuthenticationResponse#equals(Object)}
     */
    @Test
    void testEquals5() {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse(null);
        assertNotEquals(authenticationResponse, new AuthenticationResponse("ABC123"));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuthenticationResponse#equals(Object)}
     *   <li>{@link AuthenticationResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals6() {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse(null);
        AuthenticationResponse authenticationResponse1 = new AuthenticationResponse(null);
        assertEquals(authenticationResponse, authenticationResponse1);
        int expectedHashCodeResult = authenticationResponse.hashCode();
        assertEquals(expectedHashCodeResult, authenticationResponse1.hashCode());
    }
}

