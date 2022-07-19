package loops;

public class CountNumbers {

	public static void main(String[] args) {
		int num=6234567;
		int count=0;
		
		while(num!=0)
		{
			int rem=num%10;//5 
			System.out.println("rem is.."+rem);
			count++;
			 num=num/10;
			 System.out.println("quotint is.."+num);
				
		}
		System.out.println("count is.."+count);
		
		
		
	}

}
