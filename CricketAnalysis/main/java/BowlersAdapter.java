import java.util.Map;

public class BowlersAdapter extends CricketAnalysisAdapter {

        @Override
        public <E> Map<String, cricketDAO> getData(String... csvFilePath) throws CricketLeagueAnalysisExeception {
            Map<String, cricketDAO> cricketDAO=super.getData(BowlersData.class,csvFilePath[0]);
            return cricketDAO;
        }
    }


