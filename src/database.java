import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class database {

    private Connection conn;
    private Statement stmt;

    database(){
    }

    public Model getData(int i){
        Model model = null;

        String text = "";
        String[] choices;
        int[] targetId;
        int storyId = 1;

        try {

            try {
                this.conn = DriverManager.getConnection(
                        "jdbc:mysql://" + databaseConfig.DBURL + ":" + databaseConfig.port + "/" + databaseConfig.DBname +
                                "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        databaseConfig.user, databaseConfig.password);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            this.stmt = this.conn.createStatement();

            // Setup statement
            // Create query and execute
            String strSelect = "select body from story where id = " + i;

            ResultSet rset = stmt.executeQuery(strSelect);

            // Loop through the result set and print
            while (rset.next())
                text = rset.getString("body");

            strSelect = "select description, target_id, story_id from links where story_id = " + i;

            rset = stmt.executeQuery(strSelect);
            ArrayList<Integer> targetLinks = new ArrayList();
            ArrayList<String> storyDescription = new ArrayList();

            // Loop through the result set and print
            int rowCount = 0;
            while (rset.next()) {
                String description = rset.getString("description");
                int storyLink = rset.getInt("target_id");
                int storyId = rset.getInt("story_id");
                targetLinks.add(storyLink);
                storyDescription.add(description);
                storyId = storyid;
            }


            choices = getStringArray(storyDescription);
            targetId = getIntArray(targetLinks);

            model = new Model(text, choices, targetId, storyId);

            // Close conn and stmt
            this.conn.close();
            stmt.close();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return model;
    }

    public void saveToDatabase(Model model){

        String text = model.getText();
        String[] choices = model.getChoices();
        int[] targetId = model.getTargetId();

        try {

            try {
                this.conn = DriverManager.getConnection(
                        "jdbc:mysql://" + databaseConfig.DBURL + ":" + databaseConfig.port + "/" + databaseConfig.DBname +
                                "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        databaseConfig.user, databaseConfig.password);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            this.stmt = this.conn.createStatement();

            // Setup statement
            // Create query and execute
            String strSelect = "INSERT" + story.getText() + "INTO body from story where id = ";

            ResultSet rset = stmt.executeQuery(strSelect);

            // Loop through the result set and print
            while (rset.next())
                text = rset.getString("body");

            strSelect = "select description, target_id from links where story_id = ";

            rset = stmt.executeQuery(strSelect);
            ArrayList<Integer> storyLinks = new ArrayList();
            ArrayList<String> storyDescription = new ArrayList();

            // Loop through the result set and print
            int rowCount = 0;
            while (rset.next()) {
                String description = rset.getString("description");
                int storyLink = rset.getInt("target_id");
                storyLinks.add(storyLink);
                storyDescription.add(description);
            }

            choices = getStringArray(storyDescription);
            targetID = getIntArray(storyLinks);

            story = new Story(text, choices, targetId);

            // Close conn and stmt
            this.conn.close();
            stmt.close();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static String[] getStringArray(ArrayList<String> arr)
    {

        // declaration and initialise String Array
        String str[] = new String[arr.size()];

        // ArrayList to Array Conversion
        for (int j = 0; j < arr.size(); j++) {

            // Assign each value to String array
            str[j] = arr.get(j);
        }
        return str;
    }

    public static int[] getIntArray(ArrayList<Integer> arr){
        int inte[] = new int[arr.size()];

        for (int j = 0; j < arr.size(); j++){

            inte[j] = arr.get(j);
        }
        return inte;
    }

}