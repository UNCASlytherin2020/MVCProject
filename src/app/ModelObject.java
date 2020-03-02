package app;
import java.awt.Graphics;
public abstract class ModelObject {
    private double x;
    private double y;
    private double xVel;
    private double yVel;
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

    public void update() {
        this.x += this.xVel;
        this.y += this.yVel;
    }
    abstract void draw(Graphics g);
}