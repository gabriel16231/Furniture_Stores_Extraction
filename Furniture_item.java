
import java.io.*;
import java.util.*;

class Furniture_item {
    String Item_name;
    List<String> Source_site = new ArrayList<String>();
    int nr_of_searches;

    Furniture_item() {
        Item_name = "-NO_INPUT-";
        nr_of_searches = 0;
    }

    Furniture_item(String init_name, int init_nr) {
        Item_name = init_name;
        nr_of_searches = init_nr;
    }

    Furniture_item(final Furniture_item item_copy) {
        Item_name = item_copy.Item_name;
        nr_of_searches = item_copy.nr_of_searches;
    }

    public boolean set_Item(String[] URL) {
        int i = 0;
        while (i < URL.length && !URL[i].equals("products")) {
            i++;
        }
        while (i < URL.length && (URL[i].equals("page") || URL[i].equals("gift-card") || URL[i].equals("products")))
            i++;
        if (i < URL.length) {
            Source_site.add(URL[2]);
            Item_name = URL[i];
            nr_of_searches = 1;
            return true;
        }
        return false;
    }

    public String get_Item_name() {
        return Item_name;
    }

    public String get_first_Site() {
        return Source_site.getFirst();
    }

    public int get_nr_of_searches() {
        return nr_of_searches;
    }

    public void new_search(final Furniture_item F) {
        this.Source_site.add(F.get_first_Site());
        this.nr_of_searches++;
    }

    public void console_display() {
        System.out.println("----------------Furniture_Item----------------------");
        System.out.println("Item name: " + Item_name);
        System.out.println("Was found on:");
        Source_site.forEach(System.out::println);
        System.out.println("Was searched " + nr_of_searches + " time(s)");
        System.out.println("----------------------------------------------------");
    }

    public void store_Item(FileWriter output) {
        try {
            output.write(Item_name + "\n");
            output.write(nr_of_searches + "\n");
            for (int i = 0; i < Source_site.size(); i++) {
                output.write(Source_site.get(i) + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error at storing item");
        }
    }

    public void get_Item(File input) {
        try {
            Scanner get_item = new Scanner(input);
            Item_name = get_item.nextLine();
            nr_of_searches = Integer.valueOf(get_item.nextLine());
            for (int i = 0; i < nr_of_searches; i++)
                Source_site.add(get_item.nextLine());
            get_item.close();
        } catch (IOException e) {
            System.err.println("Error at getting data from file: " + input.getName());
        }
    }

}