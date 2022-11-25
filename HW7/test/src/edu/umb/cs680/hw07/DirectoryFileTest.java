package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

public class DirectoryFileTest {
    static LocalDateTime date = LocalDateTime.now();

    Directory root = new Directory(null, "root", 0, date);
    Directory Apps = new Directory(root, "Apps", 0, date);
    Directory lib = new Directory(root, "lib", 0, date);
    Directory home = new Directory(root, "home", 0, date);
    Directory code = new Directory(home, "code", 0, date);
    File x = new File(Apps, "x", 1, date);
    File y = new File(Apps, "y", 2, date);
    File z = new File(lib, "z", 3, date);
    File a = new File(code, "a", 4, date);
    File b = new File(code, "b", 5, date);
    File c = new File(code, "c", 6, date);
    File d = new File(home, "d", 7, date);

    private String[] directoryDetailsToStringArray(FSElement directory) {
        String[] dirInfo = {
                directory.getParent() != null ? directory.getParent().getName() : null,
                directory.getName(),
                Integer.toString(directory.getSize()),
                directory.getCreationTime().toString(),
                directory.isDirectory() ? "true" : "false"
        };
        return dirInfo;
    }

    @Test
    public void verifyDirectoryEqualityRoot() {
        String[] expected = { null, "root", "0", date.toString(), "true" };
        Directory actual = root;
        assertArrayEquals(expected, directoryDetailsToStringArray(actual));
    }

    @Test
    public void verifyDirectoryEqualityHome() {
        String[] expected = { "root", "home", "0", date.toString(), "true" };
        Directory actual = home;
        assertArrayEquals(expected, directoryDetailsToStringArray(actual));
    }

    @Test
    public void verifyDirectoryEqualitylib() {
        String[] expected = { "root", "lib", "0", date.toString(), "true" };
        Directory actual = lib;
        assertArrayEquals(expected, directoryDetailsToStringArray(actual));
    }

    @Test
    public void verifyDirectoryEqualityApps() {
        String[] expected = { "root", "Apps", "0", date.toString(), "true" };
        Directory actual = Apps;
        assertArrayEquals(expected, directoryDetailsToStringArray(actual));
    }

    @Test
    public void verifyDirectoryEqualityCode() {
        String[] expected = { "home", "code", "0", date.toString(), "true" };
        Directory actual = code;
        assertArrayEquals(expected, directoryDetailsToStringArray(actual));
    }

    @Test
    public void verifyFileEqualityX() {
        String[] expected = { "Apps", "x", "1", date.toString(), "false" };
        File actual = x;
        assertArrayEquals(expected, directoryDetailsToStringArray(actual));
    }

    @Test
    public void verifyFileEqualityy() {
        String[] expected = { "Apps", "y", "2", date.toString(), "false" };
        File actual = y;
        assertArrayEquals(expected, directoryDetailsToStringArray(actual));
    }

    @Test
    public void verifyFileEqualityz() {
        String[] expected = { "lib", "z", "3", date.toString(), "false" };
        File actual = z;
        assertArrayEquals(expected, directoryDetailsToStringArray(actual));
    }

    @Test
    public void verifyFileEqualityA() {
        String[] expected = { "code", "a", "4", date.toString(), "false" };
        File actual = a;
        assertArrayEquals(expected, directoryDetailsToStringArray(actual));
    }

    @Test
    public void verifyFileEqualityB() {
        String[] expected = { "code", "b", "5", date.toString(), "false" };
        File actual = b;
        assertArrayEquals(expected, directoryDetailsToStringArray(actual));
    }

    @Test
    public void directoryOrFileTest() {
        assertTrue(Apps.isDirectory());
        assertFalse(a.isDirectory());
        assertTrue(root.isDirectory());
        assertTrue(home.isDirectory());
        assertTrue(code.isDirectory());
        assertFalse(b.isDirectory());
    }

    @Test
    public void countOfSubDirOrFiles() {
        assertEquals(3, root.countChildren());
        assertEquals(3, code.countChildren());
        assertEquals(2, Apps.countChildren());
        assertEquals(2, home.countChildren());
        assertEquals(1, lib.countChildren());
    }

}
