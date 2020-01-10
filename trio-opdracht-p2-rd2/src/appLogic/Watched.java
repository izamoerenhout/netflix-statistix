package appLogic;

public class Watched {

    private int accountId;
    private String accountName;
    private String profileName;
    private int programId;
    private String programName;
    private int perctWatched;

    public Watched(int accountId, String accountName, String profileName, int programId, String programName, int perctWatched) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.profileName = profileName;
        this.programId = programId;
        this.programName = programName;
        this.perctWatched = perctWatched;
    }

    // Every class atrribute has its own getter and setter.

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
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

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public int getPerctWatched() {
        return perctWatched;
    }

    public void setPerctWatched(int perctWatched) {
        this.perctWatched = perctWatched;
    }
}
