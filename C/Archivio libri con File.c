#include <stdio.h>
#include <stdlib.h>
#include <string.h>
typedef struct libreria{
char ISBN[20];
char Titolo[30];
float Prezzo;
char Genere[15];
}libreria;
int scelta();
void inserimento();
void ricerca();
void stampa();
void modifica();
void ordina();
int conta();
void ordinamento(libreria v[], int N);
void cancella();
FILE *fp;
main()
{
        int x;
        while(1==1)
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
            printf("\t*********--4: Modifica un libro--*********************\n");
            printf("\t*********--------------------*************************\n");
            printf("\t*********--5: Ordina per titolo i libri--*************\n");
            printf("\t*********--------------------*************************\n");
            printf("\t*********--6: Cancella un libro--*********************\n");
            printf("\t*********--------------------*************************\n");
            printf("\t*********--7: Totale numero di libri--****************\n");
            printf("\t*********--------------------*************************\n");
            printf("\t*********--0: Esci dal programma--********************\n");
            printf("\t*********--------------------*************************\n");
            x=scelta();
            if(x==0) break;
        }
        system("exit");
}
int scelta()
{
    fp=fopen("Libri.txt", "r");
    int x;
    printf("\n\tInserisci un numero: ");scanf("%d", &x);
    system("cls");
    switch(x)
    {
        case 0:  break;
        case 1: { inserimento(); break;}
        case 2: {   if(fp==NULL) printf("\t\t\t Non ci sono libri\n\n");
                    else stampa();
                    break;
                }
        case 3: { if(fp==NULL) printf("\t\t\t Non ci sono libri\n\n");
                    else ricerca();
                    break;
                }
        case 4: {
                    if(fp==NULL) printf("\t\t\t Non ci sono libri\n\n");
                    else modifica();
                    break;
                }
        case 5: {
                    if(fp==NULL) printf("\t\t\t Non ci sono libri\n\n");
                    else ordina();
                    break;
                }
        case 6: {
                    if(fp==NULL) printf("\t\t\t Non ci sono libri\n\n");
                    else cancella();
                    break;
                }
        case 7: {
                    if(fp==NULL) printf("\t\t\t Non ci sono libri\n\n");
                    else
                    {
                        x=conta();
                        printf("I libri nell'archivio sono %d\n\n", x);
                        x++;
                    }
                    break;
                }
        default: printf("\t\tHai sbagliato a inserire il numero, riprova.\n\n");
    }
    fclose(fp);
    return x;
}
void inserimento()
{
    fp=fopen("Libri.txt", "a+");
    libreria libro;
    fgetc(stdin);
    printf("Inserisci l'ISBN: "); fgets(libro.ISBN, 20, stdin);
    printf("Inserisci il Titolo: "); fgets(libro.Titolo, 20, stdin);
    printf("Inserisci il Prezzo: "); scanf("%f",&libro.Prezzo);
    fgetc(stdin);
    printf("Inserisci il Genere: "); fgets(libro.Genere, 15, stdin);
    fwrite(&libro, sizeof(libro), 1, fp);
    system("cls");
    fclose(fp);
    return;
}
void stampa()
{
    libreria libro;
    fp=fopen("Libri.txt", "r");
    int i=1;
    fread(&libro, sizeof(libro), 1, fp);
    while(!feof(fp))
    {
        printf("\t==== Libro %d ====\n", i);
        printf("\tISBN: %s", libro.ISBN);
        printf("\tTitolo: %s", libro.Titolo);
        printf("\tPrezzo: %.2f\n", libro.Prezzo);
        printf("\tGenere: %s\n", libro.Genere);
        i++;
        fread(&libro, sizeof(libro), 1, fp);
    }
    fclose(fp);
    return;
}
void ricerca()
{
    libreria libro;
    fp=fopen("Libri.txt", "r");
    int i, flag=0;
    char cercare[15];
    fgetc(stdin);
    printf("Inserisci il genere da cercare\n");
    fgets(cercare, 15, stdin);
    system("cls");
    fread(&libro, sizeof(libro), 1, fp);
    for(i=1;!feof(fp) && flag==0;i++)
    {
        if(strcmp(libro.Genere, cercare)==0)
        {
            printf("\t==== Libro %d ====\n", i);
            printf("\tISBN:%s", libro.ISBN);
            printf("\tTitolo: %s", libro.Titolo);
            printf("\tPrezzo: %.2f\n\n", libro.Prezzo);
            flag=1;
        }
        fread(&libro, sizeof(libreria), 1, fp);
    }
    if(flag==0)
    {
        printf("\tNessun libro di genere %s trovato\n", cercare);
    }
    fclose(fp);
    return;
}
void modifica()
{
    int posizione, flag=0;
    char cercare[30];
    libreria libro;
    fp=fopen("Libri.txt", "r+");
    fgetc(stdin);
    printf("Inserisci il titolo del libro da modificare: ");
    fgets(cercare, 30, stdin);
    fread(&libro, sizeof(libreria), 1, fp);
    while(!feof(fp) && flag==0)
    {
        if(strcmp(cercare, libro.Titolo)==0)
        {
            flag=1;
            posizione=ftell(fp);
        }
        else
        {
            fread(&libro, sizeof(libreria), 1, fp);
        }
    }
    if(flag==0)
    {
        printf("Nessun libro di titolo %s trovato. ", cercare);
    }
    else
    {
        fseek(fp, posizione-sizeof(libreria), 0);
        printf("Inserisci l'ISBN: "); fgets(libro.ISBN, 20, stdin);
        strcpy(libro.Titolo, cercare);
        printf("Inserisci il Prezzo: "); scanf("%f",&libro.Prezzo);
        fgetc(stdin);
        printf("Inserisci il Genere: "); fgets(libro.Genere, 15, stdin);
        fwrite(&libro, sizeof(libreria), 1, fp);
        system("cls");
        printf("\t\tLibro modificato!\n\n");
    }
    fclose(fp);
}
void ordina()
{
    int dimensione;
    libreria vetlib[50];
    dimensione = conta();
    fp=fopen("Libri.txt", "r+");
    fread(vetlib, sizeof(libreria), dimensione, fp);
    ordinamento(vetlib, dimensione);
    rewind(fp);
    fwrite(vetlib, sizeof(libreria), dimensione, fp);
    fclose(fp);
}
int conta()
{
    int i=0;
    libreria libro;
    fp=fopen("Libri.txt", "r+");
    fread(&libro, sizeof(libreria), 1, fp);
    while(!feof(fp))
    {
        i++;
        fread(&libro, sizeof(libreria), 1, fp);
    }
    fclose(fp);
    return i;
}
void ordinamento(libreria v[], int N)
{
    int i, j;
    libreria temp;
    for(i=0;i<N-1;i++)
    {
        for(j=i+1;j<N;j++)
        {
            if(strcmp(v[i].Titolo, v[j].Titolo)>0)
            {
                temp=v[i];
                v[i]=v[j];
                v[j]=temp;
            }
        }
    }
}
void cancella()
{
    libreria vetlib[50];
    int i, j, N, flag=0;
    char cercare[30];
    printf("Inserisci titolo del libro da cancellare: ");
    fgetc(stdin);
    fgets(cercare, 30, stdin);
    N=conta();
    fp=fopen("Libri.txt", "r");
    fread(vetlib, sizeof(libreria), N, fp);
    fclose(fp);
    for(i=0; i<N && flag==0; i++)
    {
        if(strcmp(cercare, vetlib[i].Titolo)==0)
        {
            flag=1;
            for(j=i; j<N-1;j++)
            {
                vetlib[j]=vetlib[j+1];
            }
        }
    }
    if(flag==0)
    {
        printf("Libro inesistente, impossibile cancellare.");
    }
    else
    {
        remove("Libri.txt");
        fp=fopen("Libri.txt", "w");
        fwrite(vetlib, sizeof(libreria), N-1, fp);
        fclose(fp);
        printf("\t\tLibro cancellato!\n\n");
    }
}
