package edu.umb.cs680.hw13.fs.util;

import edu.umb.cs680.hw13.fs.Directory;
import edu.umb.cs680.hw13.fs.FSVisitor;
import edu.umb.cs680.hw13.fs.File;
import edu.umb.cs680.hw13.fs.Link;

public class CountingVisitor implements FSVisitor {

    private int dirNum = 0;
    private int fileNum = 0;
    private int linkNum = 0;

    @Override
    public void visit(Directory directory) {
        dirNum++;
    }

    @Override
    public void visit(File file) {
        fileNum++;
    }

    @Override
    public void visit(Link link) {
        linkNum++;
    }

    public int getDirNum() {
        return dirNum;
    }

    public int getFileNum() {
        return fileNum;
    }

    public int getLinkNum() {
        return linkNum;
    }

}
