#include <stdio.h>
#include <stdlib.h>
#include <string.h>
void scelta();
void inserimento();
void ricerca();
void ordinamento_Marca();
void ordinamento_Descrizione();
void ordinamento_Prezzo();
typedef struct Abbigliamento{
char Marca[20];
char Descrizione[20];
float Prezzo;
char Taglia[5];
}Abbigliamento;
Abbigliamento articolo[30];
int dim=0;
main()
{
        printf("\t*****************--------------------*****************\n");
        printf("\t*****************--Menu' principale--*****************\n");
        printf("\t*****************--------------------*****************\n\n");
        printf("\t*********--------------------*************************\n");
        printf("\t*********--1: Inserisci un articolo--*****************\n");
        printf("\t*********--------------------*************************\n");
        printf("\t*********--2: Ricerca di un articolo--****************\n");
        printf("\t*********--------------------*************************\n");
        printf("\t*********--0: Esci dal programma--********************\n");
        printf("\t*********--------------------*************************\n");
        scelta();
}
void scelta()
{
    int x;
    printf("\n\tInserisci un numero: ");scanf("%d", &x);
    system("cls");
    if(x==1)
    {
        dim++;
        fgetc(stdin);
        inserimento();
    }
    else if(x==2 && dim!=0)
    {
        ricerca();
    }
    else if(x==2 && dim==0)
    {
        printf("\t\t\tNon ci sono articoli\n\n");
        main();
    }
    else if(x==0)
    {
        system("pause");
    }
    else
    {
        printf("\t\tHai sbagliato a inserire il numero, riprova.\n\n");
        main();
    }
}
void inserimento()
{
    printf("Inserisci la Marca: "); fgets(articolo[dim].Marca, 20, stdin);
    printf("Inserisci la Descrizione: "); fgets(articolo[dim].Descrizione, 20, stdin);
    printf("Inserisci il Prezzo: "); scanf("%f",&articolo[dim].Prezzo);
    fgetc(stdin);
    printf("Inserisci la Taglia: "); fgets(articolo[dim].Taglia, 5, stdin);
    system("cls");
    main();
}
void ricerca()
{
    int cercare;
    printf("\t*****************--------------------*****************\n");
    printf("\t*****************--Menu' ricerca--********************\n");
    printf("\t*****************--------------------*****************\n\n");
    printf("\t*********--------------------*************************\n");
    printf("\t*********--1: Ricerca per marca--*********************\n");
    printf("\t*********--------------------*************************\n");
    printf("\t*********--2: Ricerca per descrizione--***************\n");
    printf("\t*********--------------------*************************\n");
    printf("\t*********--3: Ricerca per prezzo--********************\n");
    printf("\t*********--------------------*************************\n");
    printf("\t*********--0: Torna al menu' principale--*************\n");
    printf("\t*********--------------------*************************\n");
    printf("\n\tInserisci un numero: ");  scanf("%d", &cercare);
    system("cls");
    if(cercare==1)
    {
        ordinamento_Marca();
    }
    else if(cercare==2)
    {
        ordinamento_Descrizione();
    }
    else if(cercare==3)
    {
        ordinamento_Prezzo();
    }
    else if(cercare==0)
    {
        main();
    }
    else
    {
        printf("\tHai inserito un criterio sbagliato, riprova.\n\n");
        ricerca();
    }
}
void ordinamento_Marca()
{
    int inf=1, sup=dim, med, flag, c=0, j, N;
    float tmp;
    char Brand[20], temp[20];
    printf("Inserisci la Marca da cercare\n");
    fgetc(stdin);
    fgets(Brand, 20, stdin);
    N=dim-1;
    do{
        flag=0;
        for(j=0;j<N;j++)
        {
            if(strcmp(articolo[j].Marca, articolo[j+1].Marca)>0)
            {
                strcpy(temp, articolo[j].Marca);
                strcpy(articolo[j].Marca, articolo[j+1].Marca);
                strcpy(articolo[j+1].Marca, temp);
                strcpy(temp, articolo[j].Descrizione);
                strcpy(articolo[j].Descrizione, articolo[j+1].Descrizione);
                strcpy(articolo[j+1].Descrizione, temp);
                tmp=articolo[j].Prezzo;
                articolo[j].Prezzo=articolo[j+1].Prezzo;
                articolo[j+1].Prezzo=tmp;
                strcpy(temp, articolo[j].Taglia);
                strcpy(articolo[j].Taglia, articolo[j+1].Taglia);
                strcpy(articolo[j+1].Taglia, temp);
                flag=1;
            }
        }
        N--;
    }while(N>0 && flag==1);
    flag=0;
    N=1;
    while(inf<=sup && flag==0)
       {
           med=(inf+sup)/2;
           if(strcmp(Brand, articolo[med].Marca)==0)
           {
               printf("===== Articolo %d ======\n", N);
               printf("DESCRIZIONE: %s", articolo[med].Descrizione);
               printf("PREZZO: %.2f\n", articolo[med].Prezzo);
               printf("TAGLIA: %s\n", articolo[med].Taglia);
               N++;
               flag=1;
               c=0;
               while(flag==1)
                {
                    c++;
                    if(strcmp(Brand, articolo[med+c].Marca)==0)
                    {
                        printf("===== Articolo %d ======\n", N);
                        printf("DESCRIZIONE: %s", articolo[med+c].Descrizione);
                        printf("PREZZO: %.2f\n", articolo[med+c].Prezzo);
                        printf("TAGLIA: %s\n", articolo[med+c].Taglia);
                        N++;
                    }
                     else flag=0;
                }
                flag=1;
                c=0;
                while(flag==1)
                {
                    c++;
                    if(strcmp(Brand, articolo[med-c].Marca)==0)
                    {
                        printf("===== Articolo %d ======\n", N);
                        printf("DESCRIZIONE: %s", articolo[med+c].Descrizione);
                        printf("PREZZO: %.2f\n", articolo[med+c].Prezzo);
                        printf("TAGLIA: %s\n", articolo[med+c].Taglia);
                        N++;
                    }
                    else break;
                }
           }
           else if(strcmp(Brand, articolo[med].Marca)>0)
           {
                inf=med+1;
           }
           else sup=med-1;
       }
       if(flag==0) printf("Nessun articolo di marca %s trovato.\n",Brand);
       main();
}
void ordinamento_Descrizione()
{
    int inf=1, sup=dim, med, flag, c=0, j, N;
    float tmp;
    char Desc[20], temp[20];
    printf("Inserisci la descrizione da cercare\n");
    fgetc(stdin);
    fgets(Desc, 20, stdin);
    N=dim-1;
    do{
        flag=0;
        for(j=0;j<N;j++)
        {
            if(strcmp(articolo[j].Descrizione, articolo[j+1].Descrizione)>0)
            {
                strcpy(temp, articolo[j].Marca);
                strcpy(articolo[j].Marca, articolo[j+1].Marca);
                strcpy(articolo[j+1].Marca, temp);
                strcpy(temp, articolo[j].Descrizione);
                strcpy(articolo[j].Descrizione, articolo[j+1].Descrizione);
                strcpy(articolo[j+1].Descrizione, temp);
                tmp=articolo[j].Prezzo;
                articolo[j].Prezzo=articolo[j+1].Prezzo;
                articolo[j+1].Prezzo=tmp;
                strcpy(temp, articolo[j].Taglia);
                strcpy(articolo[j].Taglia, articolo[j+1].Taglia);
                strcpy(articolo[j+1].Taglia, temp);
                flag=1;
            }
        }
        N--;
    }while(N>0 && flag==1);
    flag=0;
    N=1;
    while(inf<=sup && flag==0)
       {
           med=(inf+sup)/2;
           if(strcmp(Desc, articolo[med].Descrizione)==0)
           {
               printf("===== Articolo %d ======\n", N);
               printf("MARCA: %s", articolo[med].Marca);
               printf("PREZZO: %.2f\n", articolo[med].Prezzo);
               printf("TAGLIA: %s\n", articolo[med].Taglia);
               N++;
               flag=1;
               c=0;
               while(flag==1)
                {
                    c++;
                    if(strcmp(Desc, articolo[med+c].Descrizione)==0)
                    {
                        printf("===== Articolo %d ======\n", N);
                        printf("MARCA: %s", articolo[med+c].Marca);
                        printf("PREZZO: %.2f\n", articolo[med+c].Prezzo);
                        printf("TAGLIA: %s\n", articolo[med+c].Taglia);
                        N++;
                    }
                    else flag=0;
                }
                flag=1;
                c=0;
                while(flag==1)
                {
                    c++;
                    if(strcmp(Desc, articolo[med-c].Descrizione)==0)
                    {
                        printf("===== Articolo %d ======\n", N);
                        printf("MARCA: %s", articolo[med+c].Marca);
                        printf("PREZZO: %.2f\n", articolo[med+c].Prezzo);
                        printf("TAGLIA: %s\n", articolo[med+c].Taglia);
                        N++;
                    }
                    else break;
                }
           }
           else if(strcmp(Desc, articolo[med].Descrizione)>0)
           {
                inf=med+1;
           }
           else sup=med-1;
       }
       if(flag==0) printf("Nessun articolo di descrizione %s trovato.\n", Desc);
       main();
}
void ordinamento_Prezzo()
{
    int inf=1, sup=dim, med, flag, c=0, j, N;
    float tmp, min, max;
    char temp[20];
    printf("Inserisci il tuo budget\n");
    scanf("%f", &max);
    min=max-3;
    if(min<0)
    {
        min=1;
    }
    max=max+3;
    N=dim-1;
    do{
        flag=0;
        for(j=0;j<N;j++)
        {
            if(articolo[j].Prezzo>articolo[j+1].Prezzo)
            {
                strcpy(temp, articolo[j].Marca);
                strcpy(articolo[j].Marca, articolo[j+1].Marca);
                strcpy(articolo[j+1].Marca, temp);
                strcpy(temp, articolo[j].Descrizione);
                strcpy(articolo[j].Descrizione, articolo[j+1].Descrizione);
                strcpy(articolo[j+1].Descrizione, temp);
                tmp=articolo[j].Prezzo;
                articolo[j].Prezzo=articolo[j+1].Prezzo;
                articolo[j+1].Prezzo=tmp;
                strcpy(temp, articolo[j].Taglia);
                strcpy(articolo[j].Taglia, articolo[j+1].Taglia);
                strcpy(articolo[j+1].Taglia, temp);
                flag=1;
            }
        }
        N--;
    }while(N>0 && flag==1);
    flag=0;
    N=1;
    while(inf<=sup && flag==0)
    {
        med=(inf+sup)/2;
        if(articolo[med].Prezzo>min && articolo[med].Prezzo<max)
        {
            printf("===== Articolo %d ======\n", N);
            printf("%s", articolo[med+c].Marca);
            printf("%s", articolo[med].Descrizione);
            printf("%s\n", articolo[med].Taglia);
            N++;
            flag=1;
            c=0;
            while(flag==1)
            {
                c++;
                if(articolo[med+c].Prezzo>min && articolo[med+c].Prezzo<max)
                {
                    printf("===== Articolo %d ======\n", N);
                    printf("%s", articolo[med+c].Marca);
                    printf("%s", articolo[med+c].Descrizione);
                    printf("%s\n", articolo[med+c].Taglia);
                    N++;
                }
                else
                {
                    flag=0;
                }
            }
            c=0;
            flag=1;
            while(flag==1)
            {
                c++;
                if(articolo[med-c].Prezzo>min && articolo[med-c].Prezzo<max)
                {
                    printf("===== Articolo %d ======\n", N);
                    printf("%s", articolo[med-c].Marca);
                    printf("%s", articolo[med-c].Descrizione);
                    printf("%s\n", articolo[med-c].Taglia);
                    N++;
                }
                else
                {
                    break;
                }
            }
        }
        else if(articolo[med].Prezzo>max)
        {
            sup=med-1;
        }
        else
        {
            inf=med+1;
        }
    }
    if(flag==0)
    {
        printf("Nessun articolo di prezzo %.2f trovato\n", max-3);
    }
    main();
}
