package com.KNops.Authenticationservice.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AuthenticationRequestTest {
    /**
     * Method under test: {@link AuthenticationRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new AuthenticationRequest("jane.doe@example.org", "iloveyou")).canEqual("Other"));
    }

    /**
     * Method under test: {@link AuthenticationRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest("jane.doe@example.org", "iloveyou");
        assertTrue(authenticationRequest.canEqual(new AuthenticationRequest("jane.doe@example.org", "iloveyou")));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuthenticationRequest#AuthenticationRequest()}
     *   <li>{@link AuthenticationRequest#setEmail(String)}
     *   <li>{@link AuthenticationRequest#setPassword(String)}
     *   <li>{@link AuthenticationRequest#toString()}
     *   <li>{@link AuthenticationRequest#getEmail()}
     *   <li>{@link AuthenticationRequest#getPassword()}
     * </ul>
     */
    @Test
    void testConstructor() {
        AuthenticationRequest actualAuthenticationRequest = new AuthenticationRequest();
        actualAuthenticationRequest.setEmail("jane.doe@example.org");
        actualAuthenticationRequest.setPassword("iloveyou");
        String actualToStringResult = actualAuthenticationRequest.toString();
        assertEquals("jane.doe@example.org", actualAuthenticationRequest.getEmail());
        assertEquals("iloveyou", actualAuthenticationRequest.getPassword());
        assertEquals("AuthenticationRequest(email=jane.doe@example.org, password=iloveyou)", actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuthenticationRequest#AuthenticationRequest(String, String)}
     *   <li>{@link AuthenticationRequest#setEmail(String)}
     *   <li>{@link AuthenticationRequest#setPassword(String)}
     *   <li>{@link AuthenticationRequest#toString()}
     *   <li>{@link AuthenticationRequest#getEmail()}
     *   <li>{@link AuthenticationRequest#getPassword()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        AuthenticationRequest actualAuthenticationRequest = new AuthenticationRequest("jane.doe@example.org", "iloveyou");
        actualAuthenticationRequest.setEmail("jane.doe@example.org");
        actualAuthenticationRequest.setPassword("iloveyou");
        String actualToStringResult = actualAuthenticationRequest.toString();
        assertEquals("jane.doe@example.org", actualAuthenticationRequest.getEmail());
        assertEquals("iloveyou", actualAuthenticationRequest.getPassword());
        assertEquals("AuthenticationRequest(email=jane.doe@example.org, password=iloveyou)", actualToStringResult);
    }

    /**
     * Method under test: {@link AuthenticationRequest#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new AuthenticationRequest("jane.doe@example.org", "iloveyou"), null);
        assertNotEquals(new AuthenticationRequest("jane.doe@example.org", "iloveyou"),
                "Different type to AuthenticationRequest");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuthenticationRequest#equals(Object)}
     *   <li>{@link AuthenticationRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest("jane.doe@example.org", "iloveyou");
        assertEquals(authenticationRequest, authenticationRequest);
        int expectedHashCodeResult = authenticationRequest.hashCode();
        assertEquals(expectedHashCodeResult, authenticationRequest.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuthenticationRequest#equals(Object)}
     *   <li>{@link AuthenticationRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest("jane.doe@example.org", "iloveyou");
        AuthenticationRequest authenticationRequest1 = new AuthenticationRequest("jane.doe@example.org", "iloveyou");

        assertEquals(authenticationRequest, authenticationRequest1);
        int expectedHashCodeResult = authenticationRequest.hashCode();
        assertEquals(expectedHashCodeResult, authenticationRequest1.hashCode());
    }

    /**
     * Method under test: {@link AuthenticationRequest#equals(Object)}
     */
    @Test
    void testEquals4() {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest("john.smith@example.org", "iloveyou");
        assertNotEquals(authenticationRequest, new AuthenticationRequest("jane.doe@example.org", "iloveyou"));
    }

    /**
     * Method under test: {@link AuthenticationRequest#equals(Object)}
     */
    @Test
    void testEquals5() {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest(null, "iloveyou");
        assertNotEquals(authenticationRequest, new AuthenticationRequest("jane.doe@example.org", "iloveyou"));
    }

    /**
     * Method under test: {@link AuthenticationRequest#equals(Object)}
     */
    @Test
    void testEquals6() {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest("jane.doe@example.org",
                "jane.doe@example.org");
        assertNotEquals(authenticationRequest, new AuthenticationRequest("jane.doe@example.org", "iloveyou"));
    }

    /**
     * Method under test: {@link AuthenticationRequest#equals(Object)}
     */
    @Test
    void testEquals7() {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest("jane.doe@example.org", null);
        assertNotEquals(authenticationRequest, new AuthenticationRequest("jane.doe@example.org", "iloveyou"));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuthenticationRequest#equals(Object)}
     *   <li>{@link AuthenticationRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals8() {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest(null, "iloveyou");
        AuthenticationRequest authenticationRequest1 = new AuthenticationRequest(null, "iloveyou");

        assertEquals(authenticationRequest, authenticationRequest1);
        int expectedHashCodeResult = authenticationRequest.hashCode();
        assertEquals(expectedHashCodeResult, authenticationRequest1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuthenticationRequest#equals(Object)}
     *   <li>{@link AuthenticationRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals9() {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest("jane.doe@example.org", null);
        AuthenticationRequest authenticationRequest1 = new AuthenticationRequest("jane.doe@example.org", null);

        assertEquals(authenticationRequest, authenticationRequest1);
        int expectedHashCodeResult = authenticationRequest.hashCode();
        assertEquals(expectedHashCodeResult, authenticationRequest1.hashCode());
    }
}

