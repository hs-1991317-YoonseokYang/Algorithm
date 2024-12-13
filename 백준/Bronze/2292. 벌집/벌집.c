#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main() {
	//0~n번쨰 테두리에 있는 벌집 개수 =3*n(n+1)+1
	int n;
	scanf("%d", &n);

	for (int i = 0;; i++) {
		if (3 * i * (i + 1) + 1 >= n) {
			printf("%d", i + 1);
			break;
		}
	}

}
