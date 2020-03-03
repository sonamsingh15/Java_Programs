import java.util.HashMap;
import java.util.Map;

public class LoadData {

    Map<String,cricketDAO> map=new HashMap<>();
    public Map<String,cricketDAO> getloadData(CricketLeagueAnalysis.Cricket cricket, String... csvFilePath) throws CricketLeagueAnalysisExeception {
        return CricketAnalysisFactory.loadCricketAnalysis(cricket,csvFilePath);
    }
}
