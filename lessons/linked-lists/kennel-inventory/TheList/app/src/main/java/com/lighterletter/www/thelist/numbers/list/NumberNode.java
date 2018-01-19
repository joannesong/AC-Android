package com.lighterletter.www.thelist.numbers.list;

/**
 * Created by john on 1/17/18.
 */

class NumberNode {
    protected int data;
    protected NumberNode next;

    /*  Constructor  */
    public NumberNode() {
        next = null;
        data = 0;
    }

    /*  Constructor  */
    public NumberNode(int d, NumberNode n) {
        data = d;
        next = n;
    }

    /*  Method to set next to next NumberNode  */
    public void setNext(NumberNode n) {
        next = n;
    }

    /*  Method to set data to current NumberNode  */
    public void setData(int d) {
        data = d;
    }

    /*  Method to get next to next node  */
    public NumberNode getNext() {
        return next;
    }

    /*  Method to get data from current NumberNode  */
    public int getData() {
        return data;
    }
}
