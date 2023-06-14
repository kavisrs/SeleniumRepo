//Assignment 1  Abstraction
//===========
//Interface :Language
//     Methods   :Java()
//     Interface :TestTool
//     Methods   :Selenium()
//     AbstractClass :MultipleLangauge
//     Methods   :python() and un implemented method as ruby()
//  Execution class: Automation 
//Implement all the methods of interface and abstract class in Automation class
package week3.day2;
public class Automation extends MultipleLanguage implements Language,TestTool {

	public void selenium() {
		System.out.println("Selenium from interface - TestTool");
		
	}

	public void Java() {
		System.out.println("Java from interface - Language");
		
	}

	@Override
	public void ruby() {
		System.out.println("Ruby from abstract Unimplemented method called in Automation concrete class");
		
	}

	public static void main(String[] args) {
		Automation auto = new Automation();
		auto.Java();
		auto.selenium();
		auto.python();
		auto.ruby();
	}	
}
