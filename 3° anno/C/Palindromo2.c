#include <stdio.h>
#include <stdlib.h>
main()
{
    int i=0, j, flag=0;
    char v[15], a[15];
    printf("Inserisci una parola\n");
    scanf("%s", &v);
    v[15]=a[15];
    j=15;
    while(i<5)
    {
        if(v[i]==a[j])
        {
            flag++;
        }
        else
        {
            flag=0;
        }
        i++;
        j--;
    }
    if(flag==0)
    {
        printf("La string non e' palindroma\n");
    }
    else
    {
        printf("La stringa e' palindroma\n");
    }
}
