package edu.umb.cs680.hw06.PrintingFramework;

import edu.umb.cs680.hw06.Authentication.EncryptedString;
import edu.umb.cs680.hw06.Authentication.SecurityContext;

public abstract class PrintJobExcecutor {

    public void execute(PrintJobExcecutor job, EncryptedString pwd, SecurityContext ctx) throws Exception {
        try {
            doAuthentication(pwd, ctx);
            doAccessControl();
            doPrint();
        } catch (Exception e) {
            doErrorHAndling(e);
        }
    }

    protected void doAuthentication(EncryptedString pwd, SecurityContext ctx) throws Exception {

    }

    protected void doAccessControl() {

    }

    protected void doPrint() {

    }

    protected void doErrorHAndling(Exception e) {

    }
}
