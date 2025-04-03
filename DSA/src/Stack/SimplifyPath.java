package Stack;

import java.util.Stack;

public class SimplifyPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "/../";
		System.out.println("The simplified path will be : "+simplifyPath(path));

	}
    private static String simplifyPath(String path) {
        int n = path.length();
        Stack<String> st = new Stack<>();
        //separate on the basis of "/"
        String[] directories = path.split("/");
        //iterate over the array
        for(String dir : directories){
            //if . or empty string continue
            if(dir.equals(".") || dir.isEmpty())
                continue;
            else if(dir.equals("..")){//pop for ".."
                if(!st.isEmpty())
                    st.pop();
            }else st.push(dir);//push for others
        }
        return "/"+ String.join("/",st);//join st string with "/"
    }
}
