import java.util.*;
import java.io.*;
public class baekjoon_6588 {
	public static BufferedReader br = null;
	public static BufferedWriter bw = null;
	public static int [] primeArray = null;
	public static ArrayList <Integer> arrayList = null;
	public static int upToThisNumber = 0;
	public static int max = 0;
	public static void main(String [] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		primeArray = new int[1000001];
		arrayList = new ArrayList<Integer>(); 
		
		int number = 1;
		while(number != 0) {
			number = Integer.parseInt(br.readLine());
			
			if(number == 0)
				break;
			
			arrayList.add(number);
		}
		
		max = Collections.max(arrayList);
		upToThisNumber = (int) Math.floor(Math.sqrt(max));

		// start to solve
		// 1 => ¼Ò¼ö, 0 => È¦¼ö
		writePrime();
		
		// print result
		for(int temp : arrayList) {
			boolean b = print(temp);
			if(!b) {
				bw.write("Goldbach's conjecture is wrong." + "\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
	public static void writePrime() throws IOException {		
		for(int i = 2; i < upToThisNumber + 1; i ++) {
			if(primeArray[i] == 0) {
				for(int j = i; j < max + 1; j = j + i) {
						if(j != i)
							primeArray[j] = 1;
				}
			}
		}
	}
	
	public static boolean print(int temp) throws IOException {
		boolean boo = false;
		
		for(int i = 3; i < temp / 2 + 1; i ++) {
			int a = i;
			int b = temp - i;
			
			if(primeArray[a] == 0 && a % 2 != 0 && primeArray[b] == 0 && b % 2 !=0) {
				bw.write(temp + " = " + a + " + " + b + "\n");
				boo = true;
				break;
			}
		}
		
		return boo;
	}
}
