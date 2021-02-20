package code;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RGBtoColorImage {

    public static void main(String[] args) throws IOException {

        /**
         * Read image file and convert the image file to BufferedImage.
         */
        File imgFile1 = new File("resources/input/red_flower1.jpg");
        File imgFile2 = new File("resources/input/green_flower1.jpg");
        File imgFile3 = new File("resources/input/blue_flower1.jpg");

        BufferedImage redImage = ImageIO.read(imgFile1);
        BufferedImage greenImage = ImageIO.read(imgFile2);
        BufferedImage blueImage = ImageIO.read(imgFile3);

        displayImage("Red Image", redImage);
        displayImage("Green Image", greenImage);
        displayImage("Blue Image", blueImage);

        int width = redImage.getWidth();
        int height = redImage.getHeight();

        BufferedImage colorImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int i=0; i<width; i++){
            for (int j=0; j<height; j++){
                Color redColor = new Color(redImage.getRGB(i, j));
                Color greenColor = new Color(greenImage.getRGB(i, j));
                Color blueColor = new Color(blueImage.getRGB(i, j));
                Color color = new Color(redColor.getRed(), greenColor.getGreen(), blueColor.getBlue());
                colorImage.setRGB(i, j,  color.getRGB());
            }
        }

        displayImage("Color Image", colorImage);
        ImageIO.write(redImage, "jpg", new File("resources/output/original_flower1.jpg"));

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
        frame.setSize(350, 300);
        frame.setLocationRelativeTo(null);
        frame.setTitle(title);
        frame.setContentPane(new JLabel(new ImageIcon(image)));
        frame.setVisible(true);
    }

}
