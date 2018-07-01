#include <stdio.h>
#include <stdlib.h>
main()
{
    int i=0, j, flag=0;
    float l;
    char v[15];
    printf("Inserisci una parola\n");
    scanf("%s", &v);
    while(v[i]!='\0')
    {
        i++;
    }
    printf("la lunghezza e'%d\n", i);
    j=i-1;
    l=j/2;
    i=0;
    while(i<l)
    {
        if(v[i]==v[j])
        {
            flag=1;
        }
        else
        {
            flag=0;
            break;
        }
        i++;
        j--;
    }
    if(flag==0)
    {
        printf("La stringa non e' palindroma\n");
    }
    else
    {
        printf("La stringa e' palindroma\n");
    }
}
