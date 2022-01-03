package com.blz.censusanalyser;

import org.junit.Assert;
import org.junit.Test;

public class CensusAnalyserTest {

    private static final String INDIA_CENSUS_CSV_PATH = "C:\\Users\\Dell\\Desktop\\manisha\\DesignPrinciple\\src\\main\\resources\\IndiaStateCensusData.csv";

     //  Given Case1 India State Census CSV File when Check the correct Record
    @Test
    public void givenCase1IndiaCensusCSVFile_WhenLoad_ShouldReturnCorrectRecord() {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        try {
          int numOfRecord = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_PATH);
            Assert.assertEquals(29,numOfRecord);
        } catch (CensusAnalyserException e) {

        }
    }
    //  Given  Case2 India State Census CSV File When incorrect entry count Should Return  custom Exception
    @Test
    public void givenCase2IndiaCensusCSVFile_WhenLoad_ShouldReturnInCorrectRecord() {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        try {
            int numOfRecord = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_PATH);
            Assert.assertEquals(28,numOfRecord);
        } catch (CensusAnalyserException e) {

        }
    }

    // given Case3 India State Census CSV File When incorrect Path Should Return  custom Exception
    @Test
    public void givenCase3IndiaCensusCSVFile_WhenLoad_ShouldReturnInCorrectRecord() {
        String path = "C:\\Users\\Dell\\Desktop\\manisha\\DesignPrinciple\\src\\main\\resources\\IndiaCensusData.csv.pdf ";
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        try {
            int numOfRecord = censusAnalyser.loadIndiaCensusData(path);
            Assert.assertEquals(29,numOfRecord);
        } catch (CensusAnalyserException e) {
        }
    }
    // given Case4 India State Census CSV File When incorrect delimiter Should Return  custom Exception
    @Test
    public void givenCase4IndiaCensusCSVFile_WhenLoad_ShouldReturnInCorrectRecord() {
        String FILEPATH = "C:\\Users\\Dell\\Desktop\\manisha\\DesignPrinciple\\src\\main\\resources\\CensusData.csv.pdf ";
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        try {
            int numOfRecord = censusAnalyser.loadIndiaCensusData(FILEPATH);
            Assert.assertEquals(29,numOfRecord);
        } catch (CensusAnalyserException e) {
        }
    }
}
