import java.util.*;

public class DemoChapman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Beagle> beagles = new ArrayList<>();
        final double UNDERWEIGHT_LIMIT = 1.49;
        final double OVERWEIGHT_LIMIT_MALE = 2.31;
        final double OVERWEIGHT_LIMIT_FEMALE = 2.25;
        int underweightCount = 0;
        int healthyCount = 0;
        int overweightCount = 0;
        double totalBmi = 0.0;

        // Continue prompting the user to enter Beagle data
        char continueInput;
        do {
            System.out.print("Enter a beagle's name: ");
            String name = scanner.nextLine();

            // Input validation for name to avoid empty strings
            while (name.trim().isEmpty()) {
               System.out.println("Invalid name, please try again!");  // Display error message on a new line
               System.out.print("Enter a beagle's name: ");  // Prompt the user on a new line
               name = scanner.nextLine();
            }
            int height = 0;
            // Input validation for height
            do {
                System.out.print("Enter height in total (min: 9 inches. - max: 22 inches.): ");
                height = scanner.nextInt();
                if (height < 9 || height > 22) {
                    System.out.println("Invalid height, please try again!");
                }
            } while (height < 9 || height > 22);

            double weight = 0;
            // Input validation for weight
            do {
                System.out.print("Enter weight in pounds (min: 7 lb. - max: 60 lb.): ");
                weight = scanner.nextDouble();
                if (weight < 7 || weight > 60) {
                    System.out.println("Invalid weight, please try again!");
                }
            } while (weight < 7 || weight > 60);

            // Gender selection
            scanner.nextLine(); // Consume newline
            String gender;
            do {
               System.out.println("Choose the beagle's gender:\n\tA - Male\n\tB - Female");
               System.out.print("Enter your choice: ");
               gender = scanner.nextLine();

               if (gender.equalsIgnoreCase("A")) {
                  gender = "Male";  // Convert A to Male
               } else if (gender.equalsIgnoreCase("B")) {
                  gender = "Female";  // Convert B to Female
               } else {
               System.out.println("Incorrect answer, please try again!");
               }
            } while (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female"));
            
            Beagle beagle = new Beagle(name, height, weight, gender);
            BeagleBMI bmiCalculator = new BeagleBMI(beagle);
            beagle.setBmi(bmiCalculator.calcBMI());
            beagles.add(beagle);
            
            // Increment counts based on BMI status
            String status = bmiCalculator.weightStatus();
            if (status.equalsIgnoreCase("Underweight")) {
                underweightCount++;
            } else if (status.equalsIgnoreCase("Healthy")) {
                healthyCount++;
            } else {
                overweightCount++;
            }
            totalBmi += beagle.getBmi();

            // Ask if user wants to continue with input validation for valid responses
            do {
                System.out.print("Do you wish to enter for another Beagle (Y/Yes/Continue, to continue, N/No/Quite to quit)? ");
                continueInput = scanner.nextLine().charAt(0);
                if (continueInput != 'Y' && continueInput != 'y' && continueInput != 'N' && continueInput != 'n') {
                    System.out.println("Incorrect answer, please try again!");
                }
            } while (continueInput != 'Y' && continueInput != 'y' && continueInput != 'N' && continueInput != 'n');
        } while (continueInput == 'Y' || continueInput == 'y');

        // Output the Beagle list and statistics
        System.out.println("\n    ---Beagle List---");
        for (Beagle b : beagles) {
            System.out.println(b);
        }

        // Calculating and printing the statistics
        double averageBmi = totalBmi / Beagle.beagleCount;
        System.out.println("\nTotal beagles: " + Beagle.beagleCount);
        System.out.printf("Average BMI: %.2f\n", averageBmi);
        System.out.println("\nBeagle BMI Status Breakdown:");
        System.out.println("\tUnderweight: " + underweightCount);
        System.out.println("\tHealthy: " + healthyCount);
        System.out.println("\tOverweight: " + overweightCount);
    }
}
