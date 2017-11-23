#include <stdio.h>
#include <stdlib.h>
#include <math.h>
main()
{
    int v[10],i;
    srand(time(NULL));
    printf("Inserisci un valore\n");
    for(i=0;i<10;i++)
    {
        v[i]=(rand()%100)+1;
        printf("%d\n", v[i]);
        v[i]=pow(v[i],2);
        printf("Il quadrato e' %d\n", v[i]);
    }
}
