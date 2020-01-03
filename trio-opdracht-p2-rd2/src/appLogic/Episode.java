package appLogic;

// Child class of the abstract parent class Program.

public class Episode extends Program {

    private String episodeNr;
    private String seriesTitle;

    public Episode(int programId, String programName, String length, String episodeNr, String seriesTitle) {
        super(programId, programName, length);
        this.episodeNr = episodeNr;
        this.seriesTitle = seriesTitle;
    }

    // Every class atrribute has its own getter and setter.

    public String getEpisodeNr() {
        return episodeNr;
    }

    public void setEpisodeNr(String episodeNr) {
        this.episodeNr = episodeNr;
    }

    public String getSeriesTitle() {
        return seriesTitle;
    }

    public void setSeriesTitle(String seriesTitle) {
        this.seriesTitle = seriesTitle;
    }
}
