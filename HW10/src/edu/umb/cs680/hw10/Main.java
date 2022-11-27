package edu.umb.cs680.hw10;

import edu.umb.cs680.hw10.Authentication.EncryptedString;
import edu.umb.cs680.hw10.Authentication.SecurityContext;
import edu.umb.cs680.hw10.Authentication.User;
import edu.umb.cs680.hw10.fs.Directory;
import edu.umb.cs680.hw10.fs.File;
import edu.umb.cs680.hw10.fs.Link;
import edu.umb.cs680.hw10.fs.util.FileSearchVisitor;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws Exception {

        LocalDateTime localTime = LocalDateTime.now();

        // Directories
        Directory root = new Directory(null, "root", 0, localTime);
        Directory Apps = new Directory(root, "Apps", 0, localTime);
        Directory home = new Directory(root, "home", 0, localTime);
        Directory code = new Directory(home, "code", 0, localTime);

        // Files
        File a = new File(Apps, "a", 2, localTime);
        File b = new File(home, "b", 2, localTime);
        File c = new File(code, "c", 2, localTime);
        File d = new File(code, "d", 2, localTime);

        // Link
        Link x = new Link(home, "x", 1, localTime, Apps);
        Link y = new Link(code, "y", 1, localTime, a);

        User userObj = new User("Lahasya", new EncryptedString("Lahasya"));
        SecurityContext ctx = new SecurityContext(userObj);
        ctx.login(userObj.getpwd());

        FileSearchVisitor visitor = new FileSearchVisitor(a.getName());
        root.accept(visitor, ctx);
        System.out.println(visitor.getFoundFiles().getFirst().getName());
    }
}