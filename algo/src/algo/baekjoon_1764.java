package algo;

import java.util.*;
import java.io.*;

public class baekjoon_1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = bf.readLine();
		ArrayList <String> group1 = new ArrayList();
		ArrayList <String> group2 = new ArrayList();
		StringTokenizer st = new StringTokenizer(line);
		int two = 0;
		while(st.hasMoreTokens()) {
		    int end = Integer.parseInt(st.nextToken());
		    if(two == 0) {
    		    for(int i = 0; i < end; i ++) {
    		        group1.add(bf.readLine());
    		    }
		    }
		    else {
    		    for(int i = 0; i < end; i ++) {
    		        group2.add(bf.readLine());
    		    }
    		}
    		two ++;
		}
		
		Collections.sort(group1, new Comparator<String>() {
		    @Override
		    public int compare(String one, String two) {
		        return one.compareTo(two);
		    }
		});
		
		Collections.sort(group2, new Comparator<String>() {
		    @Override
		    public int compare(String one, String two) {
		        return one.compareTo(two);
		    }
		});
		
		ArrayList <String> result = new ArrayList();
		
		int i = 0;
		int j = 0;
		while(group1.size() != i && group2.size() != j) {
		    String a = group1.get(i);
		    String b = group2.get(j);
		    if(a.compareTo(b) > 0) {
		        j ++;
		    }
		    else if(a.compareTo(b) == 0) {
		        i ++;
		        j ++;
		        result.add(a);
		    }
		    else {
		        i ++;
		    }
		    continue;
		}
		
		bw.write(result.size() + "\n");
		for(String a : result) 
		    bw.write(a + "\n");
	    bw.flush();
	    bw.close();
	}
}
