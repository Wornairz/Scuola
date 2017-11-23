#include <stdio.h>
#include <stdlib.h>
#include <math.h>
void inserimento();
void controllo();
void svolgimento();
main()
{
    int A,B,C,DELTA;
    float X,X1,X2,R;
    inserimento(&A,&B,&C);
    DELTA=(B*B)-(4*A*C);
    if(A==0)
    {
        controllo(&A, &B, &C, &X);
    }
    else if(DELTA>=0)
    {
        svolgimento(&A, &B, &C, &DELTA, &X, &X1, &X2, &R);
    }
    else
    {
        printf("L'equazione non ammette soluzioni reali.\n");
    }
}
void inserimento(int*A,int*B,int*C)
{
      printf("Inserisci a,b,c per l'equazione ax2+bx+c=0\n");
      printf("Valore di a: ");   scanf("%d",A);
      printf("Valore di b: ");   scanf("%d",B);
      printf("Valore di c: ");   scanf("%d",C);
}
void controllo(int *A, int *B, int *C, float *X)
{
    if(*B==0)
    {
            if(*C==0)
            {
                printf("L'equazione e' indeterminata.\n");
            }
            else
            {
                printf("L'equazione e' impossibile.\n");
            }
    }
    else
    {
        *X=-*C / *B;
        printf("La soluzione e': %.2f.\n",*X);
    }
}
void svolgimento(int *A,int *B,int *C,int *DELTA,float *X,float *X1,float *X2,float *R)
{
    *R=sqrt(*DELTA);
    *X1=(-*B-*R)/(2* (*A));
    *X2=(-*B+*R)/(2*(*A));
    printf("La prima soluzione e': %.2f.\n",*X1);
    printf("La seconda soluzione e': %.2f.\n",*X2);
}
