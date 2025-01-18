import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Utilities {

    public static List<Attendance> readAttendancesFromFile(String filename) {
        List<Attendance> attendances = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));

            String line;
            while((line = br.readLine()) != null) {
                try {
                    String[] values = line.trim().split(",");

                    attendances.add(new Attendance(
                            new Event(Integer.parseInt(values[0]), values[1], LocalDate.parse(values[3]), values[4]),
                            Integer.parseInt(values[2])
                    ));
                } catch (Exception ignored) {}
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return attendances;
    }

    public static void writeAttendancesToFile(List<Attendance> attendances, String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write("Renginio_ID,Renginio_pavadinimas,Lankytojai,Data,Vieta");
            bw.newLine();

            for (Attendance a : attendances) {
                bw.write(a.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int calcTotalAttendants(List<Attendance> attendances) {
        return attendances.stream().mapToInt(x -> x.getAttendants()).sum();
    }

    public static double calcAverageAttendantsPerEvent(List<Attendance> attendances) {
        return (double) calcTotalAttendants(attendances) / attendances.size();
    }

    public static List<Attendance> filterByAttendants(List<Attendance> attendances) {
        double avgAttendants = calcAverageAttendantsPerEvent(attendances);
        return attendances.stream().filter(x -> x.getAttendants() >= avgAttendants).collect(Collectors.toList());
    }

    public static void sortByAttendantsAndDate(List<Attendance> attendances) {
        Collections.sort(attendances,
                Comparator.comparing(Attendance::getAttendants, (x1, x2) -> {
                    return x2 - x1;
                })
                .thenComparing(Attendance::getEvent, (y1, y2) -> {
                    return y2.getDate().compareTo(y1.getDate());
                })
        );
    }

}
