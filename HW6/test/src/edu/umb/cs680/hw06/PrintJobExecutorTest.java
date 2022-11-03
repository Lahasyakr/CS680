package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw06.Authentication.EncryptedString;
import edu.umb.cs680.hw06.Authentication.SecurityContext;
import edu.umb.cs680.hw06.Authentication.User;
import edu.umb.cs680.hw06.ModelABC.PrintJobExcecutorAbc;
import edu.umb.cs680.hw06.ModelXYZ.PrintJobExcecutorXyz;

public class PrintJobExecutorTest {
    private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outStream));
    }

    @Test
    public void verifyPrintingAbc_withoutAuthentication() throws Exception {
        User userObj = new User("Lahasya", new EncryptedString("Lahasya"));
        SecurityContext ctx = new SecurityContext(userObj);
        PrintJobExcecutorAbc printAbc = new PrintJobExcecutorAbc();
        printAbc.execute(new PrintJobExcecutorAbc(), userObj.getpwd(), ctx);
        assertEquals("Printing....!!", outStream.toString().trim());
    }

    @Test
    public void verifyPrintingofXyz_WithAuthenticationPass() throws Exception {
        User userObj = new User("Lahasya", new EncryptedString("Lahasya"));
        SecurityContext ctx = new SecurityContext(userObj);
        PrintJobExcecutorXyz printXyz = new PrintJobExcecutorXyz();
        printXyz.execute(new PrintJobExcecutorAbc(), userObj.getpwd(), ctx);
        assertEquals("User has been logged in successfully!!\r\nPrinting....!!",
                outStream.toString().trim());
    }

    @Test
    public void verifyPrintingofXyz_WithAuthenticationFail() throws Exception {
        User userObj = new User("Lahasya", new EncryptedString("Lahasya123"));
        SecurityContext ctx = new SecurityContext(userObj);
        PrintJobExcecutorXyz printXyz = new PrintJobExcecutorXyz();
        printXyz.execute(new PrintJobExcecutorAbc(), userObj.getpwd(), ctx);
        assertEquals("Authentication error\r\nError while authenticating the user, please try to login again!!",
                outStream.toString().trim());
    }
}
