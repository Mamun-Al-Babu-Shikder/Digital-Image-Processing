package code;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SubtractTwoImage {

    public static void main(String[] args) throws IOException {

        File imgFile1 = new File("resources/input/input_image1.jpg");
        File imgFile2 = new File("resources/input/8-bit-256-x-256-Grayscale-Lena-Image_Q320.jpg");

        BufferedImage img1 = ImageIO.read(imgFile1);
        BufferedImage img2 = ImageIO.read(imgFile2);

        displayImage("Input Image 01", img1);
        displayImage("Input Image 02", img2);

        int width = img1.getWidth();
        int height = img1.getHeight();

        BufferedImage outputImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int i=0; i<width; i++){
            for (int j=0; j<height; j++){
                Color c1 = new Color(img1.getRGB(i, j));
                Color c2 = new Color(img2.getRGB(i, j));
                outputImg.setRGB(i, j, new Color(Math.abs(c1.getRed()-c2.getRed()),
                        Math.abs(c1.getGreen()-c2.getGreen()), Math.abs(c1.getBlue()-c2.getBlue())).getRGB());
            }
        }
        displayImage("Output Image", outputImg);
    }

    public static void displayImage(String title, BufferedImage image){
        JFrame frame = new JFrame();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        frame.setSize(450, 450);
        frame.setLocationRelativeTo(null);
        frame.setTitle(title);
        frame.setContentPane(new JLabel(new ImageIcon(image)));
        frame.setVisible(true);
    }
}
