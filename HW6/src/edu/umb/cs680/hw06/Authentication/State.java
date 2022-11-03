package edu.umb.cs680.hw06.Authentication;

import javax.naming.AuthenticationException;

public interface State {
    public  void login(EncryptedString pwd) throws AuthenticationException, Exception;

    public void logout(); 
}
