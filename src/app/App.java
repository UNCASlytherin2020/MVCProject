package app;

public class App {
    public static void main(String[] args) throws Exception {
        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(view, model);
        view.registerListener(controller); //add the controller as an event listener for the view.

        while(view.isActive()) { //while game in playing OR while view is active
            ModelObject objects[] = model.getObjectsInModel(); //get all the ModelObjects in the model
            for (int i = 0; i < objects.length; i++) {
                objects[i].update(); //update all model positions and collisions
            }
            view.repaint();//repaint the view so changes will be displayed.
            java.lang.Thread.sleep(1000/60);//unstable 60 FPS, could be adapted to actually check how long each frame takes to run.
        }
        System.exit(0); //if the while loop ends then the game is ended and the program should end
    }
}