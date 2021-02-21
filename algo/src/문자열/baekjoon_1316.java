package ¹®ÀÚ¿­;
import java.util.*;
import java.io.*;
public class baekjoon_1316 {
    public static BufferedReader br = null;
	public static BufferedWriter bw = null;
	public static int num = 0;
	public static int result = 0; 
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		num = Integer.parseInt(br.readLine());
		String [] words = new String[num];
		for(int i = 0; i < num; i ++) {
		    words[i] = br.readLine();
		}
		
		for(String a : words) {
		    boolean b = true;
		    HashMap<Character, Integer> hash = new HashMap();
		    hash.put(a.charAt(0), 1);
		    for(int i = 1; i < a.length(); i ++) {
		        char temp = a.charAt(i);
		        if(temp == a.charAt(i - 1))
		            continue;
		        else {
    		        if(!hash.containsKey(temp)) {
    		            hash.put(temp, 1);
    		            continue;
    		        }
    		        else {
    		            b = false;
    		            break;
    		        }
		        }
		    }
		    if(b) 
		        result ++;
		}
        bw.write(result + "\n");		
		bw.flush();
		bw.close();
	}
}
