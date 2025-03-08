package Stack;

import java.util.Stack;

public class OnlineStockSpan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {7,2,1,3,3,1,8};
		StockSpanner obj = new StockSpanner();
		for(int a:nums) {
			int ans = obj.next(a);
			System.out.print(ans+" ");
		}

	}
}
class StockSpanner {
    Stack<Pair<Integer,Integer>> st;
    int ind;
    public StockSpanner() {
        st = new Stack<>();
        ind = -1;
    }
    
    public int next(int price) {
        int ans = 0;
        ind++;//each element is less than or equal to itself
        while(!st.isEmpty() && st.peek().first <= price)
            st.pop();
        ans = ind - (st.isEmpty()? -1:st.peek().second);
        st.push(new Pair<Integer, Integer>(price,ind));
        return ans;
    }
    class Pair <K,V>{
        K first;
        V second;
        	Pair(K k,V v){
            this.first = k;
            this.second = v;
        	}
    }
}