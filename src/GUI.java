import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    public JFrame window;
    public JTextField storyText;
    public JPanel viewPanel;
    public JMenuBar menuBar;
    public JMenu menuFile, dbMenuFile;
    public JMenuItem newItem, openItem, saveItem, saveAsItem, exitItem, dbNewItem, dbOpenItem;
    public JButton choice1, choice2, restart;

    public static void main(String[] args) {
        new GUI();
    }

    public GUI() {
        createWindow();
        createTextField();
        createButtons();
        window.add(viewPanel);
        window.setVisible(true);
    }

    public void createWindow() {
        window = new JFrame("Soloadventure");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewPanel = new JPanel();
    }

    public void createTextField() {
        storyText = new JTextField("Story" ,60);
        storyText.setEditable(false);
        viewPanel.add(storyText);
    }

    public void setStoryText() {
        // storyText.setText(s);
    }

    public void createButtons() {
        // Insert database links
        choice1 = new JButton();
        choice2 = new JButton();
        restart = new JButton("Restart");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}