#include <stdio.h>
#include <stdlib.h>
main()
{
    int A[10][10], B[10][10], C[10][10], D[10][10],i,j,d;
    printf("Inserisci il numero di righe e colonne della matriche quadrata: ");
    scanf("%d", &d);
    printf("Inserisci i numeri della prima matrice\n");
    for(i=0;i<d;i++)
    {
        for(j=0;j<d;j++)
        {
            scanf("%d", &A[i][j]);
        }
    }
    printf("Inserisci i numeri della seconda matrice\n");
    for(i=0;i<d;i++)
    {
        for(j=0;j<d;j++)
        {
            scanf("%d", &B[i][j]);
        }
    }
    for(i=0;i<d;i++)
    {
        for(j=0;j<d;j++)
        {
                C[i][j]=A[i][j]+B[i][j];
        }
    }
    for(i=0;i<d;i++)
    {
        for(j=0;j<d;j++)
        {
                D[i][j]=A[i][j]*B[i][j];
        }
    }
    printf("Somma delle matrici\n");
    for(i=0;i<d;i++)
    {
        for(j=0;j<d;j++)
        {
            printf("%d|", C[i][j]);
        }
        printf("\n");
    }
    printf("Prodotto delle matrici\n");
    for(i=0;i<d;i++)
    {
        for(j=0;j<d;j++)
        {
            printf("%d|", D[i][j]);
        }
        printf("\n");
    }
}
