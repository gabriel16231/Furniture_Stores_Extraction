import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) {
        try{
        Scanner get_furniture=new Scanner(new File("furniture stores pages.csv"));
        while(get_furniture.hasNext())
           {
            String aux=get_furniture.nextLine();
            String[] link_split=aux.split("/");
            for(int i=0;i<link_split.length;i++)
            {
                System.out.print(link_split[i]+"->");
            }
            System.out.println(" ");

           }
        get_furniture.close();
        }catch(IOException e){
            System.out.println("ERROR at input");

        }

        

    }
}