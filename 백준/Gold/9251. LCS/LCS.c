#pragma warning(disable : 4996)
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int max1(int a, int b) { // max함수 추가
	return (a > b) ? a : b;
}

int findMax(int *a[],int l1,int l2) {
	int max = a[1][1];

	for (int i = 1; i < l1; i++) {
		for (int j = 1; j < l2; j++)
			if (a[i][j] > max)
				max = a[i][j];
	}
	return max;
}

int LCS(char a[], char b[]) {
	int length1 = strlen(a)+1;
	int length2 = strlen(b)+1;

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
			if (a[i-1] == b[j-1])
				LCS[i][j] = LCS[i-1][j-1] + 1;
			else {
				LCS[i][j] = max1(LCS[i][j-1], LCS[i-1][j ]);
			}
		}
	}
	return findMax(LCS, length1, length2);
	
	
}

int main() {
	char A[1000];
	char B[1000];
	
	scanf("%s%s", A,B);

	printf("%d", LCS(A,B));

}