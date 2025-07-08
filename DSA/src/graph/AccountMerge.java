package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountMerge {

	public static void main(String[] args) {
		List<List<String>> accounts = new ArrayList<>();
		List<String> l1 = Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com");
		List<String> l2 = Arrays.asList("John","johnsmith@mail.com","john00@mail.com");
		List<String> l3 = Arrays.asList("Mary","mary@mail.com");
		List<String> l4 = Arrays.asList("John","johnnybravo@mail.com");
		accounts.add(l1);accounts.add(l2);accounts.add(l3);accounts.add(l4);
		System.out.println("merged accounts is : "+accountsMerge(accounts));

	}
	public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSetSize ds = new DisjointSetSize(n);
        //step1 disjoint set is created
        HashMap<String, Integer> mapMailNode = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail = accounts.get(i).get(j);
                if(!mapMailNode.containsKey(mail)){
                    //if the mail is new add with index
                    mapMailNode.put(mail,i);
                }{
                    //else merge with the parent
                    ds.unionBySize(i, mapMailNode.get(mail));
                }
            }
        }
        //step2 create list of merge mails from map
        ArrayList<String>[] mergedMail = new ArrayList[n];
        for(int i=0;i<n;i++){
            mergedMail[i] = new ArrayList<String>();
        }
        for(Map.Entry<String, Integer> it: mapMailNode.entrySet()){
            String mail = it.getKey();
            //we will always connect the node to the ultimate parent
            int node = ds.findUPar(it.getValue());
            mergedMail[node].add(mail);
        }

        //step 3 final rearrage to return ans
        List<List<String>> ans = new ArrayList<>();
        //iterate over the merged mail
        for(int i=0;i<n;i++){
            //it do not have any mails
            if(mergedMail[i].size() == 0) continue;
            //sort the merged mails
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            //put name first and then mails
            temp.add(accounts.get(i).get(0));
            for(String it:mergedMail[i]){
                temp.add(it);
            }
            //add the List{name,List<mail>}
            ans.add(temp);
        }
        return ans;
    }
}
