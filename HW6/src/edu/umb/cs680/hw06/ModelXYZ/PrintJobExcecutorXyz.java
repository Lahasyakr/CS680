package edu.umb.cs680.hw06.ModelXYZ;

import java.io.IOError;

import javax.security.sasl.AuthenticationException;

import edu.umb.cs680.hw06.Authentication.EncryptedString;
import edu.umb.cs680.hw06.Authentication.SecurityContext;
import edu.umb.cs680.hw06.PrintingFramework.PrintJobExcecutor;

public class PrintJobExcecutorXyz extends PrintJobExcecutor {

    @Override
    protected void doAuthentication(EncryptedString pwd, SecurityContext ctx) throws Exception {
        try {
            ctx.login(pwd);

        } catch (Exception e) {
            throw e;
        }

    }

    protected void doAccessControl() {
        // empty
    }

    @Override
    protected void doPrint() {
        System.out.println("Printing....!!");
    }

    @Override
    protected void doErrorHAndling(Exception e) {
        System.out.println(e.getMessage());
    }

}
