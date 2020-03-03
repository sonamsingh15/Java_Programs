import java.util.Map;

public class CombinePlayersData extends CricketAnalysisAdapter {
    public <E> Map<String, cricketDAO> getData(String... csvFilePath) throws CricketLeagueAnalysisExeception {
        Map<String, cricketDAO> BatsmanDAO = super.getData(BatsmansData.class, csvFilePath[0]);
        Map<String, cricketDAO> BowlerDAO = super.getData(BowlersData.class, csvFilePath[1]);

        BowlerDAO.values().stream()
                .filter(cricketData -> BatsmanDAO.get(cricketData.playersName)!= null)
                .forEach(cricketData -> {BatsmanDAO.get(cricketData.playersName).
                        ballAverage = cricketData.ballAverage ;
                    BatsmanDAO.get(cricketData.playersName).wickets=cricketData.wickets;
                        });
        return BatsmanDAO;
    }
}
