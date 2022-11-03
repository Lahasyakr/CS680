package edu.umb.cs680.hw06.ModelABC;

import edu.umb.cs680.hw06.Authentication.EncryptedString;
import edu.umb.cs680.hw06.Authentication.SecurityContext;
import edu.umb.cs680.hw06.PrintingFramework.PrintJobExcecutor;

public class PrintJobExcecutorAbc extends PrintJobExcecutor {
    @Override
    protected void doAuthentication(EncryptedString pwd, SecurityContext ctx) {
        // no Authentication fot this model
    }

    @Override
    protected void doAccessControl() {
        // empty
    }

    @Override
    protected void doPrint (){
        System.out.println("Printing....!!");
    }

    @Override
    protected void doErrorHAndling (Exception e){
        System.out.println(e.getMessage());
    }
}
