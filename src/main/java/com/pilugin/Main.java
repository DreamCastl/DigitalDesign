package com.pilugin.dmitriy;

public class Main {

    public Main() {
    }


    public static void main(String[] args) {
        ConverToCron ConverToCronObj = new ConverToCron();
        String[] strData = new String[] {
                "2022-01-25T08:00:00",
                "2022-01-25T08:30:00",
                "2022-01-25T09:00:00",
                "2022-01-25T09:30:00",
                "2022-01-26T08:00:00",
                "2022-01-26T08:30:00",
                "2022-01-26T09:00:00",
                "2022-01-26T09:30:00"
        };

    System.out.println(ConverToCronObj.convert(strData));
    System.out.println(ConverToCronObj.getImplementationInfo());
    }


}
