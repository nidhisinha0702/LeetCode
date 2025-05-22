package DoublyLinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRU {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRU cache = new LRU(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
	}
	//to implement lrucache we need dll and map ds
	Nodedll head, tail;
    int capacity;
    Map<Integer, Nodedll> mpp;
    //initializing everything
    public LRU(int capacity) {
        this.capacity = capacity;
        mpp = new HashMap<>();
        mpp.clear();
        head = new Nodedll(-1, -1);
        tail = new Nodedll(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    // Function to get the value for a given key
    public int get(int key) {
    	 //map does not have it
        if(!mpp.containsKey(key)) return -1;
        //if it has it will give the node
        Nodedll node = mpp.get(key);
        //mark it lru
        deleteNode(node);
        insertAfterHead(node);
        return node.val;
    }
    // Function to put a key-value pair into the cache
    public void put(int key, int value) {
    	//if map has key
        if(mpp.containsKey(key)){
        	Nodedll oldnode = mpp.get(key);
        	oldnode.val = value;
            deleteNode(oldnode);
            insertAfterHead(oldnode);
        }else {
        	if(mpp.size() == capacity){
           	 Nodedll lastnode = tail.prev;
             mpp.remove(lastnode.key);
             deleteNode(lastnode);
             }
        	 Nodedll node = new Nodedll(key, value);
             mpp.put(key,node);
             insertAfterHead(node);
        } 
    }

    public void deleteNode(Nodedll node){
    	Nodedll prevNode = node.prev;
    	Nodedll afterNode = node.next;
        prevNode.next = afterNode;
        afterNode.prev = prevNode;
    }

    public void insertAfterHead(Nodedll node){
    	Nodedll currAfterHead = head.next;
        head.next = node;
        node.next = currAfterHead;
        node.prev = head;
        currAfterHead.prev = node;
    }
}

class Nodedll{
    int key, val;
    Nodedll next, prev;
    Nodedll(int key, int val){
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
