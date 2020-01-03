package appLogic;

import java.util.ArrayList;

public class Series {

    private String seriesTitle;
    private String genre;
    private String language;
    private String ageRating;
    private String suggestion;
    private ArrayList<Episode> episodeList;

    // There is a possibility that a series has no suggestion, hence the use of constructor overloading
    // so that Series objects with or without a suggestion can both be created.

    public Series(String seriesTitle, String genre, String language, String ageRating) {
        this.seriesTitle = seriesTitle;
        this.genre = genre;
        this.language = language;
        this.ageRating = ageRating;
        this.episodeList = new ArrayList<>();
    }

    public Series(String seriesTitle, String genre, String language, String ageRating, String suggestion) {
        this(seriesTitle, genre, language, ageRating);
        this.suggestion = suggestion;
        this.episodeList = new ArrayList<>();
    }

    // Every class atrribute has its own getter and setter.

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

    public ArrayList<Episode> getEpisodeList() {
        return episodeList;
    }

    public void setEpisodeList(ArrayList<Episode> episodeList) {
        this.episodeList = episodeList;
    }
}
