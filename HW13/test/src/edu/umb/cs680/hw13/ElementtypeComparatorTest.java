
package edu.umb.cs680.hw13;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw13.fs.Directory;
import edu.umb.cs680.hw13.fs.FSElement;
import edu.umb.cs680.hw13.fs.File;
import edu.umb.cs680.hw13.fs.Link;
import edu.umb.cs680.hw13.fs.comparator.AlphabeticalComparator;
import edu.umb.cs680.hw13.fs.comparator.ElementtypeComparator;

public class ElementtypeComparatorTest {
    static Directory root;
    static Directory home;
    static Directory Apps;
    static Directory code;
    static File a;
    static File b;
    static File c;
    static File d;
    static Link x;
    static Link y;
    static LocalDateTime localTime = LocalDateTime.now();

    @BeforeAll
    public static void setupTest() {

        // Directories
        root = new Directory(null, "root", 0, localTime);
        Apps = new Directory(root, "Apps", 0, localTime);
        home = new Directory(root, "home", 0, localTime);
        code = new Directory(home, "code", 0, localTime);
        // Files
        a = new File(Apps, "a", 2, localTime);
        b = new File(home, "b", 2, localTime);
        c = new File(code, "c", 2, localTime);
        d = new File(code, "d", 2, localTime);
        // Link
        x = new Link(home, "x", 1, localTime, Apps);
        y = new Link(code, "y", 1, localTime, a);

    }

    @Test
    public void ElementSortFiles() {
        List<FSElement> Fs = new ArrayList<FSElement>();
        Fs.add(b);
        Fs.add(x);
        Fs.add(root);
        FSElement[] expected = { root, b, x };
        Collections.sort(Fs, new AlphabeticalComparator());
        Collections.sort(Fs, new ElementtypeComparator());
        assertSame(root.getName(), Fs.get(0).getName());
        assertArrayEquals(expected, Fs.toArray());
    }

    @Test
    public void testgetChildrenElementType() {
        FSElement[] expected = { home, Apps };
        Directory directory = root;
        List<Directory> element = directory.getSubDirectories(new ElementtypeComparator());
        assertArrayEquals(expected, element.toArray());
    }

    @Test
    public void testgetSubDirectoriesElementType() {
        Directory[] expected = { code };
        List<Directory> element = home.getSubDirectories(new ElementtypeComparator());
        assertArrayEquals(expected, element.toArray());
    }

    @Test
    public void testgetFilesElementType() {
        FSElement[] expected = { d,c };
        List<File> files = code.getFiles(new ElementtypeComparator());
        assertArrayEquals(expected, files.toArray());
    }

}
