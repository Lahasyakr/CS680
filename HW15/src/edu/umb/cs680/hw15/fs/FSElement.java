package edu.umb.cs680.hw15.fs;

import java.time.LocalDateTime;

public abstract class FSElement {
    protected Directory parent;
    protected String name;
    protected int size;
    protected LocalDateTime creationTime;

    public FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
    }

    public Directory getParent() {
        return this.parent;
    }

    public int getSize() {
        return this.size;
    }

    public LocalDateTime getCreationTime() {
        return this.creationTime;
    }

    public String getName() {
        return this.name;
    }

    public abstract boolean isDirectory();

    public abstract void accept(FSVisitor visitor);

    public abstract boolean isFile();
    public abstract boolean isLink();
}