import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Ball {
    private int x, y, diameter;
    private int xSpeed;
    private int canvasWidth;

    private Color color; // Ball color

    public Ball(int x, int y, int diameter, int canvasWidth, Color color, int xSpeed) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.canvasWidth = canvasWidth;
        this.color = color;
        this.xSpeed = xSpeed;  // Speed in the x-direction (positive or negative)
    }

    public void move() {
        x += xSpeed;

        // Bounce off the walls (left and right edges)
        if (x < 0 || x + diameter > canvasWidth) {
            xSpeed = -xSpeed;
        }
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, diameter, diameter);
    }
}

public class BouncingBall extends JPanel implements Runnable {
    private Ball[] balls;
    private Thread thread;
    private boolean running;
    private JButton toggleButton; // Single toggle button for all balls

    public BouncingBall(int canvasWidth, int canvasHeight) {
        setBackground(Color.WHITE);
        running = true;

        // Create the balls
        balls = new Ball[3];
        balls[0] = new Ball(0, 50, 30, canvasWidth, Color.RED, 3);    // Red ball
        balls[1] = new Ball(0, 150, 30, canvasWidth, Color.GREEN, 5); // Green ball
        balls[2] = new Ball(0, 250, 30, canvasWidth, Color.BLUE, 7);  // Blue ball

        // Start the thread
        thread = new Thread(this);
        thread.start();

        // Initialize and add button to toggle animation
        toggleButton = new JButton("Stop");
        toggleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                running = !running; // Toggle running state
                toggleButton.setText(running ? "Stop" : "Start");
            }
        });
        setLayout(new BorderLayout());
        add(toggleButton, BorderLayout.SOUTH); // Add button at the bottom of the panel
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Ball ball : balls) {
            ball.draw(g);
        }
    }

    @Override
    public void run() {
        while (true) {
            if (running) {
                for (Ball ball : balls) {
                    ball.move();
                }
                repaint();
            }
            try {
                Thread.sleep(10); // Control the speed of the animation
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Balls");
        BouncingBall bouncingBallsPanel = new BouncingBall(600, 400);  // Canvas size

        frame.add(bouncingBallsPanel);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
