import org.apache.commons.math3.stat.regression.SimpleRegression;
import java.util.Scanner;

public class DasWetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter temperature: ");
        double temperature = scanner.nextDouble();

        System.out.print("Enter humidity: ");
        double humidity = scanner.nextDouble();

        System.out.print("Enter wind speed: ");
        double windSpeed = scanner.nextDouble();


        double[] temperatureData = {20.5, 25.3, 23.8, 22.1, 24.6, 21.9};
        double[] rainfallData = {1.2, 0.8, 1.5, 1.1, 1.4, 1.0};


        SimpleRegression regression = new SimpleRegression();
        for (int i = 0; i < temperatureData.length; i++) {
            regression.addData(temperatureData[i], rainfallData[i]);
        }

        double predictedRainfall = regression.predict(temperature);

        System.out.println("Predicted rainfall: " + predictedRainfall + " cm");

        scanner.close();
    }
}





