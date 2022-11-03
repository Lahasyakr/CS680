package edu.umb.cs680.hw05;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class SecurityContext {

    private State state;
    private User user;

    private SecurityContext(User user) {
        this.user = user;
        this.state = LoggedOut.getInstance(this);
    }

    private static SecurityContext instance;

    LinkedList<LocalDateTime> lastLoginTimeStamp = new LinkedList<LocalDateTime>();

    public static SecurityContext getInstance() {
        if (instance == null) {
            User userObj = new User("Lahasya", new EncryptedString("lahasya"));
            instance = new SecurityContext(userObj);
        }
        return instance;
    }

    public void changeState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void login(EncryptedString pwd) {
        state.login(pwd);
    }

    public void logout() {
        state.logout();
    }

    public boolean isActive() {
        Duration diff = Duration.between(lastLoginTimeStamp.getLast(), LocalDateTime.now());
        System.out
                .println(lastLoginTimeStamp.getLast() + " " + " " + diff.getSeconds() + " we are in isActive Method!!");
        if (diff.getSeconds() > 30) {
            return false;
        } else {
            return true;
        }
    }
}