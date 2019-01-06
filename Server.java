import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.*;
 
public class Server extends Thread
{
   private ServerSocket serverSocket;
  ArrayList<Data> List_Item =new ArrayList<Data>();
   
   public void write_list(ArrayList<Data> input_list){
      
      for(Data i: input_list){
         String nametemp=i.getname();
         int idtemp=i.getid();
         boolean booltemp=i.getbool();
         List_Item.add(new Data(idtemp,nametemp,booltemp));
      }
      System.out.println("Tuple has been added");
   }

  
     
   public Server(int port) throws IOException
   {
      serverSocket = new ServerSocket(port);
      //serverSocket.setSoTimeout(20000);//20 seconds
   }
 
   public void run() 
   {
      while(true)
      {
         try
         {
            //Server connection Stufff and other data.
            System.out.println("Server: Waiting for client on port " + serverSocket.getLocalPort() + "...");
            Socket server = serverSocket.accept();
            System.out.println("Server: Just connected to " + server.getRemoteSocketAddress());
            DataOutputStream out = new DataOutputStream(server.getOutputStream());
            InputStream inFromServer = server.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            ObjectInputStream objectIn = new ObjectInputStream(inFromServer);
            //temp = (ArrayList<Data>) objectIn.readObject();
            int num = (int)objectIn.readObject();
            // System.out.println(num);
            switch(num){
               case 1: //read
                  int selector = (int)objectIn.readObject();
                  switch(selector){
                     case 1:
                        String string_temp = (String)objectIn.readObject();
                        for(Data i: List_Item){
                           if((string_temp.compareTo(i.getname()))==0&&(i.getid()>0)){
                              System.out.println("< "+i.getname()+","+i.getid()+","+i.getbool()+" >");
                           }
                        }
						
                     break;
                     case 2:
                      int int_temp = (int)objectIn.readObject();
                        for(Data i: List_Item){
                           if(int_temp==i.getid()&&int_temp>0){
                              System.out.println("< "+i.getname()+","+i.getid()+","+i.getbool()+" >");
                           }
						   
                        }
                     break;

                     case 3:
                     boolean bool_temp = (boolean)objectIn.readObject();
                      //System.out.println(bool_temp);
                     for(Data i: List_Item){
                           if(bool_temp==i.getbool()&&(i.getid()>0)){
                              System.out.println("< "+i.getname()+","+i.getid()+","+i.getbool()+" >");
                           }
						   
                        }
                     break;
                  }
               break;
               case 2:
                  ArrayList<Data> temp = (ArrayList<Data>) objectIn.readObject();
                  write_list(temp);
               break;

               case 3:
                  int selector3 = (int)objectIn.readObject();
                  switch(selector3){
                     case 1:
                        String string_temp = (String)objectIn.readObject();
                        // for(Data i: List_Item){
                        //    if((string_temp.compareTo(i.getname()))==0){
                        //       System.out.println("< "+i.getname()+","+i.getid()+","+i.getbool()+" >");
                        //       i.setid(-1);
                        //       i.setname("NULL");
                        //       i.setbool(false);
                              
                        //    }
                        // }
						int x=0;
							for(int i=0;i<List_Item.size();i++){
								Data d = List_Item.get(i);
								if(string_temp.compareTo(d.name)==0){
									System.out.println(d.toString());
									List_Item.remove(i);
									x=1;
								}  
							}
						if(x==0){
							System.out.println("Not Found! Try Again");
						}
								
								
				
                        
                     break;
                     case 2:
                        int int_temp = (int)objectIn.readObject();
                        for(int i=0;i<List_Item.size();i++){
                           Data d = List_Item.get(i);
                           if(int_temp==(d.id)){
                              List_Item.remove(i);

                           }
						   
                        }
                     break;
                     case 3:
                        boolean bool_temp = (boolean)objectIn.readObject();
                        for(int i=0;i<List_Item.size();i++){
                           Data d = List_Item.get(i);
                           if(bool_temp==(d.bool)){
                              List_Item.remove(i);

                           }
						  
                        }
                     break;
                  }
               break;

               case 4:

               int selector4 = (int)objectIn.readObject();
               switch(selector4){
                  case 1:
                  String findstring4 = (String)objectIn.readObject();
                  for(Data i: List_Item){
                     if((findstring4.compareTo(i.getname()))==0){
                        System.out.println("< "+i.getname()+","+i.getid()+","+i.getbool()+" >");
                        i.setname((String) objectIn.readObject());
                        i.setid((int) objectIn.readObject());
                        i.setbool((boolean) objectIn.readObject());
                        System.out.println("< "+i.getname()+","+i.getid()+","+i.getbool()+" >");
                              
                     }
					
                  }

                  break;
                  case 2:
                  int findInt4 = (int)objectIn.readObject();
                  for(Data i: List_Item){
                     if(findInt4==i.getid()){
                        System.out.println("< "+i.getname()+","+i.getid()+","+i.getbool()+" >");
                        i.setname((String) objectIn.readObject());
                        i.setid((int) objectIn.readObject());
                        i.setbool((boolean) objectIn.readObject());
                        System.out.println("< "+i.getname()+","+i.getid()+","+i.getbool()+" >");
                              
                     }
                  }

                  break;

               }



               break;



            }
            server.close();
         }catch(SocketTimeoutException s)
         {
            System.out.println("Server: Socket timed out!");
            break;
         }catch(IOException e)
         {
            e.printStackTrace();
            break;
       
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
   }


   public static void main(String [] args)
   {
      int port = Integer.parseInt("9003");
      try
      {
         Thread t = new Server(port);
         t.start();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}