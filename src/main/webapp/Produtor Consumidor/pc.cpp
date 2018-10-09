#include "stdio.h"
#include "stdlib.h"
#define N 100                       
typedef int semaphore;
semaphore mutex = 1;            
semaphore empty = N;           
semaphore full = 0;                

void producer () {
    int item;

        while (TRUE) {
            item = produce_item();      
            down(&empty);                /* decrementa o contador de slots vazios */
            down(&mutex);                
            insert_item(item);             
            up(&mutex);                    
            up(&full);                        /* incrementa contagem de slots ocupados */
        }
}

void consumer() {
    int item;

    while (TRUE) {
        down(&full);                       /* decrementa o contador de slots ocupados */
        down(&mutex);                  
        item = remove_item();        
        up(&mutex);                       
        up(&empty);                       /* incrementa contagem de slots vazios */
        consume_item(item)           /* faz algo com o item retirado */
    }
}

