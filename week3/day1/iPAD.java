package week3.day1;

public class iPAD extends iOS {

	public void watchMovie() {
		System.out.println("Watch Movie");}
	
	
	//overriding from iOS - dynamic polymorphism
	public void startApp() {
		System.out.println("Start the app for IPAD");

}

	
	public static void main(String[] args) {
		
		iPAD ip = new iPAD();
		ip.watchMovie();
		ip.startApp();
		ip.increaseVolume();
		ip.shutdown();
		
	}
}
