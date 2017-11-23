#include <stdio.h>
#include <stdlib.h>
main()
{
    int v[10], vtemp[10], i, dim, j, k;
    for(i=0;i<10;i++)
    {
        scanf("%d", &v[i]);
    }
    vtemp[0]=v[0];
    dim=1;
    for(i=1;i<10;i++)
    {
        j=0;
        while(vtemp[j]<v[i] && j<dim)
        {
            j++;
        }
        for(k=dim-1;k>=j;k--)
        {
            vtemp[k+1]=vtemp[k];
        }
        vtemp[j]=v[i];
        dim++;
    }
    for(i=0;i<10;i++)
    {
        printf("%d|", vtemp[i]);
    }
}
