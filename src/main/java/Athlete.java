public class Athlete{
        private final int athleteNumber;
        private final String athleteName;
        private final String countryCode;
        private final String skiTimeResult;
        private final String[] shootingRanges;

        public Athlete(int athleteNumber, String athleteName, String countryCode, String skiTimeResult, String[] shootingRanges) {
            this.athleteNumber = athleteNumber;
            this.athleteName = athleteName;
            this.countryCode = countryCode;
            this.skiTimeResult = skiTimeResult;
            this.shootingRanges = shootingRanges;
        }

        public int getAthleteNumber() {
            return athleteNumber;
        }

        public String getAthleteName() {
            return athleteName;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public String getSkiTimeResult() {
            return skiTimeResult;
        }

        public String[] getShootingRanges() {
            return shootingRanges;
        }

        public int getTotalTimeResult() {
            int totalTime = timeToSeconds(skiTimeResult);
            for (String range : shootingRanges) {
                for (char shot : range.toCharArray()) {
                    if (shot == ShootingResult.MISS.getSymbol()) {
                        totalTime += 10;
                    }
                }
            }
            return totalTime;
        }

        private int timeToSeconds(String time) {
            String[] parts = time.split(":");
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            int seconds = Integer.parseInt(parts[2]);
            return hours*3600 + minutes * 60 + seconds;
        }
}
