#include <stdio.h>
#include <stdlib.h>
main()
{
    int M[10][20],v[10],i,j,r,c,b;
    printf("Inserisci il numero di righe: ");
    scanf("%d", &r);
    printf("Inserisci il numero di colonne: ");
    scanf("%d", &c);
    printf("Inserisci dei numeri\n");
    for(i=0;i<r;i++)
    {
        for(j=0;j<c;j++)
        {
            scanf("%d", &M[i][j]);
        }
    }
    for(i=0;i<r;i++)
    {
        for(j=0;j<c;j++)
        {
            printf("%d|", M[i][j]);
        }
        printf("\n");
    }
            for(i=0;i<r;i=i+2)
            {
                b=0;
                for(j=0;j<c;j++)
                {
                    v[b]=M[i][j];
                    b++;
                }
                for(j=0;j<c;j++)
                {
                    M[i][j]=M[i+1][j];
                }
                for(j=0;j<c;j++)
                {
                    M[i+1][j]=v[j];
                }
            }
            printf("\n");
    for(i=0;i<r;i++)
    {
        for(j=0;j<c;j++)
        {
            printf("%d|", M[i][j]);
        }
        printf("\n");
    }
}
