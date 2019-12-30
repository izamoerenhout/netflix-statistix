package Backend;

public class Movie {

    private int programId;
    private String genre;
    private String language;
    private String ageRating;

    public Movie(int programId, String genre, String language, String ageRating) {
        this.programId = programId;
        this.genre = genre;
        this.language = language;
        this.ageRating = ageRating;
    }

    // Ieder attribuut heeft een getter en setter.


    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Program Id: " + this.getProgramId() + "\n");
        sb.append("Genre: " + this.getGenre() + "\n");
        sb.append("Language: " + this.getLanguage() + "\n");
        sb.append("Age rating: " + this.getAgeRating() + "\n");

        return sb.toString();
    }
}
