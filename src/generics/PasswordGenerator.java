package generics;

import java.util.Random;

public class PasswordGenerator {
    public char[] generateRandomPassword(){
        String lowercaseCharacters = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedNumbers = lowercaseCharacters + uppercaseCharacters + specialCharacters + numbers;
        var random = new Random();
        var password = new char[12];

        for (int i = 0; i < 12; i++) {
            password[i] = combinedNumbers.charAt(random.nextInt(combinedNumbers.length()));
        }

        return password;
    }
}
