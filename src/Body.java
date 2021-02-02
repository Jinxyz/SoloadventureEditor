public class Body {

    private String text;
    private int currentId;
    private int targetId;

    public Body(String text, int currentId, int targetId) {
        this.text = text;
        this.currentId = currentId;
        this.targetId = targetId;
    }

    public String getText() {
        return text;
    }

    public int getCurrentId() {
        return currentId;
    }

    public int getTargetId() {
        return targetId;
    }
}
