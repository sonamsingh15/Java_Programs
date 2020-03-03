package censusanalyser;

import com.google.gson.Gson;
import java.util.*;
import java.util.stream.Collectors;

public class CensusAnalyser {


    private Country country;
    public enum Country{ INDIA,US}
    Map<String, CensusDAO> censusDAOMap =new TreeMap<>();


    public CensusAnalyser(Country country) {
        this.country = country;
    }



    public int lodeCensusData(CensusAnalyser.Country country,String... csvFilePath) throws CensusAnalyserException {
        censusDAOMap = CensusAdapterFactory.getCensusData(country, csvFilePath);
        return censusDAOMap.size();
    }

    public String getSortedIndiaCensus() throws CensusAnalyserException {
        if (censusDAOMap == null || censusDAOMap.size() == 0) {
            throw new CensusAnalyserException("NO_CENSUS_DATA", CensusAnalyserException.ExceptionType.INCORRECT_FILE_DATA);
        }

        List list=censusDAOMap.values().stream()
                .sorted((census1,census2) -> (census1.stateId).compareTo(census2.stateId))
                .map(census -> census.getCensusDTO(country))
                .collect(Collectors.toList());
        String sortedJson = new Gson().toJson(list);
        System.out.println(sortedJson);
        return sortedJson;
    }

    public String getSortedIndiaCensusPopulation() throws CensusAnalyserException {
        if (censusDAOMap == null || censusDAOMap.size() == 0) {
            throw new CensusAnalyserException("NO_CENSUS_DATA", CensusAnalyserException.ExceptionType.INCORRECT_FILE_DATA);
        }

        List list=censusDAOMap.values().stream()
                .sorted((census1,census2) -> (census1.population - census2.population))
                .map(census -> census.getCensusDTO(country))
                .collect(Collectors.toList());
        String sortedJson = new Gson().toJson(list);
        System.out.println(sortedJson);
        return sortedJson;
    }

    public String getSortedIndiaCensusDessity() throws CensusAnalyserException {
        if (censusDAOMap == null || censusDAOMap.size() == 0) {
            throw new CensusAnalyserException("NO_CENSUS_DATA", CensusAnalyserException.ExceptionType.INCORRECT_FILE_DATA);
        }
        List list=censusDAOMap.values().stream()
                .sorted((census1,census2) -> (census2.density - census1.density))
                .collect(Collectors.toList());
        String sortedJson = new Gson().toJson(list);
        System.out.println(sortedJson);
        return sortedJson;
    }

    public String getSortedIndiaCensusArea() throws CensusAnalyserException {
        if (censusDAOMap == null || censusDAOMap.size() == 0) {
            throw new CensusAnalyserException("NO_CENSUS_DATA", CensusAnalyserException.ExceptionType.INCORRECT_FILE_DATA);
        }
        List list=censusDAOMap.values().stream()
                .sorted((census1,census2) -> ((census2.area - census1.area)))
                .map(census -> census.getCensusDTO(country))
                .collect(Collectors.toList());
        String sortedJSON = new Gson().toJson(list);
        System.out.println(sortedJSON);
        return sortedJSON;
    }

    public String getSortedStateCode() throws CensusAnalyserException {
        if (censusDAOMap == null || censusDAOMap.size() == 0) {
            throw new CensusAnalyserException("NO_CENSUS_DATA", CensusAnalyserException.ExceptionType.INCORRECT_FILE_DATA);
        }
        List list=censusDAOMap.values().stream()
                .sorted((census1,census2) -> (census1.stateId).compareTo(census2.stateId))
                .map(census -> census.getCensusDTO(country))
                .collect(Collectors.toList());
        String sortedJSON = new Gson().toJson(list);
        System.out.println("JSON"+sortedJSON);
        return sortedJSON;
    }
}


