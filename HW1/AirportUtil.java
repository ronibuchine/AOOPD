import java.util.ArrayList;
import java.util.Arrays;

public class AirportUtil {
    public static void sortTransport(Comparable[] transport) {
        Arrays.sort(transport);
    }

    static String reportAll(Movable[] movables) {
        ArrayList<String> buffer = new ArrayList<>();
        for (Movable m : movables) {
            System.out.println(m.toString());
        }
        return String.join("\n", buffer);
    }
}
