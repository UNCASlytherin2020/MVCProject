package app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.geom.AffineTransform;

import javax.imageio.ImageIO;

public class Player extends ModelObject {
    BufferedImage img;
    int pointerTargetX = -1;
    int pointerTargetY = -1;
    public Player(int x, int y, int width, int height) {
        this.setX(x);
        this.setY(y);
        this.setWidth(width);
        this.setHeight(height);
        try {
            File file = new File("src/images/rocket.png");
            System.out.println(file.getAbsolutePath());
            this.img = ImageIO.read(file);
            BufferedImage outputImage = new BufferedImage(width,
            height, this.img.getType());

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
        double newX = this.getPointerTargetX() - (this.getX() + (this.getWidth()/2));
        double newY = this.getPointerTargetY() - (this.getY() + (this.getHeight()/2));
        BufferedImage rotatedImage = rotateImageByDegrees(this.img, newX, newY);
        //g.fillRect((int)this.getX(), (int)this.getY(), 30, 10); //placeholder draw player
        //System.out.println("t "+ this.img);
        g.drawImage(rotatedImage, (int)(this.getX()-(this.getWidth()/2)), (int)(this.getY()-(this.getHeight()/2)), null);
    }

    public void setPointerTargetX(int x) {
        this.pointerTargetX = x;
    }

    public void setPointerTargetY(int y) {
        this.pointerTargetY = y;
    }
    public int getPointerTargetX() {
        return this.pointerTargetX;
    }

    public int getPointerTargetY() {
        return this.pointerTargetY;
    }

    public BufferedImage rotateImageByDegrees(BufferedImage img, double vx, double vy) {
        int w = img.getWidth();
        int h = img.getHeight();

        BufferedImage rotated = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rotated.createGraphics();
        AffineTransform at = new AffineTransform();

        int x = w / 2;
        int y = h / 2;
        at.rotate(-vy, vx, x, y);
        g2d.setTransform(at);
        g2d.drawImage(img, 0, 0, null);
        //g2d.setColor(Color.RED);
        //g2d.drawRect(0, 0, newWidth - 1, newHeight - 1);
        g2d.dispose();

        return rotated;
    }

}