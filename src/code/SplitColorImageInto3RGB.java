package code;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SplitColorImageInto3RGB {

    public static void main(String[] args) throws IOException {

        /**
         * Read image file and convert the image file to BufferedImage.
         */
        File inputFile = new File("resources/input/flower1.jpg");
        BufferedImage image = ImageIO.read(inputFile);
        displayImage("Orginal Image", image);

        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage redImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        BufferedImage greenImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        BufferedImage blueImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int i=0; i<width; i++){
            for (int j=0; j<height; j++){
                int value = image.getRGB(i, j);
                Color color = new Color(value);
                redImage.setRGB(i, j, (new Color(color.getRed(), 0, 0).getRGB()));
                greenImage.setRGB(i, j, (new Color(0, color.getGreen(), 0).getRGB()));
                blueImage.setRGB(i, j, (new Color(0, 0, color.getBlue()).getRGB()));
            }
        }

        displayImage("Red Image", redImage);
        displayImage("Green Image", greenImage);
        displayImage("Blue Image", blueImage);

        ImageIO.write(redImage, "jpg", new File("resources/output/red_flower1.jpg"));
        ImageIO.write(greenImage, "jpg", new File("resources/output/green_flower1.jpg"));
        ImageIO.write(blueImage, "jpg", new File("resources/output/blue_flower1.jpg"));
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
        frame.setSize(650, 600);
        frame.setLocationRelativeTo(null);
        frame.setTitle(title);
        frame.setContentPane(new JLabel(new ImageIcon(image)));
        frame.setVisible(true);
    }
}
