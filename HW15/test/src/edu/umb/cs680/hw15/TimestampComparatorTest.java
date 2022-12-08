
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

public class TimestampComparatorTest {
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
        Apps = new Directory(root, "Apps", 1, localTime);
        home = new Directory(root, "home", 2, localTime);
        code = new Directory(home, "code",3, localTime);
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
    public void TimestampComparatorSortDirectories() {
        List<FSElement> dirs = new ArrayList<FSElement>();
        dirs.add(root);
        dirs.add(Apps);
        dirs.add(home);
        dirs.add(code);
        FSElement[] expected = { root,Apps, home, code };
        Collections.sort(dirs, (FSElement o1, FSElement o2) ->  o2.getCreationTime().compareTo(o1.getCreationTime()));
        assertSame(root.getName(), dirs.get(0).getName());
        assertArrayEquals(expected, dirs.toArray());
    }

    @Test
    public void TimestampComparatorSortFiles() {
        List<FSElement> files = new ArrayList<FSElement>();
        files.add(b);
        files.add(d);
        files.add(a);
        files.add(c);
        FSElement[] expected = {b,d,a,c };
        Collections.sort(files, (FSElement o1, FSElement o2) ->  o2.getCreationTime().compareTo(o1.getCreationTime()));
        assertSame(b.getName(), files.get(0).getName());
        assertArrayEquals(expected, files.toArray());
    }

    @Test
    public void testgetChildrenTimestampComparator() {
        FSElement[] expected = { Apps, home };
        Directory directory = root;
        List<FSElement> element = directory.getChildren((FSElement o1, FSElement o2) ->  o2.getCreationTime().compareTo(o1.getCreationTime()));
        assertArrayEquals(expected, element.toArray());
    }

    @Test
    public void testgetSubDirectoriesTimestampComparator() {
        Directory[] expected = {code};
        List<Directory> element = home.getSubDirectories((FSElement o1, FSElement o2) ->  o2.getCreationTime().compareTo(o1.getCreationTime()));
        assertArrayEquals(expected, element.toArray());
    }

    @Test
    public void testgetFilesTimestampComparator() {
        File[] expected = { c,d };
        List<File> files = code.getFiles((FSElement o1, FSElement o2) ->  o2.getCreationTime().compareTo(o1.getCreationTime()));
        assertArrayEquals(expected, files.toArray());
    }

}
