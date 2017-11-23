#include <stdio.h>
#include <stdlib.h>
#include <math.h>
main ()
{
    int i,N,N1,R;
    i=0;
    printf("Inserisci dei numeri e 0 quando finisci\n");
    scanf("%d", &N);
    R=N;
    while(N>0)
        {
           scanf("%d", &N);
           if(R>N)
           {
               R=N;
           }
        }
    printf("Il valore minimo e' %d", R);
}
