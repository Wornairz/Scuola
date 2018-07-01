#include <stdio.h>
#include <stdlib.h>
main()
{
    int n,d,i,r,range,c;
    c=0;
    srand(time(NULL));
    printf("Inserisci il numero di numeri da generare\n");
    scanf("%d",&n);
    printf("Inserisci il range di numeri da far generare\n");
    scanf("%d",&range);
    printf("Inserisci il numero da controllare\n");
    scanf("%d",&d);
    for(i=0;i<=n;i++)
    {
    r=(rand()%range)+1;
    if(r==d)
        {
        c++;
        }
    }
    printf("Il numero e' uscito %d volte", c);
}
