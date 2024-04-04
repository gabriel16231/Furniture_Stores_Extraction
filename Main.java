import java.util.*;
import java.io.*;

public class Main{


    

    public static boolean check_URL(String URL,String[] URL_split)
    {
        if(URL.charAt(0)!='h')
        {
            System.out.println("ERROR:Invalid Protocol (URL will be ignored)");
            return false;
        }
        int protocol_length=URL_split[0].length();
        if(URL.charAt(protocol_length-1)!=':')
        {
            System.out.println("ERROR: Missing \":\" after Protocol (URL will be ignored)");
            return false;
        }
        if(URL.charAt(protocol_length)!='/'&&URL.charAt(protocol_length+1)!='/')
        {
            System.out.println("ERROR: Missing \"//\" after Protocol (URL will be ignored)");
            return false;
        }
        return true;
    }
    public static void main(String[] args) {

        Map<String,Furniture_item> Furniture=new HashMap<String,Furniture_item>();


        try{
        Scanner get_furniture=new Scanner(new File("furniture stores pages.csv"));
        while(get_furniture.hasNext())
           {
            String aux=get_furniture.nextLine();
            String[] link_split=aux.split("/");
            if(check_URL(aux,link_split)==true)
            {
                Furniture_item new_item=new Furniture_item();
                if( new_item.set_Item(link_split))//checks if we can extract a furniture item and stors the data in an auxilary object
                {
                   if(Furniture.containsKey(new_item.get_Item_name()))
                   {
                    Furniture.get(new_item.get_Item_name()).new_search(new_item);
                    new_item.console_display();
                   }
                   else
                    {
                    Furniture.put(new_item.get_Item_name(),new_item);
                    }
                }
                
                
            }
            

           }
        get_furniture.close();
        }catch(IOException e){
            System.out.println("ERROR at input");
        }

        

    }
}