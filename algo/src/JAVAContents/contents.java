package JAVAContents;
/*
■ 클래스, 생성자
class Pair() {
	int sero;
	int garo;
	// 생성자
	public Pair(int sero, int garo) {
		this.sero = sero;
		this.garo = garo;
	}
	public int getSero() {
		return this.sero;
	}
	public int getGaro() {
		return this.garo;
	} 
}

------------------------------------------------------------------------------------------

■ 입출력
BufferedReader br = new BufferedReader(InputStreamReader(System.in));
BufferedWriter bw = new BufferedReader(OutputStreamWriter(System.out));
String a = br.readLine();
String temp = bf.readLine();
//1,2,3,4 4개로 쪼개고 싶으면 new StringTokenizer(temp, ","); 로하면 자를 준비 완료.
StringTokenizer st = new StringTokenizer(temp); // new StringTokenizer(temp, " ") 와 같다
for(st.hasMoreTokens) {
	int a = Integer.parseInt(st.nextToken());
	int b = Integer.parseInt(st.nextToken());
}
bw.write(a + "\n");
bw.flush();
bw.close();

------------------------------------------------------------------------------------------

■ ArrayList
★ ArrayList 에서 contains사용가능.
import java.util.*;
ArrayList <String> arrayList = new ArrayList();
arrayList.add("test");
arrayList.contains("test"); // true : 1, false : 2
arrayList.remove(0); // 0번째 index 삭제

★ 2차원 ArrayList 선언 및 사용(인접 그래프에서 많이 사용한다. Memory 절약)
ArrayList <Integer> arrayList = new ArrayList[5];
for(int i = 0; i < arrayList.size(); i ++) {
	arrayList[i] = new ArrayList<Integer>();
}

------------------------------------------------------------------------------------------

■ Deque(Queue, Stack)
Deque <Integer> deque = new LinkedList();

//queue 사용방법 0 1 2 FIFO first in first out
deque.add(0);
deque.add(1);
deque.add(2);
bw.write(deque.pollFirst() + "\n");
bw.write(deque.pollFirst() + "\n");
bw.write(deque.pollFirst() + "\n");
	
// stack 사용 방법 2 1 0 LIFO last in first out
deque.add(0);
deque.add(1);
deque.add(2);
bw.write(deque.pollLast() + "\n");
bw.write(deque.pollLast() + "\n");
bw.write(deque.pollLast() + "\n");

------------------------------------------------------------------------------------------

■ Set
[중복을 허용하지 않는다는 점이 있다.]
Set<String> set = new HashSet<String>();
set.add("A");
set.remove("A");


출력의 2가지 방법(for, 단축for, iterator : iterator가 젤느리다 객체 생성하고 해야해서)
Set<String> alpha = new HashSet<>();
for(String item: str){
        	alpha.add(item);
}

Iterator<String> iter = alpha.iterator();
while(iter.hasNext()){
	System.out.print(iter.next() + " ");
}

------------------------------------------------------------------------------------------

■ HashMap
★ 생성 및 사용
HashMap <String, Integer> a = new HashSet<Long, Integer>();
a.put("2", 3);
a.get("2"); // Output : 3

if(a.containsKey("2")); // TRUE
if(a.containsValue("3")); // TRUE

// key 값만 받아올때
for(String a : a.keySet())
// value값만 받아올때
for(String a : a.values()) 

------------------------------------------------------------------------------------------

■ 문자열
★char to int
String temp = "123456"
int sum = 0;
for(int i = 0; i < temp.length; i ++) {
	// This is Char to Int
	sum += temp.charAt(i) - '0';
}

★int to String
int a = 1;
String b = Integer.toString(a);

★String to int
String temp = "123456"
int a = Integer.parseInt(temp);

★String 각 자리 나누기
String temp1 = "test"
// 방법1
String [] temp2 = temp.split("");
// 방법2
for(int i = 0; i < temp.length; i ++) {
	String a = temp.substring(i, i + 1);
}

★제곱근 반올림, 내림, 올림
//제곱근
double temp = Math.sqrt(13);

//반올림
// 첫째 자리까지, 둘째자리까지, 셋째자리까지
double pie = 3.1415926535;
int round = Math.round(pie);
int round = Math.round((pie * 10) / 10.0);
int round = Math.round((pie * 100) / 100.0);

//버림, 올림
int num = (int)Math.floor(13.5);
int num = (int)Math.ceil(13.5);

★Sort함수(length를 기준으로 정렬하고, compareTo를 통해서 문자열 순으로 정렬한다.)
Collections.sort(array, new Comparator<String>() {
	@Override
            public int compare(String a, String b) {
		if(a.length() == b.length()) {
			return a.compareTo(b);
               	}
		return a.length() - b.length();
	}
});
*/