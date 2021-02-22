package ¹®ÀÚ¿­;

import java.util.*;
import java.io.*;

public class baekjoon_1541 {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String math = br.readLine();
		String [] minus = math.split("-");
		int result = 0;

        int i = 0;
		for(String a : minus) {
		    String [] plus = a.split("\\+");
		    int temp = 0;
		    for(String b : plus) {
		        temp += Integer.parseInt(b);
		    }
		    
		    if(i == 0)
		        result += temp;
		    else 
		        result += (-1) * temp;
		    
		    i ++;
		}
		
		
		bw.write(result + "\n");
	    bw.flush();
	    bw.close();
	}
}
