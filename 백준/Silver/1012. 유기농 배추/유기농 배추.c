#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
# define MAX 50
 
void DFS(int filed[][MAX], int x, int y, int h, int w) {
	if (filed[y][x] == 1) {
		filed[y][x] = 0;
		if (x < w - 1)
			DFS(filed, x +1, y, h, w);
		if(y<h-1)
			DFS(filed, x , y+1, h, w);
		if(x>0)
			DFS(filed, x-1, y , h, w);
		if(y>0)
			DFS(filed, x, y-1, h, w);
	}
	return;
}

int main() {
	int testCase = 0;
	int width = 0, height = 0, numberOfCabbage = 0;
	//int** filed = NULL;
	int x = 0, y = 0;//배추의 주소
	int count;

	scanf("%d", &testCase);
	for (int i = 0; i < testCase; i++) {
		count = 0;
		scanf("%d %d %d", &width, &height, &numberOfCabbage);
		

		/*filed = (int**)malloc(sizeof(int*) * height);
		for (int t = 0; t < height; t++) filed[t] = (int*)malloc(sizeof(int) * width);//동적할당 완료
		for (int i = 0; i < height; i++)
			for (int t = 0; t < width; t++)
				filed[i][t] = 0;//배열 초기화
		*/
		int filed[MAX][MAX] = { 0 };

		for (int k = 0; k < numberOfCabbage; k++) {
			scanf("%d %d", &x, &y);
			filed[y][x] = 1;//배추가 있다.
		}

		for (int i = 0; i < height; i++) 
			for (int t = 0; t < width; t++) {
				if (filed[i][t] == 0)
					continue;
				DFS(filed, t, i, height, width);
				count++;
			}
		printf("%d\n", count);


	}
	//free(filed);
}