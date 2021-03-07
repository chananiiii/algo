import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class baekjoon_10757 {
	public static BufferedReader br = null;
	public static BufferedWriter bw = null;
	public static void main(String [] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String [] temp = br.readLine().split(" ");
		BigInteger a = new BigInteger(temp[0]);
		BigInteger b = new BigInteger(temp[1]);
		
		bw.write(a.add(b) + "\n");
		bw.flush();
		bw.close();
	}
}
