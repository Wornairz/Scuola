#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
main()
{
    int A[10][10], N, i, j, flag=0;
    printf("Inserisci la dimensione della matrice quadrata:"); scanf("%d", &N);
    printf("\n");
    for(i=0;i<N;i++)
    {
        for(j=0;j<N;j++)
        {
            scanf("%d", &A[i][j]);
        }
    }
    for(i=0;i<N;i++)
    {
        for(j=0;j<N;j++)
        {
            printf("%d|", A[i][j]);
        }
        printf("\n");
    }
    for(i=0;i<N;i++)
    {
        for(j=0;j<N;j++)
        {
                if(i==j && A[i][j]!=0)
                {
                    flag=0;
                }
                else if(i==j && A[i][j]==0)
                {
                    flag=1;
                }
        }
    }
    if(flag==0)
    {
        printf("La matrice e' diagonale\n");
    }
    else
    {
        printf("La matrice non e' diagonale");
    }
}
