#include <stdio.h>
#include <stdlib.h>

main()
{
    int A,i,j,R;
    printf("Inserisci un numero\n");
    scanf("%d", &A);
    for(i=3;i<A;i++)
        {
      for(j=2;j<i;j++)
            {
            R=i%j;
            if(R!=0) printf("%d\n", i);
            }
        }
}
