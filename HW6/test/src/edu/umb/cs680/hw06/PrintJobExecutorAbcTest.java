package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw06.Authentication.*;
import edu.umb.cs680.hw06.ModelABC.*;

public class PrintJobExecutorAbcTest {
    private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outStream));
    }

    @Test
    public void verifyPrintingAbc_withoutAuthentication() throws Exception {
        User userObj = new User("Lahasya", new EncryptedString("Lahasya"));
        PrintJob job = new PrintJob("print this");
        SecurityContext ctx = new SecurityContext(userObj);
        PrintJobExcecutor printAbc = new PrintJobExcecutor();
        printAbc.execute(job, userObj.getpwd(), ctx);
        assertEquals("Printing....!!, given printjob has been completed-version ABC", outStream.toString().trim());
    }
}
