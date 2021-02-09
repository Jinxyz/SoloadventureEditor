import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class GUI implements ActionListener {
    public JFrame window;
    public JTextArea textArea;
    public JTextField authorArea;
    public JPanel viewPanel;
    public JScrollPane scrollPane;
    public JMenuBar menuBar;
    public JMenu menuFile, dbMenuFile;
    public JMenuItem newItem, openItem, saveItem, saveAsItem, exitItem, dbNewItem, dbOpenItem;

    Model file = new Model(this);

    public static void main(String[] args) {
        new GUI();
    }

    public GUI() {
        createWindow();
        createMenuBar();
        createFileMenu();
        window.add(viewPanel);
        window.setVisible(true);
    }

    public void createWindow() {
        window = new JFrame("Notepad");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        viewPanel = new JPanel();
    }


    public void createMenuBar() {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        dbMenuFile = new JMenu("Database");
        menuBar.add(dbMenuFile);
    }

    public void createFileMenu() {

        newItem = new JMenuItem("New");
        newItem.addActionListener(this);
        newItem.setActionCommand("New");
        menuFile.add(newItem);

        openItem = new JMenuItem("Open");
        openItem.addActionListener(this);
        openItem.setActionCommand("Open");
        menuFile.add(openItem);

        saveItem = new JMenuItem("Save");
        saveItem.addActionListener(this);
        saveItem.setActionCommand("Save");
        menuFile.add(saveItem);

        saveAsItem = new JMenuItem("Save As");
        saveAsItem.addActionListener(this);
        saveAsItem.setActionCommand("SaveAs");
        menuFile.add(saveAsItem);

        exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(this);
        exitItem.setActionCommand("Exit");
        menuFile.add(saveAsItem);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}