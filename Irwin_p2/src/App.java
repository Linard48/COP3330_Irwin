import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    public static boolean moreInput() {
        System.out.println("Please enter Y or N");
        Scanner scanner = new Scanner(System.in);
        char input = scanner.next().charAt(0);
        if (input == 'Y') {
            return true;
        } else if (input == 'N') {
            return false;
        }
        return false;
    }

    public static double getUserWeight(){
        double weight;
        Scanner scanner = new Scanner (System.in);
        System.out.println("Please enter your weight in pounds");
        weight = scanner.nextDouble();

        while(weight <= 0){
            System.out.println("Please enter a correct weight");
            weight = scanner.nextDouble();
        }

        return weight;
    }

    public static double getUserHeight(){
        double height;
        Scanner scanner = new Scanner (System.in);
        System.out.println("Please enter your height in inches");
        height = scanner.nextDouble();

        while(height <= 0){
            System.out.println("Please enter a correct height");
            height = scanner.nextDouble();
        }

        return height;
    }

    public static void displayBmiStatistics(ArrayList bmiData){
        double sum = 0;
        double average;
        int len = bmiData.size();
        for (int i = 0; i < len; i++){
            BodyMassIndex tmp = (BodyMassIndex) bmiData.get(i);
            sum += tmp.calculateBmi();
        }
        average = sum / len;
        System.out.println("The average BMI so far is: " + average);
    }

    public static void displayBmiInfo(BodyMassIndex bmi) {
        double bmi_val = bmi.calculateBmi();
        String category = bmi.calculateCategory();
        System.out.printf("Your BMI is %.1f (%s)\n", bmi_val, category);
    }
}

