year=int(input())

def isLeapYear(n):
    if (n % 4==0 and n % 100) or n % 400==0:
        return 1
    else:
        return 0
    
print(isLeapYear(year))