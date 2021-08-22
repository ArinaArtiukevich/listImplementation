package com.jwd.main;

import com.jwd.listImplementation.ArrayListImplementation;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayListImplementation<Integer> arrayListImplementation = initializeArrayListImplementation();
        ArrayList<Integer> arrayList = initializeArrayList();

        arrayListImplementation.addAll(1 , arrayList);

        arrayListImplementation.removeAll(arrayList);
        arrayListImplementation.toString();
    }

    public static ArrayList<Integer> initializeArrayList() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        return arrayList;
    }

    public static ArrayListImplementation<Integer> initializeArrayListImplementation() {
        ArrayListImplementation<Integer> arrayListImplementation = new ArrayListImplementation<>(7);
        arrayListImplementation.add(0);
        arrayListImplementation.add(1);
        arrayListImplementation.add(3);
        arrayListImplementation.add(4);
        return arrayListImplementation;
    }
}
