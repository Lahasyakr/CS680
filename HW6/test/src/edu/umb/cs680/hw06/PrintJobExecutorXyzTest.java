package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw06.Authentication.*;
import edu.umb.cs680.hw06.ModelXYZ.*;

public class PrintJobExecutorXyzTest {
    private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outStream));
    }

    @Test
    public void verifyPrintingofXyz_WithAuthenticationPass() throws Exception {
        User userObj = new User("Lahasya", new EncryptedString("Lahasya"));
        PrintJob job = new PrintJob("Print This");
        SecurityContext ctx = new SecurityContext(userObj);
        PrintJobExcecutor printXyz = new PrintJobExcecutor();
        printXyz.execute(job, userObj.getpwd(), ctx);
        assertEquals(
                "User has been logged in successfully!!\r\nPrinting....!!, given printjob has been completed-version XYZ",
                outStream.toString().trim());
    }

    @Test
    public void verifyPrintingofXyz_WithAuthenticationFail() throws Exception {
        User userObj = new User("Lahasya", new EncryptedString("Lahasya123"));
        SecurityContext ctx = new SecurityContext(userObj);
        PrintJobExcecutor printXyz = new PrintJobExcecutor();
        PrintJob job = new PrintJob("Print This");
        printXyz.execute(job, userObj.getpwd(), ctx);
        assertEquals("Authentication error\r\nError while authenticating the user, please try to login again!!",
                outStream.toString().trim());
    }

}
