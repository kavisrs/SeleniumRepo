package org.system;

public class Desktop extends Computer {
	public void desktopsize() {
		System.out.println("Desktop size is 13 inches");

	}
	public static void main(String[] args) {
		Desktop dp = new Desktop();
		dp.computerModel();
		dp.desktopsize();
	}
}

