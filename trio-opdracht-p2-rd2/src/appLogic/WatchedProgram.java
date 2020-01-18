package appLogic;

import javafx.scene.control.Alert;

/** Model Object for the Accounts screen. */
public class WatchedProgram {
    private String email;
    private String accountName;
    private String profileName;
    private int programId;
    private int pctWatched;

    /** Class constructor.
     *
     * @param email The user's registered email address.
     * @param accountName The user's full account name.
     * @param profileName The profile the program was watched on.
     * @param programId The id of the program that was watched.
     * @param pctWatched The percentage the user has watched.
     */
    public WatchedProgram(String email, String accountName, String profileName, int programId, int pctWatched) {
        this.email = email;
        this.accountName = accountName;
        this.profileName = profileName;
        this.programId = programId;
        if (pctWatched < 0 || pctWatched > 100) {
            throw new IllegalArgumentException("Percentage watched has to be between 0 and 100.");
        } else {
            this.pctWatched = pctWatched;
        }
    }

    /** Getters and setters. */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public int getPctWatched() {
        return pctWatched;
    }

    public void setPctWatched(int pctWatched) {
        if (pctWatched < 0 || pctWatched > 100) {
            Alert failed = new Alert(Alert.AlertType.WARNING);
            failed.setTitle("Percentage update failed");
            failed.setHeaderText(null);
            failed.setContentText("Percentage watched should be between 0 and 100.");
            failed.show();
            throw new IllegalArgumentException("Percentage watched should be between 0 and 100.");

        } else {
            this.pctWatched = pctWatched;
        }
    }
}
