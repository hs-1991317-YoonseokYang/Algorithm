#pragma warning(disable : 4996)
#include <stdio.h>
#include <stdlib.h>
#define BLACK 'B'
#define WHITE 'W'

int checkColor(char chessboard[][8]) {
	int numberOfPainting = 0;
	int count1 = 0;
	int count2 = 0;

		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++) {
				if ((i + j) % 2 == 0) {//홀수
					if (chessboard[i][j] == 'B')
						count1++;
				}
				else {//짝수
					if (chessboard[i][j] == 'W')
						count1++;
				}
			}

		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++) {
				if ((i + j) % 2 == 0) {
					if (chessboard[i][j] == 'W')
						count2++;
				}
				else {
					if (chessboard[i][j] == 'B')
						count2++;
				}
			}
		if (count1 < count2)
			return count1;
		return count2;
	
}

void cutInto8by8(char *board[],int n, int m) {//행과 열의 크기를 같이 전달해줘서 ㄱㅊ은가?
	int x = m - 8, y = n - 8;
	int min = 64;
	int tmp;
	char chessboard[8][8];

	for (int a = 0; a <= y; a++) {
		for (int b = 0; b <= x; b++) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					chessboard[i][j] = board[a + i][b + j];
				}
			}
			/*for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					printf("%c", chessboard[i][j]);
				}
				printf("\n");
			}*/

				tmp = checkColor(chessboard);
				if (tmp < min)
					min = tmp;
			
		}//이게 부르트포스 아닌가? 다 잘랐다.
	}

	printf("%d", min);
	
	/*for (int i = 0; i < 8; i++)
		free(chessboard[i]);
	free(chessboard);*/
}

int main() {
	int min = 0;
	int n, m;
	
	scanf("%d%d", &n, &m);
	getchar();
	char** board = (char**)malloc(sizeof(char*) * n);
	for (int i = 0; i < n; i++)
		board[i] = (char*)malloc(sizeof(char) * m);
	
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%c", &board[i][j]);
		}
		getchar();
	}

	/*for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			printf("%c",board[i][j]);
		}
		printf("\n");
	}*/

	cutInto8by8(board, n, m);
	
}