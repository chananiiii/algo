package ¹®ÀÚ¿­;
import java.util.*;
import java.io.*;
public class baekjoon_2711 {
	public static BufferedReader br = null;
	public static BufferedWriter bw = null;
	public static int num = 0;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		num = Integer.parseInt(br.readLine());
		for(int i = 0; i < num; i ++) {
		    String temp = br.readLine();
		    String [] s = temp.split(" ");
		    int place = Integer.parseInt(s[0]);
		    String st = s[1];
		    
		    bw.write(st.substring(0, place - 1) + st.substring(place, st.length()) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
