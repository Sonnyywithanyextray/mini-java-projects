import javax.swing.JOptionPane;

public class BMIwithGUI {

    public static void main(String[] args) {

        String name = JOptionPane.showInputDialog("Enter your name");
        JOptionPane.showMessageDialog(null, "Hello " + name);

        int age;
        try {
            age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age"));
            if (age < 18) {
                JOptionPane.showMessageDialog(null, "You are too young to be playing this game.");
                return;
            } else {
                JOptionPane.showMessageDialog(null, "You are " + age + " years old");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid age input. Please enter a valid integer.");
            return;
        }

        String option = JOptionPane.showInputDialog(null, "Do you prefer imperial or metric system?");

        if (option.equalsIgnoreCase("imperial")) {
            String heightInput = JOptionPane.showInputDialog("Enter your height in feet and inches (e.g., 5'3\")");
            try {
                String[] heightParts = heightInput.split("'"); // Split the input at the single quote (') character
                int feet = Integer.parseInt(heightParts[0]);
                int inches = 0;
                if (heightParts.length > 1) {
                    inches = Integer.parseInt(heightParts[1].substring(0, heightParts[1].indexOf("\""))); // Extract inches value
                }
                double height = feet * 12 + inches; // Convert feet and inches to inches
                JOptionPane.showOptionDialog(null, "You are " + height + " inches tall", "Height", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
                int weight = Integer.parseInt(JOptionPane.showInputDialog("Enter your weight."));
                double BMI = 703 * (weight / Math.pow(height, 2));
                if (BMI < 18.5) {
                    JOptionPane.showOptionDialog(null, "You are underweight", "BMI", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
                } else if (BMI >= 18.5 && BMI <= 24.9) {
                    JOptionPane.showOptionDialog(null, "You are in the normal weight range", "BMI", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
                } else if (BMI >= 25.0 && BMI <= 29.9) {
                    JOptionPane.showOptionDialog(null, "You are overweight", "BMI", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
                } else if (BMI >= 30.0) {
                    JOptionPane.showOptionDialog(null, "You are obese", "BMI", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
                    JOptionPane.showOptionDialog(null, "What is your diet usually consisted of?", "BMI", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid height or weight input. Please enter valid numeric values.");
                return;
            }
        }

        if (option.equalsIgnoreCase("metric")) {
            try {
                int height = Integer.parseInt(JOptionPane.showInputDialog("What is your height in centimeters?"));
                int weight = Integer.parseInt(JOptionPane.showInputDialog("What is your weight in kilograms?"));
                double BMI = 10000 * (weight / Math.pow(height, 2));
                if (BMI < 18.5) {
                    JOptionPane.showOptionDialog(null, "You are underweight", "BMI", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
                } else if (BMI >= 18.5 && BMI <= 24.9) {
                    JOptionPane.showOptionDialog(null, "You are in the normal weight range", "BMI", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
                } else if (BMI >= 25.0 && BMI <= 29.9) {
                    JOptionPane.showOptionDialog(null, "You are overweight", "BMI", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
                } else if (BMI >= 30.0) {
                    JOptionPane.showOptionDialog(null, "You are obese", "BMI", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
                    JOptionPane.showOptionDialog(null, "What is your diet usually consisted of?", "BMI", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid height or weight input. Please enter valid numeric values.");
                return;
            }
        } else {
            // empty block
        }
    }
}
