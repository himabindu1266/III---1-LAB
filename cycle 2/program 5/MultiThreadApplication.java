import java.util.*;
import java.io.*;

class Thd1 extends Thread
{
     private PipedWriter out1;
     private PipedWriter out2;
    
     Thd1(ThdEven teven, ThdOdd todd)
     {  
          try
          {
              out1 = new PipedWriter(teven.getPipedReader());
              out2 = new PipedWriter(todd.getPipedReader());
          }
          catch(Exception e)
          {
              System.out.println("err"+e);
          }
     }
    
     public void run()
     {
          Thread t = Thread.currentThread();
          t.setName("Thd1");
          System.out.println(t.getName() + " thread started");

             
          int i=1;
          int RN;
          while(true)
          {
               try
         {
                   if(i>5)
                   {
                        out1.close();
                        out2.close();
                        break;
                   }
                  
               RN = (int)(Math.random()*10) + 1;
                  
               out1.write(RN);
                   out2.write(RN);

              t.sleep(100);
        }
            catch(Exception e)
               {
              System.out.println("Thd1:"+e);
               }
              i++;
    }
    }
}

class ThdEven extends Thread
{
     PipedReader r1 = new PipedReader();
    
     public PipedReader getPipedReader()
     {
          return r1;
     }
    
     public void run()
     {
          Thread t = Thread.currentThread();
          t.setName("TE");
          System.out.println(t.getName() + " thread started");
 
          try
          {
              while(true)
              {
                   int rn = r1.read();
                   if(rn==-1)
                        break;
    
                   if(rn%2==0)
                   {  
                        System.out.println(t.getName()+" - even number "+rn+" - square = "+(rn*rn));
                   }
                   t.sleep(500);
              }
          }
          catch(Exception e)
          {
              System.out.println("ThdEven:"+e);
          }
    System.out.println(t.getName() + " thread exiting");
    }
}

class ThdOdd extends Thread
{
     PipedReader r2 = new PipedReader();
    
     public PipedReader getPipedReader()
     {
          return r2;
     }
    
     public void run()
     {
          Thread t = Thread.currentThread();
          t.setName("TO");
          System.out.println(t.getName() + " thread started");
 
          try
          {
              while(true)
              {
                   int rn=r2.read();
                  
                   if(rn==-1)
                        break;
         
                   if(rn%2==1)
                   {
                        System.out.println(t.getName()+" - odd number "+rn+" - cube = "+(rn*rn*rn));
                   }
                   t.sleep(500);
              }
          }
          catch(Exception e)
          {
              System.out.println("ThdOdd:"+e);
          }
    System.out.println(t.getName() + " thread exiting");
    }
}

public class MultiThreadApplication
{
     public static void main(String[] args) throws Exception
    {
    Thread t=Thread.currentThread();
    t.setName("Main");
    System.out.println(t.getName() + " thread Started...");          
    
          ThdEven TE = new ThdEven();
          ThdOdd TO = new ThdOdd();
                  
          Thd1 t1 = new Thd1(TE, TO);
             
          TE.start();
          TO.start();
          t1.start();
                            
          try
          {
              t.sleep(5000);
          }
          catch(Exception e)
          {}
    System.out.println(t.getName() + " thread exiting");
    }
}