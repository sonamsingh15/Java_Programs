package censusanalyser;

import com.bridgelabz.CSVBuilderException;
import com.bridgelabz.CSVBuilderFactory;
import com.bridgelabz.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.StreamSupport;


public abstract class CensusAdapter  {

    public abstract <E> Map<String, CensusDAO> loadCensusData(String... csvFilePath) throws CensusAnalyserException;

    public <E> Map<String, CensusDAO> loadCensusData(Class<E> CensusCSVClass, String csvFilePath) throws CensusAnalyserException {

        Map<String, CensusDAO> censusMap=new TreeMap<>();

        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath)))
        {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            List<E> csvFileList = csvBuilder.getCSVList(reader, CensusCSVClass);
            if(CensusCSVClass.getName().equals("censusanalyser.IndiaCensusCSV")) {
                StreamSupport.stream(csvFileList.spliterator(),false)
                        .map(IndiaCensusCSV.class::cast)
                        .forEach(CensusCSV ->censusMap.put(CensusCSV.state ,new CensusDAO(CensusCSV)));
            }
            if(CensusCSVClass.getName().equals("censusanalyser.USCensusData")) {
                StreamSupport.stream(csvFileList.spliterator(),false)
                        .map(USCensusData.class::cast)
                        .forEach(CensusCSV ->censusMap.put(CensusCSV.state,new CensusDAO(CensusCSV)));
            }
            return censusMap;
        }catch (IOException e) {
            throw new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }catch (RuntimeException e) {
            throw new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.INCORRECT_FILE_DATA);
        } catch (CSVBuilderException e) {
            throw new CensusAnalyserException(e.getMessage(), e.type.name());
        }

    }
}
