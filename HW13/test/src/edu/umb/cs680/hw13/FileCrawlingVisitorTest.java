package edu.umb.cs680.hw13;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw13.fs.Directory;
import edu.umb.cs680.hw13.fs.FSElement;
import edu.umb.cs680.hw13.fs.File;
import edu.umb.cs680.hw13.fs.Link;
import edu.umb.cs680.hw13.fs.util.FileCrawlingVisitor;

public class FileCrawlingVisitorTest {
    static Directory root;
    static LocalDateTime localTime = LocalDateTime.now();

    @BeforeAll
    public static void setupTest() {

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

    private String[] fileDetailsToStringArray(FSElement item) {
        String[] info = {
                item.getParent() != null ? item.getParent().getName() : null,
                item.getName(),
                Integer.toString(item.getSize()),
                item.getCreationTime().toString(),
                item.isDirectory() ? "true" : "false"
        };
        return info;
    }

    @Test
    public void testTotalFileCount() {
        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        root.accept(visitor);

        assertSame(4, visitor.getFiles().size());
    }

    @Test
    public void testFileA() {
        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        root.accept(visitor);

        String[] expected = { "Apps", "a", "2", localTime.toString(), "false" };
        File actual = visitor.getFiles().get(0);

        assertArrayEquals(expected, fileDetailsToStringArray(actual));
    }

    @Test
    public void testFileB() {
        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        root.accept(visitor);
        String[] expected = { "code", "d", "2", localTime.toString(), "false" };
        File actual = visitor.getFiles().get(3);
        assertArrayEquals(expected, fileDetailsToStringArray(actual));
    }

    @Test
    public void testFileD() {
        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        root.accept(visitor);
        String[] expected = { "code", "c", "2", localTime.toString(), "false" };
        File actual = visitor.getFiles().get(2);
        assertArrayEquals(expected, fileDetailsToStringArray(actual));
    }

    @Test
    public void testFileC() {
        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        root.accept(visitor);
        String[] expected = { "home", "b", "2", localTime.toString(), "false" };
        File actual = visitor.getFiles().get(1);
        assertArrayEquals(expected, fileDetailsToStringArray(actual));
    }
}
