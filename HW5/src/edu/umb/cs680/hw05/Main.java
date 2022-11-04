package edu.umb.cs680.hw05;

public class Main {
    public static void main(String[] args) throws Exception {
        
        SecurityContext ctx = new SecurityContext(new User("Lahasya", new EncryptedString("lahasya")));
        System.out.println(ctx.getState() + " " + LoggedOut.getInstance(ctx));
        //ctx.changeState(LoggedOut.getInstance());
        //ctx.changeState(LoggedIn.getInstance(ctx));
        EncryptedString pwd = new EncryptedString("Lahasya");
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
