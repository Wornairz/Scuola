#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#include <unistd.h>
#include <string.h>
int main()
{
    int i, l, c, x, y, r;
    char v[50];
    srand(time(NULL));
    x=0;
    y=0;
    //printf("Inserisci una parola:\n");
    fgets(v, 50, stdin);
    //system("cls");
    l=strlen(v)-1;
    for(x=1;x<40;x++)
    {
        GotoXY(x,y);
        printf("%s",v);
        GotoXY(x-1,y);
        printf(" ");
        _sleep(50);
    }
    system("cls");
    for(y=1;y<12;y++)
    {
        GotoXY(x,y);
        printf("%s",v);
        _sleep(50);
        if(y<11)
        {system("cls");}
    }
}
void GotoXY(int x, int  y)
{
    COORD CursorPos = {x, y};
    HANDLE hConsole = GetStdHandle(STD_OUTPUT_HANDLE);
    SetConsoleCursorPosition(hConsole, CursorPos);
}
