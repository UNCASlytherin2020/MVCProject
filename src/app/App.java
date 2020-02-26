package app;

public class App {
    public static void main(String[] args) throws Exception {
        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(view, model);
        view.registerListener(controller);
    }
}