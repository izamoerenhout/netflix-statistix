package appLogic.overviewModelObjects;

/** Model Object for the series titles that will be stored in the ComboBox of Overview 1. */
public class SeriesTitle {
    private String seriesTitle;

    /** Class constructor
     *
     * @param seriesTitle The title of the series.
     */
    public SeriesTitle(String seriesTitle) {
        this.seriesTitle = seriesTitle;
    }

    /** Getter and setter. */
    public String getSeriesTitle() {
        return seriesTitle;
    }

    public void setSeriesTitle(String seriesTitle) {
        this.seriesTitle = seriesTitle;
    }
}
