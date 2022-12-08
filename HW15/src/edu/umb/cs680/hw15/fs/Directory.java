package edu.umb.cs680.hw15.fs;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;


public class Directory extends FSElement {

    private LinkedList<FSElement> children;

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);

        children = new LinkedList<>();

        if (parent != null) {
            parent.appendChild(this,(FSElement o1, FSElement o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
        }
    }

    @Override
    public void accept(FSVisitor v) {
        v.visit(this);
        for (FSElement e : children) {
            e.accept(v);
        }
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    public LinkedList<FSElement> getChildren() {
        return this.children;
    }

    public void appendChild(FSElement file, Comparator<FSElement> comp) {
        children.add(file);
        comp = comp == null ? (FSElement o1, FSElement o2) -> o1.getName().compareToIgnoreCase(o2.getName()) : comp;
        Collections.sort(children, comp);
    }

    public int countChildren() {
        int countOfChildren = 0;
        for (FSElement item : children) {
            countOfChildren += 1;
        }
        return countOfChildren;
    }

    public LinkedList<Directory> getSubDirectories(Comparator<FSElement> comp) {
        LinkedList<Directory> directoriesList = new LinkedList<>();
        for (FSElement item : children) {
            if (item.isDirectory())
                directoriesList.add((Directory) item);
        }
        comp = comp == null ? (FSElement o1, FSElement o2) -> o1.getName().compareToIgnoreCase(o2.getName()) : comp;
        Collections.sort(directoriesList, comp);
        return directoriesList;
    }

    public LinkedList<File> getFiles(Comparator<FSElement> comp) {
        LinkedList<File> files = new LinkedList<>();
        for (FSElement item : children) {
            if (!item.isDirectory() && item.isFile())
                files.add((File) item);
        }
        comp = comp == null ? (FSElement o1, FSElement o2) -> o1.getName().compareToIgnoreCase(o2.getName()) : comp;
        Collections.sort(files, comp);
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

    public LinkedList<FSElement> getChildren(Comparator<FSElement> comp) {
        comp = comp == null ? (FSElement o1, FSElement o2) -> o1.getName().compareToIgnoreCase(o2.getName()) : comp;
        Collections.sort(children, comp);
        return children;
    }

    @Override
    public boolean isFile() {
        return false;
    }

    @Override
    public boolean isLink() {
        return false;
    }

}
