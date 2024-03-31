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
        try{
        Scanner get_furniture=new Scanner(new File("furniture stores pages.csv"));
        while(get_furniture.hasNext())
           {
            String aux=get_furniture.nextLine();
            String[] link_split=aux.split("/");
            if(check_URL(aux,link_split)==true)
            {
                Furniture_item new_item=new Furniture_item();
                if( new_item.set_Item(link_split))
                {
                    System.out.println(new_item.get_Item_name());
                }
                
            }
            

           }
        get_furniture.close();
        }catch(IOException e){
            System.out.println("ERROR at input");
        }

        

    }
}