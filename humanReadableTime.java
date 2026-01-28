public class Main {

    public static String humanReadable(int seconds) {

        int hours = seconds / 3600;
        int minutes = (seconds / 60) % 60;
        int secs = seconds % 60;

        StringBuilder sb = new StringBuilder(8);

        // Hours
        if (hours < 10) sb.append('0');
        sb.append(hours).append(':');

        // Minutes
        if (minutes < 10) sb.append('0');
        sb.append(minutes).append(':');

        // Seconds
        if (secs < 10) sb.append('0');
        sb.append(secs);

        return sb.toString();
    }
    
    public static void main(String[] args) {

        int[] testSeconds = {0, 59, 60, 3599, 3600, 86399, 359999};

        for (int sec : testSeconds) {
            System.out.println(sec + " seconds -> " + humanReadable(sec));
        }
    }
}
