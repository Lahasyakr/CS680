package edu.umb.cs680.hw10.fs;

import java.time.LocalDateTime;
import java.util.LinkedList;

import javax.naming.AuthenticationException;

import edu.umb.cs680.hw10.Authentication.SecurityContext;

public class Directory extends FSElement {

    private LinkedList<FSElement> children;

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);

        children = new LinkedList<>();

        if (parent != null) {
            parent.appendChild(this);
        }
    }

    @Override
    public void accept(FSVisitor v, SecurityContext ctx) throws Exception {
        if (ctx.isActive()) {
            v.visit(this);
            for (FSElement e : children) {
                e.accept(v,ctx);
            }
        }
        else{
            throw new AuthenticationException("Error..please login again!");
        }
        
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    public LinkedList<FSElement> getChildren() {
        return this.children;
    }

    public void appendChild(FSElement file) {
        children.add(file);
    }

    public int countChildren() {
        int countOfChildren = 0;
        for (FSElement item : children) {
            countOfChildren += 1;
        }
        return countOfChildren;
    }

    public LinkedList<Directory> getSubDirectories() {
        LinkedList<Directory> directoriesList = new LinkedList<>();
        for (FSElement item : children) {
            if (item.isDirectory())
                directoriesList.add((Directory) item);
        }
        return directoriesList;
    }

    public LinkedList<File> getFiles() {
        LinkedList<File> files = new LinkedList<>();
        for (FSElement item : children) {
            if (!item.isDirectory())
                files.add((File) item);
        }
        return files;
    }

    public int getTotalSize() {
        int totalSize = 0;
        LinkedList<FSElement> childrenList = getChildren();
        for (FSElement child : childrenList) {
            if (child.isDirectory())
                totalSize += ((Directory) child).getTotalSize();
            else
                totalSize += child.getSize();
        }
        return totalSize;
    }

}
