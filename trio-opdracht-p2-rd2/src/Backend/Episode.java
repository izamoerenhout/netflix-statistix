package Backend;

public class Episode {

    private int programId;
    private String episodeNr;
    private String seriesTitle;

    public Episode(int programId, String episodeNr, String seriesTitle) {
        this.programId = programId;
        this.episodeNr = episodeNr;
        this.seriesTitle = seriesTitle;
    }

    // Ieder attribuut heeft een getter en setter.


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

    public String getSeriesTitle() {
        return seriesTitle;
    }

    public void setSeriesTitle(String seriesTitle) {
        this.seriesTitle = seriesTitle;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Program Id: " + this.getProgramId() + "\n");
        sb.append("Episode nr.: " + this.getEpisodeNr() + "\n");
        sb.append("Series title: " + this.getSeriesTitle() + "\n");

        return sb.toString();
    }
}
