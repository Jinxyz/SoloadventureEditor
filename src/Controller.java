public class Controller {
    private GUI gui;
    private Model adventure;

    public Controller() {
        this.gui = new GUI();
        this.adventure = new Model();

        gui.setStoryText();
    }
}
