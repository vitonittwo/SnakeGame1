package ixn.snakegame.objekts;

public class Snake {
    // Круто, что энумератор используешь ))
public enum Direction {
    RIGHT, LEFT, DOWN, UP
    }
    public Direction direction = Direction.RIGHT;
    public int length = 10;

    // максимальная длина змейки
    public int snakeX[] = new int[100];
    public int snakeY[] = new int[100];

    // создадим конструктор змейки
    // будет принимать стартовые позиции первых двух элементов
    public Snake(int x0, int y0, int x1, int y1) {
        snakeX[0] = x0;
        snakeY[0] = y0;
        snakeX[1] = x1;
        snakeY[1] = y1;
    }
    public void move() {
        for(int d = length; d > 0; d--) {
            snakeX[d] = snakeX[d - 1];
            snakeY[d] = snakeY[d - 1];
        }
       switch(direction) {

           case RIGHT:
               // Лучше и правильнее использовать префикс: ++snakeX[0]
               // Разница в том, что в постфиксе создаётся копия перед операцией, а в префиксе - нет.
               snakeX[0]++;
               break;
           case LEFT:
               snakeX[0]--;
               break;
           case DOWN:
               snakeY[0]++;
               break;
           case UP:
               snakeY[0]--;
               break;

       }
        // if(direction == 0)
       // if(direction == 1)
        //if(direction == 2) ;
       // if(direction == 3)

        // змейка съедает свой хвост
        for(int d = length; d > 0; d--) {
            if((snakeX[0] == snakeX[d]) && (snakeY[0] == snakeY[d])) length = d;

        }
        if(length < 2) length = 2;

    }
    //for(int d = length; d > 0; d++) {
      //  if(snakeX[0] ==  && snakeY[0] == );
    }


