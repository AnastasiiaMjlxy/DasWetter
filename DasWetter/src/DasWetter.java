import org.apache.commons.math3.stat.regression.SimpleRegression;
import java.util.Scanner;

public class DasWetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter location: ");
        String location = scanner.nextLine();

        System.out.print("Enter temperature: ");
        double temperature = scanner.nextDouble();

        System.out.print("Enter humidity: ");
        double humidity = scanner.nextDouble();

        System.out.print("Enter wind speed: ");
        double windSpeed = scanner.nextDouble();

        System.out.print("Enter number of days to forecast: ");
        int numDays = scanner.nextInt();
        double[] temperatureData = getTemperatureDataForLocation(location);
        double[] rainfallData = getRainfallDataForLocation(location);

        if (temperatureData == null || rainfallData == null) {
            System.out.println("Data not available for the specified location.");
            scanner.close();
            return;
        }

        SimpleRegression regression = new SimpleRegression();
        for (int i = 0; i < temperatureData.length; i++) {
            regression.addData(temperatureData[i], rainfallData[i]);
        }

        for (int day = 1; day <= numDays; day++) {
            double predictedRainfall = regression.predict(temperature);

            System.out.println("Day " + day + " - Predicted rainfall for location " + location + ": " + predictedRainfall + " cm");

            temperature += 1;
        }

        scanner.close();
    }

    private static double[] getTemperatureDataForLocation(String location) {

        if (location.equalsIgnoreCase("cityA")) {
            return new double[]{20.5, 25.3, 23.8, 22.1, 24.6, 21.9};
        } else if (location.equalsIgnoreCase("cityB")) {
            return new double[]{22.0, 26.7, 24.3, 21.5, 23.8, 22.4};
        } else {
            return null;
        }
    }


    private static double[] getRainfallDataForLocation(String location) {
        if (location.equalsIgnoreCase("cityA")) {
            return new double[]{1.2, 0.8, 1.5, 1.1, 1.4, 1.0};
        } else if (location.equalsIgnoreCase("cityB")) {
            return new double[]{1.0, 0.5, 0.9, 0.8, 1.2, 1.1};
        } else {
            return null;
        }
    }
}
