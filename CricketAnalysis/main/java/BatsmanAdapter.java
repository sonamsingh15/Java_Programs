import java.util.Map;

public class BatsmanAdapter extends CricketAnalysisAdapter {
    @Override
    public <E> Map<String, cricketDAO> getData(String... csvFilePath) throws CricketLeagueAnalysisExeception {
        Map<String, cricketDAO> cricketDAO=super.getData(BatsmansData.class,csvFilePath[0]);
        return cricketDAO;
    }
}
