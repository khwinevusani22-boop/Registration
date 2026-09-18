/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registration;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Student
 */
public class RegistrationService {
    private final Map<String, User> registeredUsers = new HashMap<>();

    public boolean checkUserName(String username) {
        if (username == null) {
            return false;
        }
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean hasUpper = password.matches(".*[A-Z].*");
        boolean hasDigit = password.matches(".*[0-9].*");
        boolean hasSpecial = password.matches(".*[^a-zA-Z0-9].*");
        return hasUpper && hasDigit && hasSpecial;
    }

    public boolean checkCellPhoneNumber(String cellNumber) {
        if (cellNumber == null) {
            return false;
        }
        return cellNumber.matches("^\\+27\\d{9}$");
    }

    public String registerUser(String username, String password, String cellNumber) {

        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username "
                    + "contains an underscore and is no more than five characters in length.";
        }

        if (registeredUsers.containsKey(username)) {
            return "Username already exists, please choose a different username.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password "
                    + "contains at least 8 characters, a capital letter, a number, and a "
                    + "special character.";
        }

        if (!checkCellPhoneNumber(cellNumber)) {
            return "Cell phone number incorrectly formatted or does not contain international "
                    + "code, please correct the number and try again.";
        }

        registeredUsers.put(username, new User(username, password, cellNumber));
        return "User " + username + " successfully registered !!";
    }

    public boolean loginUser(String username, String password) {
        User user = registeredUsers.get(username);
        return user != null && user.getPassword().equals(password);
    }

    public String returnLoginStatus(String username, boolean loginSuccess) {
        if (loginSuccess) {
            return "Welcome " + username + ", it is great to see you again.";
        }
        return "Username or password incorrect, please try again.";
    }
}
