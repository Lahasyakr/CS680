package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

public class LinkTest {
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

    private String[] linkToString(FSElement item) {
        String[] linkInfo = {
                item.getParent() != null ? item.getParent().getName() : null,
                item.getName(),
                Integer.toString(item.getSize()),
                item.getCreationTime().toString(),
                item.isDirectory() ? "true" : "false"
        };
        return linkInfo;
    }

    @Test
    public void testLinkD() {
        String[] expected = {
                "root",
                "d",
                "1",
                date.toString(),
                "false"
        };
        assertArrayEquals(expected, linkToString(d));
    }

    @Test
    public void testLinkE() {
        String[] expected = {
                "root",
                "e",
                "2",
                date.toString(),
                "false"
        };
        assertArrayEquals(expected, linkToString(e));
    }

    @Test
    public void verifyTargetOfD() {
        assertSame("pictures", d.getTarget().getName());
    }

    @Test
    public void verifyTargetOfE() {
        assertSame("x", e.getTarget().getName());
    }

    @Test
    public void verifyLinkCountForHome() {
        assertEquals(0, home.getLinks().size());
    }

    @Test
    public void verifyLinkCountForApps() {
        assertEquals(0, Apps.getLinks().size());
    }

    @Test
    public void verifyLinkCountForRoots() {
        assertEquals(2, root.getLinks().size());
    }

    @Test
    public void verifyTagetForE() {
        assertEquals("x", e.getTarget().getName());
    }

    @Test
    public void verifyTagetForD() {
        assertEquals("pictures", d.getTarget().getName());
    }

    @Test
    public void testDirectoryOrNot() {
        assertFalse(e.isDirectory());
        assertFalse(d.isDirectory());
        assertTrue(e.isLink());
        assertTrue(d.isLink());
    }

}
