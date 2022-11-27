package edu.umb.cs680.hw10.Authentication;

public class User {
        private String username;
        private EncryptedString pwd;

        public User(String username1, EncryptedString encryptedString) {
            this.username = username1;
            this.pwd = encryptedString;
        }
        
        public String getUserName() {
            return this.username;
        }
        public EncryptedString getpwd() {
            return this.pwd;
        }
}
