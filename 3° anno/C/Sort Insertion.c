#include <stdio.h>
#include <stdlib.h>
void caricamento();
void ordinamento();
void stampa();
int v[10], vtemp[10];
main()
{
    caricamento();
    ordinamento();
    stampa();
}
void caricamento()
{
    int i;
    printf("Inserisci 10 numeri\n");
    for(i=0;i<10;i++)
    {
        scanf("%d", &v[i]);
    }
    vtemp[0]=v[0];
}
void ordinamento()
{
    int dim=1, i, j, k;
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
}
void stampa()
{
    int i;
    for(i=0;i<10;i++)
    {
        printf("%d|", vtemp[i]);
    }
}
