package appLogic;

// Child class of the abstract parent class Program.

public class Movie extends Program {

    private String genre;
    private String language;
    private String ageRating;

    public Movie(int programId, String programName, String length, String genre, String language, String ageRating) {
        super(programId, programName, length);
        this.genre = genre;
        this.language = language;
        this.ageRating = ageRating;
    }

    // Every class atrribute has its own getter and setter.

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
}
