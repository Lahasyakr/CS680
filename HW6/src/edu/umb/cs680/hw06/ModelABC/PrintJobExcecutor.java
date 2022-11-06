package edu.umb.cs680.hw06.ModelABC;

import edu.umb.cs680.hw06.PrintJob;
import edu.umb.cs680.hw06.Authentication.EncryptedString;
import edu.umb.cs680.hw06.Authentication.SecurityContext;

public class PrintJobExcecutor extends edu.umb.cs680.hw06.PrintingFramework.PrintJobExcecutor {
    @Override
    protected void doAuthentication(EncryptedString pwd, SecurityContext ctx) {
        // no Authentication fot this model
    }

    @Override
    protected void doAccessControl() {
        // empty
    }

    @Override
    protected void doPrint(PrintJob job) {
        System.out.println("Printing....!!, given printjob has been completed-version ABC");
    }

    @Override
    protected void doErrorHAndling(Exception e) {
        System.out.println(e.getMessage());
    }
}
