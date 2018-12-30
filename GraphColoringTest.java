/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication19;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author acer
 */
public class GraphColoringTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s="A B H\n"
                + "B A D\n"
                + "C D\n"
                + "D B C I K\n"
                + "E K F\n"
                + "F G E\n"
               +"G H K F\n"
                + "H A I J K G\n"
                + "I H J D\n"
                + "J H I K\n"
                +"K D J H G E\n";
      
    String[] renkler;   
    renkler = new String[10];
    renkler[0]="Red";
    renkler[1]="Yellow";
    renkler[2]="White";
    renkler[3]="Green";
    renkler[4]="Black";
    renkler[5]="Purple";
    renkler[6]="Blue";
    renkler[7]="Brown";
    renkler[8]="Pink";
    renkler[9]="Purple";
            
                
                                      
                                        
                        
          List<String> ac=new ArrayList<String>();      
               ac.add("A");
               ac.add("B");
               ac.add("C");
               ac.add("D");
               ac.add("E");
               ac.add("F");
               ac.add("G");
               ac.add("H");
               ac.add("I");
               ac.add("J");
               ac.add("K");
        Odev3 obje=new Odev3(s);
      
      System.out.println("Neighbors");
       for(String g:ac){
           Vertex<String> v =(Vertex<String>) obje.aa.verticesMap.get(g);
           System.out.print(g+":");
           for(Edge<String> ed:v.edges){
               
            System.out.print(ed.to.value);
          }
           System.out.println(" ");
       }
        System.out.println();
        System.out.println("GRAPH COLORS");
      Map<String,String> graphmap=new HashMap<>();
        graphmap = obje.boya(renkler);
        for(String string:ac){
            System.out.print(string+":");
            System.out.println(graphmap.get(string));
            
        }
            
        
        
       
   
        
       
}
}

    
    

