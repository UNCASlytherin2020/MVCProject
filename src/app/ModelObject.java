package app;
import java.awt.Graphics;
public abstract class ModelObject {
    private double x;
    private double y;
    private double width;
    private double height;
    private double xVel;
    private double yVel;
    private double xAcc;
    private double yAcc;
    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setWidth(double x) {
        this.width = x;
    }

    public void setHeight(double y) {
        this.height = y;
    }

    public double getXVelocity() {
        return this.xVel;
    }

    public double getYVelocity() {
        return this.yVel;
    }

    public void setXVelocity(double x) {
        this.xVel = x;
    }

    public void setYVelocity(double y) {
        this.yVel = y;
    }

    public double getXAcceleration() {
        return this.xAcc;
    }

    public double getYAcceleration() {
        return this.yAcc;
    }

    public void setXAcceleration(double x) {
        this.xAcc = x;
    }

    public void setYAcceleration(double y) {
        this.yAcc = y;
    }

    public void update() {
        this.xVel += this.xAcc;
        this.yVel += this.yAcc;
        this.x += this.xVel;
        this.y += this.yVel;
    }

    public void onOffScreen(int width, int height) {
        if (this.x < 0) {
            this.x = width;
        }
        if (this.x > width) {
            this.x = 0;
        }
        if (this.y < 0) {
            this.y = height;
        }
        if (this.y > height) {
            this.y = 0;
        }
    }
    abstract void draw(Graphics g);

    
}