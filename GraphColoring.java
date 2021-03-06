/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication19;

/**
 *
 * @author acer
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Iterator;

public class GraphColoring {
     public static  SimpleGraph obj = new SimpleGraph<String>();
     Map<String,Integer> komsuMap = new HashMap<>();
     public List<String> SıraList =new ArrayList<>();
   
    public GraphColoring(String input){
        int count;
       
         
        String[] lines = input.split(("\\\n"));
        for(String str:lines){
            count=0;
           
             String[] arr=str.split(" "); 
              obj.addVertex(arr[0]);
        }
        
        for(String st:lines){
             count=0;
             String[] ar=st.split(" ");
             for(int i=1;i<ar.length;i++)
             {
                obj.addEdge(ar[0],ar[i]);
                count++;
             }
            komsuMap.put(ar[0],count);
        }
        
     final  Comparator<Map.Entry<String, Integer>> NumberofNeighbors = 
            Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder());
    final Comparator<Map.Entry<String, Integer>> alphabetical = 
            Comparator.comparing(Map.Entry::getKey);

    
    final List<String> list= komsuMap.entrySet().stream()
                 .sorted(NumberofNeighbors.thenComparing(alphabetical))
                 .map(Map.Entry::getKey)
                 .collect(Collectors.toList());
    
    for(String s:list)
    {
        SıraList.add(s);
    }
      
        
      
    }
    

    public Map<String, String> boya(String[] colors) {
       Map<String, String> paint=new HashMap<>();
        
    
        for(String color:colors)
       {
         paint.put(SıraList.get(0),color);
         
         SıraList.remove(0);
         Iterator<String> i = SıraList.iterator();
        while(i.hasNext())
        {
           String ss = i.next();
           boolean s=true;
           Vertex<String> v =(Vertex<String>) obj.verticesMap.get(ss);
           for(Edge<String> ed:v.edges)
           {
             
               if(color.equals(paint.get(ed.to.value)))
               {
               s=false;    
               break;
                   
               }
           }
            if(s==true)
             {
              paint.put(ss,color);
              i.remove();
         
            } 
        }
        
        
        
        
        if(SıraList.isEmpty()){
           break;
       }  
        
    }
    
return paint;
}
}