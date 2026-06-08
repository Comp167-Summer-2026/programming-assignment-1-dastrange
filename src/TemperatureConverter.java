import java.util.Scanner;

public class TemperatureConverter {

    public static double convertTemperature(double temperature, String unit) {
        double result = 0.0;
 
        if (unit.equals("C") || unit.equals("c")) {
            result = (temperature * (9.0 / 5.0)) + 32.0;
        } else if (unit.equals("F") || unit.equals("f")) {
            result = (temperature - 32.0) * (5.0 / 9.0);
        }
 
        return result;
    }
 
    public static boolean isValidInput(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
 
        int i = 0;
        boolean sawDecimal = false;
 
        if (str.charAt(0) == '-') {
            if (str.length() == 1) {
                return false;
            }
            i = 1;
        }
 
        while (i < str.length()) {
            char c = str.charAt(i);
            if (c == '.') {
                if (sawDecimal) {
                    return false;
                }
                sawDecimal = true;
            } else if (!Character.isDigit(c)) {
                return false;
            }
            i++;
        }
 
        return true;
    }
 

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        boolean active = true;
 
        while (active) {
            System.out.print("Enter a temperature or \"stop\" to quit: ");
            String tempInput = scnr.nextLine().trim();
 
            if (tempInput.equalsIgnoreCase("stop")) {
                active = false;
            } else if (!isValidInput(tempInput)) {
                System.out.println("That doesn't look like a number. Please try again.");
            } else {
                double temp = Double.parseDouble(tempInput);
                boolean unitAccepted = false;
 
                while (!unitAccepted) {
                    System.out.print("Enter unit (C or F): ");
                    String unit = scnr.nextLine().trim();
 
                    if (unit.equalsIgnoreCase("stop")) {
                        active = false;
                        unitAccepted = true;
                    } else if (unit.equalsIgnoreCase("C") || unit.equalsIgnoreCase("F")) {
                        double converted = convertTemperature(temp, unit);
                        char fromUnit = Character.toUpperCase(unit.charAt(0));
                        char toUnit = (fromUnit == 'C') ? 'F' : 'C';
                        System.out.printf("%.2f%c is equal to %.2f%c%n", temp, fromUnit, converted, toUnit);
                        unitAccepted = true;
                    } else {
                        System.out.println("Invalid unit. Please enter C or F.");
                    }
                }
            }
        }
 
        System.out.println("Program terminated.");
        scnr.close();
    }
}