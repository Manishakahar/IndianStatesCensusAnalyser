package com.blz.censusanalyser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

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
            return getCount(censusCSVIterator);
        } catch (IOException e) {
            throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }

    private <E> int getCount(Iterator<E> censusCSVIterator) {
        Iterable<E> csvIterable = () -> censusCSVIterator;
        int numberOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), true).count();
        return numberOfEntries;
    }

    public int loadIndiaStateCode(String csvPath) throws CensusAnalyserException {

        try (Reader reader = Files.newBufferedReader(Paths.get(csvPath))) {
            Iterator<IndiaStateCode> censusCSVIterator = getCSVIterator(reader, CSVStateCensus.class);
            return getCount(censusCSVIterator);
        } catch (IOException e) {
            throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }

    private <E> Iterator getCSVIterator(Reader reader, Class csvClass) {
        CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder(reader);
        csvToBeanBuilder.withType(csvClass);
        csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
        CsvToBean<E> csvToBean = csvToBeanBuilder.build();
        return csvToBean.iterator();
    }
}

