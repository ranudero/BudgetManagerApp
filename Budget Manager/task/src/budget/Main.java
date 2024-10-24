package budget;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner keyboard = new Scanner(System.in);
        String input;
        double totalAmount = 0;

        while (keyboard.hasNextLine()) {
            input = keyboard.nextLine();
            String[] inputArray = input.split("\\$");
            if (inputArray.length > 1) {
                try {
                    System.out.println(input);
                    double amount = Double.parseDouble(inputArray[1]);
                    totalAmount += amount;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format: " + inputArray[1]);
                }
            }
        }

        System.out.println("Total: $" + totalAmount);

    }
}
