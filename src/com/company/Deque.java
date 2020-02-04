package com.company;

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

    private Node<Item> first;
    private Node last;
    private Node<Item> oldFirst;
    private Node head;
    private int size;
    private Item remove;

    // construct an empty deque
    private Deque(){
        head = null;
        first = null;
        oldFirst = null;
        last = null;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty(){return head == null;}

    // return the number of items on the deque
    public int size(){
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        //stack
        if (head == null) {
            head = new Node();
            head.item = item;
            size+=1;

        } else {

            if (first == null) {
                first = new Node<Item>();
                first.item = item;
                head.next = first;
                size+=1;
            } else {

                oldFirst = first;
                first = new Node<Item>();
                first.item = item;
                oldFirst.next = first;
                size+=1;
            }

        }
    }

    // add the item to the back
    public void addLast(Item item){

        if (head!= null) {
            last = new Node();
            last.item = item;
            last.next = head;
            head = last;
            size += 1;
        }
    }

    // remove and return the item from the front
    public Item removeFirst(){

if(first!=null) {
    first = oldFirst;
    first.next = null;
    remove = first.item;
    size -= 1;
    return remove;
}
return null;
    }

    /// remove and return the item from the back
    public Item removeLast(){

        if(head!=null) {
            remove = (Item) head.item;
            head = head.next;
            size -= 1;
            return remove;
        }
        return null;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator()  {return new ListIterator();}

    public class  ListIterator implements Iterator<Item>{

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

        Deque<Integer> d = new Deque<>();

        d.addFirst(1);
        d.addFirst(2);
        d.addFirst(3);
        d.addFirst(4);
        d.addLast(6);
        d.addLast(5);


d.removeFirst();
d.removeLast();
d.removeLast();

        System.out.println(d.size());
        System.out.println(d.isEmpty());

        while(d.iterator().hasNext()){
            System.out.println(d.iterator().next());
        }





    }





}