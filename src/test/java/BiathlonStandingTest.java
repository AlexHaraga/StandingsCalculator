import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class BiathlonStandingTest {
    @Test
    void testCsvParsing() {
        String csvData = "101,Alice,USA,25:30,xooox,oxxoo,xxoox\n" +
                "102,Bob,GER,24:45,xxxxx,xxxxx,xxxxo\n" +
                "103,Charlie,CAN,26:15,oxxxx,ooooo,xxxxx";
        List<Athlete> athletes = BiathlonStanding.calculateStandings();

        assertEquals(3, athletes.size());

        Athlete alice = athletes.get(0);
        assertEquals(101, alice.getAthleteNumber());
        assertEquals("Alice", alice.getAthleteName());
        assertEquals("USA", alice.getCountryCode());
        assertEquals("25:30", alice.getSkiTimeResult());
        assertArrayEquals(new String[]{"xooox", "oxxoo", "xxoox"}, alice.getShootingRanges());

        Athlete bob = athletes.get(1);
        assertEquals(102, bob.getAthleteNumber());
        assertEquals("Bob", bob.getAthleteName());
        assertEquals("GER", bob.getCountryCode());
        assertEquals("24:45", bob.getSkiTimeResult());
        assertArrayEquals(new String[]{"xxxxx", "xxxxx", "xxxxo"}, bob.getShootingRanges());

        Athlete charlie = athletes.get(2);
        assertEquals(103, charlie.getAthleteNumber());
        assertEquals("Charlie", charlie.getAthleteName());
        assertEquals("CAN", charlie.getCountryCode());
        assertEquals("26:15", charlie.getSkiTimeResult());
        assertArrayEquals(new String[]{"oxxxx", "ooooo", "xxxxx"}, charlie.getShootingRanges());
    }

}
