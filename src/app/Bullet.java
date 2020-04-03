package app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.geom.AffineTransform;

import javax.imageio.ImageIO;

public class Bullet extends ModelObject {
    public Bullet(double x, double y, double xVel, double yVel) {
        this.setX(x);
        this.setY(y);
        this.setXVelocity(xVel);
        this.setYVelocity(yVel);
    }

    @Override
    void draw(Graphics g) {
        g.setColor(Color.red);
        g.drawOval((int)this.getX(), (int)this.getY(), 10, 10);
    }
    @Override
    public void onOffScreen(int width, int height) {
        if (this.getX() < 0 || this.getX() > width || this.getY() < 0 || this.getY() > height) {
            this.setDoDelete(true);
        }
    }
}