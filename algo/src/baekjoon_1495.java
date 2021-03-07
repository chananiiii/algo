import java.util.*;
import java.io.*;

public class baekjoon_1495 {
	public static BufferedReader br = null;
	public static BufferedWriter bw = null;
	public static void main(String [] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String [] temp = br.readLine().split(" ");
		int songs = Integer.parseInt(temp[0]);
		int startVolume = Integer.parseInt(temp[1]);
		int maxVolume = Integer.parseInt(temp[2]);
		int [] volumeGroup = new int[songs];
		temp = br.readLine().split(" ");
		
		for(int i = 0; i < temp.length; i ++) {
			volumeGroup[i] = Integer.parseInt(temp[i]);
		}
		
		ArrayList <ArrayList<Integer>> arrayList = new ArrayList();
		for(int i = 0; i < songs; i ++) {
			arrayList.add(new ArrayList<Integer>());
		}
		
		//start to solve the problem
		if(startVolume + volumeGroup[0] <= maxVolume) {
			arrayList.get(0).add(startVolume + volumeGroup[0]);
		}
		if(startVolume - volumeGroup[0] >= 0) {
			arrayList.get(0).add(startVolume - volumeGroup[0]);
		}
				
		for(int i = 1; i < arrayList.size(); i ++) {
			for(int j = 0; j < arrayList.get(i - 1).size(); j ++) {
				int standard = arrayList.get(i - 1).get(j);
				if(standard + volumeGroup[i] <= maxVolume && !arrayList.get(i).contains(standard + volumeGroup[i])) {
					arrayList.get(i).add(standard + volumeGroup[i]);
				}
				
				if(standard - volumeGroup[i] >= 0 && !arrayList.get(i).contains(standard - volumeGroup[i])) {
					arrayList.get(i).add(standard - volumeGroup[i]);
				}
			}
		}
		
		if(arrayList.get(songs - 1).size() == 0) {
			bw.write("-1\n");
		}
		else {
			bw.write(Collections.max(arrayList.get(songs - 1)) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
