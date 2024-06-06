#pragma warning(disable : 4996)
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* findLCSubstring(int** LCS, char a[], int row, int column);

int max1(int a, int b) { // max함수 추가
	return (a > b) ? a : b;
}

int findMax(int* a[], int l1, int l2) {
	int max = a[1][1];

	for (int i = 1; i < l1; i++) {
		for (int j = 1; j < l2; j++)
			if (a[i][j] > max)
				max = a[i][j];
	}
	return max;
}

void LCS(char a[], char b[]) {
	int length1 = strlen(a) + 1;
	int length2 = strlen(b) + 1;

	int** LCS;

	LCS = (int**)malloc(sizeof(int*) * length1);
	for (int i = 0; i < length1; i++)
		LCS[i] = (int*)malloc(sizeof(int) * length2);

	for (int i = 0; i < length1; i++)
		LCS[i][0] = 0;
	for (int j = 0; j < length2; j++)
		LCS[0][j] = 0;
	//초기화

	for (int i = 1; i < length1; i++) {
		for (int j = 1; j < length2; j++) {
			if (a[i - 1] == b[j - 1])//문자열의 인덱스는 0부터 시작
				LCS[i][j] = LCS[i - 1][j - 1] + 1;
			else {
				LCS[i][j] = max1(LCS[i][j - 1], LCS[i - 1][j]);
			}
		}
	}
	printf("%d\n",findMax(LCS, length1, length2));
	printf("%s",findLCSubstring(LCS, a, length1, length2));
}

char* findLCSubstring(int** LCS, char a[], int row,int column) {
	//재귀적으로 가능할듯
	int r, c;
	r = row-1;//이건 LCS의 열 길이. 문자열의 길이보다 1 크다. 
	c = column-1;
	char* result;
	int index = 0;
	
	result = (char*)malloc(sizeof(char) * r);//배열은 row와 column 중 작은 값 만큼의 크기만 가져도 된다. 따라서 임의로 r로 하여도 문제 없음

	while (1) {
		if (LCS[r][c] == 0)
			break;
		if (LCS[r][c] == LCS[r - 1][c]) {
			r = r - 1;
			continue;
		}
		if (LCS[r][c] == LCS[r][c - 1])
			c = c - 1;
		else {
			//strcat(result, a[r - 1]);
			result[index] = a[r - 1];
			result[index + 1] = '\0';
			index += 1;
			
			r = r - 1, c = c - 1;
		}
	}

	char tmp;
	int len = strlen(result);
	for (int i = 0; i < len/2; i++) {
		tmp = result[i];
		result[i] = result[len - 1 - i];
		result[len - 1 - i] = tmp;
	}
	return result;

}

int main() {
	char A[1001];
	char B[1001];

	scanf("%s%s", A, B);

	LCS(A, B);
	
}