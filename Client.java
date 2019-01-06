import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
 
public class Client
{
   public static void main(String [] args)
   {
      String serverName = "localhost";
      String svalue = null;
      int ivalue =0,bvalue =0;
      boolean bool = false;
      int port = Integer.parseInt("9003");
      try
      {
         System.out.println("Client: Connecting to " + serverName + " on port " + port);
         Socket client = new Socket(serverName, port);
         System.out.println("Client: Just connected to " + client.getRemoteSocketAddress());
          
         ObjectOutputStream objectOut = new ObjectOutputStream(client.getOutputStream());
        
         
         
         System.out.println(" 1. Read \n 2. Write \n 3. Take \n 4. Update \n");
         Scanner scan = new Scanner(System.in);
         int num = scan.nextInt();
         switch(num)
         {
         case 1: //Read
            objectOut.writeObject(num);
         	System.out.println("Read");
            System.out.println("Enter a 1.String\n2.Integer\n3.Boolean\n");
            int select = scan.nextInt();
            objectOut.writeObject(select);
            switch(select){
               case 1:
               System.out.println("Enter String value");
               String findstring = scan.next();
               objectOut.writeObject(findstring);
               break;
               case 2:
               System.out.println("Enter Integer value");
               int findInt = scan.nextInt();
               objectOut.writeObject(findInt);
               break;
               case 3:
               System.out.println("Enter 1 for True and 0 for False");
               int findbool = scan.nextInt();
               boolean bool_value;
               if(findbool == 1){
                  bool_value = true;
               }else{
                  bool_value = false;
               }
               //System.out.println(bool_value);
               objectOut.writeObject(bool_value);
               break;

            }
         break;
         case 2: //Write
            objectOut.writeObject(num);
         	for(int i=0;i<3;i++)
         	{
         		System.out.println("1. Integer 2. String 3. boolean");
         		int n = scan.nextInt();
         		switch(n)
         		{
         		case 1:
         			System.out.println("Enter Integer value");
         			ivalue = scan.nextInt();
         			break;
         		case 2:
         			System.out.println("Enter String value");
         			svalue = scan.next();
         			break;
         		case 3:
         			System.out.println("Enter 1 for True and 0 for False");
         			bvalue = scan.nextInt();
         				if(bvalue == 1)
         				{
         					bool = true;
         				}
         				else if(bvalue == 0)
         				{
         					bool = false;
         				}
         				else
         				{
         					System.out.println("Invalid command");
         				}
         			break;
         		default : 
         		      System.out.println("Incorrect value. Try again");
         		}
         		
         	}
            ArrayList<Data> list = new ArrayList<Data>();
            list.add(new Data(ivalue, svalue, bool));
         	// for (int i = 0; i < list.size(); i++) 
          //   { 
          //      Data data = list.get(i); 
          //      System.out.println(data.toString());
          //   } 
            objectOut.writeObject(list);
         	break;
         case 3: //Take
            objectOut.writeObject(num);
         	System.out.println("Take");
            System.out.println("Enter a 1.String\n2.Integer\n3.Boolean\n");
            int select3 = scan.nextInt();
            objectOut.writeObject(select3);
            switch(select3){
               case 1:
               System.out.println("Enter String value");
               String findstring = scan.next();
               objectOut.writeObject(findstring);
               break;

               case 2:
               System.out.println("Enter Integer value");
               int findInt = scan.nextInt();
               objectOut.writeObject(findInt);
               break;
               case 3:
               System.out.println("Enter 1 for True and 0 for False");
               int findbool = scan.nextInt();
               boolean bool_value;
               if(findbool == 1){
                  bool_value = true;
               }else{
                  bool_value = false;
               }
               //System.out.println(bool_value);
               objectOut.writeObject(bool_value);
               break;
            }

         	break;
         case 4: //Update
            objectOut.writeObject(num);
            System.out.println("Update");
            System.out.println("Enter a 1.String\n2.Integer\n3.Boolean\n");
            int select4 = scan.nextInt();
            objectOut.writeObject(select4);
            switch(select4){
               case 1:
               System.out.println("Enter String value");
               String findstring4 = scan.next();
               objectOut.writeObject(findstring4);
               System.out.println("Enter updated String, Integer, True/False\n");
               System.out.println("Enter updated String value");
               String tempname4 = scan.next();
               System.out.println("Enter updated Integer value");
               int tempid4 = scan.nextInt();
               System.out.println("Enter 1 for True and 0 for False");
               int findbool4 = scan.nextInt();
               boolean bool_value4;
               if(findbool4 == 1){
                  bool_value4 = true;
               }else{
                  bool_value4 = false;
               }
               objectOut.writeObject(tempname4);
               objectOut.writeObject(tempid4);
               objectOut.writeObject(bool_value4);

               break;

               case 2:
               System.out.println("Enter Integer value");
               int findInt5 = scan.nextInt();
               objectOut.writeObject(findInt5);
               System.out.println("Enter updated String, Integer, True/False\n");
               System.out.println("Enter updated String value");
               String tempname5 = scan.next();
               System.out.println("Enter updated Integer value");
               int tempid5 = scan.nextInt();
               System.out.println("Enter 1 for True and 0 for False");
               int findbool5 = scan.nextInt();
               boolean bool_value5;
               if(findbool5 == 1){
                  bool_value5 = true;
               }else{
                  bool_value5 = false;
               }
               objectOut.writeObject(tempname5);
               objectOut.writeObject(tempid5);
               objectOut.writeObject(bool_value5);

               break;


            }

         	break;
         default:
         	System.out.println("Invalid number. Try again");
         }
         
          
         
          
         client.close();
          
      }catch(Exception e)
      {
         e.printStackTrace();
         System.out.println(e);
      }
   }
}