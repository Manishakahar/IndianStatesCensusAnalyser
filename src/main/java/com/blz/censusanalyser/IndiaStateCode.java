package com.blz.censusanalyser;

import com.opencsv.bean.CsvBindByName;

public class IndiaStateCode {
    @CsvBindByName(column = "SrNo")
    private int rrNo;

    @CsvBindByName(column = "State Name")
    private String stateName;

    @CsvBindByName(column = "TIN")
    private int tin;

    @CsvBindByName(column = "StateCode")
    private int stateCode;

    @Override
    public String toString() {
        return "IndiaStateCode{" +
                "rrNo=" + rrNo +
                ", stateName='" + stateName + '\'' +
                ", tin=" + tin +
                ", stateCode=" + stateCode +
                '}';
    }
}
