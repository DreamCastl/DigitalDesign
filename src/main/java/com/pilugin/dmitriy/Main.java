package com.pilugin.dmitriy;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws DatesToCronConvertException {
        ConvertToCron ConvertToCron_Obj = new ConvertToCron();
        ArrayList<String> strData = new ArrayList<>() ;
        strData.add("2022-01-26T08:30:00");
        strData.add("2022-01-26T09:00:00");
        strData.add("2022-01-26T09:30:00");
        strData.add("2022-01-25T08:00:00");
        strData.add("2022-01-25T09:00:00");
        strData.add("2022-01-25T08:30:00");

        strData.add("2022-01-25T09:30:00");
        strData.add("2022-01-26T08:00:00");


    System.out.println(ConvertToCron_Obj.convert(strData));
    System.out.println(ConvertToCron_Obj.getImplementationInfo());
    }


}
