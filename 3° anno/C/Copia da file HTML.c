#include <stdio.h>
#include <stdlib.h>
main()
{
    FILE *input, *output;
    char v;
    input=fopen("lol.html", "r");
    output=fopen("hihi.txt", "w");
    while(!feof(input))
    {
        fscanf(input, "%c", &v);
        if(v=='<')
        {
            printf("%c", v);
            while(v!='>')
            {
                fscanf(input, "%c", &v);
                printf("%c", v);
            }
            printf("\n");
        }
        else
        {
            fprintf(output, "%c", v);
        }

    }
    fclose(output);
    fclose(input);
}
