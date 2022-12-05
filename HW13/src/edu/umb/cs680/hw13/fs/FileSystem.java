package edu.umb.cs680.hw13.fs;

import java.util.LinkedList;

public class FileSystem {
    private static FileSystem instance;
    LinkedList<Directory> rootDirs = new LinkedList<>();

    private FileSystem() {
    }

    public static FileSystem getFileSystem() {
        if (instance == null)
            instance = new FileSystem();
        return instance;
    }

    public LinkedList<Directory> getRootDirs() {
        return this.rootDirs;
    }

    public void apendRootDir(Directory root) {
        rootDirs.add(root);
    }

}