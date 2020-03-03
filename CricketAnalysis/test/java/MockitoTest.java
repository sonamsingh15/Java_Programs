import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

public class MockitoTest {
    Map<String, cricketDAO> map = new HashMap<>();

    @Mock
    LoadData loadDataMock;

    @Rule
    public MockitoRule mockitoRule = new MockitoJUnit().rule();

    public String IPL_2019_FACTSHEET_MOSTRUN = "/home/admin1/CricketAnalyser/src/test/resources/mostRuns.csv";
    public String IPL_2019_FACTSHEET_MOSTWKTS = "/home/admin1/CricketAnalyser/src/test/resources/mostWkts.csv";


    @Before
    public void givenData_ShouldReturCorrectNoOfdata() throws CricketLeagueAnalysisExeception {
        BatsmansData batsmansData = new BatsmansData(1, "David Warner", 12, 692, 143.86, 76.8, 21, 57);
        BatsmansData batsmansData1 = new BatsmansData(2, "KL Rahul", 14, 593, 135.38, 53.9, 49, 25);
        BatsmansData batsmansData2 = new BatsmansData(3, "Shikhar Dhawan", 16, 521, 135.67, 34.73, 64, 11);
        map.put("David Warner", new cricketDAO(batsmansData));
        map.put("KL Rahul", new cricketDAO(batsmansData));
        map.put("Shikhar Dhawan", new cricketDAO(batsmansData));
        CricketLeagueAnalysis cricketLeagueAnalysisMock = new CricketLeagueAnalysis(CricketLeagueAnalysis.Cricket.BatsMan, loadDataMock);
        when(loadDataMock.getloadData(CricketLeagueAnalysis.Cricket.BatsMan, IPL_2019_FACTSHEET_MOSTRUN)).thenReturn(map);
        int noOfRecords = cricketLeagueAnalysisMock.loadCricketAnalysis(IPL_2019_FACTSHEET_MOSTRUN);
        Assert.assertEquals(3, noOfRecords);
        System.out.println(noOfRecords);

    }

    @Test
    public void givenFile_ShouldReturCorrectNoOfdataData() throws CricketLeagueAnalysisExeception {
        CricketLeagueAnalysis cricketLeagueAnalysisMock = new CricketLeagueAnalysis(CricketLeagueAnalysis.Cricket.BatsMan, loadDataMock);
        when(loadDataMock.getloadData(CricketLeagueAnalysis.Cricket.BatsMan, IPL_2019_FACTSHEET_MOSTRUN)).thenReturn(map);
        int noOfRecords = cricketLeagueAnalysisMock.loadCricketAnalysis(IPL_2019_FACTSHEET_MOSTRUN);
        Assert.assertEquals(3, noOfRecords);
        System.out.println(noOfRecords);

    }
    @Test
    public void givenIplCsvFile_shouldReturnHigestAverageScrore() throws CricketLeagueAnalysisExeception {
        CricketLeagueAnalysis cricketLeagueAnalysis = new CricketLeagueAnalysis(CricketLeagueAnalysis.Cricket.BatsMan,loadDataMock);
        cricketLeagueAnalysis.loadCricketAnalysis(IPL_2019_FACTSHEET_MOSTRUN);
        List<BatsmansData> iplAnalysisCsvList = cricketLeagueAnalysis.getRecords(SortFields.SortedFields.AVERAGE_RATE);
        Assert.assertEquals(76.8, iplAnalysisCsvList.get(2).batAverage, 0);
    }

    @Test
    public void givenIplCsvFileSortedListByAverage_shouldReturnBestMaximumRun() throws CricketLeagueAnalysisExeception {
        CricketLeagueAnalysis cricketAnalysis = new CricketLeagueAnalysis(CricketLeagueAnalysis.Cricket.BatsMan,loadDataMock);
        cricketAnalysis.loadCricketAnalysis(IPL_2019_FACTSHEET_MOSTRUN);
        List<BatsmansData> iplAnalysisCsvList = cricketAnalysis.getRecords(SortFields.SortedFields.MAX_RUN_AVG);
        Assert.assertEquals("David Warner", iplAnalysisCsvList.get(2).playersName);

    }

}
