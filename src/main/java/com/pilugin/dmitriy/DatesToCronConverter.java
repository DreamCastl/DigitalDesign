package com.pilugin.dmitriy;

public interface DatesToCronConverter {



    default String convert(String[] str){ // не факт что string
        String Rezult = "На входе список дат а на выходе вот эта строка";
        // А вот тут происхдит магия
        return Rezult;
    }

    default String getImplementationInfo(){
        return "Пилюгин Дмитрий, Main, com.Pilygin.Dmitry,https://github.com/DreamCastl";
    }

}
