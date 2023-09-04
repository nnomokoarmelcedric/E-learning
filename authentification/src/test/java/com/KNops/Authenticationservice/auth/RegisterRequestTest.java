package com.KNops.Authenticationservice.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.KNops.Authenticationservice.user.Role;
import org.junit.jupiter.api.Test;

class RegisterRequestTest {
    /**
     * Method under test: {@link RegisterRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new RegisterRequest("Jane", "Doe", "jane.doe@example.org", "iloveyou", Role.ADMIN)).canEqual("Other"));
    }

    /**
     * Method under test: {@link RegisterRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        RegisterRequest registerRequest = new RegisterRequest("Jane", "Doe", "jane.doe@example.org", "iloveyou",
                Role.ADMIN);
        assertTrue(
                registerRequest.canEqual(new RegisterRequest("Jane", "Doe", "jane.doe@example.org", "iloveyou", Role.ADMIN)));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RegisterRequest#RegisterRequest()}
     *   <li>{@link RegisterRequest#setEmail(String)}
     *   <li>{@link RegisterRequest#setFirstname(String)}
     *   <li>{@link RegisterRequest#setLastname(String)}
     *   <li>{@link RegisterRequest#setPassword(String)}
     *   <li>{@link RegisterRequest#setRole(Role)}
     *   <li>{@link RegisterRequest#toString()}
     *   <li>{@link RegisterRequest#getEmail()}
     *   <li>{@link RegisterRequest#getFirstname()}
     *   <li>{@link RegisterRequest#getLastname()}
     *   <li>{@link RegisterRequest#getPassword()}
     *   <li>{@link RegisterRequest#getRole()}
     * </ul>
     */
    @Test
    void testConstructor() {
        RegisterRequest actualRegisterRequest = new RegisterRequest();
        actualRegisterRequest.setEmail("jane.doe@example.org");
        actualRegisterRequest.setFirstname("Jane");
        actualRegisterRequest.setLastname("Doe");
        actualRegisterRequest.setPassword("iloveyou");
        actualRegisterRequest.setRole(Role.ADMIN);
        String actualToStringResult = actualRegisterRequest.toString();
        assertEquals("jane.doe@example.org", actualRegisterRequest.getEmail());
        assertEquals("Jane", actualRegisterRequest.getFirstname());
        assertEquals("Doe", actualRegisterRequest.getLastname());
        assertEquals("iloveyou", actualRegisterRequest.getPassword());
        assertEquals(Role.ADMIN, actualRegisterRequest.getRole());
        assertEquals(
                "RegisterRequest(firstname=Jane, lastname=Doe, email=jane.doe@example.org, password=iloveyou," + " role=ADMIN)",
                actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RegisterRequest#RegisterRequest(String, String, String, String, Role)}
     *   <li>{@link RegisterRequest#setEmail(String)}
     *   <li>{@link RegisterRequest#setFirstname(String)}
     *   <li>{@link RegisterRequest#setLastname(String)}
     *   <li>{@link RegisterRequest#setPassword(String)}
     *   <li>{@link RegisterRequest#setRole(Role)}
     *   <li>{@link RegisterRequest#toString()}
     *   <li>{@link RegisterRequest#getEmail()}
     *   <li>{@link RegisterRequest#getFirstname()}
     *   <li>{@link RegisterRequest#getLastname()}
     *   <li>{@link RegisterRequest#getPassword()}
     *   <li>{@link RegisterRequest#getRole()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        RegisterRequest actualRegisterRequest = new RegisterRequest("Jane", "Doe", "jane.doe@example.org", "iloveyou",
                Role.ADMIN);
        actualRegisterRequest.setEmail("jane.doe@example.org");
        actualRegisterRequest.setFirstname("Jane");
        actualRegisterRequest.setLastname("Doe");
        actualRegisterRequest.setPassword("iloveyou");
        actualRegisterRequest.setRole(Role.ADMIN);
        String actualToStringResult = actualRegisterRequest.toString();
        assertEquals("jane.doe@example.org", actualRegisterRequest.getEmail());
        assertEquals("Jane", actualRegisterRequest.getFirstname());
        assertEquals("Doe", actualRegisterRequest.getLastname());
        assertEquals("iloveyou", actualRegisterRequest.getPassword());
        assertEquals(Role.ADMIN, actualRegisterRequest.getRole());
        assertEquals("RegisterRequest(firstname=Jane, lastname=Doe, email=jane.doe@example.org, password=iloveyou,"
                + " role=ADMIN)", actualToStringResult);
    }

    /**
     * Method under test: {@link RegisterRequest#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new RegisterRequest("Jane", "Doe", "jane.doe@example.org", "iloveyou", Role.ADMIN), null);
        assertNotEquals(new RegisterRequest("Jane", "Doe", "jane.doe@example.org", "iloveyou", Role.ADMIN),
                "Different type to RegisterRequest");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RegisterRequest#equals(Object)}
     *   <li>{@link RegisterRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        RegisterRequest registerRequest = new RegisterRequest("Jane", "Doe", "jane.doe@example.org", "iloveyou",
                Role.ADMIN);
        assertEquals(registerRequest, registerRequest);
        int expectedHashCodeResult = registerRequest.hashCode();
        assertEquals(expectedHashCodeResult, registerRequest.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RegisterRequest#equals(Object)}
     *   <li>{@link RegisterRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        RegisterRequest registerRequest = new RegisterRequest("Jane", "Doe", "jane.doe@example.org", "iloveyou",
                Role.ADMIN);
        RegisterRequest registerRequest1 = new RegisterRequest("Jane", "Doe", "jane.doe@example.org", "iloveyou",
                Role.ADMIN);

        assertEquals(registerRequest, registerRequest1);
        int expectedHashCodeResult = registerRequest.hashCode();
        assertEquals(expectedHashCodeResult, registerRequest1.hashCode());
    }

    /**
     * Method under test: {@link RegisterRequest#equals(Object)}
     */
    @Test
    void testEquals4() {
        RegisterRequest registerRequest = new RegisterRequest("John", "Doe", "jane.doe@example.org", "iloveyou",
                Role.ADMIN);
        assertNotEquals(registerRequest,
                new RegisterRequest("Jane", "Doe", "jane.doe@example.org", "iloveyou", Role.ADMIN));
    }

    /**
     * Method under test: {@link RegisterRequest#equals(Object)}
     */
    @Test
    void testEquals5() {
        RegisterRequest registerRequest = new RegisterRequest(null, "Doe", "jane.doe@example.org", "iloveyou",
                Role.ADMIN);
        assertNotEquals(registerRequest,
                new RegisterRequest("Jane", "Doe", "jane.doe@example.org", "iloveyou", Role.ADMIN));
    }

    /**
     * Method under test: {@link RegisterRequest#equals(Object)}
     */
    @Test
    void testEquals6() {
        RegisterRequest registerRequest = new RegisterRequest("Jane", "Smith", "jane.doe@example.org", "iloveyou",
                Role.ADMIN);
        assertNotEquals(registerRequest,
                new RegisterRequest("Jane", "Doe", "jane.doe@example.org", "iloveyou", Role.ADMIN));
    }

    /**
     * Method under test: {@link RegisterRequest#equals(Object)}
     */
    @Test
    void testEquals7() {
        RegisterRequest registerRequest = new RegisterRequest("Jane", null, "jane.doe@example.org", "iloveyou",
                Role.ADMIN);
        assertNotEquals(registerRequest,
                new RegisterRequest("Jane", "Doe", "jane.doe@example.org", "iloveyou", Role.ADMIN));
    }

    /**
     * Method under test: {@link RegisterRequest#equals(Object)}
     */
    @Test
    void testEquals8() {
        RegisterRequest registerRequest = new RegisterRequest("Jane", "Doe", "john.smith@example.org", "iloveyou",
                Role.ADMIN);
        assertNotEquals(registerRequest,
                new RegisterRequest("Jane", "Doe", "jane.doe@example.org", "iloveyou", Role.ADMIN));
    }

    /**
     * Method under test: {@link RegisterRequest#equals(Object)}
     */
    @Test
    void testEquals9() {
        RegisterRequest registerRequest = new RegisterRequest("Jane", "Doe", null, "iloveyou", Role.ADMIN);
        assertNotEquals(registerRequest,
                new RegisterRequest("Jane", "Doe", "jane.doe@example.org", "iloveyou", Role.ADMIN));
    }

    /**
     * Method under test: {@link RegisterRequest#equals(Object)}
     */
    @Test
    void testEquals10() {
        RegisterRequest registerRequest = new RegisterRequest("Jane", "Doe", "jane.doe@example.org", "Jane", Role.ADMIN);
        assertNotEquals(registerRequest,
                new RegisterRequest("Jane", "Doe", "jane.doe@example.org", "iloveyou", Role.ADMIN));
    }

    /**
     * Method under test: {@link RegisterRequest#equals(Object)}
     */
    @Test
    void testEquals11() {
        RegisterRequest registerRequest = new RegisterRequest("Jane", "Doe", "jane.doe@example.org", null, Role.ADMIN);
        assertNotEquals(registerRequest,
                new RegisterRequest("Jane", "Doe", "jane.doe@example.org", "iloveyou", Role.ADMIN));
    }

    /**
     * Method under test: {@link RegisterRequest#equals(Object)}
     */
    @Test
    void testEquals12() {
        RegisterRequest registerRequest = new RegisterRequest("Jane", "Doe", "jane.doe@example.org", "iloveyou", null);
        assertNotEquals(registerRequest,
                new RegisterRequest("Jane", "Doe", "jane.doe@example.org", "iloveyou", Role.ADMIN));
    }

    /**
     * Method under test: {@link RegisterRequest#equals(Object)}
     */
    @Test
    void testEquals13() {
        RegisterRequest registerRequest = new RegisterRequest("Jane", "Doe", "jane.doe@example.org", "iloveyou",
                Role.TEACHER);
        assertNotEquals(registerRequest,
                new RegisterRequest("Jane", "Doe", "jane.doe@example.org", "iloveyou", Role.ADMIN));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RegisterRequest#equals(Object)}
     *   <li>{@link RegisterRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals14() {
        RegisterRequest registerRequest = new RegisterRequest(null, "Doe", "jane.doe@example.org", "iloveyou",
                Role.ADMIN);
        RegisterRequest registerRequest1 = new RegisterRequest(null, "Doe", "jane.doe@example.org", "iloveyou",
                Role.ADMIN);

        assertEquals(registerRequest, registerRequest1);
        int expectedHashCodeResult = registerRequest.hashCode();
        assertEquals(expectedHashCodeResult, registerRequest1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RegisterRequest#equals(Object)}
     *   <li>{@link RegisterRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals15() {
        RegisterRequest registerRequest = new RegisterRequest("Jane", null, "jane.doe@example.org", "iloveyou",
                Role.ADMIN);
        RegisterRequest registerRequest1 = new RegisterRequest("Jane", null, "jane.doe@example.org", "iloveyou",
                Role.ADMIN);

        assertEquals(registerRequest, registerRequest1);
        int expectedHashCodeResult = registerRequest.hashCode();
        assertEquals(expectedHashCodeResult, registerRequest1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RegisterRequest#equals(Object)}
     *   <li>{@link RegisterRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals16() {
        RegisterRequest registerRequest = new RegisterRequest("Jane", "Doe", null, "iloveyou", Role.ADMIN);
        RegisterRequest registerRequest1 = new RegisterRequest("Jane", "Doe", null, "iloveyou", Role.ADMIN);

        assertEquals(registerRequest, registerRequest1);
        int expectedHashCodeResult = registerRequest.hashCode();
        assertEquals(expectedHashCodeResult, registerRequest1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link RegisterRequest#equals(Object)}
     *   <li>{@link RegisterRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals17() {
        RegisterRequest registerRequest = new RegisterRequest("Jane", "Doe", "jane.doe@example.org", null, Role.ADMIN);
        RegisterRequest registerRequest1 = new RegisterRequest("Jane", "Doe", "jane.doe@example.org", null, Role.ADMIN);

        assertEquals(registerRequest, registerRequest1);
        int expectedHashCodeResult = registerRequest.hashCode();
        assertEquals(expectedHashCodeResult, registerRequest1.hashCode());
    }
}

