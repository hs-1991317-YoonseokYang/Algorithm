#pragma warning(disable : 4996)
#include <stdio.h>
#include <stdlib.h>

typedef struct Data {
	int x;
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

void enqueue(Queue* q, int x) {
	Node* temp = (Node*)malloc(sizeof(Node));
	temp->data.x = x;
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


void BFS(int v, int* map[], int visited[],int N) {//큐를 사용하거나 재귀적으로
	Queue q;
	init(&q);

	visited[v] = 1;
	enqueue(&q, v);
	printf("%d ", v);
	
	while (!is_empty(&q)) {
		v=dequeue(&q).x;
		
		for (int i = 1; i <= N; i++) {
			if (map[v][i] && !visited[i]) {
				visited[i] = 1;
				printf("%d ", i);
				enqueue(&q, i);
			}
		}

	}
}

void DFS(int v, int* map[], int visited[], int N) {
	visited[v] = 1;
	printf("%d ", v);
	for (int i = 1; i <= N; i++) {
		if (map[v][i] && !visited[i])
			DFS(i, map, visited, N);
	}
	
}

int main() {
	int N, M, V;
	int** map;
	int a, b;
	int* visited;
	scanf("%d%d%d", &N, &M, &V);

	map = (int**)malloc(sizeof(int*) * (N+1));//정점 번호는 1~N이다 <-
	for(int i=0;i<=N;i++)
		map[i]= (int*)malloc(sizeof(int) * (N+1));//그래프를 배열로 구현함.

	visited = (int*)malloc(sizeof(int) * (N+1));//방문여부 표시 배열
	

	for (int i = 1; i <= N; i++)
		for (int j = 1; j <= N; j++)
			map[i][j] = 0;

	for (int i = 0; i < M; i++) {
		scanf("%d%d", &a, &b);
		map[a][b] = 1;//dfs, bfs 함수 내에서 이 배열을 수정하면 안 될 듯.
		map[b][a] = 1;
	}

	/*for (int i = 1; i <= N; i++) {
		printf("\n");
		for (int j = 1; j <= N; j++)
			printf("%d ",map[i][j]);
	}*/

	for (int i = 1; i < N + 1; i++)
		visited[i] = 0;
	DFS(V, map, visited, N);
	printf("\n");

	for (int i = 1; i < N + 1; i++)
		visited[i] = 0;
	BFS(V, map, visited, N);
}