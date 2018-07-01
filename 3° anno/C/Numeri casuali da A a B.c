#include <stdio.h>
#include <stdlib.h>
main()
{
    int n,a,b,i,r;
    srand(time(NULL));
    printf("Inserisci il numero minore da cui generare i numeri\n");
    scanf("%d", &a);
    printf("Inserisci il massimo numero da generare\n");
    scanf("%d", &b);
    r=b-a;
    printf("I numeri generati sono:\n");
    for(i=0;i<=50;i++)
    {
        n=(rand()%r)+a;
        printf("%d\n", n);
    }
}
