package edu.umb.cs680.hw10.fs;

import java.time.LocalDateTime;

import javax.naming.AuthenticationException;

import edu.umb.cs680.hw10.Authentication.SecurityContext;

public class File extends FSElement {

    public File(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
        parent.appendChild(this);
    }

    @Override
    public boolean isDirectory() {
        return false;
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
