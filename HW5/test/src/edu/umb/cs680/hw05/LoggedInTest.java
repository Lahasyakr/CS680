package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoggedInTest {
    private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outStream));
    }
    @Test
    public void verifyLoginFromLoginState() throws Exception {
        User userObj = new User("Lahasya", new EncryptedString("Lahasya"));
        SecurityContext ctx = new SecurityContext(userObj);
        ctx.changeState(LoggedIn.getInstance(ctx));
        ctx.login(userObj.getpwd());
        assertEquals("FirstTime Login  or Active user has been logged in !!", outStream.toString().trim());
        assertTrue(ctx.getState() == LoggedIn.getInstance(ctx));
    }

    @Test
    public void verifyAuthenticationFail() throws Exception {
        User userObj = new User("Lahasya", new EncryptedString("wrong Password"));
        SecurityContext ctx = new SecurityContext(userObj);
        ctx.login(userObj.getpwd());
         assertEquals("Authentication error\r\nError while authenticating the user, please try to login again!!", outStream.toString().trim());
         assertTrue(ctx.getState() == LoggedOut.getInstance(ctx));
    }

    @Test
    public void verifyLogoutFromLoginState() {
        User userObj = new User("Lahasya", new EncryptedString("Lahasya"));
        SecurityContext ctx = new SecurityContext(userObj);
        ctx.changeState(LoggedIn.getInstance(ctx));
        ctx.logout();
        assertEquals("User has been logged out!", outStream.toString().trim());
    }

}
