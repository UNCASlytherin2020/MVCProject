package app;
import java.awt.Graphics;
public interface ModelObject {
    public int getX();
    public int getY();
    public void setX(int x);
    public void setY(int y);
    public void draw(Graphics g);
}