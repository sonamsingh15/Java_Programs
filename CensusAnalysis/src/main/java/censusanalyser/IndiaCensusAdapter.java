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

public class IndiaCensusAdapter extends CensusAdapter{
    Map<String,CensusDAO> censusDAOMap = new TreeMap<>();

    @Override
    public <E> Map<String, CensusDAO> loadCensusData(String... csvFilePath) throws CensusAnalyserException {
        Map<String,CensusDAO> censusDAOMap = super.loadCensusData(IndiaCensusCSV.class,csvFilePath[0]);
        this.loadIndiastateDataCode(csvFilePath[1],censusDAOMap);
        return censusDAOMap;
    }

    public <E> int loadIndiastateDataCode(String csvFilePath, Map<String, CensusDAO> censusMap) throws CensusAnalyserException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            List<IndiaStateCodeCsv> csvFileList = csvBuilder.getCSVList(reader,IndiaStateCodeCsv.class);

            StreamSupport.stream(csvFileList.spliterator(),false)
                    .filter(CSVStateList->censusMap.get(CSVStateList.stateName)!=null)
                    .forEach(CSVStateList ->censusMap.get(CSVStateList.stateName).stateId = CSVStateList.stateCode);

            return censusMap.size();
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

