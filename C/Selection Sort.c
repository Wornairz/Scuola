#include <stdio.h>
#include <stdlib.h>
main()
{
    int v[10], i, j, temp;
    printf("Carica il vettore da ordinare\n");
    for(i=0;i<10;i++)
    {
        scanf("%d", &v[i]);
    }
    for(i=0;i<9;i++)
    {
        for(j=i+1;j<10;j++)
        {
            if(v[j]<v[i])
            {
                temp=v[i];
                v[i]=v[j];
                v[j]=temp;
            }
        }
    }
    printf("Il vettore ordinato e':\n");
    for(i=0;i<10;i++)
    {
        printf("%d|", v[i]);
    }
}
