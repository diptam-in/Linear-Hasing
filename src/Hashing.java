
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
        String FILENAME = args[0];
        HashTable ht = new HashTable(2,B/4);
        BufferedReader br = new BufferedReader(new FileReader(FILENAME));
        String num;
        Integer elem;
        while((num=br.readLine())!=null)
        {
            elem  = Integer.parseInt(num);
            ht.insert(elem);
        }
        ht.displayTable();
    }
}
