import java.util.Scanner;

public class circleareacircum
{
    public static void main(String args[])
    {
        float r;
        double area, cir;
        Scanner scan = new Scanner(System.in);
		
        System.out.print("Enter Radius of Circle : ");
        r = scan.nextFloat();
		
        area = 3.14*r*r;
        cir = 2*3.14*r;
		
        System.out.print("Area of Circle = " +area);
		
        System.out.print("\nCircumference of Circle = " +cir);
    }
}