package censusanalyser;
import com.opencsv.bean.CsvBindByName;

public class USCensusData  {
    public USCensusData() {
    }
    //  State Id	State	Population	housingUnits	Totalarea	waterArea	landArea	populationDensity	housingDensity

    @CsvBindByName(column = "StateId", required = true)
    public String stateId;

    @CsvBindByName(column = "State", required = true)
    public String state;

    @CsvBindByName(column = "Population", required = true)
    public int population;

    @CsvBindByName(column = "housingUnits", required = true)
    public int housingUnits;

    @CsvBindByName(column = "Totalarea", required = true)
    public double totalArea;

    @CsvBindByName(column = "waterArea", required = true)
    public double waterArea;

    @CsvBindByName(column = "landArea", required = true)
    public double landArea;

    @CsvBindByName(column = "populationDensity", required = true)
    public double populationDensity;

    @CsvBindByName(column = "housingDensity", required = true)
    public double housingDensity;

    public USCensusData(String stateId, String state, int population, int housingUnits, double totalArea, double waterArea, double landArea, double populationDensity, double housingDensity) {
        stateId = stateId;
        state = state;
        population = population;
        housingUnits = housingUnits;
        totalArea = totalArea;
        waterArea = waterArea;
        landArea = landArea;
        populationDensity = populationDensity;
        housingDensity = housingDensity;
    }

    @Override
    public String toString() {
        return "USCensusData{" +
                "StateId='" + stateId + '\'' +
                ", State='" + state + '\'' +
                ", Population=" + population +
                ", housingUnits=" + housingUnits +
                ", Totalarea=" + totalArea +
                ", waterArea=" + waterArea +
                ", landArea=" + landArea +
                ", populationDensity=" + populationDensity +
                ", housingDensity=" + housingDensity +
                '}';
    }
}

