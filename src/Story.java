/*

    Getting replaced by Model.java



public class Story {

    private String storyBody;
    private String[] choices;
    private int[] targetId;
    private int currentId;

    public Story(String storyBody, String[] choices, int currentId, int[] targetId) {
        this.storyBody = storyBody;
        this.choices = choices;
        this.currentId = currentId;
        this.targetId = targetId;
    }

    public String getStoryBody() {
        return storyBody;
    }

    public String[] getChoices() {
        return choices;
    }

    public int getCurrentId() {
        return currentId;
    }

    public int[] getTargetId(int i) {
        return targetId[i];
    }
}