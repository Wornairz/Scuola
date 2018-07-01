#include <stdio.h>
#include <stdlib.h>
#include <math.h>
main ()
{
    int i=0,N,R;

    printf("Inserisci dei numeri e 0 quando finisci\n");
    scanf("%d", &N);

    while(N!=0)
        {
           i++;
           scanf("%d", &N);
        }

    printf("Hai immesso %d numeri", i);
}
