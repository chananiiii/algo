import java.util.*;
import java.io.*;
public class baekjoon_2981 {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		ArrayList <Integer> arrayList = new ArrayList<Integer>();
		ArrayList <Integer> result = new ArrayList<Integer>();
		ArrayList <Integer> arrayListAfter = new ArrayList<Integer>();
		
		for(int i = 0; i < num; i ++) {
			arrayList.add(Integer.parseInt(br.readLine()));
		}
	
		Collections.sort(arrayList);
		
		int gcd = arrayList.get(1) - arrayList.get(0);
		
		for(int i = 2; i < arrayList.size(); i ++)
			gcd = share(gcd, arrayList.get(i) - arrayList.get(i - 1));
		
		for(int i = 2; i <= gcd; i ++) {
			if(gcd % i == 0)
				result.add(i);
		}
		
		Collections.sort(result);
		
		for(int q : result) {
			if(q != 1) {
				bw.write(q + "\n");
			}
		}
		bw.flush();
		bw.close();
	}
	public static int share(int a, int b) {
		if(a % b == 0)
			return b;
		else
			return share(b, a % b);
	}
}
