#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/unistd.h>

int main(){
    pid_t pid;
    int x, y, z;
    pid=fork();
    if(pid==0){
        y=6-2;
        exit(y);
    }
    else if(pid>0){
        x=3+2;
    }
    else printf("Errore");
    wait(y);
    z=x*y;
    printf("z=%d", z);
    System("pause");
}
