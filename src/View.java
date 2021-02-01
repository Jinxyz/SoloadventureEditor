import javax.swing.*;

public class View {
    public JPanel viewPanel;
    public JFrame window;
    public JTextArea text, startScreen;
    public JButton choice1, choice2, restart;

    public View() {
        createWindow();
        this.text = new JTextArea();
        this.choice1 = new JButton();
        this.choice2 = new JButton();
        this.restart = new JButton();
    }

    public void createWindow() {
        window = new JFrame("Solo Adventure");
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        viewPanel = new JPanel();
    }


}
