
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author diptam
 */
public class Hashing {
    public static void main(String args[]) throws FileNotFoundException, IOException
    {
        Integer B = Integer.parseInt(args[2]);
        Integer M = Integer.parseInt(args[1]);
        String op,FILENAME = args[0];
        HashTable ht = new HashTable(2,B/4);
        BufferedReader br = new BufferedReader(new FileReader(FILENAME));
        String num;
        Integer elem;
        Queue<Integer> ipbuffer = new LinkedList<>();
        Queue<String> opbuffer = new LinkedList<>();
        
        while((num=br.readLine())!=null)
        {
            elem  = Integer.parseInt(num);
//            ht.insert(elem);
            ipbuffer.add(elem);
            if(ipbuffer.size()==((M-1)*B)/4)
            {
                while(!ipbuffer.isEmpty())
                {
                    elem = ipbuffer.poll();
                    op = ht.insert(elem);
                    
                    if(opbuffer.size()<(B/4) && op!=null)
                        opbuffer.add(op);
                    else
                    {
                        while(!opbuffer.isEmpty())
                            System.out.println(opbuffer.poll());
                        if(op!=null)
                            opbuffer.add(op);
                    }
                }
            }
        }
        while(!ipbuffer.isEmpty())
        {
            elem = ipbuffer.poll();
            op = ht.insert(elem);
                    
            if(opbuffer.size()<(B/4)  && op!=null)
                opbuffer.add(op);
            else
            {
                while(!opbuffer.isEmpty())
                    System.out.println(opbuffer.poll());
                if(op!=null)
                    opbuffer.add(op);
            }
        }
        while(!opbuffer.isEmpty())
            System.out.println(opbuffer.poll());
        ht.displayTable();
    }
}
