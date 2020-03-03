
import csvBuilder.CSVBuilderFactory;
import csvBuilder.CsvBuilderException;
import csvBuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.StreamSupport;

public abstract class CricketAnalysisAdapter {




    public <E> Map<String, cricketDAO> getData(Class<E> CricketcsvClass, String... csvFilePath) throws CricketLeagueAnalysisExeception {

        Map<String, cricketDAO> iplanlysisList = new TreeMap<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(String.valueOf(csvFilePath[0])))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();

            List<E> iplAnalysis = csvBuilder.getCSVFileList(reader, CricketcsvClass);

            if (CricketcsvClass.getName().equals("BatsmansData")) {
                StreamSupport.stream(iplAnalysis.spliterator(), false)
                        .map(BatsmansData.class::cast)
                        .forEach(cricketCSV -> iplanlysisList.put(cricketCSV.playersName, new cricketDAO(cricketCSV)));
            }
            if (CricketcsvClass.getName().equals("BowlersData")) {
                StreamSupport.stream(iplAnalysis.spliterator(), false)
                        .map(BowlersData.class::cast)
                        .forEach(cricketCSV -> iplanlysisList.put(cricketCSV.playersName, new cricketDAO(cricketCSV)));
            }

            return iplanlysisList;
        } catch (IOException e) {
            throw new CricketLeagueAnalysisExeception(e.getMessage(),
                    CricketLeagueAnalysisExeception.ExceptionType.FILE_PROBLEM);
        } catch (RuntimeException e) {
            throw new CricketLeagueAnalysisExeception(e.getMessage(),
                    CricketLeagueAnalysisExeception.ExceptionType.INCORRECT_FILE_DATA);

        } catch (CsvBuilderException e) {
            e.printStackTrace();
        }
        return null;
    }

    public abstract <E> Map<String, cricketDAO> getData(String... csvFilePath) throws CricketLeagueAnalysisExeception;
}

