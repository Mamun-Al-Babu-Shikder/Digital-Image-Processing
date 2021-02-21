package code;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PixelReplication {

    public static void main(String[] args) throws IOException {

        File inputFile = new File("resources/input/flower2.jpg");
        BufferedImage image = ImageIO.read(inputFile);

        displayImage("Original Image", image);

        int width = image.getWidth();
        int height = image.getHeight();

        int ir = 0, ic, widthScaling = 3, heightScaling = 3;

        BufferedImage zoomingImage = new BufferedImage(width * widthScaling, height * heightScaling,
                BufferedImage.TYPE_INT_RGB);

        for (int i=0; i<width; i++){
            ic = 0;
            for (int j=0; j<height; j++){
                for (int m=ir; m<ir+widthScaling; m++){
                    for (int n=ic; n<ic+heightScaling; n++){
                        int rgb = image.getRGB(i, j);
                        zoomingImage.setRGB(m, n, rgb);
                    }
                }
                ic+=heightScaling;
            }
            ir+=widthScaling;
        }
        displayImage("Zooming Image", zoomingImage);
    }

    public static void displayImage(String title, BufferedImage image){
        JFrame frame = new JFrame();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        frame.setSize(700, 650);
        frame.setLocationRelativeTo(null);
        frame.setTitle(title);
        frame.setContentPane(new JLabel(new ImageIcon(image)));
        frame.setVisible(true);
    }
}