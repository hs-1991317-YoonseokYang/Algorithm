
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//우선 순위 큐 사용
		Scanner in= new Scanner(System.in);
		int n=in.nextInt();
		int k=in.nextInt();
		PriorityQueue pq= new PriorityQueue();
		ArrayList<Integer> list= new ArrayList<Integer>();
		
		for(int i=0;i<n;i++) {
			pq.insert(in.nextInt());
		}
		
		
		for(int i=1;i<k;i++) {
			pq.delete();
		}
		System.out.print(pq.delete());
		
		
	}

}

class PriorityQueue{
	private ArrayList<Integer> heap= new ArrayList<Integer>();
	private int heapSize;
	
	public PriorityQueue() {
		heap.add(null);
		heapSize=0;
	}
	
	public void print() {
		//System.out.println(heapSize);
		for(int i=1;i<=heapSize;i++)
			System.out.println(heap.get(i));
	}
	
	 public void insert(int item) {
	        int i = ++heapSize;
	        
	        // 새로운 요소를 추가해야 하므로 heap에 공간을 추가
	        if (heapSize < heap.size()) {
	            heap.set(i, item);
	        } else {
	            heap.add(item);
	        }

	        // 위로 올라가면서 부모와 비교 및 교환
	        while ((i != 1) && (item > heap.get(i / 2))) {
	            heap.set(i, heap.get(i / 2));
	            i = i / 2;
	        }
	        heap.set(i, item);
	    }

	
	public int delete() {
		int item=heap.get(1);
		int temp=heap.get(heapSize--);
		int parent=1;
		int child=2;
		
		while(child<=heapSize) {
			if(heapSize > child && heap.get(child)<heap.get(child+1)) child++;
			if(temp>=heap.get(child)) break;
			
			heap.set(parent, heap.get(child));
			parent=child;
			child=child*2;
		}
		heap.set(parent,temp);
		return item;
		
	}
	
	
}
