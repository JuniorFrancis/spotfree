package com.exame.spotfree.models.request;

public class RegisterRequest {

    public RegisterRequest(String firstname,String username, String password) {
        this.firstname = firstname;
        this.username = username;
        this.password = password;
    }

    public RegisterRequest() {
    }

    private String firstname;

    private String username;

    private String password;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static class Builder {

        public String firstname;

        public String username;

        public String password;

        public void withFirstname(String firstname){
            this.firstname = firstname;
        }

        public void withEmail(String email){
            this.username = username;
        }

        public void withPassword(String password){
            this.password = password;
        }

        public RegisterRequest build() {
            return new RegisterRequest(firstname, username, password);
        }

    }
}
