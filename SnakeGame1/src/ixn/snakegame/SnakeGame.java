package ixn.snakegame;

import java.awt.Graphics;
import ixn.snakegame.objekts.Snake;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static ixn.snakegame.objekts.Snake.Direction.*;


public class SnakeGame extends JPanel implements ActionListener {

    public static final int SCALE = 20;
    public static final int WIDTH = 40;
    public static final int HEIGHT = 42;
    public static final int SPEED = 30;

    // задаём стартовую позицию
    Snake snake = new Snake(10, 10, 9, 10);
    Timer t = new Timer(10000/SPEED, this);

    // делаем конструктор движения
    public SnakeGame() {
        t.start();
        addKeyListener(new Keyboard());
        setFocusable(true);

    }


// задаём стандартный шаблон
    public void paint(Graphics g) {
        g.setColor(color(5, 50, 10));
        g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
        //задаём фон
        // цвет сетки
        g.setColor(color(255, 216, 0));

        for(int xx = 0; xx <= WIDTH*SCALE; xx+=SCALE) {
           g.drawLine(xx, 0, xx, HEIGHT*SCALE);
        }
        for(int yy = 0; yy <= HEIGHT*SCALE; yy+=SCALE) {
            g.drawLine(0, yy, WIDTH*SCALE, yy);
        }
       // рисуем саму змейку
        for(int d = 0; d < snake.length; d++) {
            g.setColor(color(200,150, 0));
            g.fillRect(snake.snakeX[d]*SCALE+1, snake.snakeY[d]*SCALE+1, SCALE+1, SCALE+1);
        }

        // закрашиваем квадрат
        Timer t = new Timer(900000000/SPEED, this);
        t.start();
        int a = 0;
        int b = 39;


        int random_foodx = a + (int) (Math.random() * b);
        // System.out.println("1-ое случайное число: " + random_foodx);

        int random_foody = a + (int) (Math.random() * b);
        // System.out.println("2-ое случайное число: " + random_foody);

        g.setColor(color(200, 0, 0));
        g.fillRect(random_foodx * SCALE + 1, random_foody * SCALE + 1, SCALE - 1, SCALE - 1);




    }
    // фуркция для цвета
    public Color color(int red, int green, int blue) {
        return new Color(red, green, blue);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setSize(WIDTH*SCALE+7, HEIGHT*SCALE+34);
        f.setLocationRelativeTo(null);
        f.add(new SnakeGame());
        f.setVisible(true);


    }
// для implements ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move();

        repaint();
        // это движение змейки

    }
    private class Keyboard extends KeyAdapter {
        public void keyPressed(KeyEvent kEvt) {
            int key = kEvt.getKeyCode();

            if((key == KeyEvent.VK_RIGHT) && snake.direction != LEFT) snake.direction = RIGHT;
            if((key == KeyEvent.VK_DOWN) && snake.direction != UP) snake.direction = DOWN;
            if((key == KeyEvent.VK_LEFT) && snake.direction != RIGHT) snake.direction = LEFT;
            if((key == KeyEvent.VK_UP) && snake.direction != DOWN) snake.direction = UP;


        }

    }
}
