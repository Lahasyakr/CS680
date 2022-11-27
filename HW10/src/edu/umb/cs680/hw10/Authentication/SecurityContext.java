package edu.umb.cs680.hw10.Authentication;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.LinkedList;

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
            return false;
        } else {
            // System.out.println(lastLoginTimeStamp.getLast());
            Duration diff = Duration.between(lastLoginTimeStamp.getLast(), LocalDateTime.now());
            if (diff.getSeconds() > 80) {
                return false;
            } else {
                return true;
            }
        }
    }
}