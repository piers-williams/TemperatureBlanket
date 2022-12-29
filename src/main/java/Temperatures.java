import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Temperatures {

    public static Float[][] readTemperatures(String fileName, int minLoc, int maxLoc) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(fileName));
        return lines.stream()
                .skip(1)
                .map(x -> x.split(","))
                .map(x -> new Float[]{Float.parseFloat(x[maxLoc]), Float.parseFloat(x[minLoc])})
                .toArray(Float[][]::new);
    }

    public static Float[][] readTemperatures(String fileName) throws IOException
    {
        return readTemperatures(fileName, 3, 1);
    }
}
