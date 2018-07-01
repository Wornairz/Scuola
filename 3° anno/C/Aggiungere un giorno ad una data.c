#include <stdio.h>
#include <stdlib.h>
main()
{
    int g,m,a,r;
    char risp;
    do{
        printf("Inserisci una data nel formato gg/mm/aaaa\n");
        scanf("%d/%d/%d", &g, &m, &a);
        switch(m)
            {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:    {
                        g++;
                        if(g>31)
                            {
                            m++;
                            g=1;
                            }
                        break;
                        }
            case 2: {
                    g++;
                    r=a%4;
                    if(g>28 && r!=0)
                        {
                        m++;
                        g=1;
                        }
                    else if(g>29 && r==0)
                        {
                            m++;
                            g=1;
                        }
                    break;
                    }
            case 4:
            case 6:
            case 9:
            case 11:
                {
                    g++;
                    if(g>30)
                    {
                        m++;
                        g=1;
                    }
                    break;
                }
            case 12:    {
                        g++;
                        if (g>31)
                        {
                            a++;
                            m=1;
                            g=1;
                        }
                    break;
                    }
            }
    printf("Il giorno seguente e': %d/%d/%d\n", g,m,a);
    printf("Vuoi inserire un'altra data?(Inserire s o n)\n");
    scanf(" %c",&risp);
    }while(risp=='s');
    system("pause");
}
