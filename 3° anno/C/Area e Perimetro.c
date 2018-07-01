#include <stdio.h>
#include <stdlib.h>
#include <math.h>
main()
{
    int a, b, c, d;
    printf("Inserisci:\n1) Triangolo\n2) Cerchio\n3) Poligono Regolare\n");
    scanf("%d", &a);
    switch(a)
    {
        case 1:
            {
                printf("Inserisci la dimensione della base, dei 2 lati e l'altezza\n");
                printf("Base: "); scanf("%d", &b);
                printf("Lato 1: "); scanf("%d", &a);
                printf("Lato 2: "); scanf("%d", &c);
                printf("Altezza: "); scanf("%d", &d);
                triangolo(a, b, c, d);
                break;
            }
        case 2:
            {
                printf("Inserisci la misura del raggio: "); scanf("%d", &a);
                cerchio(a);
                break;
            }
        case 3:
            {
                printf("Inserisci la misura del lato: "); scanf("%d", &a);
                do{
                    printf("Inserisci il numero dei lati: "); scanf("%d", &b);
                }while(b<3);
                p_regolare(a, b);
                break;
            }
        default: printf("Errore"); break;
    }
    system("pause");
}
void triangolo(int a,int b,int c, int d)
{
    int P=a+b+c;
    float Area=b*d/2;
    printf("Il perimetro e' %d.\nL'area e' %.2f.\n", P, Area);
    return;
}
void cerchio(int a)
{
    float C=a*M_PI*M_PI, Area=a*a*M_PI;
    printf("La Circonferenza misura %.2f.\nL'area misura %.2f.\n", C, Area);
    return;
}
void p_regolare(int l, int n)
{
    float area=l/(2*tan(M_PI/n));
    l=l*n;
    area=l*area/2;
    printf("Il perimetro e' %d.\nL'area e' %.2f.\n", l, area);
    return;
}
