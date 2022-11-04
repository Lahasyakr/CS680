package edu.umb.cs680.hw05;

import java.util.Base64;

public class Authenticator {

    public static boolean authenticate(SecurityContext ctx, EncryptedString pwd) {
        // High level authentication for the testing purpose
        String correctPassword = "Lahasya";
        //dencoding data
        byte[] decodedBytes = Base64.getDecoder().decode(pwd.getEncryptedData());
        String decodedString = new String(decodedBytes);
        if (decodedString.equals(correctPassword)) {
            return true;
        } else {
            return false;
        }
    }

}
