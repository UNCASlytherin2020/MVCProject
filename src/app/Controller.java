package app;

import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.event.MouseInputListener;

public class Controller implements MouseInputListener, KeyListener {
    private View view;
    private Model model;
    public Controller(View v, Model m) {
        this.view = v;
        this.model = m;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (model.getPlayers().length > 0) {
            Player p = model.getPlayers()[0];
            p.setPointerTargetY(e.getY());
            p.setPointerTargetX(e.getX());
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        //--------------------------------------PLAYER 1 CONTROLLER START
        Player player1 = model.getPlayers()[0];
        double newX = player1.getPointerTargetX() - (player1.getX() + (player1.getWidth()/2));
        double newY = player1.getPointerTargetY() - (player1.getY() + (player1.getHeight()/2));
        double xS = 0;
        if (newX != 0) {
            xS = newX/Math.abs(newY);
        }
        double yS = 0;
        if (newY != 0) {
            yS = newY/Math.abs(newX);
        }
        if (Math.abs(xS) > Math.abs(yS)) {
            xS /= Math.abs(xS);
        } else {
            yS /= Math.abs(yS);
        }
        if (e.getKeyChar() == 'w') {
            //System.out.println(newX/Math.abs(newX) + " " + newY/Math.abs(newY));
            player1.setXAcceleration(xS/10);
            player1.setYAcceleration(yS/10);
        }
        if (e.getKeyChar() == ' ') {
            System.out.println(newX + " "+ newY + " " + xS + " " + yS);
            model.addObject(new Bullet(player1.getX(), player1.getY(), xS*2, yS*2));
        }
        //--------------------------------------PLAYER 1 CONTROLLER END
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //--------------------------------------PLAYER 1 CONTROLLER START
        Player player1 = model.getPlayers()[0];
        if (e.getKeyChar() == 'w') {
            player1.setXAcceleration(0);
            player1.setYAcceleration(0);
        }
        //--------------------------------------PLAYER 1 CONTROLLER END
    }

    public double mapping(double X, double A, double B, double D, double C) {
        return (X-A)/(B-A) * (D-C) + C;
    }
}