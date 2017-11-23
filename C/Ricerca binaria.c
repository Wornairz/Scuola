#include <stdio.h>
#include <stdlib.h>
#include <string.h>
main()
{
    int inf=0, sup=3, med, a, i,j,flag=0;
    char nome[4][20], cognome[4][20], indirizzo[4][20], residenza[4][20], capelli[4][20],stato[4][20], v[20];
    for(i=0;i<4;i++)
    {
        printf("Inserisci il nome dell'utente %d\n", i+1);
        gets(nome[i]);
        printf("Inserisci il cognome dell'utente %d\n", i+1);
        gets(cognome[i]);
        printf("Inserisci l'indirizzo dell'utente %d\n", i+1);
        gets(indirizzo[i]);
        printf("Inserisci la residenza dell'utente %d\n", i+1);
        gets(residenza[i]);
        printf("Inserisci il colore dei capelli dell'utente %d\n", i+1);
        gets(capelli[i]);
        printf("Inserisci lo stato civile dell'utente %d\n", i+1);
        gets(stato[i]);
    }
    for(i=0;i<3;i++)
    {
        for(j=i+1;j<4;j++)
        {
            a=strcmp(cognome[i],cognome[j]);
            if(a>0)
            {
                strcpy(v, nome[i]);
                strcpy(nome[i],nome[j]);
                strcpy(nome[j], v);
                strcpy(v, cognome[i]);
                strcpy(cognome[i],cognome[j]);
                strcpy(cognome[j], v);
                strcpy(v, indirizzo[i]);
                strcpy(indirizzo[i],indirizzo[j]);
                strcpy(indirizzo[j], v);
                strcpy(v, residenza[i]);
                strcpy(residenza[i],residenza[j]);
                strcpy(residenza[j], v);
                strcpy(v, capelli[i]);
                strcpy(capelli[i],capelli[j]);
                strcpy(capelli[j], v);
                strcpy(v, stato[i]);
                strcpy(stato[i],stato[j]);
                strcpy(stato[j], v);
            }
        }
    }
    printf("\nInserisci il cognome  dell'utente da cercare\n");
    gets(v);
    while(inf<=sup)
    {
        med=(inf+sup)/2;
        a=strcmp(v, cognome[med]);
        if(a==0)
        {
            flag=1;
            break;
        }
        else if(a<0)
        {
            sup=med-1;
        }
        else
        {
            inf=med+1;
        }
    }
        if(flag==1)
        {
            printf("Ecco i dati del sig. %s:\n\nNome: %s\nCognome: %s\nIndirizzo: %s\n", v, nome[med], cognome[med], indirizzo[med]);
            printf("Residenza: %s\nColore capelli: %s\nStato civile: %s\n", residenza[med], capelli[med], stato[med]);
        }
        else
        {
            printf("Utente non trovato\n");
        }
}
