package com.jwd.listImplementation;

import java.util.Arrays;
import java.util.List;

public class ArrayListImplementation<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elementData;
    private int size;

    public ArrayListImplementation() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public ArrayListImplementation(int initialCapacity) {
        if(initialCapacity < 0) {
            throw new IllegalArgumentException("ArrayListImplementation: Illegal capacity");
        }
        this.elementData = new Object[initialCapacity];
    }

    public E get(int index) {
        checkIndex(index);

        return (E)elementData[index];
    }

    public boolean add(E element) {
        if(size == elementData.length) {
            elementData = changeSizeOfArray(0);
        }
        elementData[size] = element;
        size++;

        return true;
    }

    private Object[] changeSizeOfArray(int capacity) {
        Object[] localElementData;
        if (size == 0)  {
            localElementData = new Object[DEFAULT_CAPACITY];
        } else {
            if(capacity > elementData.length ) {
                localElementData = new Object[elementData.length + capacity];
            } else {
                localElementData = new Object[elementData.length * 2];
            }
        }

        System.arraycopy(elementData, 0, localElementData, 0, size );

        return localElementData;
    }

    public void add(int index, E element) {
        checkIndex(index);

        if(size == elementData.length){
            elementData = changeSizeOfArray(0);
        }

        Object[] localElementData = new Object[elementData.length];
        System.arraycopy(elementData, index, localElementData, 0, size - index);
        elementData[index] = element;
        System.arraycopy(localElementData, 0, elementData, index + 1, size - index);
        size++;
    }

    private void checkIndex(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("ArrayListImplementation: Invalid index");
        }
    }

    public E remove(int index) {
        checkIndex(index);
        E deletedObject = (E) elementData[index];

        for(int i = index ; i < size; i++){
            elementData[i] = elementData[i + 1];
        }

        size--;

        return deletedObject;
    }

    public boolean remove(E element) {
        boolean isDeleted = false;
        if(element == null) {
            throw new NullPointerException("ArrayListImplementation: Not null object is required");
        }

        for(int i = 0; i < elementData.length; i++) {
            if(element.equals(elementData[i])) {
                System.arraycopy(elementData, i + 1, elementData, i, size - i);
                isDeleted = true;
                size--;
                break;
            }
        }

        return isDeleted;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public boolean addAll(List<E> list) {
        int leftCapacity = elementData.length - size;

        if(list.size() > leftCapacity) {
            elementData = changeSizeOfArray(list.size() - leftCapacity);
        }
        for(int i = 0; i < list.size(); i++){
            elementData[i + size] = list.get(i);
            size ++;
        }

        return true;
    }


    public boolean addAll(int index, List<E> list) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("ArrayListImplementation: Invalid index");
        }

        int leftCapacity = elementData.length - size;
        if(list.size() > leftCapacity) {
            elementData = changeSizeOfArray(list.size() - leftCapacity);
        }

        int localIterations = addAllElementsFromIndex(index, list);
        size += localIterations;

        return true;
    }

    private int addAllElementsFromIndex(int index, List<E> list) {
        Object[] localElementData = new Object[elementData.length];
        int localIterations = 0;
        for(int i = index; i < (index + list.size()); i++){
            localElementData[localIterations] = elementData[i];
            elementData[i] = list.get(localIterations++);
        }
        int localIndex = 0;
        for(int i = index + list.size(); i < index + list.size() + localIterations; i++){
            elementData[i] = localElementData[localIndex++];
        }
        return localIterations;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public boolean removeAll(List<E> list) {
        for(E element : list) {
            if(contains(element)) {
                remove(element);
            }
        }
        return true;
    }

    public int indexOf(Object o) {
        if(o == null) {
            throw new NullPointerException("ArrayListImplementation: Not null object is required");
        }
        for (int i = 0; i < size; i++) {
            if (o.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "ArrayListImplementation{" +
                "elementData=" + Arrays.toString(elementData) +
                ", size=" + size +
                '}';
    }
}
