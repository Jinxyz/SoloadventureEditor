public class Model {

    private String description;
    private int currentId;
    private int targetId;
    private GUI gui;
    private database db;

    public Model(GUI gui, String description, int currentId, int targetId) {
        this.description = description;
        this.currentId = currentId;
        this.targetId = targetId;
    }

    public String getDescription() {
        return description;
    }

    public int getCurrentId() {
        return currentId;
    }

    public int getTargetId() {
        return targetId;
    }


}