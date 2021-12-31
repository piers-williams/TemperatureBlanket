import java.awt.Color;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TemperatureScale {

    public static Map<Integer, Color> getColors(String fileName) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(fileName));
        return lines.stream()
                .map(x -> x.split(","))
                .map(x -> Arrays.stream(x).map(Integer::parseInt).toArray(Integer[]::new))
                .collect(Collectors.toMap(x -> x[0], x -> new Color(x[1], x[2], x[3])));
    }
}
