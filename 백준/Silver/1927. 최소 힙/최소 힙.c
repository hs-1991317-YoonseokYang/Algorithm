#pragma warning(disable : 4996)
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX_ELEMENT 100000

typedef struct {
	unsigned int heap[MAX_ELEMENT];
	int heapSize;
}HeapType;

HeapType* create() {
	return (HeapType*)malloc(sizeof(HeapType));
}

void init(HeapType* h) {
	h->heapSize = 0;
}

void insertMinHeap(HeapType* h, unsigned int item) {
	int i;
	i = ++(h->heapSize);
	
	while ((i != 1) && (item < h->heap[i / 2])) {
		h->heap[i] = h->heap[i / 2];
		i /= 2;
	}
	h->heap[i] = item;
}

unsigned int deleteMinHeap(HeapType* h) {
	int parent, child;
	unsigned int item, temp;

	if(!(h->heapSize))
		return 0;

	item = h->heap[1];
	temp = h->heap[(h->heapSize)--];
	parent = 1;
	child = 2;

	while (child <= h->heapSize) {
		if ((child < h->heapSize) && (h->heap[child]) > h->heap[child + 1])//여기서 부등호를 반대로 입력해서 오류..
			child++;//왼쪽 오른쪽 비교
		if (temp <= h->heap[child]) break;
		h->heap[parent] = h->heap[child];
		parent = child;
		child *= 2;//왼쪽 자식, 
	}
	h->heap[parent] = temp;
	return item;
}

int main() {
	int testCase;
	unsigned int num;
	HeapType* h;

	h = create();
	init(h);
	scanf("%d", &testCase);

	for(int i=0;i<testCase;i++){
		scanf("%u", &num);
		if(!num)
			printf("%u\n", deleteMinHeap(h));
		else
			insertMinHeap(h, num);
	}
}