package Stack;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LFUCache cache = new LFUCache(2);
		
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1)+" ");
		cache.put(3, 3);
		System.out.println(cache.get(2)+" ");
		cache.put(4, 4);
		System.out.println(cache.get(3)+" ");
		System.out.println(cache.get(4)+" ");
		cache.put(5, 5);
	}
	class Node{
		int key,value,cnt;
		Node next,prev;
		
		Node(int key, int value){
			this.key = key;
			this.value = value;
			//initial frequency is 1
			cnt = 1;
		}
	}
	
	static class Pair<F, S>{
		F first;
		S second;
		Pair(F first, S second){
			this.first=first;
			this.second=second;
		}
		
	}
	//map of int and node which represents key and Node address
	private Map<Integer, Node> keyNodeMap;
	//map of int and DLL which represents frequency and DLL(Pair<head,tail>)
	private Map<Integer, Pair<Node , Node>> freqDLLMap;
	//minimum frequency of each node
	private int minFreq;
	private int capacity;
	
	LFUCache(int capacity){
		this.capacity = capacity;
		minFreq = 0;
		keyNodeMap = new HashMap<>();
		freqDLLMap = new HashMap<>();
	}
	
	int get(int key) {
		//check if the key is there in the key-map
		if(keyNodeMap.containsKey(key)) {
			Node node = keyNodeMap.get(key);
			//update its frequency as it is used
			int res = node.value;
			updateFreq(node);
			return res;
		}else	return -1;
	}
	
	void put(int key,int value) {
		//check if the capacity is zero
		if(capacity == 0) {
			return;
		}
		//update the value if key exist in the key-map
		if(keyNodeMap.containsKey(key)) {
			Node node = keyNodeMap.get(key);
			node.value = value;
			//update its frequency
			updateFreq(node);
		}else {
			//add a new key value pair in the key-map
			//remove the least frequently used node if the map is full
			if(keyNodeMap.size() == capacity) {
				Node node = freqDLLMap.get(minFreq).second.prev;//LRU node among all
				keyNodeMap.remove(node.key);
				remove(node);//remove it from the DLL
				
				//remove the freq list if its empty
				if(freqDLLMap.get(minFreq).first.next == freqDLLMap.get(minFreq).second) {
					freqDLLMap.remove(minFreq);
				}
			}
			//create a new node for key-map
			Node node = new Node(key,value);//this will create a new node(K,V)
			keyNodeMap.put(key, node);//put it in the key-map
			//reset the minimum freq to 1 for this node as it is created newly its freq is 1
			minFreq = 1;
			add(node,1);
		}
	}
	
	//adding a node after head
	void add(Node node, int freq) {
		//if the does not exist
		if(!freqDLLMap.containsKey(freq)) {
			//create a dummy head node
			Node head = new Node(-1,-1);
			
			//dummy tail
			Node tail = new Node(-1,-1);
			
			head.next = tail;
			tail.prev = head;
			freqDLLMap.put(freq, new Pair<>(head,tail));
		}//insert the node
		Node head = freqDLLMap.get(freq).first;
		Node temp = head.next;
		node.next = temp;
		node.prev = head;
		head.next = node;
		temp.prev = node;
	}
	void remove(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}
	
	void updateFreq(Node node) {
		int oldFreq = node.cnt;
		
		//Increment the frequency
		node.cnt++;
		//remove the node from the current frequency list and add it to the next frequency list
		remove(node);
		//as per LRU we remove the least recently used node
		//check if the first.next(head->next) is tail then remove the oldFreq and clean up the map
		if(freqDLLMap.get(oldFreq).first.next == freqDLLMap.get(oldFreq).second) {
			freqDLLMap.remove(oldFreq);
		//update the minimum frequency
			if(minFreq == oldFreq) {
			minFreq++;
			}
		}
		//add the node to the updated freq list
		add(node,node.cnt);
		
	}

}
