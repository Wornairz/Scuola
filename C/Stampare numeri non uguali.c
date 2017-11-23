#include <stdio.h>
#include <stdlib.h>
#include <math.h>
main()
{
    int v[10],i,j,flag;
    printf("Inserisci 10 valori\n");
    for(i=0;i<10;i++)
    {
        scanf("%d", &v[i]);
    }
    for(i=0;i<10;i++)
    {
        flag=0;
        for(j=i+1;j<10;j++)
        {
            if(v[i]==v[j])
            {
                flag=1;
            }
        }
        if(flag==0)
        {
            printf("%d\n", v[i]);
        }
    }
}
