package com.pilugin.dmitriy;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws DatesToCronConvertException {
        ConvertToCron ConvertToCron_Obj = new ConvertToCron();
        ArrayList<String> strData = new ArrayList<>() ;
//        strData.add("2022-01-26T08:30:00");
//        strData.add("2022-01-26T09:00:00");
//        strData.add("2022-01-26T09:30:00");
//        strData.add("2022-01-25T08:00:00");
//        strData.add("2022-01-25T09:00:00");
//        strData.add("2022-01-25T08:30:00");
//
//        strData.add("2022-01-25T09:30:00");
//        strData.add("2022-01-26T08:00:00");

        strData.add("2022-01-24T19:53:00");
        strData.add("2022-01-24T19:54:00");
        strData.add( "2022-01-24T19:55:00");
        strData.add( "2022-01-24T19:56:00");
        strData.add( "2022-01-24T19:57:00");
        strData.add( "2022-01-24T19:58:00");
        strData.add( "2022-01-24T19:59:00");
        strData.add( "2022-01-24T20:00:00");
        strData.add( "2022-01-24T20:01:00");
        strData.add(  "2022-01-24T20:02:00");


        System.out.println(ConvertToCron_Obj.convert(strData));
    System.out.println(ConvertToCron_Obj.getImplementationInfo());
    }


}
