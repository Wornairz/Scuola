#include <stdio.h>
#include <stdlib.h>
main ()
{
    int n,i,c;
    printf("Inserisci un numero\n");
    scanf("%d", &n);
    i=n-1;
    while(i!=0)
    {
        c=n*i;
        for(i=n-2;i!=0;i--)
            {
                c=c*i;
            }
    }
    if(n==0 || n==1)
    {
        c=1;
    }
    printf("Il fattoriale e' %d\n", c);
    system("pause");
}
