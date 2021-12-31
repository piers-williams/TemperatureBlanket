import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Temperatures {

    public static Float[] readTemperatures(String fileName) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(fileName));
        return lines.stream()
                .skip(1)
                .map(x -> x.split(","))
                .map(x -> x[1])
                .map(Float::parseFloat)
                .toArray(Float[]::new);
    }
}
