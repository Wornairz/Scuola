#include <stdio.h>
#include <stdlib.h>
typedef struct libreria
{
char ISBN[20];
char Titolo[30];
float Prezzo;
char Genere[15];
}libreria;
FILE *file;
main()
{
    file=fopen("Libri.txt", "a");
    libreria libro;
    printf("Inserisci l'ISBN: "); scanf("%s", libro.ISBN);
    printf("Inserisci il Titolo: "); scanf("%s", libro.Titolo);
    printf("Inserisci il Prezzo: "); scanf("%f",&libro.Prezzo);
    printf("Inserisci il Genere: "); scanf("%s", libro.Genere);
    system("cls");
    fwrite(&libro,sizeof(libro),1,file);
    fclose(file);
    system("pause");
}
