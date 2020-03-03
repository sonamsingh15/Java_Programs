package censusanalyser;

import com.opencsv.bean.CsvBindByName;

public class IndiaStateCodeCsv {

    @CsvBindByName(column = "SrNo", required = true)
    public int srNo;

    @CsvBindByName(column = "StateName", required = true)
    public String stateName;

    @CsvBindByName(column = "TIN", required = true)
    public int TIN;

    @CsvBindByName(column = "stateCode", required = true)
    public String stateCode;

    @Override
    public String toString() {
        return "IndiaStateCodeCsv{" +
                "SrNo=" + srNo +
                ", StateName='" + stateName + '\'' +
                ", TIN=" + TIN +

                ", stateCode='"+ stateCode;
    }


    public IndiaStateCodeCsv() {
    }
}


