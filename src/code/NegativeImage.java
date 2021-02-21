package code;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class NegativeImage {

    public static void main(String[] args) throws IOException {

        File imageFile = new File("resources/input/MCZ7o.jpg");

        BufferedImage originalImg = ImageIO.read(imageFile);
        displayImage("Original Image", originalImg);

        int width = originalImg.getWidth();
        int height = originalImg.getHeight();

        BufferedImage outputImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int i=0; i<width; i++){
            for (int j=0; j<height; j++){
                Color color = new Color(originalImg.getRGB(i, j));
                Color newColor = new Color(255-color.getRed(), 255-color.getGreen(), 255-color.getBlue());
                outputImg.setRGB(i, j, newColor.getRGB());
            }
        }
        displayImage("Negative Image", outputImg);
    }

    public static void displayImage(String title, BufferedImage image){
        JFrame frame = new JFrame();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        frame.setSize(550, 590);
        frame.setLocationRelativeTo(null);
        frame.setTitle(title);
        frame.setContentPane(new JLabel(new ImageIcon(image)));
        frame.setVisible(true);
    }
}