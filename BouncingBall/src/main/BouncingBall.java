package main;

import java.awt.*;
import java.time.Instant;

public class BouncingBall extends Frame {

    private static final int SIZE = 1000;
    private boolean gameover = false;
    
    private Ball ball;
    private int xRichtung,yRichtung;

    public BouncingBall()
    {
        ball = new Ball(new Point(SIZE/2, SIZE/2));
        xRichtung = 2;
        yRichtung = -1;
        setSize(SIZE, SIZE);
        //setResizable(false);
        setVisible(true);
        createBufferStrategy(2);
    }

    public static void main(String[] args) {
        new BouncingBall().run();
    }

    
    

    private void run() {

            while (! gameover) {

                calculateScene();
                renderScene();
                //Thread.sleep(10);
            }

    }

    private void renderScene() {

        Graphics g = null;



        try {

            g = getBufferStrategy().getDrawGraphics();

            g.clearRect(0, 0, getWidth(), getHeight());
            //g.setXORMode(Color.BLUE);
            ball.draw(g);

        } finally {

            if (g != null) {

                g.dispose();

            }

        }
        getBufferStrategy().show();
    }

    private void calculateScene() {
        int x = ball.getLocation().x;
        int y = ball.getLocation().y;

        x += xRichtung;

        if(x < 0 || x > this.getWidth())
            xRichtung *= -1;

        y += yRichtung;
        if(y < 0 || y > this.getHeight())
            yRichtung *= -1;

        ball.getLocation().move(x,y);
    }
}

/*
[13:47] Michael von Keitz

import javax.swing.*;

import java.awt.*;

import java.awt.image.BufferStrategy;

 

public class Game extends JFrame {


    private Canvas canvas = new Canvas();

 

    public static void main(String[] args) {

        Game game = new Game();

        game.startGameLoop();

    }

 

    public Game() {

        setBounds(10, 10, 800, 600);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setVisible(true);

        canvas.setBounds(0, 0, 800, 600);

        add(canvas);

        canvas.createBufferStrategy(2); // Create a double buffer

    }

 

    public void startGameLoop() {

        BufferStrategy bufferStrategy = canvas.getBufferStrategy();

        int i = 0;

 

        while(true) {

            do {

                do {

                    Graphics g = null;

 

                    try {

                        g = bufferStrategy.getDrawGraphics();

                        g.clearRect(0, 0, getWidth(), getHeight());

                        g.setColor(Color.BLACK);

                        g.drawString("Frame: " + i, 5, 50);

                    } finally {

                        if (g != null) {

                            g.dispose();

                        }

                    }

                } while(bufferStrategy.contentsRestored());

 

                bufferStrategy.show();

 

            } while(bufferStrategy.contentsLost());

 

            i++;

        }

    }

}

 */