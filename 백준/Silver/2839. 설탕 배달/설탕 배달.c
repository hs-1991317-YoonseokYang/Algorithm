#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>



int main() {
	int n, tmp;
	int f = 0;
	int t = 0;
	
	scanf("%d", &n);
	if (n == 4||n==7) {
		printf("-1");
		return 0;
	}

	else if (n % 5 == 0) {
		f = n / 5;	
	}
	else {
		f = n / 5;
		tmp = n - 5 * f;
		t = tmp / 3;

		if (tmp % 3 == 1) {
			f--;
			t += 2;
		}
		else if (tmp % 3 == 2) {
			f -= 2;
			t += 4;
		}
	}

	printf("%d", f + t);
}