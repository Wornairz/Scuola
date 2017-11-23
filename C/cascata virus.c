#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#include <dos.h>
#include <unistd.h>
#include <string.h>
void GotoXY(int x, int  y) 
{
    COORD CursorPos = {x, y};
    HANDLE hConsole = GetStdHandle(STD_OUTPUT_HANDLE); SetConsoleCursorPosition(hConsole, CursorPos);
}
main()
{
    int i,l,x=0,y=0,j;
    char v[50];
    printf("Inserisci una parola:\t");
    fgets(v, 50, stdin);
    l=strlen(v)-1;
    system("cls");

    for(i=0;i<l;i++){
    for(j=0;j<5;j++){
    if(v[i]=='32'){
    j=5;}
    y++;
    GotoXY(x,y-1);
    printf(" ");
    GotoXY(x,y);
    printf("%c \n",v[i]);
    sleep(100);
    }
    x++;
    y=0;
    sleep(100);
    }
system("PAUSE");
                    
}
