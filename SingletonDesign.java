/*
When to use the Singleton Pattern
    When only one instance of a class should exist across the application.
    When you need centralized configuration, logging, or caching.
    For shared resources like database connections or file systems.
 */
class DatabaseConnection {
    private static DatabaseConnection databaseConnection;

    private DatabaseConnection() {
        System.out.println("Connecting to Database.......");
    }

    public static DatabaseConnection getInstance() {
        if (databaseConnection == null)
            databaseConnection = new DatabaseConnection();
        return databaseConnection;
    }
}

public class SingletonDesign {
    public static void main(String[] args) {
        DatabaseConnection one = DatabaseConnection.getInstance();
        DatabaseConnection two = DatabaseConnection.getInstance();
        System.out.println(one.hashCode() + " " + two.hashCode());
        System.out.println(one == two);
    }
}