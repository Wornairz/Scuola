#include <stdio.h>
#include <stdlib.h>
main()
{
    int v[10], i, j, temp;
    printf("Inserisci 10 valori interi nel vettore\n");
    for (i=0;i<10;i++)
    {
        scanf("%d", &v[i]);
    }
    for (i=0;i<10;i++)
    {
        j=i+1;
        while (j>0 && v[j] < v[j-1])
        {
            temp=v[j];
            v[j]=v[j-1];
            v[j-1]=temp;
            j--;
        }
    }

    printf("Il vettore ordinato e':\n");
    for (i=0;i<10;i++)
    {
    printf("%d|", v[i]);
    }
}
