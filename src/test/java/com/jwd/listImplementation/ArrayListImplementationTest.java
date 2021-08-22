package com.jwd.listImplementation;

import com.jwd.main.Main;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import java.util.ArrayList;

public class ArrayListImplementationTest extends TestCase {

    private ArrayListImplementation arrayListImplementation;
    private ArrayList arrayList;

    @Before
    public void before() {
        arrayListImplementation = Main.initializeArrayListImplementation();
        arrayList = Main.initializeArrayList();
    }

    public void testAdd() {
        before();
        arrayListImplementation.add(2,2);
        Assert.assertEquals(arrayListImplementation.get(2), 2);
    }

    public void testRemove() {
        before();
        Assert.assertEquals(arrayListImplementation.remove(2),3);
    }

    public void testIsEmpty() {
        before();
        Assert.assertFalse(arrayListImplementation.isEmpty());
    }

    public void testTestRemove() {
        before();
        Assert.assertTrue(arrayListImplementation.remove((Integer)1));
        Assert.assertFalse(arrayListImplementation.remove((Integer)6));
    }

    public void testAddAll() {
        before();
        Assert.assertTrue(arrayListImplementation.addAll(arrayList));
    }
}