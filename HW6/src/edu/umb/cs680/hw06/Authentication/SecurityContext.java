package edu.umb.cs680.hw06.Authentication;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.LinkedList;

import javax.naming.AuthenticationException;

public class SecurityContext {

    private State state;
    private User user;

    public SecurityContext(User userobj) {
        this.user = userobj;
        this.state = LoggedOut.getInstance(this);
    }

    LinkedList<LocalDateTime> lastLoginTimeStamp = new LinkedList<LocalDateTime>();

    public void changeState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void login(EncryptedString pwd) throws Exception {
        state.login(pwd);
    }

    public void logout() {
        state.logout();
    }

    public boolean isActive() {
        if (lastLoginTimeStamp.size() == 0) {
            return true;
        } else {
            // System.out.println(lastLoginTimeStamp.getLast());
            Duration diff = Duration.between(lastLoginTimeStamp.getLast(), LocalDateTime.now());
            if (diff.getSeconds() > 30) {
                return false;
            } else {
                return true;
            }
        }
    }
}