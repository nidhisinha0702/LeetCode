package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {

	private static List<List<String>> ans;
	private static Map<String, Integer> mpp;
	
	public static void main(String[] args) {
		// WAP to print the word ladder sequence
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
		
		List<List<String>> ans = formLadder(beginWord, endWord, wordList);
		
		for(List<String> seq:ans) {
			for(String s:seq) {
				System.out.print(s+" ");
			}System.out.println();
		}
		
		
	}

	private static List<List<String>> formLadder(String beginWord, String endWord, List<String> wordList){
		//step1 follow wordLadder 1 and find the min step and to store the steps and string in mpp
        //step2 backtrack in the map from end to begin to get the answer
		//initialize a queue with a begin word
		Queue<String> q = new LinkedList<>();
		q.add(beginWord);
		//set for making vis
		Set<String> set = new HashSet<>(wordList);
		//add beginword to mapp
		mpp = new HashMap<>();
		mpp.put(beginWord, 1);
		//mark vis
		set.remove(beginWord);
		int size = beginWord.length();
		//iterate in the queue and find similar word
		while(!q.isEmpty()) {
			String word = q.peek();
			int steps = mpp.get(word);
			//remove it from queue
			q.remove();
			
			//break if you reach endword
			if(word.equals(endWord)) break;
			
			for(int i=0;i<size;i++) {
				for(char ch='a';ch<='z';ch++) {
					char replacedCharArray[] = word.toCharArray();
					replacedCharArray[i] = ch;
					String replacedWord = new String(replacedCharArray);
					//if set has this word push it in q, mark vis, put in map with incre step
					if(set.contains(replacedWord)) {
						q.add(replacedWord);
						set.remove(replacedWord);
						mpp.put(replacedWord, steps+1);
					}
				}
			}
		}
			//finally create ans 
			ans = new ArrayList<>();
			//if we reach the end word we found a seq
			if(mpp.containsKey(endWord)) {
				List<String> seq = new ArrayList<>();
				seq.add(endWord);//add this word
				dfs(endWord, beginWord, seq);//call dfs in reverse order
			}
			//return ans
			return ans;
	}
	
	private static void dfs(String endWord, String beginWord, List<String> seq) {
		//if reach beginword ---base condition
		if(endWord.equals(beginWord)) {
			//create a new arraylist
			List<String> dup = new ArrayList<>(seq);
			//reverse it
			Collections.reverse(dup);
			ans.add(dup);
			return;
		}
		
		int steps = mpp.get(endWord);
		int sz = endWord.length();
		for(int i=0;i<sz;i++) {
			for(char ch='a';ch<='z';ch++) {
				char replacedCharArray[] = endWord.toCharArray();
				replacedCharArray[i] = ch;
				String replacedWord = new String(replacedCharArray);
				//if the replaced word is found in mpp and on level - 1
				if(mpp.containsKey(replacedWord) && mpp.get(replacedWord) + 1 == steps) {
					seq.add(replacedWord);
					dfs(replacedWord, beginWord, seq);
					//backtrack step
					seq.remove(seq.size() - 1);
				}
			}
		}
	}
}
