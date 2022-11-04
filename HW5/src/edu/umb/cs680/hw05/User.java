package edu.umb.cs680.hw05;

public class User {
        private String username;
        private EncryptedString pwd;

        public User(String username1, EncryptedString password) {
            this.username = username1;
            this.pwd = password;
        }
        
        public String getUserName() {
            return this.username;
        }
        public EncryptedString getpwd() {
            return this.pwd;
        }
}
