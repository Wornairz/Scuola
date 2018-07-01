#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#include <unistd.h>
#include <string.h>
int main()
{
    int i, l, c, flag, x, y, r[50];
    char v[50];
    srand(time(NULL));
    system("color 4b");
    x=0;
    y=0;
    //printf("Inserisci una parola:\n");
    fgets(v, 50, stdin);
    //system("cls");
    l=strlen(v)-1;
    for(i=0;i<l;i++)
    {
        flag=0;
        r[i]=(rand()%l);
        c=0;
        while(c<i)
        {
            if(r[i]==r[c])
            {
                r[i]=(rand()%l);
                c=-1;
            }
            c++;
        }
        for(c=0;c<5;c++)
        {
            x=r[i];
            y++;
            GotoXY(x,y-1);
            printf(" ");
            GotoXY(x,y);
            printf("%c\n",v[x]);
            _sleep(50);
        }
        y=0;
        _sleep(50);
    }
}
void GotoXY(int x, int  y)
{
    COORD CursorPos = {x, y};
    HANDLE hConsole = GetStdHandle(STD_OUTPUT_HANDLE);
    SetConsoleCursorPosition(hConsole, CursorPos);
}
