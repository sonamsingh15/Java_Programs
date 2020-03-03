import com.opencsv.bean.CsvBindByName;

public class BowlersData {
    @CsvBindByName(column = "POS", required = true)
    public int position;

    @CsvBindByName(column = "PLAYER", required = true)
    public String playersName;

    @CsvBindByName(column = "Mat", required = true)
    public int noOfMatch;

    @CsvBindByName(column = "Inns", required = true)
    public int noOfInnings;

    @CsvBindByName(column = "Ov", required = true)
    public double over;

    @CsvBindByName(column = "Runs", required = true)
    public int runs;

    @CsvBindByName(column = "Wkts", required = true)
    public int wickets;

    @CsvBindByName(column = "BBI", required = true)
    public int bestBowlingInn;

    @CsvBindByName(column = "Avg", required = true)
    public double ballAverage;

    @CsvBindByName(column = "Econ", required = true)
    public double economy;

    @CsvBindByName(column = "SR", required = true)
    public double strikeRate;

    @CsvBindByName(column = "4w", required = true)
    public int fourWkts;

    @CsvBindByName(column = "5w", required = true)
    public int fiveWkts;

    public BowlersData() {
    }

    public BowlersData(int pos, String playersName, int noOfMatch, int runs, int wickets, double ballAverage, double economy, double strikeRate, int fourWkts, int fiveWkts) {
        this.position = pos;
        this.playersName = playersName;
        this.noOfMatch = noOfMatch;
        this.runs = runs;
        this.wickets = wickets;
        this.ballAverage=ballAverage;
        this.economy = economy;
        this.strikeRate = strikeRate;
        this.fourWkts = fourWkts;
        this.fiveWkts = fiveWkts;

    }

    @Override
    public String toString() {
        return "BowlersData{" +
                "position=" + position +
                ", playersName='" + playersName + '\'' +
                ", noOfMatch=" + noOfMatch +
                ", noOfInnings=" + noOfInnings +
                ", over=" + over +
                ", runs=" + runs +
                ", wickets=" + wickets +
                ", bestBowlingInn=" + bestBowlingInn +
                ", ballAverage=" + ballAverage +
                ", economy=" + economy +
                ", strikeRate=" + strikeRate +
                ", fourWkts=" + fourWkts +
                ", fiveWkts=" + fiveWkts +
                '}';
    }
}
