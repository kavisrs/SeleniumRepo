package week3.day1;



public class ReverseString {
	
	
	// output should be nozamA
	// convert to charArray
	//iterate through for reverse loop
	//print in the console
	public static void main(String[] args) {
		
		String str = "Amazon";
	
	char[] ca = str.toCharArray();
	//System.out.println(ca[1]);
	System.out.println("Reverse order for Amazon is");
	
	for(int i=ca.length-1;i>=0; i--) {
		System.out.println(ca[i]);
	}
	
}

}