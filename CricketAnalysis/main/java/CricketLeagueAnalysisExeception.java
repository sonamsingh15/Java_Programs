public class CricketLeagueAnalysisExeception extends Throwable {

        enum ExceptionType {
            FILE_PROBLEM,INCORRECT_FILE_DATA
        }

        ExceptionType type;

        public CricketLeagueAnalysisExeception(String message, ExceptionType type) {
            super(message);
            this.type = type;
        }

        public CricketLeagueAnalysisExeception(String message, ExceptionType type, Throwable cause) {
            super(message, cause);
            this.type = type;
        }
    public CricketLeagueAnalysisExeception(String message, String name){
            this.type=ExceptionType.valueOf(name);
        }

    }



