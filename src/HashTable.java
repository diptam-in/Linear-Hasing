
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
    
    private Vector<Bucket> ht;
    private int collisions=0;
    private int N,size=0;
    private int p,div,pos;
    private int b;
    
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
        p= collisions/size;
        div = (int) (Math.pow(2,p)*size);
        pos = elem % div;
        //System.out.println(p+" "+div+" "+pos);
        ht.get(pos).insert(elem);
        
        if(ht.get(pos).getCurrentSize()>b)
        {
            split();
            collisions++;
        }
    }
    
    private void split()
    {
        Bucket nb = new Bucket(b);
        ht.add(nb);
        if(collisions%N==0)
            N=2*N;
        ht.get((ht.size()-(N/2)-1)).split(nb, N,ht.size()-1);
        
    }
    
    public void displayTable()
    {
        for(Bucket i : ht)
        {
            System.out.println(i.getElements());
        }
    }
}
