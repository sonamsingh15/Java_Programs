package censusanalyser;

public class IndiaStateCodeDAO {
    public  String stateCode;
    public  int srNo;
    public String stateName;
    public  int TIN;

    public IndiaStateCodeDAO(IndiaStateCodeCsv indiaStateCodeCsv){
        stateCode=indiaStateCodeCsv.stateCode;
        srNo=indiaStateCodeCsv.srNo;
        stateName=indiaStateCodeCsv.stateName;
        TIN=indiaStateCodeCsv.TIN;
    }

    public String getStateCode() {
        return stateCode;
    }
}
