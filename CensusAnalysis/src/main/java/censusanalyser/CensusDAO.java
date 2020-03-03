package censusanalyser;

public class CensusDAO {
    public int area;
    public String state;
    public int density;
//    public int population;
    public String stateId;
    public  int population;
    public int housingUnits;
    public double Totalarea;
    public double waterArea;
    public double landArea;
    public double populationDensity;
    public double housingDensity;
    public String stateCode;

    public CensusDAO(USCensusData usCensusData){
        stateId=usCensusData.stateId;
        state=usCensusData.state;
        population=usCensusData.population;
        housingUnits =usCensusData.housingUnits;
        Totalarea=usCensusData.totalArea;
        waterArea =usCensusData.waterArea;
        landArea =usCensusData.landArea;
        populationDensity =usCensusData.populationDensity;
        housingDensity =usCensusData.housingDensity;
    }


    public CensusDAO(IndiaCensusCSV indiaCensusCSV) {
        area=indiaCensusCSV.areaInSqKm;
        state =indiaCensusCSV.state;
        density=indiaCensusCSV.densityPerSqKm;
        population=indiaCensusCSV.population;
    }

    public CensusDAO() {
    }

    @Override
    public String toString() {
        return "CensusDAO{" +
                "Area=" + area +
                ", State='" + state + '\'' +
                ", Density=" + density +
                ", population=" + population +
                ", StateId='" + stateId + '\'' +
                ", Population=" + population +
                ", housingUnits=" + housingUnits +
                ", Totalarea=" + Totalarea +
                ", waterArea=" + waterArea +
                ", landArea=" + landArea +
                ", populationDensity=" + populationDensity +
                ", housingDensity=" + housingDensity +
                ", stateCode='" + stateCode + '\'' +
                '}';
    }

    public Object getCensusDTO(CensusAnalyser.Country country) {
        if (country.equals(CensusAnalyser.Country.US))
            return new USCensusData(stateId,state,population, housingUnits,Totalarea, waterArea, landArea, populationDensity, housingDensity);
        return new IndiaCensusCSV(stateCode,state,population,density,area);
    }

}
