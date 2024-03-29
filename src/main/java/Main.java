import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        var temperatureFileName = args[0];
        var minLoc = Integer.parseInt(args[1]);
        var maxLoc = Integer.parseInt(args[2]);
        var scaleFileName = args[3];
        var outputFileName = args[4];

        var temperatureData = Temperatures.readTemperatures(temperatureFileName, minLoc, maxLoc);
        var scaleData = TemperatureScale.fixColors(TemperatureScale.getColors(scaleFileName));
        final int squareHeight = 30;
        var width = 18;
        var height = 21;
        var image = new BufferedImage((width) * squareHeight, (height) * squareHeight, BufferedImage.TYPE_INT_RGB );
        var graphics = image.getGraphics();

        for(int i = 0; i <= width; i++){
            for(int j = 0; j <= height; j++){
                var index = (i * height) + j;
                if(temperatureData.length > index) {
                    var temps = temperatureData[index];
                    graphics.setColor(scaleData.get(Math.round(temps[0])));
                    graphics.fillRect(i * squareHeight, j * squareHeight, squareHeight, squareHeight);
                    graphics.setColor(scaleData.get(Math.round(temps[1])));
                    graphics.fillRect((i * squareHeight) + squareHeight / 4,
                            j * squareHeight + squareHeight / 4,
                            squareHeight / 2,
                            squareHeight / 2);
                }
            }
        }

        File file = new File(outputFileName);
        ImageIO.write(image, "png", file);
    }
}
