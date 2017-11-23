#include <stdio.h>
#include <stdlib.h>
main()
{
    int v[3][31], i, j, max[31];
    for(j=0;j<31;j++)
    {
        for(i=0;i<3;i++)
        {
            printf("Inserisci la temperatura della citta' %d nel giorno %d: ",i,j);
            scanf("%d", &v[i][j]);
            if(v[i][j]>v[i-1][j])
            {
                max[j]=v[i][j];
            }
        }
    }
    for(i=0;i<31;i++)
    {
       printf("La temperatura max del giorno %d e' stata %d\n",i, max[i]);
    }
}
