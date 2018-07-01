#include <stdio.h>
#include <stdlib.h>
main ()
{
    int B,H,i,j;
    printf("Inserisci la base e l'altezza del quadrilatero\n");
    scanf("%d%d", &B, &H);
    for(i=0;i<H;i++)
    {
        for(j=0;j<B;j++)
        {
            printf("*");
        }
        printf("\n");
    }
}
