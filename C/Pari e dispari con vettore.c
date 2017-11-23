// archiviare 10 numeri interi in un vettore e contare quelli pari e quelli dispari //
#include <stdio.h>
#include <stdlib.h>
main()
{
    int i,v[10],cp,cd,r;
    cp=0;
    cd=0;
    printf("Inserisci 10 valori\n");
    for(i=0;i<10;i++)
    {
        scanf("%d", &v[i]);
        r=v[i]%2;
        if(r==0)
        {cp++;}
        else
        {cd++;}
    }
    printf("I numeri pari sono %d e i numeri dispari sono %d\n", cp,cd);
}
