import java.io.*;
import java.util.*;

public class Queues {
    static Stack<Integer> stk1 = new Stack<>();
    static Stack<Integer> stk2 = new Stack<>();
    static ArrayList<Integer> result = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static Integer top = -1;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        int q = sc.nextInt();
        while(q-- > 0){
            int type = sc.nextInt();
            operate(type);
        }
        for(Integer rs : result)
            System.out.println(rs);
    }
    public static void operate(int type){
        switch(type){
            case 1: 
            Integer x = sc.nextInt();
            if(top == -1) top = x;
            stk1.push(x);
            break;
            
            case 2: 
            if(stk2.isEmpty()){
                while(!stk1.isEmpty())
                    stk2.push(stk1.pop());
            }  
            if(!stk2.isEmpty())
                stk2.pop();
            if(!stk2.isEmpty())
                top = stk2.peek();                            
            else {
                if(stk1.isEmpty()) top = -1;
                else {
                    while(!stk1.isEmpty())
                        stk2.push(stk1.pop());
                    top = stk2.peek();
                }                    
            }      
            break;
            
            case 3:          
            if(top != -1)
                result.add(top);
                        
            break;
        }
    }
}
