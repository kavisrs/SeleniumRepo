package week3.day2;

public class Samsung extends AndroidTV{

	public void playVideo() {
		System.out.println("Play Video");
		
	}

	public static void main(String[] args) {
		Samsung sg = new Samsung();
		sg.openApp();
		sg.playVideo();
	}
}
