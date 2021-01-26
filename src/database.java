import java.sql.Connection;
import java.sql.DriverManager;

public class database {


    Connection conn = DriverManager.getConnection(
            "jdbc:mysql://" + databaseConfig.DBURL + ":" + databaseConfig.port + "/" + databaseConfig.DBname +
                    "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
            databaseConfig.user, databaseConfig.password);

}
