public class Model {

    private String description;
    private String[] storyText;
    private String[] choices;
    private int storyId;
    private int targetId;
    private database db;

    public Model() {
        this.description = description;
        this.storyText = storyText;
        this.choices = choices;
        this.storyId = storyId;
        this.targetId = targetId;
    }

    public String getDescription() {
        return description;
    }

    public String[] getStoryText() {
        return storyText;
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

    public database getDb() {
        return db;
    }
}