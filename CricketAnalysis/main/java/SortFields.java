import java.util.Comparator;
import java.util.HashMap;

public class SortFields {
    public enum SortedFields {
        AVERAGE_RATE,
        STRIKE_RATE,
        FOUR_SIX_RECORD,
        FOUR_SIX_STRIKE_RATE,
        AVG_WITH_STRIKE_RATE,
        MAX_RUN_AVG,
        TOP_BOWLING_AVG,
        TOP_STRIKING_RATES,
        BEST_ECONOMY_RATE,
        FOUR_FIVE_WKTS,
        FOUR_WICKETS_AND_SIX_WICKETS_STRIKE,
        MAX_WKTS_WITH_MAX_BOWLS,
        AVG_RATE_BOTH, TOP_BATTING_AVG,
        ALL_ROUNDER_CRICKETER;
    }

    HashMap<SortedFields, Comparator<cricketDAO>> comapareHashMap = new HashMap<>();

    public Comparator getField(SortedFields sortingFields) {


        comapareHashMap.put(sortingFields.STRIKE_RATE, (data1, data2) -> (int) (data1.strikeRate - data2.strikeRate));
        comapareHashMap.put(sortingFields.AVERAGE_RATE, (data1, data2) -> (int) (data1.batAverage - data2.batAverage));

        Comparator<cricketDAO> codecomparator = (p1, p2) -> new Integer((p1.four * 4 + p1.six * 6) < (p2.four * 4 + p2.six * 6) ? 1 : -1);
        comapareHashMap.put(sortingFields.FOUR_SIX_RECORD, codecomparator);

        codecomparator = codecomparator.thenComparing((data1, data2) -> (int) (data1.strikeRate - data2.strikeRate));
        comapareHashMap.put(SortedFields.FOUR_SIX_STRIKE_RATE, codecomparator);

        Comparator<cricketDAO> codecomparator1 = ((data1, data2) -> (int) (data2.batAverage - data1.batAverage));
        codecomparator1.thenComparing((data1, data2) -> (int) (data2.strikeRate - data1.strikeRate));
        comapareHashMap.put(SortedFields.AVG_WITH_STRIKE_RATE, codecomparator1);

        Comparator<cricketDAO> comparator1 = ((data1, data2) -> (int) (data2.runs - data1.runs));
        comparator1.thenComparing((data1, data2) -> (int) (data2.batAverage - data1.batAverage));
        comapareHashMap.put(SortedFields.MAX_RUN_AVG, comparator1);


        Comparator<cricketDAO> bowlersDataComparator = ((d1, d2) -> (int) (d2.ballAverage - d1.ballAverage));
        comapareHashMap.put(SortedFields.TOP_BOWLING_AVG, bowlersDataComparator);
//----------------------------------------------------------
        Comparator<cricketDAO> batsmanDataComparator = ((d1, d2) -> (int) (d2.batAverage - d1.batAverage));
        comapareHashMap.put(SortedFields.TOP_BATTING_AVG, batsmanDataComparator);

        Comparator<cricketDAO> bowlersDataComparator1 = ((d1, d2) -> (int) (d2.strikeRate - d1.strikeRate));
        comapareHashMap.put(SortedFields.TOP_STRIKING_RATES, bowlersDataComparator1);

        Comparator<cricketDAO> bowlersDataComparator2 = ((d1, d2) -> (d1.economy < d2.economy) ? 1 : -1);
        comapareHashMap.put(SortedFields.BEST_ECONOMY_RATE, bowlersDataComparator2);

        Comparator<cricketDAO> codecomparator3 = (p1, p2) -> new Integer((p1.fiveWkts * 4 + p1.fiveWkts * 6) < (p2.fiveWkts * 4 + p2.fiveWkts * 6) ? 1 : -1);
        comapareHashMap.put(SortedFields.FOUR_FIVE_WKTS, codecomparator3);


        comapareHashMap.put(SortedFields.FOUR_FIVE_WKTS, (data1, data2) -> ((data1.fiveWkts * 4 + data2.fiveWkts * 5) - (data1.fourWkts * 4 + data2.fiveWkts * 5)));
        comapareHashMap.put(sortingFields.FOUR_WICKETS_AND_SIX_WICKETS_STRIKE, comapareHashMap.get(SortedFields.FOUR_FIVE_WKTS)
                .thenComparing(comapareHashMap.get(SortedFields.STRIKE_RATE)));



        Comparator<cricketDAO> codeWicketCompare=(data1, data2)-> (data1.wickets > data2.wickets)? -1 :1;
        codeWicketCompare.thenComparing(codecomparator1);
        comapareHashMap.put(SortedFields.MAX_WKTS_WITH_MAX_BOWLS,codeWicketCompare);

        comapareHashMap.put(SortedFields.AVG_RATE_BOTH,comapareHashMap.get(SortedFields.TOP_BATTING_AVG)
                .thenComparing(comapareHashMap.get(SortedFields.TOP_BOWLING_AVG)));

        Comparator<cricketDAO> allRound = Comparator.comparing(cricketAnalysisDAO -> {
            if (cricketAnalysisDAO.wickets > 7 && cricketAnalysisDAO.runs > 150)
                return (cricketAnalysisDAO.runs + (cricketAnalysisDAO.wickets * 20));
            return 0;
        });


        comapareHashMap.put(SortedFields.ALL_ROUNDER_CRICKETER,allRound.reversed());
        Comparator comparator = comapareHashMap.get(sortingFields);
        return comparator;
    }
}