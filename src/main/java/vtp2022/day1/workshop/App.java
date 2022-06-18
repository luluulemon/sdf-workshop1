package vtp2022.day1.workshop;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        String dbName = " ";
        // create shoppingCart directory 
        if (args.length == 0) dbName = "db";
        else dbName = args[0];
        shoppingCartDB.startSession(dbName);

        System.out.println( "Welcum!" );
        cart.start(dbName);
    }
}
