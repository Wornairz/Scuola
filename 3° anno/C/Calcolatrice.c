#include <stdio.h>
#include <stdlib.h>
#include <math.h>
main ()
{
    int A,B,x,R;
    printf("Inserisci due numeri\n");
    scanf("%d%d", &A, &B);
    printf("Inserisci un tasto per eseguire le diverse operazione:\n1-Somma\n2-Sottrazione\n3-Moltiplicazione\n4-Divisione\n");
    scanf("%d", &x);
    switch(x)
    {
    case 1:{R=A+B;break;}
    case 2:{R=A-B;break;}
    case 3:{R=A*B;break;}
    case 4:{R=A/B;break;}
    default:{printf("Sei stupido, ho detto da 1 a 4.\n");}
    }
    printf("Il risultato e' %d", R);
}
