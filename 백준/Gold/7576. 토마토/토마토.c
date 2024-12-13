#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

typedef struct Data {
	int x;
	int y;
}Data;

typedef struct Node {
	Data data;
	struct Node* link;
	
}Node;

typedef struct {
	Node* front, * rear;
	int count;
}Queue;

int is_empty(Queue* q);

void enqueue(Queue* q, int x, int y) {
	Node* temp = (Node*)malloc(sizeof(Node));
	temp->data.x = x;
	temp->data.y = y;
	temp->link = NULL;

	if (is_empty(q)) {
		q->front = temp;
		q->rear = temp;
	}
	else {
		q->rear->link = temp;
		q->rear = temp;
	}
	q->count++;
}

Data dequeue(Queue* q) {
	Node* temp = (Node*)malloc(sizeof(Node));
	temp=q->front;
	Data data;

	if (is_empty(q)) {
		printf("비어있음");
		exit(0);
	}
	else {
		data = temp->data;
		q->front = temp->link;
		if (q->front == NULL)
			q->rear = NULL;
		free(temp);
	}
	q->count--;
	return data;//here
}

void init(Queue* q) {
	q->front = q->rear = 0;//이게 null인가?
	q->count = 0;
}

int is_empty(Queue* q) {
	return(q->front == NULL);
}



int BFS(int** box, Queue* queue,int w, int h) {
	Data data;
	int num;
	int x, y;
	int day = 0;

	while (!is_empty(queue)){
		 num= queue->count;
		for (int i = 0; i < num; i++) {
			data = dequeue(queue);
			x = data.x;
			y = data.y;

			if (x < w - 1)
				if (box[y][x + 1] == 0) {
					box[y][x + 1] = 1;
					enqueue(queue, x + 1, y);
				}
			if (y < h - 1)
				if (box[y + 1][x] == 0) {
					box[y + 1][x] = 1;
					enqueue(queue, x, y + 1);
				}
			if (x > 0)
				if (box[y][x - 1] == 0) {
					box[y][x - 1] = 1;
					enqueue(queue, x - 1, y);
				}
			if (y > 0)
				if (box[y - 1][x] == 0) {
					box[y - 1][x] = 1;
					enqueue(queue, x, y - 1);
				}

		}
		day++;
	}
	return --day;

}



int main() {
	int w, h = 0;
	int** box;
	int day = 0;
	Queue queue;

	init(&queue);
	

	scanf("%d %d", &w, &h);
	box = (int**)malloc(sizeof(int*) * h);
	for (int i = 0; i < h; i++) box[i] = (int*)malloc(sizeof(int) * w);

	for (int i = 0; i < h; i++)
		for (int t = 0; t < w; t++) {
			scanf("%d", &box[i][t]);
		}
	
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				if (box[y][x] == 1)
					enqueue(&queue, x, y);
			}
		}

		day=BFS(box, &queue,w,h);
		//마지막으로 0이 있는지 확인
		
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				if (box[y][x] == 0) {
					printf("-1");
					return 0;
				}
			}
		}
		printf("%d", day);
		return 0;
}
