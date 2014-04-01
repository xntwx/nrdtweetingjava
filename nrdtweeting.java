/* author: nur tri wibowo (nordskriving.wordpress.com - github.com/xntwx)
 * 
 * nrdtweeting.java
 * ----------------
 * Simple code for tweeting written in java.
 * 
*/

//import library
import java.io.*;
import java.util.Scanner;

import twitter4j.*;
import twitter4j.auth.AccessToken;

public class nrdtweeting{
  
  public static void main(String[] args){
    //the key enter yours.
    
    //api key
    String aKey = "xxxx";
    //api secret
    String aSecret = "xxxx";
    //access token
    String aToken = "xxx-xxxx";
    //access token secret
    String aTokenSecret = "xxxx";
    
    //inisialisasi
    TwitterFactory twitFactory = new TwitterFactory();
    Twitter twit = twitFactory.getSingleton();
    
    //setup oauth
    twit.setOAuthConsumer(aKey,aSecret);
    twit.setOAuthAccessToken(new AccessToken(aToken,aTokenSecret));
    
    //---------------------//
    
    int menu;
    int choice;
    choice = 0;
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner input = new Scanner(System.in);
    
    //menu
    System.out.println(" 1. Update Status");
    System.out.println(" 2. Send DM");
    System.out.println(" 3. Exit");
    System.out.print(" Enter your choice: ");
    menu = input.nextInt();
    
    while(menu != 3){
      switch(menu){
        case 1:
          try{
            System.out.println("");
            System.out.print(" Update status: ");
            String stat = br.readLine();
            try{              
               Status status = twit.updateStatus(stat + " [via @nordskriving's app]");
             }catch(TwitterException e){
               System.out.println(e);
             }
          }catch(IOException e){
            System.out.println(e);
          }
          break;
        //menu 2
        case 2:
          try{
            System.out.println("");
            System.out.print(" To: ");
            String forwho = br.readLine();
            System.out.print(" Msg: ");
            String msg = br.readLine();
            try{
              DirectMessage dm = twit.sendDirectMessage(forwho,msg + "[via @nordskriving's app]");
            }catch(TwitterException e){
              System.out.println(e);
            }
          }catch(IOException e){
            System.out.println(e);
          }
      }
      System.out.println("");
      System.out.println(" 1. Update Status");
      System.out.println(" 2. Send DM");
      System.out.println(" 3. Exit");
      System.out.print(" Enter your choice: ");
      menu = input.nextInt();
    }
    //exit
    System.out.println("");
    System.out.println("nordskriving.wordpress.com");
  }
}
          
