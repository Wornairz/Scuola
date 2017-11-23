#include <stdio.h>
#include <stdlib.h>
#include <string.h>
main()
{
    int giorni[11]={31,59,90,120,151,181,212,243,273,304,334}, gg, mm, aaaa, ggpassati, somma, bisestile=1, s;
    char mese[12][20]={"Gennaio","Febbraio","Marzo","Aprile","Maggio","Giugno","Luglio","Agosto","Settembre","Ottobre","Novembre","Dicembre"}, alfagiorni[7][15]={"Domenica","Lunedi'","Martedi'","Mercoledi'","Giovedi'","Venerdi'","Sabato"};
    do{
    printf("Inserisci una data in formato gg/mm/aaaa\n");
    scanf("%d/%d/%d", &gg, &mm, &aaaa);
    if(aaaa%400==0 || (aaaa%100!=0 && aaaa%4==0)) bisestile=0;
    }while(gg>31 || (bisestile==1 && mm==2 && gg>28) || (bisestile==0 && mm==2 && gg>29) || mm>12 ||  aaaa<1582 || ((mm==4 || mm==6 || mm==9 || mm==11) && gg>30));
    printf("%d %s %d\n", gg, mese[mm-1], aaaa);
    if(bisestile==0) printf("L'anno e' bisestile.\n");
    else printf("L'anno non e' bisestile.\n");
    if(bisestile==0 && mm>2)
     {
         ggpassati=giorni[mm-2]+gg+1;
         printf("Sono passati %d giorni dall'inizio dell'anno.\n",ggpassati);
     }
     else if(mm>1)
     {
           ggpassati=giorni[mm-2]+gg;
           printf("Sono passati %d giorni dall'inizio dell'anno.\n",ggpassati);
     }
    else     printf("Sono passati %d giorni dall'inizio dell'anno.\n",gg);
    somma=gg%7;
    switch(mm)
    {
    case 1:
        {
            if(bisestile==1)
            {
                somma=somma+0;
                break;
            }
            else
            {
                somma=somma+6;
                break;
            }
        }
        case 2:
        {
            if(bisestile==1)
            {
                somma=somma+3;
                break;
            }
            else
            {
                somma=somma+2;
                break;
            }
        }
        case 3: case 11:
        {
            somma=somma+3;
            break;
        }
        case 4: case 7:
        {
            somma=somma+6;
            break;
        }
        case 5:
        {
            somma=somma+1;
            break;
        }
        case 6:
        {
            somma=somma+4;
            break;
        }
        case 8:
        {
            somma=somma+2;
            break;
        }
        case 9: case 12:
        {
            somma=somma+5;
            break;
        }
        case 10:
        {
            somma=somma+0;
            break;
        }
    }
    s=aaaa%100;
    somma=somma+(s%28)+((s%28)/4);
    s=aaaa/100;
    s=s%4;
    switch(s)
    {
        case 0:
            {
                somma=somma+6;
                break;
            }
        case 1:
            {
                somma=somma+4;
                break;
            }
        case 2:
            {
                somma=somma+2;
                break;
            }
        case 3:
            {
                somma=somma+0;
                break;
            }
    }
    somma=somma%7;
    printf("Il giorno della settimana e' %s\n", alfagiorni[somma]);
    system("pause");
}

