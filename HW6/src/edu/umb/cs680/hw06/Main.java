package edu.umb.cs680.hw06;

import edu.umb.cs680.hw06.Authentication.EncryptedString;
import edu.umb.cs680.hw06.Authentication.SecurityContext;
import edu.umb.cs680.hw06.Authentication.User;

public class Main {
    public static void main(String[] args) throws Exception {
        User userObj = new User("Lahasya", new EncryptedString("Lahasya"));
        SecurityContext ctx = new SecurityContext(userObj);
        PrintJob job = new PrintJob("print this");

        edu.umb.cs680.hw06.PrintingFramework.PrintJobExcecutor printAbc = new edu.umb.cs680.hw06.ModelABC.PrintJobExcecutor();
        printAbc.execute(job, null, null);

        edu.umb.cs680.hw06.PrintingFramework.PrintJobExcecutor printXyz = new edu.umb.cs680.hw06.ModelXYZ.PrintJobExcecutor();
        printXyz.execute(job, userObj.getpwd(), ctx);
    }
}
