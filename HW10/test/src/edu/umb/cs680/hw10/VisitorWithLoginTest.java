
package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import javax.naming.AuthenticationException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw10.Authentication.EncryptedString;
import edu.umb.cs680.hw10.Authentication.LoggedOut;
import edu.umb.cs680.hw10.Authentication.SecurityContext;
import edu.umb.cs680.hw10.Authentication.User;
import edu.umb.cs680.hw10.fs.Directory;
import edu.umb.cs680.hw10.fs.File;
import edu.umb.cs680.hw10.fs.Link;
import edu.umb.cs680.hw10.fs.util.CountingVisitor;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class VisitorWithLoginTest {
    static Directory root;
    static Directory home;
    static Directory Apps;
    static Directory code;
    static LocalDateTime localTime = LocalDateTime.now();
    static SecurityContext ctx;

    private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outStream));
    }

    @BeforeAll
    public static void setupTest() throws Exception {
        User userObj = new User("Lahasya", new EncryptedString("Lahasya"));
        ctx = new SecurityContext(userObj);
        ctx.login(userObj.getpwd());

        // Directories
        root = new Directory(null, "root", 0, localTime);
        Apps = new Directory(root, "Apps", 0, localTime);
        home = new Directory(root, "home", 0, localTime);
        code = new Directory(home, "code", 0, localTime);
        // Files
        File a = new File(Apps, "a", 2, localTime);
        File b = new File(home, "b", 2, localTime);
        File c = new File(code, "c", 2, localTime);
        File d = new File(code, "d", 2, localTime);
        // Link
        Link x = new Link(home, "x", 1, localTime, Apps);
        Link y = new Link(code, "y", 1, localTime, a);

    }

    @Test
    public void testingForUnActiveUser() throws Exception {
        SecurityContext ctx2 = new SecurityContext(new User("Lahasya", new EncryptedString("xxx")));
        ctx2.changeState(LoggedOut.getInstance(ctx));
        try {
            CountingVisitor visitor = new CountingVisitor();
            root.accept(visitor, ctx2);
        } catch (AuthenticationException e) {
            System.out.println(e.getMessage());
        }
        assertEquals("Error..please login again!", outStream.toString().trim());
    }

    @Test
    public void verifyDirectoryCountInRoot() throws Exception {
        CountingVisitor visitor = new CountingVisitor();
        try {
            root.accept(visitor, ctx);
        } catch (AuthenticationException e) {
            System.out.println(e);
        }
        assertSame(4, visitor.getDirNum());
    }

    @Test
    public void verifyFilesCountInRoot() throws Exception {
        CountingVisitor visitor = new CountingVisitor();
        try {
            root.accept(visitor, ctx);
        } catch (AuthenticationException e) {
            System.out.println(e);
        }
        assertSame(4, visitor.getFileNum());
    }

    @Test
    public void verifyLinksCountInRoot() throws Exception {
        CountingVisitor visitor = new CountingVisitor();
        try {
            root.accept(visitor, ctx);
        } catch (AuthenticationException e) {
            System.out.println(e);
        }
        assertSame(2, visitor.getLinkNum());
    }

    // Checking for "home" directories as well
    @Test
    public void verifyDirectoryCountInHome() throws Exception {
        CountingVisitor visitor = new CountingVisitor();
        try {
            home.accept(visitor, ctx);
        } catch (AuthenticationException e) {
            System.out.println(e);
        }
        assertSame(2, visitor.getDirNum());
    }

    @Test
    public void verifyFilesCountInHome() throws Exception {
        CountingVisitor visitor = new CountingVisitor();
        try {
            home.accept(visitor, ctx);
        } catch (AuthenticationException e) {
            System.out.println(e);
        }
        assertSame(3, visitor.getFileNum());
    }

    @Test
    public void verifyLinksCountInHome() throws Exception {
        CountingVisitor visitor = new CountingVisitor();
        try {
            home.accept(visitor, ctx);
        } catch (AuthenticationException e) {
            System.out.println(e);
        }
        assertSame(2, visitor.getLinkNum());
    }

    // Checking for "code" directories as well
    @Test
    public void verifyDirectoryCountInCode() throws Exception {
        CountingVisitor visitor = new CountingVisitor();
        try {
            code.accept(visitor, ctx);
        } catch (AuthenticationException e) {
            System.out.println(e);
        }
        assertSame(1, visitor.getDirNum());
    }

    @Test
    public void verifyFilesCountInCode() throws Exception {
        CountingVisitor visitor = new CountingVisitor();
        try {
            code.accept(visitor, ctx);
        } catch (AuthenticationException e) {
            System.out.println(e);
        }
        assertSame(2, visitor.getFileNum());
    }

    @Test
    public void verifyLinksCountInCode() throws Exception {
        CountingVisitor visitor = new CountingVisitor();
        try {
            code.accept(visitor, ctx);
        } catch (AuthenticationException e) {
            System.out.println(e);
        }
        assertSame(1, visitor.getLinkNum());
    }

}
