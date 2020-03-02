package app;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class View extends JPanel {
    JFrame frame;
    Model model;
    JPanel displayPanel;

    public View(Model model) {
        super();
        this.model = model;
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);
        
        this.setSize(400, 600);
        this.setBackground(Color.BLACK);

        frame.add(this);
        frame.setVisible(true);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Should paint the components in model
        ModelObject objects[] = model.getObjectsInModel();
        for (int i = 0; i < objects.length; i++) {
            objects[i].draw(g);
        }
    }

    /**
	 * Register the controller as the listener to the JList and the
	 * MousePanel.
	 * @param listener
	 */
	public void registerListener(Controller listener) {
        frame.addMouseListener(listener);
        frame.addKeyListener(listener);
	}


}