package com.pilugin.dmitriy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public interface DatesToCronConverter {



    default String convert(ArrayList str){ // не факт что string
        // А вот тут происхдит магия

        /*
        ┌───────────── second (0-59)
        │ ┌───────────── minute (0 - 59)
        │ │ ┌───────────── hour (0 - 23)
        │ │ │ ┌───────────── day of the month (1 - 31)
        │ │ │ │ ┌───────────── month (1 - 12) (or JAN-DEC)
        │ │ │ │ │ ┌───────────── day of the week (0 - 7)
        │ │ │ │ │ │          (0 or 7 is Sunday, or MON-SUN)
        │ │ │ │ │ │
         * * * * * *
         */
        //need sort and parse ArrayList

        ArrayList<ArrayList<String>> AnaliticArray = SortAndParse(str);
        String Rezult = "в";
        return Rezult;
    }

    default String getImplementationInfo(){
        return "Пилюгин Дмитрий, Main, com.Pilygin.Dmitry,https://github.com/DreamCastl";
    }

    static ArrayList<ArrayList<String>> SortAndParse(ArrayList<String> str) {
        ArrayList<ArrayList<String>> rez = new ArrayList<>();
        Collections.sort(str); //сортировка, работает так как формат “yyyy-MM-dd'T’HH:mm:ss” - от высшего к низшему

        for (String LineData:str) {


            String[] YearsAndTime= LineData.split("T");
            String[] YYYY_MM_DD = YearsAndTime[0].split("-");
            String[] HH_mm_ss = YearsAndTime[1].split(":");

            ArrayList<String> strData = new ArrayList<>() ;
            strData.add(YYYY_MM_DD[0]);
            strData.add(YYYY_MM_DD[1]);
            strData.add(YYYY_MM_DD[2]);
            strData.add(HH_mm_ss[0]);
            strData.add(HH_mm_ss[1]);
            strData.add(HH_mm_ss[2]);
            rez.add(strData);



           int a = 4;
        }

        return rez;
    }


}
