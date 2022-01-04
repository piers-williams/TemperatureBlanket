import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        var temperatureFileName = args[0];
        var scaleFileName = args[1];

        var temperatureData = Temperatures.readTemperatures(temperatureFileName);
        var scaleData = TemperatureScale.getColors(scaleFileName);
        final int squareHeight = 30;
        var width = 18;
        var height = 21;
        var image = new BufferedImage(width * squareHeight, height * squareHeight, BufferedImage.TYPE_INT_RGB );
        var graphics = image.getGraphics();

        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                var temps = temperatureData[i * width + j];
                graphics.setColor(scaleData.get(Math.round(temps[0])));
                graphics.fillRect(i * squareHeight, j * squareHeight, squareHeight, squareHeight);
                graphics.setColor(scaleData.get(Math.round(temps[1])));
                graphics.fillRect((i * squareHeight) + squareHeight / 4,
                        j * squareHeight + squareHeight / 4,
                        squareHeight / 2,
                        squareHeight / 2);
            }
        }

        File file = new File(args[2]);
        ImageIO.write(image, "png", file);
    }
}
