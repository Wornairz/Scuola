#include <stdio.h>
#include <stdlib.h>
main()
{
    int m[10][10], i, j, N, flag=0;
    printf("Inserisci la dimensione della matrice quadrata:"); scanf("%d", &N);
    printf("\n");
    for(i=0;i<N;i++)
    {
        for(j=0;j<N;j++)
        {
            scanf("%d", &m[i][j]);
        }
    }
    for(i=0;i<N && flag==0;i++)
    {
        for(j=0;j<N && flag==0;j++)
        {
            if(m[i][j]==m[j][i])
            {
                flag=0;
            }
            else
            {
                flag=1;
            }
        }
    }
    if(flag==0)
    {
        printf("La matrice e' simmetrica\n");
    }
    else
    {
        printf("La matrice non e' simmetrica\n");
    }
    for(i=0;i<N;i++)
    {
        for(j=0;j<N;j++)
        {
            printf("%d|", m[i][j]);
        }
        printf("\n");
    }
}
