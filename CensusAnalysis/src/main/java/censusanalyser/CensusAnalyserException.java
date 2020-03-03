package censusanalyser;

public class CensusAnalyserException extends Exception {



    enum ExceptionType {
        CENSUS_FILE_PROBLEM, UNABLE_TO_PARSE, INCORRECT_FILE_DATA,INCORRECT_COUNTRY
    }

    ExceptionType type;

    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public CensusAnalyserException(String message, ExceptionType type, Throwable cause) {
        super(message, cause);
        this.type = type;
    }
    public CensusAnalyserException(String message, String name) {
        this.type=ExceptionType.valueOf(name);
    }
}
