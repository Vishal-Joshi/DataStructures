package com.example;

import java.util.HashMap;

public class JavaSet {

    private HashMap<String, Object> map;
    private static final Object DUMMY = new Object();

    public JavaSet() {
        map = new HashMap<>();
    }

    public boolean addToSet(String element) {
        return map.put(element, DUMMY) == null;
    }

    public boolean removeFromSet(String element) {
        return map.remove(element) == DUMMY;
    }

    public int sizeOfSet(){
        return map.size();
    }
}
