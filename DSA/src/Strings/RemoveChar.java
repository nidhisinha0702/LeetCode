package Strings;

public class RemoveChar {

	private static void skip(String p, String up) {
		if(up.isEmpty()) {
			System.out.println(p);
			return;
		}
		
		char ch = up.charAt(0);
		
		if(ch == 'a') {
			skip(p, up.substring(1));
		}
		else
			skip(p+ch, up.substring(1));
	}
	
	private static String skip1(String up) {
		if(up.isEmpty()) {
			return "";
		}
		
		char ch = up.charAt(0);
		
		if(ch == 'a') {
			return skip1(up.substring(1));
		}
		else {
			return ch + skip1(up.substring(1));
		}
	}
	
	private static String skipApple(String up) {
		if(up.isEmpty()) {
			return "";
		}
		
		
		if(up.startsWith("apple")) {
			return skipApple(up.substring(5));
		}
		else {
			return up.charAt(0) + skipApple(up.substring(1));
		}
	}
	
	private static String skipAppNotApple(String up) {
		if(up.isEmpty()) {
			return "";
		}
		
		
		if(up.startsWith("app") && !up.startsWith("apple")) {
			return skipAppNotApple(up.substring(3));
		}
		else {
			return up.charAt(0) + skipAppNotApple(up.substring(1));
		}
	}
	
	public static void main(String[] args) {
		// WAP to remove all the 'a' from string
		//skip("", "baccadah");
		String p = skip1("baccadah");
		System.out.println(p);
		System.out.println("skip apple : "+skipApple("bdapplefg"));
		System.out.println("skip app: "+skipAppNotApple("bdapplefg"));
		System.out.println("skip app: "+skipAppNotApple("bdappfg"));
	}

}
