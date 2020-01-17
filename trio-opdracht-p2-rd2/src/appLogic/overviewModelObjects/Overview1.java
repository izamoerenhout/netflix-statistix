package appLogic.overviewModelObjects;

/** Model Object for Overview 1. */
public class Overview1 {
    private int programId;
    private String episodeNr;
    private String episodeName;
    private int avgPctWatched;

    /** Class constructor
     *
     * @param programId The episode's program id.
     * @param episodeNr The episode's number.
     * @param episodeName The episode's name.
     * @param avgPctWatched The average percentage the episode has been watched.
     */
    public Overview1(int programId, String episodeNr, String episodeName, int avgPctWatched) {
        this.programId = programId;
        this.episodeNr = episodeNr;
        this.episodeName = episodeName;
        if (avgPctWatched < 0 || avgPctWatched > 100) {
            throw new IllegalArgumentException("Average percentage watched should be between 0 and 100.");
        } else {
            this.avgPctWatched = avgPctWatched;
        }
    }

    /** Getters and setters. */
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
        if (avgPctWatched < 0 || avgPctWatched > 100) {
            throw new IllegalArgumentException("Average percentage watched should be between 0 and 100.");
        } else {
            this.avgPctWatched = avgPctWatched;
        }
    }
}
