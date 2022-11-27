package edu.umb.cs680.hw10.Authentication;

import java.util.Base64;

public class Authenticator {

    public static boolean authenticate(SecurityContext ctx, EncryptedString pwd) {
        String correctPassword = "Lahasya";
        byte[] decodedBytes = Base64.getDecoder().decode(pwd.getEncryptedData());
        String decodedString = new String(decodedBytes);
        if (decodedString.equals(correctPassword)) {
            return true;
        } else {
            return false;
        }

    }

}
