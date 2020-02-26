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
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D.Double circle = new Ellipse2D.Double(20, 30, 10, 10);

        g2d.setColor(Color.GRAY);
        g2d.fill(circle);
    }

    /**
	 * Register the controller as the listener to the JList and the
	 * MousePanel.
	 * @param listener
	 */
	public void registerListener(Controller listener) {
		displayPanel.addMouseListener(listener);
	}


}