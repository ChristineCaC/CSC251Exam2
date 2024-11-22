/**
  The BeagleBMI class calculates the BMI of a Beagle and determines its weight status.
 */
public class BeagleBMI {
    private final double height;  // Height of the beagle in inches
    private final double weight;  // Weight of the beagle in pounds
    private final String gender;  // Gender of the beagle

    /**
      Constructor to initialize the BeagleBMI with a Beagle object.
      @param beagle The Beagle object to calculate BMI for.
     */
    public BeagleBMI(Beagle beagle) {
        this.height = beagle.getHeight();
        this.weight = beagle.getWeight();
        this.gender = beagle.getGender();
    }

    /**
      Calculates and returns the BMI for the beagle.
      @return The BMI of the beagle.
     */
    public double calcBMI() {
        return weight / height;
    }

    /**
      Determines the weight status of the beagle based on its BMI and gender.
      @return A string representing the weight status (Underweight, Healthy, Overweight).
     */
    public String weightStatus() {
        double bmi = calcBMI();
        if (gender.equalsIgnoreCase("Male")) { // Male
            if (bmi < 1.54) {
                return "Underweight";
            } else if (bmi <= 2.31) {
                return "Healthy";
            } else {
                return "Overweight";
            }
        } else { // Female
            if (bmi < 1.49) {
                return "Underweight";
            } else if (bmi <= 2.25) {
                return "Healthy";
            } else {
                return "Overweight";
            }
        }
    }

    /**
      Returns a string representation of the BMI and weight status.
      @return A string containing the BMI and weight status.
     */
    public String toString() {
        return String.format("BMI: %.1f\nStatus: %s", calcBMI(), weightStatus());
    }
}
