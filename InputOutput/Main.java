import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputFile = "InputOutput/renginiai.csv";
        String outputFile = "InputOutput/atrinkti_renginiai.csv";
        List<Attendance> attendances = Utilities.readAttendancesFromFile(inputFile);

        System.out.println(
                "Bendras lankytojų skaičių visuose renginiuose: " +
                Utilities.calcTotalAttendants(attendances)
        );

        System.out.println(
                "\nVidutinis lankytojų skaičių viename renginyje: " +
                Utilities.calcAverageAttendantsPerEvent(attendances)
        );

        List<Attendance> filtered = Utilities.filterByAttendants(attendances);
        System.out.println("\nRenginiai, kurių lankytojų skaičius viršiją vidutinį lankytojų skaičių:");
        filtered.forEach(x -> System.out.println(x.toString()));

        Utilities.sortByAttendantsAndDate(filtered);
        System.out.println("\nAtrinkti renginiai surikiuoti pagal lankytojų skaičių ir renginio datą:");
        filtered.forEach(x -> System.out.println(x));

        Utilities.writeAttendancesToFile(filtered, outputFile);
    }


}
