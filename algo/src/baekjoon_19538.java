import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class baekjoon_19538 {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList <ArrayList<Integer>> arrayList = new ArrayList();
		Deque <Integer> deque1 = new ArrayDeque<Integer>();
		Deque <Integer> deque2 = new ArrayDeque<Integer>();
		int [] people = new int[N];
		for(int i=0; i<N; i++) {
			people[i] = -1;
			arrayList.add(new ArrayList<Integer>());
			String [] input = br.readLine().split(" ");
			for(String temp : input) {
				if(!temp.equals("0")) {
					arrayList.get(i).add(Integer.parseInt(temp)-1);
				}
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int rumor = Integer.parseInt(st.nextToken())-1;
			people[rumor] = 0;
			for(int j=0; j<arrayList.get(rumor).size(); j++) {
				if(check(arrayList.get(rumor).get(j), people, arrayList)) {
					deque1.addLast(arrayList.get(rumor).get(j));
				}
			}
		}

		int time = 1;
		while(true) {
			if(deque1.size() == 0) {
				break;
			}
			
			while(!deque1.isEmpty()) {
				int rumor = deque1.pollFirst();
				
				if(people[rumor] >= 0) {
					continue;
				}

				if(check(rumor, people, arrayList)) {
					deque2.addLast(rumor);
				}
			}
			
			while(!deque2.isEmpty()) {
				int rumor = deque2.pollFirst();
				people[rumor] = time;
				
				for(int i=0; i<arrayList.get(rumor).size(); i++) {
					if(people[arrayList.get(rumor).get(i)] < 0) {
						deque1.addLast(arrayList.get(rumor).get(i));
					}
				}
			}
			
			time ++;
		}
		
		print(people);
		
		bw.write("\n");
		bw.flush();
		bw.close();
	}
	
	public static void print(int [] people) {
		for(int i=0; i<people.length; i++) {
			System.out.print(people[i] + " ");
		}
		
		System.out.println("");
	}
	
	public static boolean check(int rumor, int [] people, ArrayList <ArrayList<Integer>> arrayList) {
		int num = 0;
		
		for(int i=0; i<arrayList.get(rumor).size(); i++) {
			if(people[arrayList.get(rumor).get(i)] >= 0) {
				num ++;
			}
		}
		
		if(num >= arrayList.get(rumor).size()/2.0) {
			return true;
		}
		else {
			return false;
		}
	}
}
