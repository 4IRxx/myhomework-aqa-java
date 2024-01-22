package com.myaqa;

import java.util.Scanner;

public class UI {
    private LoginStorage loginList;
    private Scanner scanner;

    public UI (LoginStorage loginList, Scanner scanner) {
        this.loginList = loginList;
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            System.out.println("Напишите логин (для выхода из программы введите пустую строку): ");
            String login = this.scanner.nextLine();

            if (login.isEmpty()) {
                System.out.println("Cписок логинов начинающихся на f: ");
                this.loginList.printLoginsStartWith('f');
                break;
            }

            this.loginList.addLogin(login);
        }
    }
}