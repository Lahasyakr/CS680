package edu.umb.cs680.hw10.fs;

import java.time.LocalDateTime;

import javax.naming.AuthenticationException;

import edu.umb.cs680.hw10.Authentication.SecurityContext;

public class Link extends FSElement {

    private FSElement target;

    public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
        super(parent, name, size, creationTime);
        parent.appendChild(this);

        this.target = target;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    public boolean isLink() {
        return true;
    }

    public FSElement getTarget() {
        return target;
    }

    @Override
    public void accept(FSVisitor v, SecurityContext ctx) throws AuthenticationException {
        if(ctx.isActive()){
            v.visit(this);
        }
        else{
            throw new AuthenticationException("Error..please login again!");
        }
        
    }
}