public class Main {

    // Convert seconds to HH:MM:SS format
    public static String humanReadable(int seconds) {

        int hours = seconds / 3600;           // total hours
        int minutes = (seconds % 3600) / 60;  // remaining minutes
        int secs = seconds % 60;              // remaining seconds

        // Format as two digits using String.format
        return String.format("%02d:%02d:%02d", hours, minutes, secs);
    }

    public static void main(String[] args) {

        int[] testSeconds = {0, 59, 60, 3599, 3600, 86399, 359999};

        for (int sec : testSeconds) {
            System.out.println(sec + " seconds -> " + humanReadable(sec));
        }
    }
}
