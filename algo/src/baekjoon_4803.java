import java.util.*;
import java.io.*;

public class baekjoon_4803 {
   public static BufferedReader br = null;
   public static BufferedWriter bw = null;
   public static int [] check = null;
   public static boolean cycle = false;
   public static int oneDepth = 0;
   public static int sibal = 0;
   
   public static void main(String [] args) throws IOException {
      br = new BufferedReader(new InputStreamReader(System.in));
      bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      while(true) {
         String temp = br.readLine();
         if(temp.equals("0 0")) {
            break;
         }
         else {
            String [] num = temp.split(" ");
            int pointNumber = Integer.parseInt(num[0]);
            int lineNumber = Integer.parseInt(num[1]);
            check = new int[pointNumber];
            ArrayList <ArrayList<Integer>> graph = new ArrayList();
            for(int i = 0; i < pointNumber; i ++) {
               graph.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < lineNumber; i ++) {
               String [] lineToLine = br.readLine().split(" ");
               int a = Integer.parseInt(lineToLine[0]) - 1;
               int b = Integer.parseInt(lineToLine[1]) - 1;
               graph.get(a).add(b);
               graph.get(b).add(a);
            }
            // 여기까지 그래프 담음
            
			/*
			 * for(int i = 0; i < graph.size(); i ++) { for(int j = 0; j <
			 * graph.get(i).size(); j ++) { bw.write(graph.get(i).get(j) + " "); }
			 * bw.write("\n"); }
			 */
             
            //bw.write("\n");
            //bw.write("\n");
            //bw.write("\n");
            
            int cycleNumber = 0;
            for(int i = 0; i < pointNumber; i ++) {
               if(graph.get(i).size() == 0) {
                  check[i] = 1;
                  cycleNumber ++;
                  continue;
               }
               
               if(check[i] != 1) {
                  for(int j = 0; j < graph.get(i).size(); j ++) {
                     if(check[graph.get(i).get(j)] != 1) {
                        // graph, 이전거, 다음꺼로 갈꺼
                        check[i] = 1;
                        findGraph(graph, i, i);
                        
                        if(!cycle) {
                           cycleNumber ++;
                        }

                        cycle = false;
                     }
                  }
               }
            }
            
            sibal ++;
            if(cycleNumber == 0)
            	bw.write("Case " + sibal + ": " + "No trees.\n");
            else if(cycleNumber == 1)
            	bw.write("Case " + sibal + ": " + "There is one tree.\n");
            else
            	bw.write("Case " + sibal + ": " + "A forest of " + cycleNumber + " trees.\n");
         }
      }
      
      bw.flush();
      bw.close();
   }
   public static void findGraph(ArrayList<ArrayList<Integer>> graph, int previous, int present) throws IOException {
      
      for(int i = 0; i < graph.get(present).size(); i ++) {
         if(check[graph.get(present).get(i)] != 1 && previous != graph.get(present).get(i)) {
            check[graph.get(present).get(i)] = 1;
            findGraph(graph, present, graph.get(present).get(i));
         }
         else if(check[graph.get(present).get(i)] == 1 && previous != graph.get(present).get(i)) {
        	 cycle = true;
         }
      }
   }
}