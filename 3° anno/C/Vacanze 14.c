#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
main()
{
    int A[8][8], n=1, x=0, y=0;
    for(x=0;x<7;x++)
    {
        GotoXY(x,y);
        printf("%d", n);
        n++;
    }
    for(y=0;y<8;y++)
    {
        GotoXY(x,y);
        printf("%d", n);
        n++;
    }
    while(x>0)
    {
        GotoXY(x,y);
        printf("%d", n);
        n++;
        x=x-2;
    }
}
void GotoXY(int x, int  y)
{
    COORD CursorPos = {x, y};
    HANDLE hConsole = GetStdHandle(STD_OUTPUT_HANDLE);
    SetConsoleCursorPosition(hConsole, CursorPos);
}
