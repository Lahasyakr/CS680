package edu.umb.cs680.hw05;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SecurityContextTest {

  @Test
  public void verifyCtxIsLoggedoutObj() {
      SecurityContext ctx = SecurityContext.getInstance();
      ctx.changeState(LoggedIn.getInstance(ctx));
      assertEquals(ctx.getState(), LoggedIn.getInstance(ctx));
  }

  @Test
  public void verifyLoginFunction() {
      SecurityContext ctx = SecurityContext.getInstance();
      ctx.changeState(LoggedOut.getInstance(ctx));
      assertEquals(ctx.getState(), LoggedOut.getInstance(ctx));
  } 

}
