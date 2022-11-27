package edu.umb.cs680.hw10.Authentication;

import java.time.LocalDateTime;

public class LoggedOut implements State  {

    private static LoggedOut instance;
    private SecurityContext ctx;

    private LoggedOut(SecurityContext securityContext) {
        ctx = securityContext;
    }

    public static LoggedOut getInstance(SecurityContext obj) {
        if (instance == null) {
            instance = new LoggedOut(obj);
        }
        return instance;
    }

    @Override
    public void logout() {
      // do nothing
    }

    @Override
    public void login(EncryptedString pwd) throws Exception {
        if ( Authenticator.authenticate(ctx,pwd) )
            {
                ctx.lastLoginTimeStamp.add(LocalDateTime.now());
                ctx.changeState(LoggedIn.getInstance(ctx));
                System.out.println("User has been logged in successfully!!");
            }
            else
            {
                System.out.println("Authentication error");
                throw new Exception("Error while authenticating the user, please try to login again!!");
            }
    }  
} 
