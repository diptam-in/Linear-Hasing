
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
public class Bucket {
    
    private final Integer b;
    private Vector<Integer> elements=null;
    private Integer currsize=0;
    
    Bucket(int n)
    {
        this.b = n;
        currsize =0;
        elements  = new Vector<>(b);
    }
    
    int getCurrentSize()
    {
        return currsize;
    }
    
    void insert(int elem)
    {
        elements.add(elem);
        currsize++;
    }
    
    boolean isThere(int elem)
    {
        return elements.contains(elem);
    }
    
    void split(Bucket nb,int div, int targetpos)
    {
        Vector<Integer> splitted = new Vector<>();
        for(Integer i : elements)
        {
            if(i%div==targetpos)
            {
                nb.insert(i);
                splitted.add(i);
                currsize--;
            }
        }
        elements.removeAll(splitted);
    }
    
    String getElements()
    {
        return elements.toString();
    }
}
