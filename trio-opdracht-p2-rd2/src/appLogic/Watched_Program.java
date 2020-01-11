package appLogic;

public class Watched_Program {
    private String email;
    private String accountName;
    private String profileName;
    private int programId;
    private int pctWatched;

    public Watched_Program(String email, String accountName, String profileName, int programId, int pctWatched) {
        this.email = email;
        this.accountName = accountName;
        this.profileName = profileName;
        this.programId = programId;
        this.pctWatched = pctWatched;
    }

    // Every class atrribute has its own getter and setter.

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
        this.pctWatched = pctWatched;
    }
}
