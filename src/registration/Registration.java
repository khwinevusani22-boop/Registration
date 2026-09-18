/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registration;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Registration {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RegistrationService service = new RegistrationService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Chat App: Registration ===");

        boolean registered = false;

        while (!registered) {
            System.out.print("Enter a username (must contain '_' and be <= 5 characters): ");
            String username = scanner.nextLine();

            System.out.print("Enter a password (min 8 chars, 1 capital, 1 number, 1 special char): ");
            String password = scanner.nextLine();

            System.out.print("Enter your SA cell number (e.g. +27831234567): ");
            String cellNumber = scanner.nextLine();

            String result = service.registerUser(username, password, cellNumber);
            System.out.println(result);

            registered = result.contains("successfully registered");
        }

        System.out.println("\n=== Chat App: Login ===");
        System.out.print("Enter your username: ");
        String loginUsername = scanner.nextLine();
        System.out.print("Enter your password: ");
        String loginPassword = scanner.nextLine();

        boolean loginSuccess = service.loginUser(loginUsername, loginPassword);
        System.out.println(service.returnLoginStatus(loginUsername, loginSuccess));

        scanner.close();
    }
}
