import java.util.*;
import java.io.*;

class Furniture_Data {
    static int nr_of_F_items;
    Map<String,Furniture_item> Furniture;
    Furniture_Data(){Furniture=new HashMap<String,Furniture_item>(); nr_of_F_items=0;}
    Furniture_Data(Map<String,Furniture_item> F_data){Furniture=F_data; };

    public void add_F_data(Map<String,Furniture_item> F_data){Furniture=F_data;};

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
    
    public void add_Furiniture_item_by_URL(String URL)
    {
        String[] URL_split=URL.split("/");
        if(check_URL(URL,URL_split)==true)
            {
                Furniture_item new_item=new Furniture_item();
                if( new_item.set_Item(URL_split))//checks if we can extract a furniture item and stors the data in an auxilary object
                {
                   if(Furniture.containsKey(new_item.get_Item_name()))
                   {
                    Furniture.get(new_item.get_Item_name()).new_search(new_item);
                   }
                   else
                    {
                    Furniture.put(new_item.get_Item_name(),new_item);
                    }
                }
                
                
            }
    }

    public void console_display_Furniture()
    {
        System.out.println(nr_of_F_items+"furniture items were found->");
        int it=0;
        for(Map.Entry<String,Furniture_item> entry: Furniture.entrySet())
        {
            it++;
            if(entry.getValue().get_nr_of_searches()>1)
            {
                System.out.println("Item nr. "+it);
            entry.getValue().console_display();
            }
        }
    }

    void add_to_file(FileWriter output)
    {
        for(Map.Entry<String,Furniture_item> entry: Furniture.entrySet())
        {
            entry.getValue().store_Item(output);
        }
    }
    public void store_Data()
    {
        try{
            File file_store=new File("Furniture_Data.txt");
            if(file_store.createNewFile())
            {
                System.out.println(file_store.getName()+"was created successfuly");
            }
            else
            {
                System.err.println("File already exists!");
            }

            FileWriter file_store_write =new FileWriter("Furniture_Data.txt");
            add_to_file(file_store_write);
            file_store_write.close();

        }catch(IOException e)
        {
            System.err.println("Error at creating and/or storing in file");
        }

        

    }

    public void get_Data()
    {
            File file_get=new File("Furniture_Data.txt");
            for(Map.Entry<String,Furniture_item> entry: Furniture.entrySet())
            {
            entry.getValue().get_Item(file_get);
            }

        

    }



    
}
