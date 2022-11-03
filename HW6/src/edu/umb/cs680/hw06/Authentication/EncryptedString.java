package edu.umb.cs680.hw06.Authentication;

import java.io.IOException;
import java.util.Base64;

public class EncryptedString {
    private String encryptedData;

    public EncryptedString(String s) {
        try {
            this.encryptedData = Encrypt(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String Encrypt(String stringData) throws IOException {
        byte[] byteData = stringData.getBytes();
        String base64String = Base64.getEncoder().encodeToString(byteData);
        return base64String;
    }

    public String getEncryptedData() {
        return encryptedData;
    }
}
