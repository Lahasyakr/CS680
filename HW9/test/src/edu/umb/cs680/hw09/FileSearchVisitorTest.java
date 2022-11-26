package edu.umb.cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw09.fs.Directory;
import edu.umb.cs680.hw09.fs.File;
import edu.umb.cs680.hw09.fs.Link;
import edu.umb.cs680.hw09.fs.util.FileSearchVisitor;

public class FileSearchVisitorTest {
    static Directory root;

    @BeforeAll
    public static void setupTest() {
        LocalDateTime localTime = LocalDateTime.now();
        // Directories
        root = new Directory(null, "root", 0, localTime);
        Directory Apps = new Directory(root, "Apps", 0, localTime);
        Directory home = new Directory(root, "home", 0, localTime);
        Directory code = new Directory(home, "code", 0, localTime);
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
    public void verifyFileA() {
        FileSearchVisitor visitor = new FileSearchVisitor("a");
        root.accept(visitor);
        assertSame(1, visitor.getFoundFiles().size());
    }

    @Test
    public void testDirectory() {
        FileSearchVisitor visitor = new FileSearchVisitor("Apps");
        root.accept(visitor);
        assertSame(0, visitor.getFoundFiles().size());
    }

    @Test
    public void testLink() {
        FileSearchVisitor visitor = new FileSearchVisitor("x");
        root.accept(visitor);
        assertSame(0, visitor.getFoundFiles().size());
    }
}
