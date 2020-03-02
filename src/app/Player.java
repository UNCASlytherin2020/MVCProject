package app;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends ModelObject {

    public Player(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int)this.getX(), (int)this.getY(), 30, 10); //placeholder draw player
    }

}