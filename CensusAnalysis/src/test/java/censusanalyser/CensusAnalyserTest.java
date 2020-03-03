package censusanalyser;

import com.bridgelabz.CSVBuilderException;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

public class CensusAnalyserTest {

    private static final String INDIA_CENSUS_CSV_FILE_PATH = "/home/admin1/Downloads/CensusAnalyser/src/test/resources/IndiaStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    private static final String WRONG_CSV_EXTENSION = "./src/main/resources/IndiaStateCensusData";
    private static final String WRONG_CSV_DELIMITER = "/home/admin1/Downloads/CensusAnalyser/src/test/resources/indiaStateCensusWrongDelimeter.csv";
    private static final String WRONG_CSV_HEADER = "/home/admin1/Downloads/CensusAnalyser/src/test/resources/IndiaStateWrongHeader.csv";

    private static final String INDIAN_STATE_CODE_CSV_FILE_PATH = "/home/admin1/Downloads/CensusAnalyser/src/test/resources/IndiaStateCode.csv";
    private static final String WRONG_STATE_CODE_CSV_FILE_PATH = "/home/admin1/main/CensusAnalyser/src/test/resources/IndiaStateCode.CSV";
    private static final String WRONG_STATE_CSV_EXTENSION = "/home/admin1/main/CensusAnalyser/src/test/resources/IndiaStateCode.CSV";
    private static final String WRONG_CSV_STATE_DELIMITER = "/home/admin1/Downloads/CensusAnalyser/src/test/resources/IndiaStateWrongDelimiter.csv";
    private static final String WRONG_CSV_STATE_CSV_HEADER = "/home/admin1/Downloads/CensusAnalyser/src/test/resources/indiaStateWrongHeader.csv";


    //IndiaStateCode csv test case
    @Test
    public void givenIndianStateCodeCSVFile_shouldReturnsCorrectRecords() {

        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser(CensusAnalyser.Country.INDIA);
            int numOfRecords = censusAnalyser.lodeCensusData(CensusAnalyser.Country.INDIA, INDIA_CENSUS_CSV_FILE_PATH, INDIAN_STATE_CODE_CSV_FILE_PATH);
            System.out.println(numOfRecords);
            Assert.assertEquals(29, numOfRecords);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();

        }

    }

    @Test
    public void givenIndianCensusFileExtensionWrong_shouldReturnCustomException() throws IOException, CSVBuilderException {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser(CensusAnalyser.Country.INDIA);
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.lodeCensusData(CensusAnalyser.Country.INDIA, WRONG_CSV_EXTENSION);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }

    }

    @Test
    public void givenStateCensusCsvDelimiterIncorrect_shouldReturnsCustomException() throws IOException, CSVBuilderException {
        CensusAnalyser censusAnalyser = new CensusAnalyser(CensusAnalyser.Country.INDIA);
        ExpectedException exceptionRule = ExpectedException.none();
        exceptionRule.expect(CensusAnalyserException.class);
    }

    @Test
    public void givenStateCensusCsvHeaderIncorrect_shouldReturnsCustomException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser(CensusAnalyser.Country.INDIA);
            int numOfRecords = censusAnalyser.lodeCensusData(CensusAnalyser.Country.INDIA, WRONG_CSV_HEADER);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }


    @Test
    public void givenIndiaStateCode_withWrongFile_shouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser(CensusAnalyser.Country.INDIA);
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.lodeCensusData(CensusAnalyser.Country.INDIA, WRONG_STATE_CODE_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIndianStateFileExtensionWrong_shouldReturnCustomException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser(CensusAnalyser.Country.INDIA);
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.lodeCensusData(CensusAnalyser.Country.INDIA, WRONG_STATE_CSV_EXTENSION);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }

    }

    @Test
    public void givenIndiaStateCFileExtensionWrong_shouldReturnCustomException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser(CensusAnalyser.Country.INDIA);
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.lodeCensusData(CensusAnalyser.Country.INDIA, WRONG_CSV_STATE_CSV_HEADER);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_FILE_DATA, e.type);
        }

    }


    @Test
    public void givenStateCodeCsvHeaderIncorrect_shouldReturnsCustomException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser(CensusAnalyser.Country.INDIA);
            int numOfRecords = censusAnalyser.lodeCensusData(CensusAnalyser.Country.INDIA, WRONG_CSV_STATE_DELIMITER);
            Assert.assertEquals(37, numOfRecords);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_FILE_DATA, e.type);
        }
    }

    //teast case using sorting  state csv file and return in json format

    @Test
    public void givenIndiaState_whenSortedOnStateByName_shouldReturnSortedResult() throws CensusAnalyserException, IOException, CSVBuilderException {
        CensusAnalyser censusAnalyser = new CensusAnalyser(CensusAnalyser.Country.INDIA);
        censusAnalyser.lodeCensusData(CensusAnalyser.Country.INDIA, INDIA_CENSUS_CSV_FILE_PATH,INDIAN_STATE_CODE_CSV_FILE_PATH);
        String sortedStateCensusData = censusAnalyser.getSortedIndiaCensus();
        IndiaCensusCSV[] censusCSVS = new Gson().fromJson(sortedStateCensusData, IndiaCensusCSV[].class);
        Assert.assertEquals("Andhra Pradesh", censusCSVS[0].state);
    }

    @Test
    public void givenIndiaState_whenSortedOnStateByName_shouldReturnEndState() throws CensusAnalyserException, IOException, CSVBuilderException {
        CensusAnalyser censusAnalyser = new CensusAnalyser(CensusAnalyser.Country.INDIA);
        censusAnalyser.lodeCensusData(CensusAnalyser.Country.INDIA, INDIA_CENSUS_CSV_FILE_PATH,INDIAN_STATE_CODE_CSV_FILE_PATH);
        String sortedStateCensusData = censusAnalyser.getSortedIndiaCensus();
        IndiaCensusCSV[] censusCSVS = new Gson().fromJson(sortedStateCensusData, IndiaCensusCSV[].class);
        Assert.assertEquals("West Bengal", censusCSVS[28].state);
    }


    @Test
    public void givenIndiaStateCode_shouldReturnFirstStateCode() throws CensusAnalyserException {
        CensusAnalyser censusAnalyser = new CensusAnalyser(CensusAnalyser.Country.INDIA);
        censusAnalyser.lodeCensusData(CensusAnalyser.Country.INDIA, INDIA_CENSUS_CSV_FILE_PATH, INDIAN_STATE_CODE_CSV_FILE_PATH);
        String sortState = censusAnalyser.getSortedStateCode();
        CensusDAO[] stateCodeCsvs = new Gson().fromJson(sortState, CensusDAO[].class);
        Assert.assertEquals("Andhra Pradesh", stateCodeCsvs[0].state);
    }

    @Test
    public void givenIndiaStateCode_shouldReturnEndStateCode() throws CensusAnalyserException {
        CensusAnalyser censusAnalyser = new CensusAnalyser(CensusAnalyser.Country.INDIA);
        censusAnalyser.lodeCensusData(CensusAnalyser.Country.INDIA, INDIA_CENSUS_CSV_FILE_PATH, INDIAN_STATE_CODE_CSV_FILE_PATH);
        String sortedStateCensusData = censusAnalyser.getSortedStateCode();
        CensusDAO[] stateCodeCsvs = new Gson().fromJson(sortedStateCensusData, CensusDAO[].class);
        Assert.assertEquals("West Bengal", stateCodeCsvs[28].state);

    }
        //Test case for population
        @Test
        public void givenIndiaCensusDtata_shouldReturnHigestPopulationState () throws CensusAnalyserException {
            CensusAnalyser censusAnalyser = new CensusAnalyser(CensusAnalyser.Country.INDIA);
            censusAnalyser.lodeCensusData(CensusAnalyser.Country.INDIA, INDIA_CENSUS_CSV_FILE_PATH,INDIAN_STATE_CODE_CSV_FILE_PATH);
            String sortedIndiaCensus = censusAnalyser.getSortedIndiaCensusPopulation();
            IndiaCensusCSV[] censusCSVS = new Gson().fromJson(sortedIndiaCensus, IndiaCensusCSV[].class);
            Assert.assertEquals("Sikkim", censusCSVS[0].state);
        }

        @Test
        public void givenIndiaCensusDtata_shouldReturnLowestPopulationState () throws CensusAnalyserException {
            CensusAnalyser censusAnalyser = new CensusAnalyser(CensusAnalyser.Country.INDIA);
            censusAnalyser.lodeCensusData(CensusAnalyser.Country.INDIA, INDIA_CENSUS_CSV_FILE_PATH,INDIAN_STATE_CODE_CSV_FILE_PATH);
            String sortedIndiaCensus = censusAnalyser.getSortedIndiaCensusPopulation();
            IndiaCensusCSV[] censusCSVS = new Gson().fromJson(sortedIndiaCensus, IndiaCensusCSV[].class);
            Assert.assertEquals("Uttar Pradesh", censusCSVS[28].state);
        }

        //Test case uses density wise
        @Test
        public void givenIndiaCensusDtata_shouldReturnHigestDensityState () throws CensusAnalyserException {
            CensusAnalyser censusAnalyser = new CensusAnalyser(CensusAnalyser.Country.INDIA);
            censusAnalyser.lodeCensusData(CensusAnalyser.Country.INDIA, INDIA_CENSUS_CSV_FILE_PATH,INDIAN_STATE_CODE_CSV_FILE_PATH);
            String sortedIndiaCensus = censusAnalyser.getSortedIndiaCensusDessity();
            IndiaCensusCSV[] censusCSVS = new Gson().fromJson(sortedIndiaCensus, IndiaCensusCSV[].class);
            Assert.assertEquals("Bihar", censusCSVS[0].state);
        }

        @Test
        public void givenIndiaCensusDtata_shouldReturnLowestDensityState () throws CensusAnalyserException {
            CensusAnalyser censusAnalyser = new CensusAnalyser(CensusAnalyser.Country.INDIA);
            censusAnalyser.lodeCensusData(CensusAnalyser.Country.INDIA, INDIA_CENSUS_CSV_FILE_PATH,INDIAN_STATE_CODE_CSV_FILE_PATH);
            String sortedIndiaCensus = censusAnalyser.getSortedIndiaCensusDessity();
            IndiaCensusCSV[] censusCSVS = new Gson().fromJson(sortedIndiaCensus, IndiaCensusCSV[].class);
            System.out.println(censusCSVS[0]);
            Assert.assertEquals("Arunachal Pradesh", censusCSVS[28].state);
        }

        @Test
        public void givenIndiaCensusDtata_shouldReturnLargestAreaByState () throws CensusAnalyserException {
            CensusAnalyser censusAnalyser = new CensusAnalyser(CensusAnalyser.Country.INDIA);
            censusAnalyser.lodeCensusData(CensusAnalyser.Country.INDIA, INDIA_CENSUS_CSV_FILE_PATH,INDIAN_STATE_CODE_CSV_FILE_PATH);
            String sortedIndiaCensus = censusAnalyser.getSortedIndiaCensusArea();
            IndiaCensusCSV[] censusCSVS = new Gson().fromJson(sortedIndiaCensus, IndiaCensusCSV[].class);
            Assert.assertEquals("Rajasthan", censusCSVS[0].state);
        }

        @Test
        public void givenIndiaCensusDtata_shouldReturnLowestAreaState () throws CensusAnalyserException {
            CensusAnalyser censusAnalyser = new CensusAnalyser(CensusAnalyser.Country.INDIA);
            censusAnalyser.lodeCensusData(CensusAnalyser.Country.INDIA, INDIA_CENSUS_CSV_FILE_PATH,INDIAN_STATE_CODE_CSV_FILE_PATH);
            String sortedIndiaCensus = censusAnalyser.getSortedIndiaCensusArea();
            IndiaCensusCSV[] censusCSVS = new Gson().fromJson(sortedIndiaCensus, IndiaCensusCSV[].class);
            Assert.assertEquals("Goa", censusCSVS[28].state);
        }

        @Test
        public void givenUSCensusCSVFile_ReturnsCorrectRecords () throws CensusAnalyserException {
            CensusAnalyser censusAnalyser = new CensusAnalyser(CensusAnalyser.Country.US);
            int numOfRecords = censusAnalyser.lodeCensusData(CensusAnalyser.Country.US, "/home/admin1/Downloads/CensusAnalyser/src/test/resources/USCensusData.csv");
            System.out.println(numOfRecords);
            Assert.assertEquals(51, numOfRecords);
        }
    }
