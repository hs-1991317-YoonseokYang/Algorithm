#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main() {
	int n;
	int a = 4;
	int b = 2;
	scanf("%d", &n);

		for (int i = 1; i <= n; i++) {
			b *= 2;
			a = a * 4 - (b+3);
		}
	
	printf("%d", a);
}