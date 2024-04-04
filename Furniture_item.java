
import java.util.*;


class Furniture_item
{
    String Item_name;
    List<String> Source_site=new ArrayList<String>();
    int nr_of_searches;

    Furniture_item(){ Item_name="-NO_INPUT-"; nr_of_searches=0;}
    Furniture_item(String init_name,int init_nr){ Item_name=init_name; nr_of_searches=init_nr;}
    Furniture_item(final Furniture_item item_copy){ Item_name=item_copy.Item_name; nr_of_searches=item_copy.nr_of_searches; }

    public boolean set_Item(String[] URL)
    {
        int i=0;
        while(i<URL.length && !URL[i].equals("products")) 
        {
            i++;
        }
        if(i<URL.length-1)
        {
            Source_site.add(URL[2]);
            Item_name=URL[i+1];
            nr_of_searches=1;
            return true;
        }
        return false;
    }

    public String get_Item_name()
    {
        return Item_name;
    }

    public String get_first_Site()
    {
            return Source_site.getFirst();
    }
    public void new_search(final Furniture_item F)
    {
       this.Source_site.add(F.get_first_Site());
       this.nr_of_searches++;
    }

    public void console_display()
    {
        System.out.println("----------------Furniture_Item----------------------");
        System.out.println("Item name: "+Item_name);
        System.out.println("Was found on:");
        Source_site.forEach(System.out::println);
        System.out.println("Was searched "+nr_of_searches+" time(s)");
        System.out.println("----------------------------------------------------");
    }

    @Override
    public String toString()
    {
        String out="----------------Furniture_Item----------------------\n";
        out=out+"Item name: "+Item_name+"\n";
        return out;

    }
   

    

}