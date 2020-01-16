package appLogic.overviewModelObjects;

/** Model Object for Overview 6. */
public class Overview6 {
    private int programId;
    private String movieName;
    private int amountOfViewers;

    /** Class constructor.
     *
     * @param programId The movie's program id.
     * @param movieName The name of the movie.
     * @param amountOfViewers The total amount of viewers that have watched the entire movie.
     */
    public Overview6(int programId, String movieName, int amountOfViewers) {
        this.programId = programId;
        this.movieName = movieName;
        this.amountOfViewers = amountOfViewers;
    }

    /** Getters and setters. */
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

    public int getAmountOfViewers() {
        return amountOfViewers;
    }

    public void setAmountOfViewers(int amountOfViewers) {
        this.amountOfViewers = amountOfViewers;
    }
}
