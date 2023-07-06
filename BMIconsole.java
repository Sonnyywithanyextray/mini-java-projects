import java.util.Scanner;
public class BMIconsole {
    public static void main (String [] args) {

        Scanner scanner = new Scanner (System.in);
        System.out.println("Hi. What's your weight?");
        int weight = scanner.nextInt();

        System.out.println("What's your height? Please just say the foot. For instance, if you're 6 foot 3, type 6.");
        int heightfoot = scanner.nextInt();

        System.out.println("Now, what are the remaining inches of your height? For instance, if you're 6 foot 3, type 3.");
        int heightinches = scanner.nextInt();

        int totalheight = heightfoot*12+heightinches;
        double correctedheight = (double)totalheight/12;        
        System.out.println(correctedheight);

        double BMI = 703 * (weight / Math.pow(correctedheight, 2));

        if (BMI < 18.5) {
                System.out.println("You are underweight.");
        } else if (BMI >= 18.5 && BMI <= 24.9) {
                System.out.println("You are in normal weight range.");
        } else if (BMI >= 25.0 && BMI <= 29.9) {
                System.out.println("You are overweight.");
        } else if (BMI >= 30.0) {
                System.out.println("You are obese.");
         }
    }
}