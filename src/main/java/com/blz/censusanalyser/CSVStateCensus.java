package com.blz.censusanalyser;

import com.opencsv.bean.CsvBindByName;

public class CSVStateCensus {
    @CsvBindByName(column = "State")
    private String state;

    @CsvBindByName(column = "Population")
    private int population;

    @CsvBindByName(column = "AreaInSqKm")
    private int areaInSqKm;

    @CsvBindByName(column = "DensityPerSqKm")
    private int densityPerSqKm;

    @Override
    public String toString() {
        return "CSVStateCensus{" +
                "state='" + state + '\'' +
                ", population=" + population +
                ", areaInSqKm=" + areaInSqKm +
                ", densityPerSqKm=" + densityPerSqKm +
                '}';
    }
}
