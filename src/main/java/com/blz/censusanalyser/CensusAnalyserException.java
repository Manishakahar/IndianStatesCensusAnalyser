package com.blz.censusanalyser;

public class CensusAnalyserException extends Exception {

    ExceptionType type;
    private String message;



    public CensusAnalyserException(String message, ExceptionType type){
        this.message = message;
        this.type = type;
    }

    enum ExceptionType{
        CENSUS_FILE_PROBLEM;
    }

    @Override
    public String toString() {
        return "CensusAnalyserException{" +
                "type=" + type +
                ", message='" + message + '\'' +
                '}';
    }
}
