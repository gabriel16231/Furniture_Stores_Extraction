class Furniture_item
{
    String Item_name;
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
            Item_name=URL[i+1];
            nr_of_searches++;
            return true;
        }
        return false;
    }

    public String get_Item_name()
    {
        return Item_name;
    }
}