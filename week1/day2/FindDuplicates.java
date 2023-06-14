package week1.day2;

public class FindDuplicates {

	public static void main(String[] args) {
		int nums[] = {2,5,7,7,5,9,2,3};
		//		int len = nums.length;
		for (int i=0;i<nums.length;i++)
		{
			for (int j=i+1;j<nums.length;j++)
			{

				if(nums[i]==nums[j]) {
					
				System.out.println("Duplicate Numbers : " +nums[i]);
				}
			}


		}

	}

} 
