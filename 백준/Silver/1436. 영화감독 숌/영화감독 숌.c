#pragma warning(disable : 4996)
#include <stdio.h>
#include <stdlib.h>



int isThat(int n) {
	int count = 0;
	int tmp;

	for (int j = 10;; j *= 10) {
		tmp = (n % j)/(j/10);//0을 인식하지..못한다
		if (tmp == 6)
			count++;
		else
			count = 0;//시-발 겨우 이거 한줄떄문에..

		if (count >= 3)
			return 1;
		if (j >= n)
			return 0;
	}
}

int main() {
	
	int n;
	int count = 0;

		scanf("%d", &n);
		count = 0;
		//int range[3] = { 1,39,719 };

		for (int i = 666;; i++) {
			if (isThat(i))
				count++;
			if (count == n) {
				printf("%d\n", i);
				//return 0;
				break;
			}
		}
	
}