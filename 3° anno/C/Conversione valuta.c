#include <stdio.h>
#include <stdlib.h>
void conversione_euro();
void conversione_dollaro();
void conversione_sterline();
void conversione_marchi();
void conversione_franchi();
main()
{
    char valuta[10];
    printf("Inserisci la valuta che vuoi convertire\n");
    scanf("%s", valuta);
    if(strcmp(valuta, "euro")==0)
    {
        conversione_euro();
    }
    else if(strcmp(valuta, "dollaro")==0)
    {
        conversione_dollaro();
    }
    else if(strcmp(valuta, "sterline")==0)
    {
        conversione_sterline();
    }
    else if(strcmp(valuta, "marchi")==0)
    {
        conversione_marchi();
    }
    else if(strcmp(valuta, "franchi")==0)
    {
        conversione_franchi();
    }
    else
    {
        printf("Hai inserito una valuta errata\n");
    }
    system("pause");
}
void conversione_euro()
{
    float moneta;
    char valuta[10];
    printf("Inserisci la valuta in cui convertire\n");
    scanf("%s", valuta);
    system("cls");
    printf("Euro: "); scanf("%f", &moneta);
    if(strcmp(valuta, "dollaro")==0)
    {
        moneta=moneta*1.08005;
        printf("\nDollari: %f\n", moneta);
    }
    else if(strcmp(valuta, "sterline")==0)
    {
        moneta=moneta*0.723421357;
        printf("\nSterline: %f\n", moneta);
    }
     else if(strcmp(valuta, "marchi")==0)
    {
        moneta=moneta*1.95583;
        printf("\nMarchi: %f\n", moneta);
    }
     else if(strcmp(valuta, "franchi")==0)
    {
        moneta=moneta*0.94815;
        printf("\nFranchi: %f\n", moneta);
    }
    else
    {
        printf("Valuta errata.");
    }
    return;
}
void conversione_dollaro()
{
    float moneta;
    printf("Dollari: "); scanf("%f", &moneta);
    moneta=moneta*0.925883061;
    printf("Euro: %f\n", moneta);
    return;
}
void conversione_sterline()
{
    float moneta;
    printf("Sterline: "); scanf("%f", &moneta);
    moneta=moneta*1.38232026;
    printf("Euro: %f\n", moneta);
    return;
}
void conversione_marchi()
{
    float moneta;
    printf("Marchi: "); scanf("%f", &moneta);
    moneta=moneta/1.95583;
    printf("Euro: %f\n", moneta);
    return;
}
void conversione_franchi()
{
    float moneta;
    printf("Franchi: "); scanf("%f", &moneta);
    moneta=moneta/0.94815;
    printf("Euro: %f\n", moneta);
    return;
}
