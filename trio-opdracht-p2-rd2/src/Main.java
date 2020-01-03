import database.DatabaseConnection;
import database.ProfileDAO;

public class Main {

    public static void main(String[] args) {
        ProfileDAO profileDAO = new ProfileDAO(new DatabaseConnection());

        profileDAO.insertProfile(1, "Gerda", 51);
    }
}
