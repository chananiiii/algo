package JAVAContents;
/*
�� Ŭ����, ������
class Pair() {
	int sero;
	int garo;
	// ������
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

�� �����
BufferedReader br = new BufferedReader(InputStreamReader(System.in));
BufferedWriter bw = new BufferedReader(OutputStreamWriter(System.out));
String a = br.readLine();
String temp = bf.readLine();
//1,2,3,4 4���� �ɰ��� ������ new StringTokenizer(temp, ","); ���ϸ� �ڸ� �غ� �Ϸ�.
StringTokenizer st = new StringTokenizer(temp); // new StringTokenizer(temp, " ") �� ����
for(st.hasMoreTokens) {
	int a = Integer.parseInt(st.nextToken());
	int b = Integer.parseInt(st.nextToken());
}
bw.write(a + "\n");
bw.flush();
bw.close();

------------------------------------------------------------------------------------------

�� ArrayList
�� ArrayList ���� contains��밡��.
import java.util.*;
ArrayList <String> arrayList = new ArrayList();
arrayList.add("test");
arrayList.contains("test"); // true : 1, false : 2
arrayList.remove(0); // 0��° index ����

�� 2���� ArrayList ���� �� ���(���� �׷������� ���� ����Ѵ�. Memory ����)
ArrayList <Integer> arrayList = new ArrayList[5];
for(int i = 0; i < arrayList.size(); i ++) {
	arrayList[i] = new ArrayList<Integer>();
}

------------------------------------------------------------------------------------------

�� Deque(Queue, Stack)
Deque <Integer> deque = new LinkedList();

//queue ����� 0 1 2 FIFO first in first out
deque.add(0);
deque.add(1);
deque.add(2);
bw.write(deque.pollFirst() + "\n");
bw.write(deque.pollFirst() + "\n");
bw.write(deque.pollFirst() + "\n");
	
// stack ��� ��� 2 1 0 LIFO last in first out
deque.add(0);
deque.add(1);
deque.add(2);
bw.write(deque.pollLast() + "\n");
bw.write(deque.pollLast() + "\n");
bw.write(deque.pollLast() + "\n");

------------------------------------------------------------------------------------------

�� Set
[�ߺ��� ������� �ʴ´ٴ� ���� �ִ�.]
Set<String> set = new HashSet<String>();
set.add("A");
set.remove("A");


����� 2���� ���(for, ����for, iterator : iterator�� �������� ��ü �����ϰ� �ؾ��ؼ�)
Set<String> alpha = new HashSet<>();
for(String item: str){
        	alpha.add(item);
}

Iterator<String> iter = alpha.iterator();
while(iter.hasNext()){
	System.out.print(iter.next() + " ");
}

------------------------------------------------------------------------------------------

�� HashMap
�� ���� �� ���
HashMap <String, Integer> a = new HashSet<Long, Integer>();
a.put("2", 3);
a.get("2"); // Output : 3

if(a.containsKey("2")); // TRUE
if(a.containsValue("3")); // TRUE

// key ���� �޾ƿö�
for(String a : a.keySet())
// value���� �޾ƿö�
for(String a : a.values()) 

------------------------------------------------------------------------------------------

�� ���ڿ�
��char to int
String temp = "123456"
int sum = 0;
for(int i = 0; i < temp.length; i ++) {
	// This is Char to Int
	sum += temp.charAt(i) - '0';
}

��int to String
int a = 1;
String b = Integer.toString(a);

��String to int
String temp = "123456"
int a = Integer.parseInt(temp);

��String �� �ڸ� ������
String temp1 = "test"
// ���1
String [] temp2 = temp.split("");
// ���2
for(int i = 0; i < temp.length; i ++) {
	String a = temp.substring(i, i + 1);
}

�������� �ݿø�, ����, �ø�
//������
double temp = Math.sqrt(13);

//�ݿø�
// ù° �ڸ�����, ��°�ڸ�����, ��°�ڸ�����
double pie = 3.1415926535;
int round = Math.round(pie);
int round = Math.round((pie * 10) / 10.0);
int round = Math.round((pie * 100) / 100.0);

//����, �ø�
int num = (int)Math.floor(13.5);
int num = (int)Math.ceil(13.5);

��Sort�Լ�(length�� �������� �����ϰ�, compareTo�� ���ؼ� ���ڿ� ������ �����Ѵ�.)
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