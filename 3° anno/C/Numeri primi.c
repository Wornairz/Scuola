#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

main()
{
    int numero;
    printf("Inserisci un numero\n");
    scanf("%d", &numero);
    boolean flag = false;
    for(int i=0; i<numero/2; i++){
        if(numero%i == 0){
            flag = true;
            break;
        }
    }
    if(flag)
        printf("Il numero %d e' primo", numero);
    else
        printf("Il numero %d non e' primo", numero);
}
