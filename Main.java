import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) {

        Furniture_Data Data=new Furniture_Data();

        try{
        Scanner get_furniture=new Scanner(new File("furniture stores pages.csv"));
        while(get_furniture.hasNext())
           {
            String aux=get_furniture.nextLine();
            Data.add_Furiniture_item_by_URL(aux);
           }
        get_furniture.close();
        }catch(IOException e){
            System.err.println("ERROR at input");
        }
        Data.store_Data();
        Data.console_display_Furniture();
        Data.get_Data();
        Data.console_display_Furniture();
    }
}