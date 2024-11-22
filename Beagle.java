/**
  The Beagle class represents a beagle dog with details such as name, height, weight, gender, and BMI.
 */
public class Beagle {
    private String name;  
    private int height;  
    private double weight;  
    private String gender;  
    private double bmi;  // Body Mass Index (BMI)

    // Static variable to count instances of Beagle
    public static int beagleCount = 0;

    /**
      Default constructor that initializes a Beagle with default values.
     */
    public Beagle() {
        this.name = "";
        this.height = 0;
        this.weight = 0.0;
        this.gender = "";
        beagleCount++;
    }

    /**
      Constructor to initialize a Beagle object with given values.
      @param n The name of the beagle.
      @param h The height of the beagle in inches.
      @param w The weight of the beagle in pounds.
      @param g The gender of the beagle (Male or Female).
     */
    public Beagle(String n, int h, double w, String g) {
        this.name = n;
        this.height = h;
        this.weight = w;
        this.gender = g;
        beagleCount++;
    }

    // Getters and Setters

    /**
      Gets the name of the beagle.
      @return The name of the beagle.
     */
    public String getName() {
        return name;
    }

    /**
      Sets the name of the beagle.
      @param n The name of the beagle.
     */
    public void setName(String n) {
        this.name = n;
    }

    /**
      Gets the height of the beagle.
      @return The height of the beagle in inches.
     */
    public int getHeight() {
        return height;
    }

    /**
      Sets the height of the beagle.
      @param h The height of the beagle in inches.
     */
    public void setHeight(int h) {
        this.height = h;
    }

    /**
      Gets the weight of the beagle.
      @return The weight of the beagle in pounds.
     */
    public double getWeight() {
        return weight;
    }

    /**
      Sets the weight of the beagle.
      @param w The weight of the beagle in pounds.
     */
    public void setWeight(double w) {
        this.weight = w;
    }

    /**
      Gets the gender of the beagle.
      @return The gender of the beagle.
     */
    public String getGender() {
        return gender;
    }

    /**
      Sets the gender of the beagle.
      @param g The gender of the beagle.
     */
    public void setGender(String g) {
        this.gender = g;
    }

    /**
      Gets the BMI of the beagle.
      @return The BMI of the beagle.
     */
    public double getBmi() {
        return bmi;
    }

    /**
      Sets the BMI of the beagle.
      @param bmi The BMI of the beagle.
     */
    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    /**
      Calculates and returns the height of the beagle in meters.
      @return A string representing the height in meters.
     */
    public String calcHeightMeters() {
        final double INCHES_TO_METERS = 1 / 39.3701; // Conversion constant based on your prompt
        double meters = height * INCHES_TO_METERS;
        return String.format("Height (m.): %.2fm.", meters);
    }

    /**
      Calculates and returns the weight of the beagle in kilograms.
      @return A string representing the weight in kilograms.
     */
    public String calcWeightKilograms() {
        final double POUNDS_TO_KILOGRAMS = 1 / 2.20462; // Conversion constant based on your prompt
        double kilograms = weight * POUNDS_TO_KILOGRAMS;
        return String.format("Weight (kg.): %.2f kg.", kilograms);
    }

    /**
      Returns a string representation of the Beagle object, including its details.
      @return A string representing the Beagle's details.
     */
    public String toString() {
        return String.format("-------------------------------------------------------\n" +
                             "Name: \t%s\n" +
                             "Gender: \t%s\n" +
                             "Height (in.): %d in.\n" +
                             "Weight (lb.): %.2f lb.\n" +
                             "%s\n" +
                             "%s\n" +
                             "BMI: \t\t\t\t%.1f\n" +
                             "Status: \t\t\t%s\n" +
                             "-------------------------------------------------------", 
                             name, gender, height, weight, 
                             calcHeightMeters(), calcWeightKilograms(), 
                             bmi, new BeagleBMI(this).weightStatus());
    }
}
