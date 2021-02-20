package code;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RGBImageToGrayscaleButKeepOneColor {

    public static void main(String[] args) throws IOException {

        File inputFile = new File("resources/input/flower3.png");
        BufferedImage image = ImageIO.read(inputFile);
        displayImage("Original Image", image);

        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);

        for (int i=0; i<width; i++){
            for (int j=0; j<height; j++){
                int value = image.getRGB(i, j);
                Color color = new Color(value);
                img.setRGB(i, j, convertColor(color).getRGB());
            }
        }

        displayImage("Output Image", img);
    }

    public static Color convertColor(Color color){
        int red = (int) (color.getRed() * 0.14);
        int green = (int) (color.getGreen() * 0.15);
        int blue = (int) (color.getBlue() * 0.19);
        if((color.getRed()/2)>color.getGreen() && (color.getRed()/2)>color.getBlue())
            return color;
        return new Color(red + green + blue, red + green + blue, red + green + blue);
    }

    public static void displayImage(String title, BufferedImage image){
        JFrame frame = new JFrame();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        frame.setSize(550, 500);
        frame.setLocationRelativeTo(null);
        frame.setTitle(title);
        frame.setContentPane(new JLabel(new ImageIcon(image)));
        frame.setVisible(true);
    }
}
