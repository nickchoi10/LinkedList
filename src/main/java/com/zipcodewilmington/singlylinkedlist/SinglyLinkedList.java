package com.zipcodewilmington.singlylinkedlist;

import javax.lang.model.element.Element;
import javax.xml.soap.Node;
import java.util.Comparator;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<Element extends Comparable<Element>> {

private class Node{
    Element data;
    Node next;

    public Node(Element data){
        this.data=data;
        this.next=null;
    }

    void setNextNode(Node node){this.next=node;}
    Node getNextNode(){return this.next;}

    void setData(Element data){this.data =data;}
    Element getData(){return this.data;}

}

// everything below here we will create methods to use for our linked list..
    //where we also keep track of head and tail linkedlist.
private Node head;
private Node tail;
private Integer size;

public SinglyLinkedList(){
    this.head=null;
    this.tail=null;
    this.size=0;
}


public void add(Element data){
    Node node = new Node(data);

    if(this.head==null){
        this.head=node;
    }else{
        this.tail.next=node;
    }
    this.tail =node; //making the node that you added as tail.
    this.size++; //keeping track of count/size
}

public void remove(int index){ //TODO this is the hardest method.... need more reviews...

        Node previousNode = this.head;
        Node currentNode = this.head.getNextNode();

        if (index < 0 || index > this.size-1) {
            return;
        }
        if (index == 0) {
            this.head = this.head.getNextNode();
        }

        for (int i = 0; i < index-1; i++) {
            currentNode = currentNode.getNextNode();
            previousNode = previousNode.getNextNode();
        }
        previousNode.next = currentNode.getNextNode();

        this.size--;
    }
//    //iterate through the singly list
//    Node previousNode = null;
//    Node currentNode = this.head;
//    int currentIndex =0;
//    //check if current node exist
//    if(currentNode != null && currentIndex!=index){
//        previousNode=currentNode;
//        //continuing the iteration
//        currentNode=currentNode.getNextNode();
//        currentIndex++;
//    }
//    //remove the index
//    if(currentIndex==index){
//        //checking if previous node is not null
//        if(previousNode!= null){
//            //pointing the previous node to the node after
//            previousNode.getNextNode()=currentNode.getNextNode();
//        }
//        //checking current node is head
//        if(currentNode==null || currentNode.getNextNode()==null){
//            //return head as null
//            head=null;
//        }else{
//            //the new head will be the next node
//            head =currentNode.getNextNode();
//        }
//        //current is the tail
//
//    }else if(currentNode==tail){
//        //the tail is the previous one
//        tail= previousNode;
//    }
//    }

    public Integer size(){
    return this.size;
    }

    public Boolean contains(Element element) {
        Node currentNode = this.head;
        while(currentNode != null) {    //iterating through the list
            if (currentNode.getData().equals(element)) {
                return true;
            }
            currentNode = currentNode.getNextNode();//keep iterating throughthe list until if statemnet comes true..
        }
        return false;   //no elements found
    }

    public Integer find(Element element) {
        Node currentNode = this.head;
        Integer index = 0;

        while(currentNode != null) {    //iterating through the list
            if (currentNode.getData().equals(element)) {
                return index;
            }
            currentNode = currentNode.getNextNode();
            index++;
        }
        return -1;
    }

    public Element get(int index) {
        Node currentNode = this.head;
        Integer currentIndex = 0;

        if (index < 0 || index > size) { //if out of bounds...
            return null;
        }

        while(currentIndex != index) {  //iterating through the list until index is found
            currentNode = currentNode.getNextNode();
            currentIndex++;
        }
        return currentNode.getData(); //when index is found..
    }

    public SinglyLinkedList<Element> copy() {
        SinglyLinkedList<Element> copyList = new SinglyLinkedList<Element>();
        Node currentNode = this.head;

        while (currentNode != null) { //iterating through the list
            Element data = currentNode.getData(); //storing value of element
            copyList.add(data);                     //adding it to the copy list
            currentNode = currentNode.getNextNode(); //this is needed to iterate through the currentnode
        }
        return copyList;
    }
    public void sort() {
        Node currentNode = this.head;
        Node nextNode;
            /*
            Comparable returns:
                -1  - object is < specified object
                0   - object is = specified object
                1   - object is > specified object
             */

        for(int i = 0; i < size; i++){
            while(currentNode.getNextNode() != null){ //iterating through the comparing element
                nextNode = currentNode.getNextNode();
                if(currentNode.getData().compareTo(nextNode.getData()) > 0){
                    Element temp = currentNode.getData();
                    currentNode.setData((nextNode.getData()));
                    nextNode.setData(temp);
                }
                currentNode = currentNode.getNextNode();
            }
            currentNode = this.head;
        }

    }

    public String toString() {
        Node currentNode = this.head;
        String s = "";

        while (currentNode != null) { //iterating through the list
            s += currentNode.data;
            currentNode = currentNode.getNextNode();
        }

        return s;
    }


}











