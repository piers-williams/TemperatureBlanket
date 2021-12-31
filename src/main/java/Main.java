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
final int height = 30;
        var image = new BufferedImage(temperatureData.length, height, BufferedImage.TYPE_INT_RGB );
        var graphics = image.getGraphics();
        for(int i = 0; i < temperatureData.length; i++){
            graphics.setColor(scaleData.get(Math.round(temperatureData[i])));
            for(int j = 0; j < height; j++){
                graphics.drawRect(i, j, 1, 1);
            }
        }

        File file = new File(args[2]);
        ImageIO.write(image, "png", file);
    }
}
