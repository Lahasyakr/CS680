package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoggedOutTest {
    private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outStream));
    }

    @Test
    public void verifyLoginfromLoggedOutState() throws Exception {
        User userObj = new User("Lahasya", new EncryptedString("Lahasya"));
        SecurityContext ctx = new SecurityContext(userObj);
        ctx.login(userObj.getpwd());
        assertEquals("User has been logged in from logout state!!", outStream.toString().trim());
        
    }

    @Test
    public void verifyLogoutfromLoggedOutState() {
        User userObj = new User("Lahasya", new EncryptedString("Lahasya"));
        SecurityContext ctx = new SecurityContext(userObj);
        ctx.logout();
        assertEquals("", outStream.toString().trim());
    }

}
