package app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.geom.AffineTransform;

import javax.imageio.ImageIO;

public class Asteroid extends ModelObject {
    BufferedImage img;
    double rotation;
    public Asteroid(int x, int y) {
        this.setX(x);
        this.setY(y);
        this.setXVelocity((Math.random()*4)-2);
        this.setYVelocity((Math.random()*4)-2);
        this.setWidth(100);
        this.setHeight(100);

        try {
            File file = new File("src/images/asteroid.png");
            System.out.println(file.getAbsolutePath());
            this.img = ImageIO.read(file);
            BufferedImage outputImage = new BufferedImage((int)this.getWidth(),
            (int)this.getHeight(), this.img.getType());

            // scales the input image to the output image
            Graphics2D g2d = outputImage.createGraphics();
            g2d.drawImage(this.img, 0, 0, (int)this.getWidth(), (int)this.getHeight(), null);
            g2d.dispose();
            this.img = outputImage;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.red);

        BufferedImage rotatedImage = rotateImageByDegrees(this.img, this.rotation);

        g.drawImage(rotatedImage, (int)(this.getX()-(this.getWidth()/2)), (int)(this.getY()-(this.getHeight()/2)), null);
        this.rotation += 0.01;
        this.rotation = this.rotation % (2 * Math.PI);
    }

    public BufferedImage rotateImageByDegrees(BufferedImage img, double radians) {
        int w = img.getWidth();
        int h = img.getHeight();

        BufferedImage rotated = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rotated.createGraphics();
        AffineTransform at = new AffineTransform();

        int x = w / 2;
        int y = h / 2;
        at.rotate(radians, x, y);
        g2d.setTransform(at);
        g2d.drawImage(img, 0, 0, null);
        //g2d.setColor(Color.RED);
        //g2d.drawRect(0, 0, newWidth - 1, newHeight - 1);
        g2d.dispose();

        return rotated;
    }

}