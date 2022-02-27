package com.pilugin.dmitriy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class ConvertToCron implements DatesToCronConverter{
    @Override
    public String convert(ArrayList str) throws DatesToCronConvertException {
        // не факт что string
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

        ArrayList<String> Rezult = new ArrayList<>();

        Rezult.add(AddTime(AnaliticArray,1));
        Rezult.add(AddTime(AnaliticArray,2));
        Rezult.add(AddTime(AnaliticArray,3));
        Rezult.add(AddTime(AnaliticArray,4));
        Rezult.add(AddTime(AnaliticArray,5));
        Rezult.add(AddDayOftheWeek(AnaliticArray));
      //  Rezult = ConvertationToCron(AnaliticArray); // не дождался ответа на письмо. Эта ветка по подбору из списка дат - не используется.

        return String.join(" ", Rezult);
    }

    private String AddTime(ArrayList<ArrayList<String>> analiticArray, int i) {
        return "*";
    }

    private String AddDayOftheWeek(ArrayList<ArrayList<String>> analiticArray) {
        return "*";
    }













    static ArrayList<ArrayList<String>> SortAndParse(ArrayList<String> str) throws DatesToCronConvertException {
        ArrayList<ArrayList<String>> rez = new ArrayList<>();
        Collections.sort(str); //сортировка, работает так как формат “yyyy-MM-dd'T’HH:mm:ss” - от высшего к низшему

        for (String LineData : str) {


            String[] YearsAndTime = LineData.split("T");
            String[] YYYY_MM_DD = YearsAndTime[0].split("-");
            String[] HH_mm_ss = YearsAndTime[1].split(":");

            ArrayList<String> strData = new ArrayList<>();
            strData.add(YYYY_MM_DD[0]);
            strData.add(YYYY_MM_DD[1]);
            strData.add(YYYY_MM_DD[2]);
            strData.add(HH_mm_ss[0]);
            strData.add(HH_mm_ss[1]);
            strData.add(HH_mm_ss[2]);
            rez.add(strData);

        }

        return rez;
    }

    static String ConvertationToCron(ArrayList<ArrayList<String>> AnaliticArray) throws DatesToCronConvertException {
// Значение по умолчанию каждую секунду

        String second = collapse(AnaliticArray, 5);
        String minute = collapse(AnaliticArray, 4);
        String hour = collapse(AnaliticArray, 3);
        String day = collapse(AnaliticArray, 2);
        String month = collapse(AnaliticArray, 1);
        String dayweek = "*"; //    collapse(AnaliticArray,0);
        String result = second + " " + minute + " " + hour + " " + day + " " + month + " " + dayweek;
        return result;
    }

    static String collapse(ArrayList<ArrayList<String>> AnaliticArray, int number) throws DatesToCronConvertException {
        String rez = "";
        ArrayList ArrayData = СolumnToLine(AnaliticArray, number);

        // Чистим дубли потому что в переоидичности они нам не нужны
        HashSet set = new HashSet(ArrayData);
// Очищаем коллекцию списков
        ArrayData.clear();
// Повторно добавляем дедублированные элементы в список
        ArrayData.addAll(set);

        // если количество = 1 тогда его и устанвливаем
        AnaliticArray.size();


        //rez = (String) ArrayData.get(0) + "-" + ArrayData.get(ArrayData.size()-1) ;
        // switch ругается
        if (ArrayData.size() == 1) {
            rez = (String) ArrayData.get(0);
        } else {
            // проверим на инкрементность, если нет, то перечислением TODO усложнить проверку
            if (Integer.valueOf((String) ArrayData.get(0)) + 1 == Integer.valueOf((String) ArrayData.get(1))) {
                rez = ArrayData.get(0) + "-" + ArrayData.get(ArrayData.size() - 1);
            } else {
                switch (number = 1) {
                    case 1:
                        minute(ArrayData);
                        break;
                    case 2:
                        minute(ArrayData);
                        break;
                    default:
                        break;

                }


                for (Object element : ArrayData) {
                    rez = rez + element + ",";
                }
                rez = rez.substring(0, rez.length() - 1);

            }

        }
        //* Проверим последовательность элементов

        return rez;
    }

    static String minute(ArrayList ArrayData) throws DatesToCronConvertException {

        int divider = abs(Integer.valueOf((String) ArrayData.get(0)) - Integer.valueOf((String) ArrayData.get(1)));
        String rez = "*";

        for (Object element : ArrayData) {

            int remainder = Integer.valueOf((String) element) % divider;

            if (remainder != 0) {
                break;
            }
        }
        return "*";
    }

    /*
    static String hour(ArrayList<ArrayList<String>> AnaliticArray) throws DatesToCronConvertException {
        String rez = "*";

        return "*";
    }

    static String day(ArrayList<ArrayList<String>> AnaliticArray) throws DatesToCronConvertException {
        String rez = "*";

        return "*";
    }
    static String month(ArrayList<ArrayList<String>> AnaliticArray) throws DatesToCronConvertException {
        String rez = "*";

        return "*";
    }
    static String day_of_the_week(ArrayList<ArrayList<String>> AnaliticArray) throws DatesToCronConvertException {
        String rez = "*";

        return "*";
    }
*/
    static ArrayList СolumnToLine(ArrayList<ArrayList<String>> analiticArray, int i) {
        ArrayList Rezult = new ArrayList();

        for (ArrayList Line : analiticArray) {
            Rezult.add(Line.get(i));
        }
        return Rezult;
    }

    static int abs(int a) {
        if (a < 0) {
            return -a;
        } else {
            return a;
        }
    }

    @Override
    public String getImplementationInfo() throws DatesToCronConvertException {
        return "Пилюгин Дмитрий, Main, com.Pilygin.Dmitry,https://github.com/DreamCastl";
    }
}
