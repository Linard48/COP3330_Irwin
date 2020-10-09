import java.util.Scanner;

public class BodyMassIndex {
    Scanner scanner = new Scanner(System.in);
    private double weight, height;

    public BodyMassIndex(double height, double weight) {
        this.weight = weight;
        this.height = height;
    }


    public double calculateBmi() {
        return (weight * 703) / (height * height);
    }

    public String calculateCategory() {
        double bmi_val = calculateBmi();
        String category;
        if (bmi_val <= 18.5) {
            category = "Underweight";
        } else if (bmi_val < 25) {
            category = "Normal weight";
        } else if (bmi_val < 30) {
            category = "Overweight";
        } else {
            category = "Obese";
        }
        return category;
    }
}