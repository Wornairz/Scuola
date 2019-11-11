#include <stdio.h>
#include <stdlib.h>

main() {
  int v[10], i, ins = 0;
  float s = 0;
  printf("Inserisci 10 voti\n");
  for (i = 0; i < 10; i++) {
    scanf("%d", &v[i]);
    if (v[i] < 6) {
      ins++;
    }
    s = s + v[i];
  }
  s = s / 10;
  printf("La media e' %f e le insufficienze sono %d\n", s, ins);
}
