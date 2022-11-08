package com.Pharmacy.Project;

public class LoginController {
    // check if the user is valid
    public boolean isUserValid(String username, String password) {
        if (username.equals("admin") && password.equals("admin")) {
            return true;
        } else {
            return false;
        }
    }

}
