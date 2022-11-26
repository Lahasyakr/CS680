package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

public class DirectoryFileTest {
    static LocalDateTime date = LocalDateTime.now();

    Directory root = new Directory(null, "root", 0, date);
    Directory Apps = new Directory(root, "Apps", 0, date);
    Directory bin = new Directory(root, "bin", 0, date);
    Directory home = new Directory(root, "home", 0, date);
    Directory pictures = new Directory(home, "pictures", 0, date);
    File x = new File(Apps, "x", 1, date);
    File y = new File(bin, "y", 2, date);
    File a = new File(pictures, "a", 4, date);
    File b = new File(pictures, "b", 5, date);
    File c = new File(home, "c", 6, date);
    Link d = new Link(root, "d", 1, date, pictures);
    Link e = new Link(root, "e", 2, date, x);

    private String[] directoryDetailsToStringArray(FSElement item) {
        String[] dirInfo = {
                item.getParent() != null ? item.getParent().getName() : null,
                item.getName(),
                Integer.toString(item.getSize()),
                item.getCreationTime().toString(),
                item.isDirectory() ? "true" : "false"
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
    public void verifyDirectoryEqualitybin() {
        String[] expected = { "root", "bin", "0", date.toString(), "true" };
        Directory actual = bin;
        assertArrayEquals(expected, directoryDetailsToStringArray(actual));
    }

    @Test
    public void verifyDirectoryEqualityApps() {
        String[] expected = { "root", "Apps", "0", date.toString(), "true" };
        Directory actual = Apps;
        assertArrayEquals(expected, directoryDetailsToStringArray(actual));
    }

    @Test
    public void verifyDirectoryEqualitypictures() {
        String[] expected = { "home", "pictures", "0", date.toString(), "true" };
        Directory actual = pictures;
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
        String[] expected = { "bin", "y", "2", date.toString(), "false" };
        File actual = y;
        assertArrayEquals(expected, directoryDetailsToStringArray(actual));
    }

    @Test
    public void verifyFileEqualityz() {
        String[] expected = { "home", "c", "6", date.toString(), "false" };
        File actual = c;
        assertArrayEquals(expected, directoryDetailsToStringArray(actual));
    }

    @Test
    public void verifyFileEqualityA() {
        String[] expected = { "pictures", "a", "4", date.toString(), "false" };
        File actual = a;
        assertArrayEquals(expected, directoryDetailsToStringArray(actual));
    }

    @Test
    public void verifyFileEqualityB() {
        String[] expected = { "pictures", "b", "5", date.toString(), "false" };
        File actual = b;
        assertArrayEquals(expected, directoryDetailsToStringArray(actual));
    }

    @Test
    public void verifyLinkEqualityD() {
        String[] expected = { "root", "d", "1", date.toString(), "false" };
        Link actual = d;
        assertArrayEquals(expected, directoryDetailsToStringArray(actual));
    }

    @Test
    public void verifyLinkEqualityE() {
        String[] expected = { "root", "e", "2", date.toString(), "false" };
        Link actual = e;
        assertArrayEquals(expected, directoryDetailsToStringArray(actual));
    }

    @Test
    public void directoryOrFileTest() {
        assertTrue(Apps.isDirectory());
        assertFalse(a.isDirectory());
        assertTrue(root.isDirectory());
        assertTrue(home.isDirectory());
        assertTrue(pictures.isDirectory());
        assertFalse(b.isDirectory());
    }

    @Test
    public void countOfSubDirOrFiles() {
        assertEquals(5, root.countChildren());
        assertEquals(2, pictures.countChildren());
        assertEquals(1, Apps.countChildren());
        assertEquals(2, home.countChildren());
        assertEquals(1, bin.countChildren());
    }

}
