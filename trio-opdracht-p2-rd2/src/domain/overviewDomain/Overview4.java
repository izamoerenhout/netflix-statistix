package domain.overviewDomain;

import java.sql.Time;

/** Model Object for Overview 4. */
public class Overview4 {
    private int programId;
    private String movieName;
    private int ageRating;
    private Time length;

    /** Class constructor.
     *
     * @param programId The movie's program id.
     * @param movieName The name of the movie.
     * @param ageRating The movie's age rating.
     * @param length The length of the movie.
     */
    public Overview4(int programId, String movieName, int ageRating, Time length) {
        this.programId = programId;
        this.movieName = movieName;
        this.ageRating = ageRating;
        this.length = length;
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

    public int getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(int ageRating) {
        this.ageRating = ageRating;
    }

    public Time getLength() {
        return length;
    }

    public void setLength(Time length) {
        this.length = length;
    }
}
