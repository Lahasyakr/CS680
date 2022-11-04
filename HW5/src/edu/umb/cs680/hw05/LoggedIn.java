package edu.umb.cs680.hw05;

import java.time.LocalDateTime;

public class LoggedIn implements State {

    private static LoggedIn instance;
    private SecurityContext ctx;

    private LoggedIn(SecurityContext securityContext) {
        ctx = securityContext;
    }

    public static LoggedIn getInstance(SecurityContext obj) {
        if (instance == null) {
            instance = new LoggedIn(obj);
        }
        return instance;
    }

    @Override
    public void logout() {
        System.out.println("User has been logged out!");
        ctx.changeState(LoggedOut.getInstance(ctx));
    }

    @Override
    public void login(EncryptedString pwd) throws Exception {
        if (!ctx.isActive()) {
            ctx.changeState(LoggedOut.getInstance(ctx));
            System.out.println("User has been logged out before logging in again - inactive user !!");
            ctx.login(pwd);
        } else {
            ctx.lastLoginTimeStamp.add(LocalDateTime.now());
            System.out.println("FirstTime Login  or Active user has been logged in !!");
        }
    }
}
