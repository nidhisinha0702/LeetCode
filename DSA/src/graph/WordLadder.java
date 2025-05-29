package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {
		// WAP to return the number of word in the shortest transformation sequence from begin to end
		String startWord = "der", targetWord = "dfs";
        List<String> wordList = new ArrayList<>(Arrays.asList("des","der","dfr","dgt","dfs"));
        
        System.out.println("the length is : "+ladderLength(startWord, targetWord, wordList));

	}
	private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //queue ds for word,transition
        Queue<Pair> q = new LinkedList<>();

        //BFS traversal
        q.add(new Pair(beginWord, 1));

        //push all values of wordList into set
        //to make deletion from it easier and in less time complexity
        Set<String> st = new HashSet<>(wordList);

        //remove from set equivalent for marking vis
        st.remove(beginWord);

        //iterate in the queue
        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();
            //return the steps as soon as we find target
            if(word.equals(endWord)) return steps;

            //now replace each character in the word from a-z and check it in the wordList
            for(int i=0;i<word.length();i++){
                for(char c = 'a';c<='z';c++){
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = c;
                    String replacedWord = new String(replacedCharArray);

                    //check if it exist in the set
                    if(st.contains(replacedWord)){
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps+1));
                    }
                }
            }
        }return 0;
    }
}

class Pair{
    String first;
    int second;
    Pair(String first, int second){
        this.first = first;
        this.second = second;
    }
}
