#include <stdio.h>
#include <stdlib.h>
main()
{
    int v[11],i,ins=0;
    float s=0;
    printf("Inserisci i voti\n");
    for(i=0;i<11;i++)
    {
    scanf("%d", &v[i]);
    if(v[i]<6)
    {ins++;}
    s=s+v[i];
    }
    s=s/11;
    printf("La media e' %f e le insufficienze sono %d\n", s, ins);
}
