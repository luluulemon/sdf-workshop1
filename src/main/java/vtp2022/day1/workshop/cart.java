package vtp2022.day1.workshop;

import java.io.Console;
import java.util.LinkedList;
import java.util.List;

// allows user to add, list, delete shopping cart

public class cart {
    
    public cart(){ ;}

    public static void start(String db){
        Console cons = System.console();
        String input;
        String cmd;

        List<String> shoppingCart = new LinkedList<>();
        boolean stop = false;
        String user = null;

        while(!stop){
            
            input = cons.readLine("Enter cmd item\n(login/add/del/list/save/end) > ");
            String[] items = input.split(" ");
            cmd = input.split(" ")[0];
            
            switch(cmd.toLowerCase()){
                case "login":
                    // look inside directory, find user file (all names to Lowercase)
                    user = items[1].toLowerCase();
                    shoppingCart = shoppingCartDB.loadDB(user, db);
                    break;
                
                case "add":
                    for(int i=1; i<items.length; i++){
                        if (shoppingCart.contains(items[i].toLowerCase()) ) 
                            continue;
                        
                        shoppingCart.add(items[i].toLowerCase());
                        System.out.printf("added %s to cart\n", items[i]);
                    }
                    break;
                case "list":
                    if(shoppingCart.size() == 0) System.out.println("Your cart is empty la");
                    for(int i=0; i < shoppingCart.size(); i++){
                        System.out.printf("%d: %s\n", i+1, shoppingCart.get(i));    }
                    
                    break;
                case "del":
                    int delete_idx = Integer.parseInt(input.split(" ")[1]) ;
                    if ( delete_idx > shoppingCart.size() || delete_idx < 1) 
                        System.out.println("Incorrect item index");
                    else{
                    System.out.printf("removed item %s from Cart\n", 
                        shoppingCart.get(delete_idx -1));
                        shoppingCart.remove(delete_idx - 1);    }
                    
                    break;
                case "save":
                    if (user == null)
                        System.out.println("Need to login 1st ser.");
                    else 
                        shoppingCartDB.saveDB(user, db, shoppingCart);
                    break;              
                case "users":
                    shoppingCartDB.listUsers(db);

                    break;

                case "end":
                    stop = true;
                    break;

                default:
                    System.out.println("Invalid cmd!");

            }

        }
        System.out.println("Thank you for shopping with us ser");
    }
}
