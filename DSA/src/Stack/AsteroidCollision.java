package Stack;

import java.util.ArrayList;
import java.util.List;

public class AsteroidCollision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int aster[] = {10,2,-5};
		int ans[] = asteroidCollision(aster);
		for(int i: ans)
			System.out.print(i+" ");

	}
	private static int[] asteroidCollision(int[] asteroids) {
        List<Integer> st = new ArrayList<>();
        int n = asteroids.length;
        //iterate over the array
        for(int i = 0;i < n ;i ++){
            //if array element is +ve push it in list
            if(asteroids[i] > 0)
                st.add(asteroids[i]);
            else{
                //if list is not empty
                while(!st.isEmpty() && st.get(st.size()-1) > 0 && st.get(st.size()-1) < Math.abs(asteroids[i]))
                    st.remove(st.size()-1);
                if(!st.isEmpty() && st.get(st.size()-1) == Math.abs(asteroids[i]))   
                    st.remove(st.size()-1);
                else if(st.isEmpty() || st.get(st.size()-1) < 0)
                    st.add(asteroids[i]);
            }
        }int a[] = st.stream().mapToInt(Integer::intValue).toArray();
        return a;
    }
}
