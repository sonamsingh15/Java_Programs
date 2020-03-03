import java.util.Map;


public class CricketAnalysisFactory {
        public static  <E> Map<String, cricketDAO> loadCricketAnalysis(CricketLeagueAnalysis.Cricket cricket, String... csvFilePath) throws CricketLeagueAnalysisExeception {

            if (cricket.equals(CricketLeagueAnalysis.Cricket.BatsMan)) {
                return new BatsmanAdapter().getData(csvFilePath);
            } else if (cricket.equals(CricketLeagueAnalysis.Cricket.Bowlers))
            { return new BowlersAdapter().getData(csvFilePath);
            } else if (cricket.equals(CricketLeagueAnalysis.Cricket.COMBINE_BAT_BOWL))
            { return new CombinePlayersData().getData(csvFilePath);
            } else {
                throw new CricketLeagueAnalysisExeception("INCORRECT_FILE_DATA", CricketLeagueAnalysisExeception.ExceptionType.INCORRECT_FILE_DATA);
            }
        }


    }
