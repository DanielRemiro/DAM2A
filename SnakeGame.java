import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SnakeGame extends JPanel implements ActionListener {

    private final int TILE_SIZE = 25;
    private final int WIDTH = 600;
    private final int HEIGHT = 600;
    private final int TOTAL_TILES = (WIDTH * HEIGHT) / (TILE_SIZE * TILE_SIZE);

    private final int x[] = new int[TOTAL_TILES];
    private final int y[] = new int[TOTAL_TILES];
    private int snakeLength = 3;

    private int appleX;
    private int appleY;

    private char direction = 'R'; // U=up, D=down, L=left, R=right
    private boolean running = false;
    private Timer timer;
    private Random random;

    public SnakeGame() {
        random = new Random();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new MyKeyAdapter());
        startGame();
    }

    public void startGame() {
        spawnApple();
        running = true;
        timer = new Timer(100, this);
        timer.start();
    }

    public void spawnApple() {
        appleX = random.nextInt(WIDTH / TILE_SIZE) * TILE_SIZE;
        appleY = random.nextInt(HEIGHT / TILE_SIZE) * TILE_SIZE;
    }

    public void move() {
        for (int i = snakeLength; i > 0; i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }

        switch(direction) {
            case 'U': y[0] -= TILE_SIZE; break;
            case 'D': y[0] += TILE_SIZE; break;
            case 'L': x[0] -= TILE_SIZE; break;
            case 'R': x[0] += TILE_SIZE; break;
        }
    }

    public void checkApple() {
        if (x[0] == appleX && y[0] == appleY) {
            snakeLength++;
            spawnApple();
        }
    }

    public void checkCollisions() {
        // Choca contra su propio cuerpo
        for (int i = snakeLength; i > 0; i--) {
            if (x[0] == x[i] && y[0] == y[i]) {
                running = false;
            }
        }
        // Choca contra las paredes
        if (x[0] < 0 || x[0] >= WIDTH || y[0] < 0 || y[0] >= HEIGHT) {
            running = false;
        }

        if (!running) {
            timer.stop();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (running) {
            // Manzana
            g.setColor(Color.RED);
            g.fillOval(appleX, appleY, TILE_SIZE, TILE_SIZE);

            // Serpiente
            for (int i = 0; i < snakeLength; i++) {
                if (i == 0) g.setColor(Color.GREEN); // cabeza
                else g.setColor(new Color(45,180,0)); // cuerpo
                g.fillRect(x[i], y[i], TILE_SIZE, TILE_SIZE);
            }

            // Puntuación
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Score: " + (snakeLength - 3), 10, 25);

        } else {
            gameOver(g);
        }
    }

    public void gameOver(Graphics g) {
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.drawString("GAME OVER", WIDTH/4, HEIGHT/2);
        g.setFont(new Font("Arial", Font.BOLD, 25));
        g.drawString("Score: " + (snakeLength - 3), WIDTH/2 - 50, HEIGHT/2 + 50);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    private class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (direction != 'R') direction = 'L';
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction != 'L') direction = 'R';
                    break;
                case KeyEvent.VK_UP:
                    if (direction != 'D') direction = 'U';
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != 'U') direction = 'D';
                    break;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        SnakeGame gamePanel = new SnakeGame();
        frame.add(gamePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
