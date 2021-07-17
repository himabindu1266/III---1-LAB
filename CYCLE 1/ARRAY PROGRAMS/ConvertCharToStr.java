public class ConvertCharToStr {
  
    
    public static String toString(char[] a)
    {
        String string = new String(a);
        return string;
    }
  
   
    public static void main(String args[])
    {
  
        
        char s[] = { 'm', 'y', 's', 'e','l','f'};
  
        
        System.out.println(toString(s));
    }
}