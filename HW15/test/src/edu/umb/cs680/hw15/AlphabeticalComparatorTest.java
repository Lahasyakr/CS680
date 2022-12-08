
package edu.umb.cs680.hw15;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw15.fs.Directory;
import edu.umb.cs680.hw15.fs.FSElement;
import edu.umb.cs680.hw15.fs.File;
import edu.umb.cs680.hw15.fs.Link;

public class AlphabeticalComparatorTest {
    static Directory root;
    static Directory home;
    static Directory Apps;
    static Directory code;
    static File a;
    static File b;
    static File c;
    static File d;
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
        Link x = new Link(home, "x", 1, localTime, Apps);
        Link y = new Link(code, "y", 1, localTime, a);

    }

    @Test
    public void AlphaSortDirectories() {
        List<FSElement> dirs = new ArrayList<FSElement>();
        dirs.add(root);
        dirs.add(Apps);
        dirs.add(home);
        dirs.add(code);
        FSElement[] expected = { Apps, code, home, root };
        Collections.sort(dirs, (FSElement o1, FSElement o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
        assertSame(Apps.getName(), dirs.get(0).getName());
        assertArrayEquals(expected, dirs.toArray());
    }

    @Test
    public void AlphaSortFiles() {
        List<FSElement> files = new ArrayList<FSElement>();
        files.add(b);
        files.add(d);
        files.add(a);
        files.add(c);
        FSElement[] expected = { a, b, c, d };
        Collections.sort(files, (FSElement o1, FSElement o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
        assertSame(a.getName(), files.get(0).getName());
        assertArrayEquals(expected, files.toArray());
    }

    @Test
    public void testgetChildrenDefault() {
        FSElement[] expected = { Apps, home };
        Directory directory = root;
        List<FSElement> element = directory.getChildren(null);
        assertArrayEquals(expected, element.toArray());
    }

    @Test
    public void testgetSubDirectoriesDefault() {
        Directory[] expected = { code };
        List<Directory> element = home.getSubDirectories(null);
        assertArrayEquals(expected, element.toArray());
    }

    @Test
    public void testgetFilesDefault() {
        File[] expected = {c,d };
        List<File> files = code.getFiles(null);
        assertArrayEquals(expected, files.toArray());
    }

}
