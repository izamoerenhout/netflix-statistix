package appLogic.overviewModelObjects;

/** Model Object for Overview 2. */
public class Overview2 {
    private String email;
    private int programId;
    private String episodeNr;
    private String episodeName;
    private int avgPctWatched;

    /** Class constructor.
     *
     * @param email The email address of the account that has been selected.
     * @param programId The episode's program id.
     * @param episodeNr The episode's number.
     * @param episodeName The episode's name.
     * @param avgPctWatched The average percentage the episode has been watched.
     */
    public Overview2(String email, int programId, String episodeNr, String episodeName, int avgPctWatched) {
        this.email = email;
        this.programId = programId;
        this.episodeNr = episodeNr;
        this.episodeName = episodeName;
        this.avgPctWatched = avgPctWatched;
    }

    /** Getters and setters. */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public String getEpisodeNr() {
        return episodeNr;
    }

    public void setEpisodeNr(String episodeNr) {
        this.episodeNr = episodeNr;
    }

    public String getEpisodeName() {
        return episodeName;
    }

    public void setEpisodeName(String episodeName) {
        this.episodeName = episodeName;
    }

    public int getAvgPctWatched() {
        return avgPctWatched;
    }

    public void setAvgPctWatched(int avgPctWatched) {
        this.avgPctWatched = avgPctWatched;
    }
}
