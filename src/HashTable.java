
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author diptam
 */
public class HashTable {
    
    private final double LOAD_FACTOR=1.5;
    private Vector<Bucket> ht;
    private int collisions=0;
    private int N,size=0;
    private int p,div,pos;
    private int b;
    private int totalelement=0;
    
    HashTable(int n, int B)
    {
        size=n;
        N=size;
        b=B;
        ht = new Vector<>(size); 
        for(int i=0;i<size;i++)
            ht.add(new Bucket(b));
    }
    
    public void insert(int elem)
    {
        pos = find(elem);
        if(ht.get(pos).isThere(elem)) return;
        ht.get(pos).insert(elem);
        totalelement++;      
//        if(ht.get(pos).getCurrentSize()>b)
        if(getLoad()>LOAD_FACTOR)
        {
            split();
            collisions++;
            if(collisions==size)
            {
                size*=2;
                collisions=0;
            }
        } 
        System.out.println("Inserted: "+elem);
    }
    
    private void split()
    {
        Bucket nb = new Bucket(b);
        ht.add(nb);
        if(collisions%(N/2)==0)
            N=2*N;
        ht.get((ht.size()-(size)-1)).split(nb,2*size,ht.size()-1);
        
    }
    
    private int find(int elem)
    {
        int s = ht.size();
        int prod=1;
        while(prod<s)
            prod*=2;
        int temp = elem%prod;
        
        if(temp >= s)
            return temp-size;
        else
            return temp;
    }
    
    private double getLoad()
    {
        return (double)(totalelement/ht.size());
    }
    
    public void displayTable()
    {
        System.out.println("------------------- HASH TABLE ------------------------");
        for(Bucket i : ht)
        {
            System.out.println(i.getElements());
        }
        System.out.println(ht.size());
    }
}
