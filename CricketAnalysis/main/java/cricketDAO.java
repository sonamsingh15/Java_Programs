public class cricketDAO {

    public int pos;
    public String playersName;
    public int noOfMatch;
    public double ballAverage;
    public double batAverage;
    public double strikeRate;
    public Integer six;
    public Integer four;
    public int runs;
    public double economy;
    public int wickets;
    public int fourWkts;
    public int fiveWkts;


    public cricketDAO(BatsmansData batsMansData) {
        pos = batsMansData.position;
        playersName = batsMansData.playersName;
        six = batsMansData.Six;
        four = batsMansData.Four;
        noOfMatch = batsMansData.noOfMatch;
        batAverage = batsMansData.batAverage;
        strikeRate = batsMansData.strikeRate;
        runs = batsMansData.runs;

    }

    public cricketDAO(BowlersData bowlersData) {

        pos = bowlersData.position;
        ballAverage = bowlersData.ballAverage;
        strikeRate = bowlersData.strikeRate;
        runs = bowlersData.runs;
        playersName = bowlersData.playersName;
        economy = bowlersData.economy;
        wickets = bowlersData.wickets;
        fiveWkts = bowlersData.fiveWkts;
        fiveWkts = bowlersData.fiveWkts;


    }

    public cricketDAO() {

    }

    @Override
    public String toString() {
        return "cricketDAO{" +
                "pos=" + pos +
                ", playersName='" + playersName + '\'' +
                ", noOfMatch=" + noOfMatch +
                ", ballAverage=" + ballAverage +
                ", batAverage=" + batAverage +
                ", strikeRate=" + strikeRate +
                ", six=" + six +
                ", four=" + four +
                ", runs=" + runs +
                ", economy=" + economy +
                ", wickets=" + wickets +
                ", fourWkts=" + fourWkts +
                ", fiveWkts=" + fiveWkts +
                '}';
    }

    public Object getCricketDTO(CricketLeagueAnalysis.Cricket cricket) {
        if (cricket.equals(CricketLeagueAnalysis.Cricket.BatsMan))
            return new BatsmansData(pos,playersName, noOfMatch, runs, strikeRate, batAverage, six, four);
        return new BowlersData(pos,playersName, noOfMatch, runs, wickets, ballAverage, economy, strikeRate, fourWkts, fiveWkts);

    }
}
