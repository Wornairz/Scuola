#include <stdio.h>
#include <stdlib.h>
#include <string.h>
void scelta();
void inserimento();
void ricerca();
void stampa();
typedef struct libreria{
char ISBN[20];
char Titolo[30];
float Prezzo;
char Genere[15];
}libreria;
libreria libro[30];
int dim=0;
main()
{
        printf("\t*****************--------------------*****************\n");
        printf("\t*****************--Menu' principale--*****************\n");
        printf("\t*****************--------------------*****************\n\n");
        printf("\t*********--------------------*************************\n");
        printf("\t*********--1: Inserisci un libro--********************\n");
        printf("\t*********--------------------*************************\n");
        printf("\t*********--2: Elenco di tutti i libri--***************\n");
        printf("\t*********--------------------*************************\n");
        printf("\t*********--3: Elenco di tutti i libri di un genere--**\n");
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
        stampa();
    }
    else if(x==2 && dim==0)
    {
        printf("\t\t\tNon ci sono libri\n\n");
        main();
    }
    else if(x==3)
    {
        ricerca();
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
    printf("Inserisci l'ISBN: "); fgets(libro[dim].ISBN, 20, stdin);
    printf("Inserisci il Titolo: "); fgets(libro[dim].Titolo, 20, stdin);
    printf("Inserisci il Prezzo: "); scanf("%f",&libro[dim].Prezzo);
    fgetc(stdin);
    printf("Inserisci il Genere: "); fgets(libro[dim].Genere, 15, stdin);
    system("cls");
    main();
}
void ricerca()
{
    int i, flag=0;
    char cercare[15];
    printf("Inserisci il genere da cercare\n");
    fgetc(stdin);
    fgets(cercare, 15, stdin);
    system("cls");
    for(i=1;i<dim+1;i++)
    {
        if(strcmp(libro[i].Genere, cercare)==0)
        {
            printf("\t==== Libro %d ====\n", i);
            printf("\tISBN:%s", libro[i].ISBN);
            printf("\tTitolo: %s", libro[i].Titolo);
            printf("\tPrezzo: %.2f\n\n", libro[i].Prezzo);
            flag=1;
        }
    }
    if(flag==0)
    {
        printf("\tNessun libro di genere %s trovato\n", cercare);
    }
    main();
}
void stampa()
{
    int i;
    for(i=1;i<dim+1;i++)
    {
        printf("\t==== Libro %d ====\n", i);
        printf("\tISBN: %s", libro[i].ISBN);
        printf("\tTitolo: %s", libro[i].Titolo);
        printf("\tPrezzo: %.2f\n", libro[i].Prezzo);
        printf("\tGenere: %s\n", libro[i].Genere);
    }
    main();
}
