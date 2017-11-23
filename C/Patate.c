#include <stdio.h>
#include <stdlib.h>
#include <math.h>
main ()
{
    int P,C,S;
    C=0;
    S=0;
    printf("Quanti kg di patate hai comprato?\n");
    scanf("%d", &P);
    if (P>=30)
        {
        P=P-30;
        C=C+1;
        }
    if (P>=30)
        {
        P=P-30;
        C=C+1;
        }
    if (P>=5 && P<30)
        {
        P=P-5;
        S=S+1;
        }
    if (P>=5 && P<30)
        {
        P=P-5;
        S=S+1;
        }
    if (P>=5 && P<30)
        {
        P=P-5;
        S=S+1;
        }
    if (P>=5 && P<30)
        {
        P=P-5;
        S=S+1;
        }
    printf("Cassete necessarie=%d, Sacchetti necessari=%d\n",C,S);
    system("pause");
}

