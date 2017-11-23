#include <stdio.h>
#include <stdlib.h>
#include <math.h>
main ()
{
    int A,B,x,i,R;
    i=0;
    x=1;
    printf("Inserisci due numeri\n");
    scanf("%d%d", &A,&B);
    while (i<x)
    {
        printf("Inserisci un tasto per eseguire le diverse operazione:\n0-Esci dal programma\n1-Somma\n2-Sottrazione\n3-Moltiplicazione\n4-Divisione\n");
        scanf("%d", &x);
        switch(x)
            {
        case 0:{x=0;break;}
        case 1:{R=A+B;break;}
        case 2:{R=A-B;break;}
        case 3:{R=A*B;break;}
        case 4:{R=A/B;break;}
        default:{printf("Sei stupido, ho detto da 1 a 4.\n");}
            }
        if (x>=0 && x<=4)   {
                    printf("Il risultato e' %d \n", R);
                    }
    }

    system("pause");
}
