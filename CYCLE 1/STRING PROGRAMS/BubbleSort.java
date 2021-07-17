public class BubbleSort {
   public static void main(String []args) {
	String str[] = { "Hp", "Dell", "Lenovo", "Acer"};
	String temp;
	System.out.println("sorted order is:" + "\n");
	for (int j = 0; j < str.length; j++) {
   	   for (int i = j + 1; i < str.length; i++) {
		
		if (str[i].compareTo(str[j]) < 0) {
			temp = str[j];
			str[j] = str[i];
			str[i] = temp;
		}
	   }
	   System.out.println(str[j] + "\n");
	}
   }
}