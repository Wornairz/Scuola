#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int main()
{
    int s,i;
    scanf("%d", &s);
    s=quadrato(s);
    printf("Il quadrato e' %d", s);
}
int quadrato(int b)
{
    b=pow(b,2);
    return b;
}
