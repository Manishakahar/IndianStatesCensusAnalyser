package com.blz.censusanalyser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class CensusAnalyser {

    public int loadIndiaCensusData(String csvPath) throws CensusAnalyserException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvPath))) {
            Iterator<CSVStateCensus> censusCSVIterator = new OpenCSV().getCSVIterator(reader, CSVStateCensus.class);
            return    getCount(censusCSVIterator);
        } catch (IOException e) {
            throw new CensusAnalyserException(e.getMessage(),CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }
    private <E> int getCount(Iterator<E> censusCSVIterator) {
        Iterable<E> csvIterable = () -> censusCSVIterator;
        int numberOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), true).count();
        return numberOfEntries;
    }
}
