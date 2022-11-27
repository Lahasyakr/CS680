package edu.umb.cs680.hw10.fs;

import java.time.LocalDateTime;

import edu.umb.cs680.hw10.Authentication.SecurityContext;

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

    public abstract void accept(FSVisitor visitor, SecurityContext ctx) throws Exception;
}