package Backend;

public class Watched {

    private int accountId;
    private String profileName;
    private int programId;
    private int perctWatched;

    public Watched(int accountId, String profileName, int programId, int perctWatched) {
        this.accountId = accountId;
        this.profileName = profileName;
        this.programId = programId;
        this.perctWatched = perctWatched;
    }

    // Ieder attribuut heeft een getter en setter.


    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
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

    public int getPerctWatched() {
        return perctWatched;
    }

    public void setPerctWatched(int perctWatched) {
        this.perctWatched = perctWatched;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Account Id: " + this.getAccountId() + "\n");
        sb.append("Profile name: " + this.getProfileName() + "\n");
        sb.append("Program Id: " + this.getProgramId() + "\n");
        sb.append("% watched: " + this.getPerctWatched() + "\n");

        return sb.toString();
    }
}
