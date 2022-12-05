package edu.umb.cs680.hw13.fs.util;

import java.util.LinkedList;
import edu.umb.cs680.hw13.fs.Directory;
import edu.umb.cs680.hw13.fs.File;
import edu.umb.cs680.hw13.fs.Link;

public class FileSearchVisitor implements edu.umb.cs680.hw13.fs.FSVisitor {
    private String fileName;
    private LinkedList<File> foundFiles = new LinkedList<File>();

    public FileSearchVisitor(String name) {
        fileName = name;
    }

    @Override
    public void visit(File file) {
        if (file.getName().equals(fileName)) {
            foundFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        return;
    }

    @Override
    public void visit(Link link) {
        return;
    }

    public LinkedList<File> getFoundFiles() {
        return foundFiles;
    }

    public String getFileName() {
        return fileName;
    }


}
