import java.util.*;
import java.util.stream.Collectors;


public class CricketLeagueAnalysis {

    private Cricket cricket;

    CricketAnalysisFactory cricketAnalysisFactory;
    LoadData loadData=new LoadData();

    Map<String, cricketDAO> iplList = new TreeMap<>();

    public CricketLeagueAnalysis(Cricket cricket , LoadData loadDataMock) {
        this.cricket=cricket;
        this.loadData=loadDataMock;


    }
    public enum Cricket {BatsMan, Bowlers, COMBINE_BAT_BOWL}

    public CricketLeagueAnalysis(Cricket cricket) {
        this.cricket = cricket;
        cricketAnalysisFactory = new CricketAnalysisFactory();
    }
    public int loadCricketAnalysis(String... csvFilePath) throws CricketLeagueAnalysisExeception {
        iplList = loadData.getloadData(cricket, csvFilePath);
        return iplList.size();

    }


    public List getRecords(SortFields.SortedFields sortedFields) {
        Comparator<cricketDAO> comparator = new SortFields().getField(sortedFields);
        List list = iplList.values().stream().sorted(comparator)
                .map(player -> player.getCricketDTO(cricket))
                .collect(Collectors.toCollection(ArrayList::new));
        return list;
    }

}
