package code;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PixelMatrixAndGRB {

    public static void main(String[] args) throws IOException {

        /**
         * Read image file and convert the image file to BufferedImage.
         */
        File file = new File("resources/input/blackandwhite.jpg");
        BufferedImage image = ImageIO.read(file);

        int width = image.getWidth();
        int height = image.getHeight();

        /**
         * Display RGB value for each pixel
         */
        for (int i=0; i<width; i++){
            for (int j=0; j<height; j++){
                int value = image.getRGB(i, j);
                Color color = new Color(value);
                System.out.print("RGB("+color.getRed()+","+color.getGreen()+","+color.getBlue()+")\t");
            }
            System.out.println();
        }

        System.out.println("Pixel Matrix: (" + width + "*" + height + ") = " + (width*height) );

        /**
         * Display image using JFrame of AWT
         */
        JFrame frame = new JFrame();
        frame.setSize(450, 400);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Getting Image Pixels and RGB Value");
        frame.setContentPane(new JLabel(new ImageIcon(image)));
        frame.setVisible(true);
    }
}
