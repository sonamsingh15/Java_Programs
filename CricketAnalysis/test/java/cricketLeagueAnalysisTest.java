import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class cricketLeagueAnalysisTest {

    public String IPL_2019_FACTSHEET_MOSTRUN = "/home/admin1/CricketAnalyser/src/test/resources/mostRuns.csv";
    public String IPL_2019_FACTSHEET_MOSTWKTS="/home/admin1/CricketAnalyser/src/test/resources/mostWkts.csv";

    @Test
    public void givenIPLCSVfile_shouldReturnCorrectRecordsOfMostRunnIplCsvFile() throws CricketLeagueAnalysisExeception {
        CricketLeagueAnalysis cricketLeagueAnalysis = new CricketLeagueAnalysis(CricketLeagueAnalysis.Cricket.BatsMan);
        int noOfRecords = cricketLeagueAnalysis.loadCricketAnalysis(IPL_2019_FACTSHEET_MOSTRUN);
        Assert.assertEquals(100, noOfRecords);
    }

    @Test
    public void givenIplCsvFile_shouldReturnHigestAverageScrore() throws CricketLeagueAnalysisExeception {
        CricketLeagueAnalysis cricketLeagueAnalysis = new CricketLeagueAnalysis(CricketLeagueAnalysis.Cricket.BatsMan);
        cricketLeagueAnalysis.loadCricketAnalysis(IPL_2019_FACTSHEET_MOSTRUN);
        List<BatsmansData> iplAnalysisCsvList = cricketLeagueAnalysis.getRecords(SortFields.SortedFields.AVERAGE_RATE);
        Assert.assertEquals(83.2, iplAnalysisCsvList.get(99).batAverage, 0);
    }

    @Test
    public void givenIplCsvFile_shouldReturnLowestAverageScrore() throws CricketLeagueAnalysisExeception {
        CricketLeagueAnalysis iplAnalyzer = new CricketLeagueAnalysis(CricketLeagueAnalysis.Cricket.BatsMan);
        iplAnalyzer.loadCricketAnalysis(IPL_2019_FACTSHEET_MOSTRUN);
        List<BatsmansData> iplAnalysisCsvList = iplAnalyzer.getRecords(SortFields.SortedFields.AVERAGE_RATE);
        Assert.assertEquals(0.0, iplAnalysisCsvList.get(0).batAverage, 0);
    }

    @Test
    public void givenIplCsvFile_shouldReturnHigestStrikeRate() throws CricketLeagueAnalysisExeception {
        CricketLeagueAnalysis cricketLeagueAnalysis = new CricketLeagueAnalysis(CricketLeagueAnalysis.Cricket.BatsMan);
        cricketLeagueAnalysis.loadCricketAnalysis(IPL_2019_FACTSHEET_MOSTRUN);
        List<BatsmansData> iplAnalysisCsvList = cricketLeagueAnalysis.getRecords(SortFields.SortedFields.STRIKE_RATE);
        Assert.assertEquals(333.33, iplAnalysisCsvList.get(99).strikeRate, 0);
    }

    @Test
    public void givenIplCsvFile_shouldReturnLowestStrikeRate() throws CricketLeagueAnalysisExeception {
        CricketLeagueAnalysis cricketAnalysis = new CricketLeagueAnalysis(CricketLeagueAnalysis.Cricket.BatsMan);
        cricketAnalysis.loadCricketAnalysis(IPL_2019_FACTSHEET_MOSTRUN);
        List<BatsmansData> iplAnalysisCsvList = cricketAnalysis.getRecords(SortFields.SortedFields.STRIKE_RATE);
        Assert.assertEquals(63.15, iplAnalysisCsvList.get(0).strikeRate, 0);
    }

    @Test
    public void givenIplCsvFile_shouldReturnSixFour() throws CricketLeagueAnalysisExeception {
        CricketLeagueAnalysis cricketAnalysis = new CricketLeagueAnalysis(CricketLeagueAnalysis.Cricket.BatsMan);
        cricketAnalysis.loadCricketAnalysis(IPL_2019_FACTSHEET_MOSTRUN);
        List<BatsmansData> iplAnalysisCsvList = (List<BatsmansData>) cricketAnalysis.getRecords(SortFields.SortedFields.FOUR_SIX_RECORD);
        Assert.assertEquals("Andre Russell", iplAnalysisCsvList.get(0).playersName);
        Assert.assertEquals("Shakib Al Hasan", iplAnalysisCsvList.get(99).playersName);


    }

    @Test
    public void givenIplCsvFileSortedListByStrikeRate_shouldReturnStrikeRateAccordingList() throws CricketLeagueAnalysisExeception {
        CricketLeagueAnalysis cricketAnalysis = new CricketLeagueAnalysis(CricketLeagueAnalysis.Cricket.BatsMan);
        cricketAnalysis.loadCricketAnalysis(IPL_2019_FACTSHEET_MOSTRUN);
        List<BatsmansData> iplAnalysisCsvList = cricketAnalysis.getRecords(SortFields.SortedFields.FOUR_SIX_STRIKE_RATE);
        Assert.assertEquals("Andre Russell", iplAnalysisCsvList.get(0).playersName);
        Assert.assertEquals("Shakib Al Hasan", iplAnalysisCsvList.get(99).playersName);
    }

    @Test
    public void givenIplCsvFileSortedListByStrikeRate_shouldReturnStrikeRateAccordingAverage() throws CricketLeagueAnalysisExeception {
        CricketLeagueAnalysis cricketAnalysis = new CricketLeagueAnalysis(CricketLeagueAnalysis.Cricket.BatsMan);
        cricketAnalysis.loadCricketAnalysis(IPL_2019_FACTSHEET_MOSTRUN);
        List<BatsmansData> iplAnalysisCsvList = cricketAnalysis.getRecords(SortFields.SortedFields.AVG_WITH_STRIKE_RATE);
        Assert.assertEquals("MS Dhoni", iplAnalysisCsvList.get(0).playersName);
       Assert.assertEquals("Tim Southee", iplAnalysisCsvList.get(99).playersName);


    }


    @Test
    public void givenIplCsvFileSortedListByAverage_shouldReturnBestMaximumRun() throws CricketLeagueAnalysisExeception {
        CricketLeagueAnalysis cricketAnalysis = new CricketLeagueAnalysis(CricketLeagueAnalysis.Cricket.BatsMan);
        cricketAnalysis.loadCricketAnalysis(IPL_2019_FACTSHEET_MOSTRUN);
        List<BatsmansData> iplAnalysisCsvList = cricketAnalysis.getRecords(SortFields.SortedFields.MAX_RUN_AVG);
        Assert.assertEquals("David Warner ", iplAnalysisCsvList.get(0).playersName);
        Assert.assertEquals("Tim Southee", iplAnalysisCsvList.get(99).playersName);
    }

    //bowlling testcases

    @Test
    public void givenIPLCSVfile_shouldReturnCorrectRecordsOfMostWicketsIplCsvFile() throws CricketLeagueAnalysisExeception {
        CricketLeagueAnalysis cricketLeagueAnalysis = new CricketLeagueAnalysis(CricketLeagueAnalysis.Cricket.Bowlers);
        int noOfRecords =cricketLeagueAnalysis.loadCricketAnalysis(IPL_2019_FACTSHEET_MOSTWKTS);
        Assert.assertEquals(99, noOfRecords);
    }
    @Test
    public void givenIplCsvFileSortedListByAverage_shouldReturnTopBowlingAverage() throws CricketLeagueAnalysisExeception {
        CricketLeagueAnalysis cricketAnalysis = new CricketLeagueAnalysis(CricketLeagueAnalysis.Cricket.Bowlers);
        cricketAnalysis.loadCricketAnalysis(IPL_2019_FACTSHEET_MOSTWKTS);
        List<BowlersData> iplAnalysisCsvList = cricketAnalysis.getRecords(SortFields.SortedFields.TOP_STRIKING_RATES);
        Assert.assertEquals(120, iplAnalysisCsvList.get(0).strikeRate,0);
        Assert.assertEquals(0.0, iplAnalysisCsvList.get(98).strikeRate,0);
    }

    @Test
    public void givenIplCsvFileSortedList_shouldReturnBestBowlingEconomyRate() throws CricketLeagueAnalysisExeception {
        CricketLeagueAnalysis cricketAnalysis = new CricketLeagueAnalysis(CricketLeagueAnalysis.Cricket.Bowlers);
        cricketAnalysis.loadCricketAnalysis(IPL_2019_FACTSHEET_MOSTWKTS);
        List<BowlersData> iplAnalysisCsvList = cricketAnalysis.getRecords(SortFields.SortedFields.BEST_ECONOMY_RATE);
        Assert.assertEquals(13.5, iplAnalysisCsvList.get(0).economy,0);
        Assert.assertEquals(4.8, iplAnalysisCsvList.get(98).economy,0);
    }
    @Test
    public void givenIplCsvFileSortedList_shouldReturnBestBowlingStrikeRatesWith5w4w() throws CricketLeagueAnalysisExeception {
        CricketLeagueAnalysis cricketAnalysis = new CricketLeagueAnalysis(CricketLeagueAnalysis.Cricket.Bowlers);
        cricketAnalysis.loadCricketAnalysis(IPL_2019_FACTSHEET_MOSTWKTS);
        List<BowlersData> iplAnalysisCsvList = cricketAnalysis.getRecords(SortFields.SortedFields.FOUR_WICKETS_AND_SIX_WICKETS_STRIKE);
        System.out.println(iplAnalysisCsvList);
        Assert.assertEquals("Krishnappa Gowtham", iplAnalysisCsvList.get(98).playersName);
    }

    @Test
    public void givenIplCsvFileSortedList_shouldReturnMaximumWicketsWithBestBowlingAvg() throws CricketLeagueAnalysisExeception {
        CricketLeagueAnalysis cricketAnalysis = new CricketLeagueAnalysis(CricketLeagueAnalysis.Cricket.Bowlers);
        cricketAnalysis.loadCricketAnalysis(IPL_2019_FACTSHEET_MOSTWKTS);
        List<BowlersData> iplAnalysisCsvList = cricketAnalysis.getRecords(SortFields.SortedFields.MAX_WKTS_WITH_MAX_BOWLS);
        Assert.assertEquals("Imran Tahir", iplAnalysisCsvList.get(0).playersName);

    }

    @Test
    public void givenIplCsvFileSortedList_shouldReturnHighestAverage() throws CricketLeagueAnalysisExeception {
        CricketLeagueAnalysis cricketAnalysis = new CricketLeagueAnalysis(CricketLeagueAnalysis.Cricket.COMBINE_BAT_BOWL);
        cricketAnalysis.loadCricketAnalysis(IPL_2019_FACTSHEET_MOSTRUN,IPL_2019_FACTSHEET_MOSTWKTS);
        List<BowlersData> iplAnalysisCsvList = cricketAnalysis.getRecords(SortFields.SortedFields.AVG_RATE_BOTH);
        Assert.assertEquals("MS Dhoni", iplAnalysisCsvList.get(0).playersName);

    }
    @Test
    public void whenGivenTopOfBothRunsAndWickets_shouldReturnAllRounderCricketer() throws CricketLeagueAnalysisExeception {
        CricketLeagueAnalysis iplAnalyzer = new CricketLeagueAnalysis(CricketLeagueAnalysis.Cricket.COMBINE_BAT_BOWL);
        iplAnalyzer.loadCricketAnalysis(IPL_2019_FACTSHEET_MOSTRUN,IPL_2019_FACTSHEET_MOSTWKTS);
        List<BowlersData> topBatsmenRecords = iplAnalyzer.getRecords(SortFields.SortedFields.ALL_ROUNDER_CRICKETER);
        for(int i=0;i< topBatsmenRecords.size(); i++){
        }
        Assert.assertEquals("Andre Russell",topBatsmenRecords.get(0).playersName);
    }
}

