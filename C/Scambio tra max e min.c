#include <stdio.h>
#include <stdlib.h>
#include <math.h>
main()
{
    int v[10],i,min,max;
    srand(time(NULL));
    min=100;
    max=0;
    for(i=0;i<10;i++)
    {
        v[i]=(rand()%100)+1;
        printf("%d\n", v[i]);
        if(min>v[i])
        {min=v[i];}
        if(max<v[i])
        {max=v[i];}
    }
    printf("Il valore minimo e' %d e il valore max e' %d\n", min, max);
    i=min;
    min=max;
    max=i;
    printf("Il valore minimo e' %d e il valore max e' %d\n", min, max);
}
