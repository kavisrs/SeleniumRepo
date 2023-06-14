package week3.day1;

//Class     :BankInfo
//Methods :saving(),fixed(),deposit()
//
// Class     :AxisBank
// Methods :deposit()
//
//Description:
//You have to override the method deposit in AxisBank.



public class AxisBank extends BankInfo{
	
	@Override
	public void deposit() {
		System.out.println("Deposit tenure is 5 years");
	}
	
	public static void main(String[] args) {
		AxisBank ab = new AxisBank();
		ab.saving();
		ab.fixed();
		ab.deposit();
	}

}
