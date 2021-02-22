package ¹®ÀÚ¿­;

import java.util.*;
import java.io.*;

public class baekjoon_11656 {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String temp = br.readLine();
		ArrayList<String> result = new ArrayList();
		
		for(int i = 0; i < temp.length(); i ++) {
		    result.add(temp.substring(i, temp.length()));
		}
		
		Collections.sort(result, new Comparator<String>() {
		    @Override
		    public int compare(String a, String b) {
		        return a.compareTo(b);
		    }
		});
		
		for(String a : result) {
		    bw.write(a + "\n");
		}
	    bw.flush();
	    bw.close();
	}
}
