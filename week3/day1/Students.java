package week3.day1;


//Create multiple getStudentInfo() method by passing id argument alone, by id & name, by email & phoneNumber

public class Students {

	public void getStudentInfo(int a) {
		System.out.println(a);
	}
	
	public void getStudnetInfo(int e ,String b) {
		System.out.println("student Id: " +e+ "  Student Name: " +b);
		

	}	
	
	public void getStudnetInfo(String c, double d) {
		System.out.println("Email ID: " +c + "  Phone Number:  " +d);
	}
	
	public static void main(String[] args) {
		Students si = new Students();	
		si.getStudentInfo(122);
		si.getStudnetInfo(122, "Kavitha");
		si.getStudnetInfo("abc@yahoo.com", 1234567890);
		
	}
}

