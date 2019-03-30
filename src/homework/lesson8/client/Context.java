package homework.lesson8.client;

import java.sql.Connection;

public class Context {
    private final static Context instance = new Context();
    public static Context getInstance() {
        return instance;
    }

    private Connection con;
    public void setConnection(Connection con)
    {
        this.con=con;
    }
    public Connection getConnection() {
        return con;
    }

    private Controller tabRough;
    public void setTabRough(Controller tabRough) {
        this.tabRough=tabRough;
    }

    public Controller getTabRough() {
        return tabRough;
    }
}
