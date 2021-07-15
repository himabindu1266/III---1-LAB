import java.util.Scanner;
public class GradeCalculation
{
	public static void main(String args[]){
		int markArr[] = new int[5];
		int i;
		float total=0, avg;
		Scanner scanner = new Scanner(System.in);
 
		System.out.print("Enter Marks for 5 Subjects : ");
		for(i=0; i < 5; i++){ 
			markArr[i] = scanner.nextInt(); 
			total = total + markArr[i]; 
		} 
 
		avg = total/5; 
		System.out.print("Student's Grade is "); 
		if(avg > 80){
			System.out.print("A");
		}else if(avg > 60 && avg<=80){ 
			System.out.print("B"); }
		else if(avg > 40 && avg <= 60){
			System.out.print("C");
		} else{
			System.out.print("D");
		}
		scanner.close();
	}
}