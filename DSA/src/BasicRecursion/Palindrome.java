package BasicRecursion;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "A man, a plan, a canal: Panama";
		//remove all the non-alphanumeric character and convert it to lowercase letter and check palindrome
		 if(s.length()==1 && s.contains(" ")) System.out.println("s is palindrome");;
	        s=s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
			boolean ans = checkPalindrome(0,s);
			if(ans)
			System.out.println("s is palindrome");
			else
				System.out.println("s is not palindrome");

	}
	
	private static boolean checkPalindrome(int i,String s) {
		int n = s.length();
		//halfway means all the elements are compared
		if(s.charAt(i)>=n/2)
		return true;
		
		//if start is not equal to end
		if(s.charAt(i)!=s.charAt(n-i-1)) return false;
		
		//call function with new input
		return checkPalindrome(i+1, s);
		}

}
