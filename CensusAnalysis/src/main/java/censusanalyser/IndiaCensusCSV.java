package censusanalyser;

import com.opencsv.bean.CsvBindByName;

public class IndiaCensusCSV {
    public IndiaCensusCSV() {
    }

    @CsvBindByName(column = "State", required = true)
    public String state;

    @CsvBindByName(column = "Population", required = true)
    public int population;

    @CsvBindByName(column = "AreaInSqKm", required = true)
    public int areaInSqKm;

    @CsvBindByName(column = "DensityPerSqKm", required = true)
    public int densityPerSqKm;

    public IndiaCensusCSV(String stateId, String state, int population, int areaInSqKm, int densityPerSqKm) {
       this.state = state;
        this.population = population;
        this.areaInSqKm = areaInSqKm;
        this.densityPerSqKm = densityPerSqKm;
    }

    @Override
    public String toString() {
        return "IndiaCensusCSV{" +
                "State='" + state + '\'' +
                ", population=" + population +
                ", areaInSqKm=" + areaInSqKm +
                ", densityPerSqKm=" + densityPerSqKm +
                '}';
    }


}
