#include <stdio.h>
#include <stdlib.h>
main()
{
    int a[5], b[5], i, j, n, v[10];
    i=0;
    printf("Carica il primo vettore in ordine crescente\n");
    scanf("%d", &a[i]);
    for(i=1;i<5;i++)
    {
        scanf("%d", &a[i]);
        if(a[i]<a[i-1])
        {
            printf("In ordine CRESCENTE...\n");
            scanf("%d", &a[i]);
        }
    }
    printf("Carica il secondo vettore in ordine crescente\n");
    i=0;
    scanf("%d", &b[i]);
    for(i=1;i<5;i++)
    {
        scanf("%d", &b[i]);
        if(b[i]<b[i-1])
        {
            printf("In ordine CRESCENTE...\n");
            scanf("%d", &b[i]);
        }
    }
    for(n=0;n<10;n++)
    {
        if(a[i]<b[j])
        {
            v[n]=a[i];
            i++;
        }
        else
        {
            v[n]=b[j];
            j++;
        }
    }
    printf("Il vettore ordinato e'\n");
    for(i=0;i<10;i++)
    {
        printf("%d\n", v[i]);
    }
}
