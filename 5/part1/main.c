#include <stdio.h>
#include <stdlib.h>
#define LINES 851

int
cmpfunc (const void * a, const void * b) {
   return ( *(int*)a - *(int*)b );
}

int
main()
{
    char input[LINES][10];
    int id[LINES];
    int lowRows = 0;
    int highRows = 127;

    int lowCols = 0;
    int highCols = 7;
    int currentHigh = 0;
    for (int i = 0; i < LINES; i++)
        scanf("%s", input[i]);

    for (int i = 0; i < LINES; i++)
    {
        lowCols = 0;
        lowRows = 0;
        highCols = 7;
        highRows = 127;
        for (int j = 0; j < 10; j++)
        {
            if (input[i][j] == 'F')
            {
                //printf("F: ");
                highRows = ((highRows - lowRows) / 2) + lowRows;
            }

            if (input[i][j] == 'B')
            {
                //printf("B: ");
                lowRows += (highRows - lowRows) / 2;
            }

            if (input[i][j] == 'R')
            {
                lowCols += (highCols - lowCols) / 2;
            }
            if (input[i][j] == 'L')
            {
                highCols = ((highCols - lowCols) / 2) + lowCols;
            }
            //printf("highCols: %d lowCols: %d lowRows: %d highRows: %d\n", highCols, lowCols, lowRows, highRows);
        }
        id[i] = (highRows * 8) + highCols;
    }
    qsort(id, LINES, sizeof(int), cmpfunc);
    /*
    for (int i = 0; i < LINES; i++)
    {
        if (id[i] >= currentHigh)
            currentHigh = id[i];
    }
    printf("%d\n", currentHigh);
    */
    for (int i = 0; i < LINES; i++)
    {
        if (id[i] != id[i+1] - 1)
        {
            printf("maybe: %d, %d, %d\n", id[i], id[i+1], id[i+2]);
            break;
        }
        printf("%d\n", id[i]);
    }
}
