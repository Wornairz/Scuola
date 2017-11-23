#include <stdio.h>
#include <stdlib.h>
main()
{
    FILE *input;
    input=fopen("Numeri.txt", "r+");
    int v[30], i, j, temp,l=0;
    while(!feof(input))
    {
        fscanf(input, "%d", &v[l]);
        l++;
    }
    for(i=0;i<l-1;i++)
    {
        for(j=i+1;j<l;j++)
        {
            if(v[j]<v[i])
            {
                temp=v[i];
                v[i]=v[j];
                v[j]=temp;
            }
        }
    }
    fputs("\n", input);
    for(i=0;i<l;i++)
    {
        fprintf(input, "%d|", v[i]);
    }
    fclose(input);
}
