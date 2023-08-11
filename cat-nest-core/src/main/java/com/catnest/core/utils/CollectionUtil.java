package com.catnest.core.utils;


import java.util.HashMap;
import java.util.Map;

public class CollectionUtil {

    private CollectionUtil() {
    }

    public static <K, V> Map<K, V> mergeCollection(K[] keys, V[] values) {
        Map<K, V> result = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            result.put(keys[i], values[i]);
        }
        return result;
    }


}
