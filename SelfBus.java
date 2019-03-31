import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class SelfBus {

    // Complete the solve function below.
    static int solve(int[][] tree) {
        ArrayList<Integer> al1=new ArrayList<Integer>();
        int c=0;
        for(int i=0;i<tree.length;i++)
        {
            for(int j=0;j<tree[i].length;j++)
            {
                if(!(al1.contains(tree[i][j])))
                    al1.add(tree[i][j]);
            }
        }
        c=al1.size();
        ArrayList<Integer> al=new ArrayList<Integer>();
        int k=0;
        for(int z=0;z<tree.length-1;z++)
        {
            k=z+1;
            for(int y=0;y<tree[z].length;y++)
            {
                al.add(tree[z][y]);
            }
            while(k<tree.length)
            {
                if(al.contains(tree[k][0]))
                    al.add(tree[k][1]);
                else
                    break;
                k++;
            }
            if(al.size()!=0)
                c++;
            al.clear();    
        }
        return (c+1);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] tree = new int[n-1][2];

        for (int treeRowItr = 0; treeRowItr < n-1; treeRowItr++) {
            String[] treeRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int treeColumnItr = 0; treeColumnItr < 2; treeColumnItr++) {
                int treeItem = Integer.parseInt(treeRowItems[treeColumnItr]);
                tree[treeRowItr][treeColumnItr] = treeItem;
            }
        }

        int result = solve(tree);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
