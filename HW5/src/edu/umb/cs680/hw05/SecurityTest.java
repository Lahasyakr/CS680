package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SecurityTest {
    @Test
    public void verifyCtxInitialObj() {
        SecurityContext ctx = new SecurityContext(new User("Lahasya", new EncryptedString("lahasya")));
        assertTrue(ctx.getState() == LoggedOut.getInstance(ctx));
        assertEquals(ctx.getState(), LoggedOut.getInstance(ctx));
    }

    @Test
    public void verifyChangeStateWithLoginObj() {
        SecurityContext ctx = new SecurityContext(new User("Lahasya", new EncryptedString("lahasya")));
        ctx.changeState(LoggedIn.getInstance(ctx));
        assertEquals(ctx.getState(), LoggedIn.getInstance(ctx));
    }

    @Test
    public void verifyChangeStateWithLogOutObj() {
        SecurityContext ctx = new SecurityContext(new User("Lahasya", new EncryptedString("lahasya")));
        ctx.changeState(LoggedOut.getInstance(ctx));
        assertEquals(ctx.getState(), LoggedOut.getInstance(ctx));
    }

    @Test
    public void verifyChangeStateWithLoginObj_2() {
        SecurityContext ctx = new SecurityContext(new User("Lahasya", new EncryptedString("lahasya")));
        ctx.changeState(LoggedIn.getInstance(ctx));
        assertEquals(ctx.getState(), LoggedIn.getInstance(ctx));
        assertTrue(ctx.getState() == LoggedIn.getInstance(ctx));
    }

    @Test
    public void verifyChangeStateWithLogOutObj_2() {
        SecurityContext ctx = new SecurityContext(new User("Lahasya", new EncryptedString("lahasya")));
        ctx.changeState(LoggedOut.getInstance(ctx));
        assertEquals(ctx.getState(), LoggedOut.getInstance(ctx));
        assertTrue(ctx.getState() == LoggedOut.getInstance(ctx));
    }

}
