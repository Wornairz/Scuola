#include <stdio.h>
#include <stdlib.h>
int main()
{
    int i=0, j, c, flag=0;
    float l;
    char v[15], a[15];
    printf("Inserisci una parola\n");
    scanf("%s", &v);
    j=lunghezza(v)-1;
    l=j/2;
    c=j;
    while(i<l)
    {
        a[i]=v[c];
        i++;
        c--;
    }
    for(i=0;i<l;i++)
    {
        if(v[i]==a[i])
        {
            flag=1;
        }
        else
        {
            flag=0;
            break;
        }
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
int lunghezza(char stringa[15])
{
    int l=0;
    while(stringa[l]!='\0')
    {
        l++;
    }
    return l;
}
