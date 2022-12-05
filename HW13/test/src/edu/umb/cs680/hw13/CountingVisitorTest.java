
package edu.umb.cs680.hw13;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw13.fs.Directory;
import edu.umb.cs680.hw13.fs.File;
import edu.umb.cs680.hw13.fs.Link;
import edu.umb.cs680.hw13.fs.util.CountingVisitor;

public class CountingVisitorTest {
    static Directory root;
    static Directory home;
    static Directory Apps;
    static Directory code;
    static LocalDateTime localTime = LocalDateTime.now();

    @BeforeAll
    public static void setupTest() {

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
    public void verifyDirectoryCountInRoot() {
        CountingVisitor visitor = new CountingVisitor();
        root.accept(visitor);

        assertSame(4, visitor.getDirNum());
    }

    @Test
    public void verifyFilesCountInRoot() {
        CountingVisitor visitor = new CountingVisitor();
        root.accept(visitor);
        assertSame(4, visitor.getFileNum());
    }

    @Test
    public void verifyLinksCountInRoot() {
        CountingVisitor visitor = new CountingVisitor();
        root.accept(visitor);
        assertSame(2, visitor.getLinkNum());
    }

    // Checking for "home" directories as well
    @Test
    public void verifyDirectoryCountInHome() {
        CountingVisitor visitor = new CountingVisitor();
        home.accept(visitor);
        assertSame(2, visitor.getDirNum());
    }

    @Test
    public void verifyFilesCountInHome() {
        CountingVisitor visitor = new CountingVisitor();
        home.accept(visitor);
        assertSame(3, visitor.getFileNum());
    }

    @Test
    public void verifyLinksCountInHome() {
        CountingVisitor visitor = new CountingVisitor();
        home.accept(visitor);
        assertSame(2, visitor.getLinkNum());
    }

    // Checking for "code" directories as well
    @Test
    public void verifyDirectoryCountInCode() {
        CountingVisitor visitor = new CountingVisitor();
        code.accept(visitor);
        assertSame(1, visitor.getDirNum());
    }

    @Test
    public void verifyFilesCountInCode() {
        CountingVisitor visitor = new CountingVisitor();
        code.accept(visitor);
        assertSame(2, visitor.getFileNum());
    }

    @Test
    public void verifyLinksCountInCode() {
        CountingVisitor visitor = new CountingVisitor();
        code.accept(visitor);
        assertSame(1, visitor.getLinkNum());
    }

}
