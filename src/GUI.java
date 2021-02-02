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

    MVC file = new MVC(this);

    public static void main(String[] args) {
        new GUI();
    }

    public GUI() {
        createWindow();
        createMenuBar();
        createDbMenu();
        createFileMenu();
        create
        window.add(viewPanel);
        window.setVisible(true);
    }

    public void createWindow() {
        window = new JFrame("Notepad");
        window.setSize(800,600);
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

    public void createDbMenu() {
        dbNewItem = new JMenuItem("Save");
        dbNewItem.addActionListener(new saveDBListener());
        dbMenuFile.add(dbNewItem);

        dbOpenItem = new JMenuItem("Open");
        dbOpenItem.addActionListener(new loadDBListener());
        dbMenuFile.add(dbOpenItem);
    }

    public class loadDBListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            try {
                database db = new database();
                setLogg(db.getData(Integer.parseInt(JOptionPane.showInputDialog(null, "write the id of the log"))));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private class saveDBListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            Body body = getLogg();
            try {
                database db = new database();
                db.insertData(body);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        String command = actionEvent.getActionCommand();

        switch(command) {
            case "New": file.newFile(); break;
            case "Open": file.open(); break;
            case "Save": file.save(); break;
            case "SaveAs": file.saveAs(); break;
        }
    }

    public void setLogg(Body body) {
        authorArea.setText(body.getCreator());

        textArea.setText(body.getText());
    }

    public Body getLogg() {
        return new Body(authorArea.getText(), textArea.getText());
    }
}
