package app;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class View {
    JFrame frame;
    Model model;
    JPanel displayPanel = new JPanel();

    public View(Model model) {
        this.model = model;
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }

    /**
	 * Register the controller as the listener to the JList and the
	 * MousePanel.
	 * @param listener
	 */
	public void registerListener(Controller listener) {
		displayPanel.addMouseMotionListener(listener);
	}


}