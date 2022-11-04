package edu.umb.cs680.hw06;

import edu.umb.cs680.hw06.Authentication.EncryptedString;
import edu.umb.cs680.hw06.Authentication.SecurityContext;
import edu.umb.cs680.hw06.Authentication.User;
import edu.umb.cs680.hw06.ModelABC.PrintJobExcecutorAbc;
import edu.umb.cs680.hw06.ModelXYZ.PrintJobExcecutorXyz;

public class Main {
    public static void main(String[] args) throws Exception {
        User userObj = new User("Lahasya", new EncryptedString("Lahasya"));
        SecurityContext ctx = new SecurityContext(userObj);

        PrintJobExcecutorAbc printAbc = new PrintJobExcecutorAbc();
        printAbc.execute(printAbc,null, null);

        PrintJobExcecutorXyz printXyz = new PrintJobExcecutorXyz();
        printXyz.execute(printXyz, userObj.getpwd(), ctx);
    }
}
