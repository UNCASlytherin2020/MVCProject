package app;

public class App {
    public static void main(String[] args) throws Exception {
        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(view, model);
        view.registerListener(controller);
        Player player1 = model.getPlayers()[0];
        while(true) {
            player1.update();
            view.repaint();
            java.lang.Thread.sleep(10);
        }
    }
}