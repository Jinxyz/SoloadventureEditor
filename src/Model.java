public class Model {

    private String description;
    private String[] text;
    private String[] choices;
    private int storyId;
    private int targetId;
    private GUI gui;
    private database db;

    public Model(String description, String[] text, String[] choices, int storyId, int targetId, GUI gui, database db) {
        this.description = description;
        this.text = text;
        this.choices = choices;
        this.storyId = storyId;
        this.targetId = targetId;
        this.gui = gui;
        this.db = db;
    }

    public String getDescription() {
        return description;
    }

    public String[] getText() {
        return text;
    }

    public String[] getChoices() {
        return choices;
    }

    public int getstoryId() {
        return storyId;
    }

    public int getTargetId() {
        return targetId;
    }

    public GUI getGui() {
        return gui;
    }

    public database getDb() {
        return db;
    }
}