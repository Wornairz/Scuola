#include <stdio.h>
#include <stdlib.h>
int N,NUM,vett1[50], vett2[50], vett3[30], c, l;
void input();
void caricamento();
void assegnamento();
void output();
main()
{
    input();
    caricamento();
    assegnamento();
    output();
}
void input()
{
    printf("Inserisci la grandezza del vettore\n");
    scanf("%d", &N);
}
void caricamento()
{
    int i;
    printf("Inserisci i numeri\n");
    for(i=0;i<N;i++)
    {
        scanf("%d", &vett1[i]);
    }
}
void assegnamento()
{
    int i;
    printf("Inserisci il numero da cercare\n");
    scanf("%d", &NUM);
    for(i=0;i<N;i++)
    {
        if(NUM<vett1[i])
        {
            vett2[c]=vett1[i];
            c++;
        }
        else if(NUM>vett1[i])
        {
            vett3[l]=vett1[i];
            l++;
        }
    }
}
void output()
{
    int i;
    printf("I numeri maggiori di %d sono:\n", NUM);
    for(i=0;i<c;i++)
    {
        printf("%d:", vett2[i]);
    }
    printf("\nI numeri minori di %d sono:\n", NUM);
    for(i=0;i<l;i++)
    {
        printf("%d:", vett3[i]);
    }
}
