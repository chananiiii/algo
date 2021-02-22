package ¹®ÀÚ¿­;

import java.util.*;
import java.io.*;

public class baekjoon_1159 {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		ArrayList<String> key = new ArrayList();
		ArrayList<String> result = new ArrayList();
		HashMap <String, Integer> player = new HashMap();
		
		for(int i = 0; i < num; i ++) {
		    String temp = br.readLine().substring(0, 1);
		    if(!player.containsKey(temp))
		        player.put(temp, 1);
		    else 
		        player.put(temp, player.get(temp) + 1);
		    
		    if(!key.contains(temp))
		        key.add(temp);
		}
		
		for(int i = 0; i < key.size(); i ++){
		    if(player.get(key.get(i)) > 4)
		        result.add(key.get(i));
		}
		    
		Collections.sort(result);
		
		if(result.size() > 0)
		    for(String a : result) 
		        bw.write(a);
		else
		    bw.write("PREDAJA");
		bw.write("\n");
	    bw.flush();
	    bw.close();
	}
}
