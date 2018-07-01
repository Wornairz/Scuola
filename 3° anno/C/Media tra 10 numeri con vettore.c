// calcolare il valore medio tra 10 numeri interi archiviati in un vettore di nome vett //
#include <stdio.h>
#include <stdlib.h>
main ()
{
    int i,vett[10],med,s;
    s=0;
    printf("Inserisci 10 valori\n");
    for(i=0;i<10;i++)
    {
        scanf("%d", &vett[i]);
        s=s+vett[i];
    }
    med=s/10;
    printf("la media e'%d", med);
}
