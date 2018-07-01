#include <stdio.h>
#include <stdlib.h>
main()
{
    int A,R,i;
    i=0;
    printf("Inserisci dei numeri pari, inseriscine uno dispari quando finisci\n");
    scanf("%d", &A);
    R=A%2;
    while(R==0)
        {
        i++;
        scanf("%d", &A);
        R=A%2;
        }
    printf("Hai inserito %d numeri pari", i);

}
