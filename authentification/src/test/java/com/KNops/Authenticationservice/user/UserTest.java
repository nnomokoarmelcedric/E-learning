package com.KNops.Authenticationservice.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;

class UserTest {
    /**
     * Method under test: {@link User#getAuthorities()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAuthorities() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.KNops.Authenticationservice.user.Role.name()" because "this.role" is null
        //       at com.KNops.Authenticationservice.user.User.getAuthorities(User.java:41)
        //   See https://diff.blue/R013 to resolve this issue.

        (new User()).getAuthorities();
    }

    /**
     * Method under test: {@link User#getAuthorities()}
     */
    @Test
    void testGetAuthorities2() {
        User user = new User();
        user.setRole(Role.ADMIN);
        Collection<? extends GrantedAuthority> actualAuthorities = user.getAuthorities();
        assertEquals(1, actualAuthorities.size());
        assertEquals("ADMIN", ((List<? extends GrantedAuthority>) actualAuthorities).get(0).getAuthority());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#User()}
     *   <li>{@link User#getPassword()}
     *   <li>{@link User#getUsername()}
     *   <li>{@link User#isAccountNonExpired()}
     *   <li>{@link User#isAccountNonLocked()}
     *   <li>{@link User#isCredentialsNonExpired()}
     *   <li>{@link User#isEnabled()}
     * </ul>
     */
    @Test
    void testConstructor() {
        User actualUser = new User();
        assertNull(actualUser.getPassword());
        assertNull(actualUser.getUsername());
        assertTrue(actualUser.isAccountNonExpired());
        assertTrue(actualUser.isAccountNonLocked());
        assertTrue(actualUser.isCredentialsNonExpired());
        assertTrue(actualUser.isEnabled());
    }
}

