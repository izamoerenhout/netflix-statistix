import database.AccountDAO;
import database.DatabaseConnection;
import database.ProfileDAO;
import database.WatchedDAO;

public class Main {

    public static void main(String[] args) {
        WatchedDAO watchedDAO = new WatchedDAO(new DatabaseConnection());

        watchedDAO.deleteWatched(2, "Iza", 2001);
    }
}
