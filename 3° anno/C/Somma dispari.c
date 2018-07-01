#include <stdio.h>
#include <stdlib.h>
main ()
{
    int N,R,i,S;
    i=0;
    S=0;
    printf("Inserisci dei numeri dispari\n");
    scanf("%d", &N);
    R=N%2;
    while(R!=0)
        {
        S=S+N;
        printf("La somma e': %d\n",S);
        scanf("%d", &N);
        R=N%2;
        }
}
