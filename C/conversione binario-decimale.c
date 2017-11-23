#include <stdio.h>
#include <stdlib.h>
main()
{
    int A,B,C,D,S;
    printf("Inserisci un numero binario da 4 bit\n");
    scanf("%d%d%d%d", &A, &B, &C, &D);
    A=A*8;
    B=B*4;
    C=C*2;
    D=D*1;
    S=A+B+C+D;
    printf("Il numero equivalente in decimale e': %d\n", S);
    system("pause");
}
