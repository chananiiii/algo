import java.util.*;
import java.io.*;
public class baekjoon_2668 {
	public static BufferedReader br = null;
	public static BufferedWriter bw = null;
	public static int N = 0;
	public static int [] map = null;
	public static int result = 0;
	public static int max = 0;
	public static boolean b = true;
	public static HashSet <Integer> upArrayList = null;
	public static HashSet <Integer> downArrayList = null;
	public static ArrayList <Integer> resultArrayList = null;
	public static int [] check = null;
	public static void main(String [] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N];
		check = new int[N];
		upArrayList = new HashSet();
		downArrayList = new HashSet();
		resultArrayList = new ArrayList();
		for(int i = 0; i < N; i ++) {
			map[i] = Integer.parseInt(br.readLine());
		}
		for(int i = 0; i < N; i ++) {
			if(check[i] == 1) 
				continue;
			
			b = true;
			upArrayList = new HashSet<Integer>();
			downArrayList = new HashSet<Integer>();
			dfs(i, map[i]);
			if(upArrayList.size() == downArrayList.size()) {
				List <Integer> list1 = new ArrayList<Integer>(upArrayList);
				List <Integer> list2 = new ArrayList<Integer>(downArrayList);
				
				boolean correct = true;
				Collections.sort(list1);
				Collections.sort(list2);
				for(int z = 0; z < list1.size(); z ++) {
					if(list1.get(z) != list2.get(z)) {
						correct = false;
						break;
					}
				}
				if(correct) {
					for(int a : list1) {
						check[a] = 1;
						resultArrayList.add(a + 1);
					}
				}
			}
		}
		Collections.sort(resultArrayList);
		bw.write(resultArrayList.size() + "\n");
		for(int i = 0; i < resultArrayList.size(); i ++) {
			bw.write(resultArrayList.get(i) + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int present, int next) throws IOException {
		upArrayList.add(present);
		downArrayList.add(next);
		
		if(check[next] == 1)
			return;
		
		if(upArrayList.contains(next)) {
			return;
		}
			
		dfs(next, map[next]);
	}
}
