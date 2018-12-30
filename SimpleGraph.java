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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleGraph<T> {
    /**
     * DÃ¼ÄŸÃ¼mleri tutan liste
     */
    protected List<Vertex<T>> vertices;
    /**
     * DÃ¼ÄŸÃ¼mlere kolay eriÅŸmek iÃ§in kullanÄ±lan map <deÄŸer, dÃ¼ÄŸÃ¼m>
     */
    protected Map<T, Vertex<T>> verticesMap;
    /**
     * Ã‡izge yÃ¶nlÃ¼ mÃ¼
     */
    boolean directed=true;

    public SimpleGraph() {
        vertices=new ArrayList<>();
        verticesMap=new HashMap<>();
    }

    public SimpleGraph(boolean directed) {
        this();
        this.directed=directed;
    }

    /**
     * Ã‡izgeye dÃ¼ÄŸÃ¼m ekler
     * @param deger eklenecek dÃ¼ÄŸÃ¼mÃ¼n deÄŸeri
     */
    public void addVertex(T deger){
        if(!vertices.contains(deger)) {
            Vertex<T> v=new Vertex<>(deger);
            vertices.add(v);
            verticesMap.put(deger, v);
        }
    }

    /**
     * Ã‡izgeye kenar ekler
     * @param from kenarÄ±n Ã§Ä±ktÄ±ÄŸÄ± dÃ¼ÄŸÃ¼m
     * @param to kenarÄ±n girdiÄŸi dÃ¼ÄŸÃ¼m
     */
    public void addEdge(T from, T to){
        addEdge(from,to,1);
    }

    /**
     * Ã‡izgeye kenar ekler
     * @param from kenarÄ±n Ã§Ä±ktÄ±ÄŸÄ± dÃ¼ÄŸÃ¼m
     * @param to kenarÄ±n girdiÄŸi dÃ¼ÄŸÃ¼m
     * @param weight kenarÄ±n aÄŸÄ±rlÄ±ÄŸÄ±
     */
    public void addEdge(T from, T to, int weight) {
        Vertex<T> f=verticesMap.get(from);
        Vertex<T> t=verticesMap.get(to);
        if (f!=null && t!=null){
            for (Edge<T> e:f.edges)
                if(e.to.value.equals(to))
                    return;
            Edge e1=new Edge(f,t,weight);
            //edges.get(from).add(e1);//alttaki ÅŸekilde deÄŸiÅŸti
            verticesMap.get(from).edges.add(e1);
            if(!directed){
                Edge e2=new Edge(t,f,weight);
                //edges.get(to).add(e2);//alttaki ÅŸekilde deÄŸiÅŸti
                verticesMap.get(to).edges.add(e2);
            }
        }

    }

    /**
     * Ã‡izgenin iÃ§eriÄŸini ekrana yazdÄ±rÄ±r
     */
    public void print() {
        System.out.println(toString());
    }

    /**
     * DÃ¼ÄŸÃ¼m ve kenarlarÄ± iÃ§eren metinsel temsil
     * @return Ã‡izgenin metin temsilini verir
     */
    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("Vertices:\n");
        for (Vertex<T> vertex:vertices)
            sb.append(vertex.value+"\n");
        sb.append("Edges:\n");
        for (Vertex<T> vertex:vertices)
            for (Edge<T> edge:vertex.edges)
                sb.append(edge.from.value+(edge.weight!=1?" - "+edge.weight:"")+" -> "+edge.to.value+"\n");
        return sb.toString();
    }

    /**
     * DÃ¼ÄŸÃ¼me gelen kenar sayÄ±sÄ±nÄ± verir
     * @param deger hesaplanmak istenen dÃ¼ÄŸÃ¼mÃ¼n deÄŸeri
     * @return gelen kenar sayÄ±sÄ±
     */
    public int inDegree(T deger) {
        Vertex<T> vv=verticesMap.get(deger);
        if(vv==null)
            return -1;
        int id=0;
        for (Vertex<T> v:vertices)
            for (Edge<T> e:v.edges)
                if(e.to.value.equals(deger))
                    id++;
        return id;
    }

    /**
     * DÃ¼ÄŸÃ¼mden Ã§Ä±kan kenar sayÄ±sÄ±nÄ± verir
     * @param deger hesaplanmak istenen dÃ¼ÄŸÃ¼mÃ¼n deÄŸeri
     * @return Ã§Ä±kan kenar sayÄ±sÄ±
     */
    public int outDegree(T deger) {
        Vertex<T> v=verticesMap.get(deger);
        if(v==null)
            return -1;
        return v.edges.size();
    }

}

