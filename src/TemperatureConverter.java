public class TemperatureConverter {

    public static double convertTemperature(double temperature, String unit) {
        if (unit.equalsIgnoreCase("C")) {
            return (temperature * 9.0 / 5.0) + 32;
        } else {
            return (temperature - 32) * 5.0 / 9.0;
        }
    }


     

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
 
        while (running) {
            System.out.print("Enter a temperature (or 'stop' to quit): ");
            String input = scanner.nextLine().trim();
 
            if (input.equalsIgnoreCase("stop")) {
                running = false;
            } else {
                boolean hasDigit = false;
                boolean hasDot = false;
                boolean valid = true;
                int startIndex = 0;
 
                if (input.length() == 0) {
                    valid = false;
                } else {
                    if (input.charAt(0) == '-') {
                        startIndex = 1;
                    }
                    if (startIndex >= input.length()) {
                        valid = false;
                    }
                }
 
                if (valid) {
                    for (int i = startIndex; i < input.length(); i++) {
                        char c = input.charAt(i);
                        if (c == '.') {
                            if (hasDot) {
                                valid = false;
                            }
                            hasDot = true;
                        } else if (c >= '0' && c <= '9') {
                            hasDigit = true;
                        } else {
                            valid = false;
                        }
                    }
                    if (!hasDigit) {
                        valid = false;
                    }
                }
 
                if (!valid) {
                    System.out.println("Invalid temperature input. Please enter a numeric value.");
                } else {
                    double temp = Double.parseDouble(input);
 
                    System.out.print("Enter unit (C or F): ");
                    String unit = scanner.nextLine().trim().toUpperCase();
 
                    if (!unit.equals("C") && !unit.equals("F")) {
                        System.out.println("Invalid unit. Please enter C or F.");
                    } else {
                        double converted = convertTemperature(temp, unit);
                        String toUnit = unit.equals("C") ? "F" : "C";
                        System.out.printf("%.2f\u00B0%s is equal to %.2f\u00B0%s%n",
                                temp, unit, converted, toUnit);
                    }
                }
            }
        }
 
        scanner.close();
    }
}
 
 
