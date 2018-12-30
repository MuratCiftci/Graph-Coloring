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
import java.util.List;

public class Vertex<T> {
    public T value;
    public List<Edge<T>> edges;
    public Vertex(T value) {
        this.value = value;
        edges=new ArrayList<>();
    }
}
