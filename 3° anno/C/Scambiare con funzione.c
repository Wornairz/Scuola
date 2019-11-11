#include <stdio.h>
#include <stdlib.h>
void scambia();
main()
{
    int x, y;
    printf("Inserisci il valore di X: "); scanf("%d", &x);
    printf("Inserisci valore di Y: "); scanf("%d", &y);
    if(x>y)
    {
        scambia(&x,&y);
    }
    printf("valore di X: %d\nvalore di Y: %d", x ,y);
}
void scambia(int *x, int *y)
{
    int z;
    z=*x;
    *x=*y;
    *y=z;
}
