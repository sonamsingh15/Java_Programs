import com.opencsv.bean.CsvBindByName;

public class BatsmansData {
    //POS,PLAYER,Mat,Inns,NO,Runs,HS,Avg,BF,SR,100,50,4s,6s
    @CsvBindByName(column = "POS", required = true)
    public int position;

    @CsvBindByName(column = "PLAYER", required = true)
    public String playersName;

    @CsvBindByName(column = "Mat", required = true)
    public int noOfMatch;

    @CsvBindByName(column = "Inns", required = true)
    public int noOfInnings;

    @CsvBindByName(column = "NO", required = true)
    public int notOut;

    @CsvBindByName(column = "Runs", required = true)
    public int runs;

    @CsvBindByName(column = "HS", required = true)
    public int higestScrore;

    @CsvBindByName(column = "Avg", required = true)
    public double batAverage;

    @CsvBindByName(column = "BF", required = true)
    public int bestScrore;

    @CsvBindByName(column = "SR", required = true)
    public double strikeRate;

    @CsvBindByName(column = "100", required = true)
    public int century;

    @CsvBindByName(column = "50", required = true)
    public int halfCentury;

    @CsvBindByName(column = "6s", required = true)
    public Integer Six;

    @CsvBindByName(column = "4s", required = true)
    public Integer Four;

    public BatsmansData() {
    }

    public BatsmansData(int pos, String playersName, int noOfMatch, int runs, double strikeRate, double batAverage, Integer six, Integer four) {
        this.position = pos;
        this.playersName = playersName;
        this.noOfMatch = noOfMatch;
        this.runs = runs;
        this.strikeRate = strikeRate;
        this.batAverage = batAverage;
        this.Six = six;
        this.Four = four;

    }

    @Override
    public String toString() {
        return "BatsmansData{" +
                "position=" + position +
                ", playersName='" + playersName + '\'' +
                ", noOfMatch=" + noOfMatch +
                ", noOfInnings=" + noOfInnings +
                ", notOut=" + notOut +
                ", runs=" + runs +
                ", higestScrore=" + higestScrore +
                ", batAverage=" + batAverage +
                ", bestScrore=" + bestScrore +
                ", strikeRate=" + strikeRate +
                ", century=" + century +
                ", halfCentury=" + halfCentury +
                ", six=" + Six +
                ", four=" + Four +
                '}';
    }


}

