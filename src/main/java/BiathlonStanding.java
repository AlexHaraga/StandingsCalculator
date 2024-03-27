import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class BiathlonStanding {

    static List<Athlete> readAthletesFromFile(String "DEMO.csv") {
        List<Athlete> athletes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("DEMO.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int athleteNumber = Integer.parseInt(parts[0]);
                String athleteName = parts[1];
                String countryCode = parts[2];
                String skiTimeResult = parts[3];
                String[] shootingRanges = Arrays.copyOfRange(parts, 4, parts.length);
                athletes.add(new Athlete(athleteNumber, athleteName, countryCode, skiTimeResult, shootingRanges));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return athletes;
    }

    static void calculateStandings(List<Athlete> athletes) {
        athletes.sort(Comparator.comparingInt(Athlete::getTotalTimeResult));
    }
}
