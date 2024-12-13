#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

typedef struct Data {
	int x;
	int y;
	int z;
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

void enqueue(Queue* q, int x, int y,int z) {
	Node* temp = (Node*)malloc(sizeof(Node));
	temp->data.x = x;
	temp->data.y = y;
	temp->data.z = z;
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
	temp = q->front;
	Data data;

	if (is_empty(q)) {
		printf("비어있음");
		exit(1);
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



int BFS(int*** box, Queue* queue, int w, int h, int l ) {
	Data data;
	int num;
	int x, y, z;
	int day = 0;

	while (!is_empty(queue)) {
		num = queue->count;
		for (int i = 0; i < num; i++) {
			data = dequeue(queue);
			x = data.x;
			y = data.y;
			z = data.z;

			if (x < w - 1)
				if (box[z][y][x + 1] == 0) {
					box[z][y][x + 1] = 1;
					enqueue(queue, x + 1, y,z);
				}
			if (y < h - 1)
				if (box[z][y + 1][x] == 0) {
					box[z][y + 1][x] = 1;
					enqueue(queue, x, y + 1,z);
				}
			if (z < l - 1)
				if (box[z+1][y][x] == 0) {
					box[z+1][y][x] = 1;
					enqueue(queue, x, y, z+1);
				}
			if (x > 0)
				if (box[z][y][x - 1] == 0) {
					box[z][y][x - 1] = 1;
					enqueue(queue, x - 1, y,z);
				}
			if (y > 0)
				if (box[z][y - 1][x] == 0) {
					box[z][y - 1][x] = 1;
					enqueue(queue, x, y - 1,z);
				}
			if (z > 0)
				if (box[z-1][y][x] == 0) {
					box[z-1][y][x] = 1;
					enqueue(queue, x, y, z-1);
				}
			

		}
		day++;
	}
	return --day;

}



int main() {
	int w, h, l = 0;
	int*** box;
	int day = 0;
	Queue queue;

	init(&queue);


	scanf("%d %d %d", &w, &h ,&l);
	box = (int***)malloc(sizeof(int**) * l);
	for (int i = 0; i < l; i++) {
		box[i] = (int**)malloc(sizeof(int*) * h);
		for (int t = 0; t < h; t++) {
			box[i][t]= (int*)malloc(sizeof(int) * w);
		}
	}
		
	for(int k=0;k<l;k++)
		for (int i = 0; i < h; i++)
			for (int t = 0; t < w; t++) {
				scanf("%d", &box[k][i][t]);
			}
	for (int z = 0; z < l; z++)
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				if (box[z][y][x] == 1)
					enqueue(&queue, x, y,z);
			}
		}

	day = BFS(box, &queue, w, h,l);
	//마지막으로 0이 있는지 확인
	for (int z = 0; z < l; z++)
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				if (box[z][y][x] == 0) {
					printf("-1");
					return 0;
				}
			}
		}
	printf("%d", day);
	return 0;
}
