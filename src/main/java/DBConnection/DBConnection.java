package DBConnection;

import com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.sql.*;

public class DBConnection {
    private String driver;
    private String host;
    private String port;
    private String db;
    private String user;
    private String password;
    private Connection conn;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Connection getConn() {
        return conn;
    }

//    public void setConn(Connection conn) {
//        this.conn = conn;
//    }

    public DBConnection(String dbName) {
        super();
//        super() to auto generated constructor stub
        this.driver = "mysql";
        this.host = "localhost";
        this.port = "3306";
        this.db = dbName;
        this.user = "root";
        this.password = "motconvit";
        this.conn = null;
    }

    public void ConnectionDB() {
        try {
            String dbURL = "jdbc:"+this.driver+"://"+this.host+":"+ this.port+"/"+this.db;
            this.conn = DriverManager.getConnection(dbURL, this.user, this.password);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disConnectDB() {
        try {
            this.conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
