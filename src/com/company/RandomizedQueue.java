package com.company;

import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;



public class RandomizedQueue<Item> implements Iterable<Item> {

    private Node first;
    private int size = 0;
    private Item remove;

    // construct an empty randomized queue
    public RandomizedQueue(){
        first = null;
        remove = null;
        size = 0;


    }

    // is the randomized queue empty?
    public boolean isEmpty(){
        return first == null;
    }

    // return the number of items on the randomized queue
    public int size(){
        return size;
    }

    // add the item
    public void enqueue(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    // remove and return a random item
    public Item dequeue(){
       Node current = first;

        first = current.next;

       return (Item) current.item;
    }

    // return a random item (but do not remove it)
    public Item sample(){

        return null;

    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator(){
        return null;
    }

    // unit testing (required)
    public static void main(String[] args){
    RandomizedQueue r = new RandomizedQueue();


        r.enqueue(1);
        r.enqueue(2);
        r.enqueue(3);
        r.enqueue(4);
        r.enqueue(5);
        r.dequeue();
        r.dequeue();
        r.dequeue();
        r.dequeue();


    }

}