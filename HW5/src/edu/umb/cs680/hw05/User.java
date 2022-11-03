package edu.umb.cs680.hw05;

public class User {
        private String username;
        private EncryptedString pwd;

        public User(String string, EncryptedString encryptedString) {
            this.username = username;
            this.pwd = pwd;
        }
        
        public String getUserName() {
            return this.username;
        }
        public EncryptedString getpwd() {
            return this.pwd;
        }
}
