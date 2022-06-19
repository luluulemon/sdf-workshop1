package vtp2022.day1.workshop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
// import java.util.Scanner;        try using scanner later
import java.util.List;

public class shoppingCartDB {
    
    public static void startSession(String db){
        Path path = Paths.get(db);
        if (!Files.exists(path)){
            try {Files.createDirectory(path); }
            catch(IOException e){ e.printStackTrace();; }    
        }
    }


    public static LinkedList<String> loadDB(String user, String db){
        LinkedList<String> shoppingCart = new LinkedList<>();
        Path path = Paths.get(db);

        for(File f: path.toFile().listFiles() ){
            if(f.getName().equals(user)){
                System.out.printf("Loading %s's list\n", user);
                // load up shoppingCart
                try { 
                    Reader reader = new FileReader(f); 
                    BufferedReader br = new BufferedReader(reader);
                    String input;
                    while ((input= br.readLine()) != null)
                    {    shoppingCart.add(input);    }
                    br.close();
                    return shoppingCart;
                    }
                catch (FileNotFoundException e){ e.printStackTrace();}
                catch (IOException e){ e.printStackTrace(); }
            }
        }
        return shoppingCart;    // returns empty Cart for new user     
    }


    public static void saveDB(String username, String db, List<String> shoppingCart){
        
        String fileName = db + "/" + username;
        Path userFile = Paths.get(fileName);

        if (userFile.toFile().exists()){ userFile.toFile().delete(); }  // delete old file first;

        try {
        Files.createFile(userFile);
        Files.write(userFile, shoppingCart);
        System.out.println("Ur shopping cart has been saved");    }
        catch (IOException e) { e.printStackTrace();}
        
        }
    

    public static void listUsers(String db){
        Path path = Paths.get(db);
        if (path.toFile().listFiles().length == 0)
            System.out.println("No users saved in directory yet");
        for(File f: path.toFile().listFiles() )
        {   System.out.println(f.getName());          }
    }

}
