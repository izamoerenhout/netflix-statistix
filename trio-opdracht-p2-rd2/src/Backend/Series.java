package Backend;

public class Series {

    private String seriesTitle;
    private String genre;
    private String language;
    private String ageRating;
    private String suggestion;

    // Een serie kan ook géén suggestion hebben. We maken dus gebruik van constructor overloading
    // zodat er zowel een Series object mét als zónder suggestion gemaakt kan worden.

    public Series(String seriesTitle, String genre, String language, String ageRating) {
        this.seriesTitle = seriesTitle;
        this.genre = genre;
        this.language = language;
        this.ageRating = ageRating;
    }

    public Series(String seriesTitle, String genre, String language, String ageRating, String suggestion) {
        this(seriesTitle, genre, language, ageRating);
        this.suggestion = suggestion;
    }

    // Ieder attribuut heeft een getter en setter.


    public String getSeriesTitle() {
        return seriesTitle;
    }

    public void setSeriesTitle(String seriesTitle) {
        this.seriesTitle = seriesTitle;
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

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Series title: " + this.getSeriesTitle() + "\n");
        sb.append("Genre: " + this.getGenre() + "\n");
        sb.append("Language: " + this.getLanguage() + "\n");
        sb.append("Age rating: " + this.getAgeRating() + "\n");
        sb.append("Suggestion: " + this.getSuggestion() + "\n");

        return sb.toString();
    }
}
