package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;


public class RandomizedQueue<Item> implements Iterable<Item> {

    private Node first;
    private int size = 0;
    private Item remove;
    private LinkedList<Item> l;

    // construct an empty randomized queue
    public RandomizedQueue(){
        first = null;
        remove = null;
        size = 0;
        l = new LinkedList<>();

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

        l.add(item);
        size++;
    }

    // remove and return a random item
    private Item dequeue(){
        return null;
    }

    // return a random item (but do not remove it)
    public Item sample(){
        Random random = new Random();
        int min=0;
        int max= 0;

        for(Object item : l ){
            max+=1;
        }

        int result = random.nextInt(max-min)+min;


return l.get(result);
    }
    // return an independent iterator over items in random order
    public Iterator<Item> iterator()  {return new ListIterator();}

    private class  ListIterator implements Iterator<Item>{

        Node current = first;

           public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = (Item) current.item;
            first = current.next;

            return item;
        }
    }

    // unit testing (required)
    public static void main(String[] args){
    RandomizedQueue<Integer> r = new RandomizedQueue<>();


        r.enqueue(1);
        r.enqueue(5);
        r.enqueue(7);
        r.enqueue(3);
        r.enqueue(2);

        while(r.iterator().hasNext()){
            System.out.println(r.iterator().next());
        }

for(int i =0;i<100;i++) {
    System.out.println(r.sample());
}
    }

}