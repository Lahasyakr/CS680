package edu.umb.cs680.hw05;

public class Main {
    public static void main(String[] args) {
        
        SecurityContext ctx = SecurityContext.getInstance();
        System.out.println(ctx.getState() + " " + LoggedOut.getInstance(ctx));
        //ctx.changeState(LoggedOut.getInstance());
        EncryptedString pwd = new EncryptedString("lahasya");
        ctx.login(pwd);
        try{
            Thread.sleep(50000);
        }
        catch (InterruptedException ignored) {
        }
        ctx.login(pwd);
        ctx.login(pwd);
        ctx.logout();

    }
}
