import java.util.*;
import java.io.*;
public class baekjoon_1629 {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String [] temp = br.readLine().split(" ");
		long A = Integer.parseInt(temp[0]);
		long B = Integer.parseInt(temp[1]);
		long C = Integer.parseInt(temp[2]);
		
		long result = divide(A % C, B, C);
		bw.write(result + "\n");
		bw.flush(); 
		bw.close();
	}
	public static long divide(long a, long b, long c) {
		if(b == 1)
			return a;

		long temp = divide(a, b / 2, c);
		
		if(b % 2 == 0) {
			return (temp * temp) % c;
		}
		else {
			return (((temp * temp) % c) * a) % c;
		}
	}
}
