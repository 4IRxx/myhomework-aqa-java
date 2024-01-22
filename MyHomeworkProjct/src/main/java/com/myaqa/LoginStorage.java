package com.myaqa;

import java.util.ArrayList;

public class LoginStorage {
    private ArrayList<String> loginList;

    public LoginStorage() {
        this.loginList = new ArrayList<>();
    }

    public void addLogin (String login) {
        this.loginList.add(login);
    }

    public void printLoginsStartWith (char firstLetter) {
        for (String login : this.loginList) {
            if (login.toLowerCase().startsWith(String.valueOf(firstLetter).toLowerCase())) {
                System.out.println(login);
            }
        }
    }

}
