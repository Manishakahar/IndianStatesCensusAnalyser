package com.blz.censusanalyser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;;
import java.nio.file.Paths;
import java.util.Iterator;

public class CensusAnalyser {


    public int loadIndiaCensusData(String csvPath) throws CensusAnalyserException {

        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvPath));
            CsvToBeanBuilder<CSVStateCensus> CsvToBeanBuilder = new CsvToBeanBuilder<CSVStateCensus>(reader);
            CsvToBeanBuilder.withType(CSVStateCensus.class);
            CsvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<CSVStateCensus> csvToBean = CsvToBeanBuilder.build();
            Iterator<CSVStateCensus> censusCSVIterator = csvToBean.iterator();
            int numOfEntries = 0;
            while (censusCSVIterator.hasNext()) {
                numOfEntries++;
                System.out.println(censusCSVIterator);
                censusCSVIterator.next();
            }
            return numOfEntries;
        } catch (IOException e) {
            e.printStackTrace();
            throw new CensusAnalyserException(e.getMessage(),CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }

    }
}
