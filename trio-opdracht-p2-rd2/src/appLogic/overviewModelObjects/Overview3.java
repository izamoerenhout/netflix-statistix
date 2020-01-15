package appLogic.overviewModelObjects;

/** Model Object for Overview 3. */
public class Overview3 {
    private String email;
    private String profileName;
    private int programId;
    private String movieName;

    /** Class constructor.
     *
     * @param email The account's email address.
     * @param profileName The name of the profile that has watched the movie.
     * @param programId The watched movie's program id.
     * @param movieName The name of the movie.
     */
    public Overview3(String email, String profileName, int programId, String movieName) {
        this.email = email;
        this.profileName = profileName;
        this.programId = programId;
        this.movieName = movieName;
    }

    /** Getters and setters. */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
