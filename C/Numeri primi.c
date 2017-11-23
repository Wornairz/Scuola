#include <stdio.h>
#include <stdlib.h>

main()
{
    int A,R,B,i;
    printf("Inserisci un numero\n");
    scanf("%d", &A);
    R=A%2;
    if (R==0)
        {
            printf("2\n");
        }
    R=A%3;
    if (R==0)
        {
            printf("3\n");
        }
    R=A%5;
    if (R==0)
        {
            printf("5\n");
        }
    R=A%7;
    if (R==0)
        {
            printf("7\n");
        }
    R=A%11;
    if (R==0)
        {
            printf("11\n");
        }
    R=A%13;
    if (R==0)
        {
            printf("13\n");
        }
    R=A%17;
    if (R==0)
        {
            printf("17\n");
        }
    R=A%19;
    if (R==0)
        {
            printf("19\n");
        }

}
