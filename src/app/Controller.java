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
        System.out.println("Clicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Released");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Exit");

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent e) {
        Player player1 = model.getPlayers()[0];
        if (e.getKeyChar() == 'w') {
            player1.setYVelocity(-1);
        }
        if (e.getKeyChar() == 's') {
            player1.setYVelocity( 1);
        }
        if (e.getKeyChar() == 'a') {
            player1.setXVelocity(-1);
        }
        if (e.getKeyChar() == 'd') {
            player1.setXVelocity( 1);
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent e) {
        Player player1 = model.getPlayers()[0];
        if (e.getKeyChar() == 'w' && player1.getYVelocity() == -1) {
            player1.setYVelocity(0);
        }
        if (e.getKeyChar() == 's' && player1.getYVelocity() == 1) {
            player1.setYVelocity(0);
        }
        if (e.getKeyChar() == 'a' && player1.getXVelocity() == -1) {
            player1.setXVelocity(0);
        }
        if (e.getKeyChar() == 'd' && player1.getXVelocity() == 1) {
            player1.setXVelocity(0);
        }
    }
}