package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;

import java.util.List;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {
    SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

    @org.junit.jupiter.api.Test
    void add() {

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.remove(3);

        Integer expected=3;
        Integer actual = list.size();

        Assert.assertEquals(expected,actual);

    }

    @org.junit.jupiter.api.Test
    void remove() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.remove(list.size()-1);

        Integer expected=3;
        Integer actual = list.size();

        Assert.assertEquals(expected,actual);
    }
    @org.junit.jupiter.api.Test
    void removeOutOfBounds() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.remove(list.size());

        Integer expected=3;
        Integer actual = list.size();

        Assert.assertNotEquals(expected,actual);
    }








}
