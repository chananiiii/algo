import java.util.*;
import java.io.*;
public class baekjoon_2981 {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		ArrayList <Integer> arrayList = new ArrayList<Integer>();
		ArrayList <Integer> result = new ArrayList<Integer>();
		
		for(int i = 0; i < num; i ++) {
			arrayList.add(Integer.parseInt(br.readLine()));
		}
	
		Collections.sort(arrayList);
		
		for(int i = 0; i < arrayList.get(0); i ++){
			int temp = share(arrayList.get(1) - i, arrayList.get(0) - i);
			boolean check = true;
			for(int j = 2; j < arrayList.size(); j ++) {
				if(temp != share(arrayList.get(j) - i, arrayList.get(0) - i)) {
					check = false;
					break;
				}
			}

			if(check && !result.contains(temp)) {
				result.add(temp);
			}
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
