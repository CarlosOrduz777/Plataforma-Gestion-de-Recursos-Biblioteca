package edu.eci.cvds.security;

import com.github.sdorra.shiro.ShiroRule;
import com.github.sdorra.shiro.SubjectAware;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShiroUnitTest {
    /**
     * Test for Shiro
     * Equivalence domain(Authenticated - notAuthenticated)
     */
    @Test
    @SubjectAware(
            username = "adminECI@mail.com",
            password = "admin",
            configuration = "classpath:shiro.ini"
    )
    public void testMethodAuthenticated(){
        Subject subject = SecurityUtils.getSubject();
        assertTrue(subject.isAuthenticated());
    }
    @Test
    @SubjectAware(
            configuration = "classpath:shiro.ini"
    )
    public void testMethodnotAuthenticated(){
        assertFalse(SecurityUtils.getSubject().isAuthenticated());
    }
    /**
     * Test for Shiro
     * Equivalence domain(null - notnull)
     */
    @Test
    @SubjectAware(
            username = "adminECI@mail.com",
            password = "admin",
            configuration = "classpath:shiro.ini"
    )
    public void testMethodNotnull(){
        Subject subject = SecurityUtils.getSubject();
        assertNotNull(subject);
    }
    @Test
    @SubjectAware(
            configuration = "classpath:shiro.ini"
    )
    public void testMethodNull(){
        assertFalse(SecurityUtils.getSubject().isRunAs());
    }


    @Rule
    public ShiroRule rule = new ShiroRule();
}