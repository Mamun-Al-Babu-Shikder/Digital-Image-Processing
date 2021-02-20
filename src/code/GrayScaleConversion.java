package code;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GrayScaleConversion {

    public static void main(String[] args) throws IOException {

        /**
         * Read image file and convert the image file to BufferedImage.
         */
        File inputFile = new File("resources/input/mbstu_logo.jpg");
        BufferedImage image = ImageIO.read(inputFile);
        displayImage("Input Image", ImageIO.read(inputFile));

        int width = image.getWidth();
        int height = image.getHeight();
        /**
         * Converting to GrayScale Image
         */
        for (int i=0; i<width; i++){
            for (int j=0; j<height; j++){
                int value = image.getRGB(i, j);
                Color color = new Color(value);
                image.setRGB(i, j, convertColor(color).getRGB());
            }
        }
        displayImage("Output Image", image);
    }

    // Color conversion
    public static Color convertColor(Color color){
        int red = (int) (color.getRed() * 0.299);
        int green = (int) (color.getGreen() * 0.299);
        int blue = (int) (color.getBlue() * 0.299);
        return new Color(red + green + blue, red + green + blue, red + green + blue);
    }

    // Display image using JFrame
    public static void displayImage(String title, BufferedImage image){
        JFrame frame = new JFrame();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        frame.setSize(450, 400);
        frame.setLocationRelativeTo(null);
        frame.setTitle(title);
        frame.setContentPane(new JLabel(new ImageIcon(image)));
        frame.setVisible(true);
    }
}