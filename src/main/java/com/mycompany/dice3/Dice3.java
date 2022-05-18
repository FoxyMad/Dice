

package com.mycompany.dice3;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Dice3 {
    
  public interface Dice {
      
    int setLength();
    int returnRandomValue();

        public void setLength(int P);
    }  
public static void main(String[] args) {
  
        Dice Di = new DiceImpl() {
            @Override
            public int setLength() {
                throw new UnsupportedOperationException("Not supported yet."); 
            }
        };
                
        ArrayList <Integer> players = new ArrayList<Integer>();
        
        Scanner Scan3 = new Scanner( System.in );
        
        Scanner Scan4 = new Scanner( System.in );

        int sum1=0; 
        int sum2=0;
        int l;
        int K; 
        int N;
        int s;
        int c;        
        int P = 6;
        
        System.out.println("Please, type the number of players: ");

        N = Scan4.nextInt();    
                
        System.out.println("Please, type the number of throws: ");

        K = Scan3.nextInt();

        Di.setLength(P);
                
        System.out.println("It is turn of computer now. It's throws:\n");
        
              for( int t = 0; t < K; t++ ){  
                c = Di.returnRandomValue();      
                System.out.println("Computer got: "+c);
                sum2 = sum2 + c;
              } 
        System.out.println("Computer got a sum of " + sum2);
                
        for( int j = 0; j < N; j++ ){
        l=j+1; 
                        
        System.out.println("It is your turn now player "+ l + " you'll throw now.\n");

            for( int i = 0; i < K; i++ ){
                s = Di.returnRandomValue();
                System.out.println("You got: " + s);
                sum1 = sum1 + s;
            }
            
                players.add(j,sum1);
                System.out.println("Player, you got a sum of " + sum1);
                sum1=0;
            }
                int obj = Collections.max(players);
                int index = players.indexOf(obj);
                int index1 = index+1;
                
                if(sum2 > obj){ 
                 System.out.println( "Computer wins!");               
               } 
                else
                 System.out.println( "Player "+index1+", you won with sum = "+obj);                                
            }
 
public static abstract class DiceImpl implements Dice {

    Random generator = new Random();

    public int thro;
    private int length;
    public int getLength() {
        return length;
    }
    
    @Override
    public void setLength(int Lng) {
        length = Lng;
    }
    @Override
    public int returnRandomValue()
    {
        return thro = 1 + generator.nextInt( length );
    }
}
}
