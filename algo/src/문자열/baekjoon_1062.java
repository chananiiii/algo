package 문자열;

import java.util.*;
import java.io.*;

public class baekjoon_1062 {
    public static int max = 0;
    public static int n = 0;
    public static int k = 0;
    public static String [] words = null;
    public static ArrayList <Character> one = null;
    public static BufferedReader br = null;
    public static BufferedWriter bw = null;
    public static int [] check = null;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        String [] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        k = Integer.parseInt(temp[1]);
        words = new String[n];
        one = new ArrayList();
        
        for(int i = 0; i < n; i ++) {
            words[i] = br.readLine();
        }
        
        one.add('a');
        one.add('n');
        one.add('t');
        one.add('i');
        one.add('c');
        
        for(String a : words) {
            for(int i = 0; i < a.length(); i ++) {
                if(a.length() > 8) {
                    String [] s = a.substring(4, a.length() - 4).split("");
                    for(String b : s) {
                        if(!one.contains(b.charAt(0)))
                            one.add(b.charAt(0));
                    }
                }
            }
        }
        
        check = new int[one.size()];
        
        for(int i = 0; i < 5; i ++)
            check[i] = 1;
        
        if(k < 5) 
            bw.write("0" + "\n");
        else if(one.size() < k)
            bw.write(n + "\n");
        else {
            backtracking(5, 5);
            bw.write(max + "\n");
        }
        
        
        bw.flush();
        bw.close();
	}
	
	public static void backtracking(int idx, int pick) throws IOException{
        // 전부 배운경우
        if(pick == k) {
            //계산
            calc();
            return;
	    }
	    
	    for(int i = idx; i < check.length; i ++) {
    	    check[i] = 1;
    	    backtracking(i + 1, pick + 1);
    	    check[i] = 0;
	    }
	}
	
	public static void calc() throws IOException {
        int total = 0;
        ArrayList <Character> array = new ArrayList();
        for(int i = 0; i < check.length; i ++) {
            if(check[i] == 1)
                array.add(one.get(i));
        }
        
    	for(int i = 0; i < words.length; i ++) {
    	    boolean b = true;
    	    for(int j = 0; j < words[i].length(); j ++ ) {
            	if(!array.contains(words[i].charAt(j))) {
            	    b = false;
            	    break;
    	        }
    	    }
        	if(b)
        	    total ++;
    	}
	    max = (max < total) ? total : max;
	}
	
	public static void print() throws IOException {
    	for(int test = 0; test < check.length; test ++) {
    	    bw.write(check[test] + " ");
    	}
    	bw.write("\n");
	}
}
