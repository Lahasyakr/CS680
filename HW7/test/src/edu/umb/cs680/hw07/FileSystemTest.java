package edu.umb.cs680.hw07;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;



public class FileSystemTest {
    static LocalDateTime localTime = LocalDateTime.now();

    private String[] directoryDetailsToStringArray(Directory directory) {
        String[] info = {
                null,
                directory.getName(),
                Integer.toString(directory.getSize()),
                directory.getCreationTime().toString()
        };

        return info;
    }

    @Test
    public void isFileSystemSingleton() {
        FileSystem f1 = FileSystem.getFileSystem();
        FileSystem f2 = FileSystem.getFileSystem();
        assertEquals(f1, f2);
    }

    @Test
    public void testRootDirectory() {
        FileSystem fileSystem =  FileSystem.getFileSystem();
        Directory maindir = new Directory(null, "mainDir", 0, localTime);
        fileSystem.apendRootDir(maindir);
        String[] expectedData = { null, "mainDir", "0", localTime.toString() };
        Directory actual = fileSystem.getRootDirs().get(0);
        assertArrayEquals(expectedData, directoryDetailsToStringArray(actual));
    }
    
}
