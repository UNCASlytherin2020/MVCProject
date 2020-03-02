package app;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class View extends JPanel {
    private JFrame frame;
    private Model model;
    private boolean isActive = false; 

    public View(Model model) {
        super();
        this.model = model;
        frame = new JFrame();
        frame.setSize(600, 400);
        
        this.setSize(400, 600);
        this.setBackground(Color.BLACK);

        frame.add(this);
        frame.addWindowListener(onClose());
        frame.setVisible(true);
        this.isActive = true;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Should paint the components in model
        ModelObject objects[] = model.getObjectsInModel(); //get all the ModelObjects in the model
        for (int i = 0; i < objects.length; i++) {
            objects[i].draw(g);//draw all the objects onto the screen
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

    public boolean isActive() {
        return this.isActive;
    }

    private WindowAdapter onClose() {
        return new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                isActive = false;
            }
        };
    }
}