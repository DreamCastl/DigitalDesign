package com.pilugin.dmitriy;

import java.util.ArrayList;

public interface DatesToCronConverter {


    default String convert(ArrayList str) throws DatesToCronConvertException {
        return null;
    }


    default String getImplementationInfo() throws DatesToCronConvertException {
        return null;

    }
}
