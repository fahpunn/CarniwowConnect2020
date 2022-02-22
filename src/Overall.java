import javax.swing.*;
import java.awt.*;

public class Overall extends JPanel {

    private final CardLayout cl;
    private final Gameplay bg;
    private final GameOver go;

    private Timer timer;
    private int second;
    private int difficulty;
    private final int MAX_SECOND;

    public Overall() {

        difficulty = 500;
        MAX_SECOND = 1000;
        second = MAX_SECOND;

        bg = new Gameplay(this);
        go = new GameOver(bg);
        cl = new CardLayout();

        this.setLayout(cl);

        this.add(bg, "1");
        this.add(go, "2");

        this.setVisible(true);

        // Counting Timer
        simpleTimer();
        timer.start();

    }

    public void simpleTimer() {
        timer = new Timer(100, e -> {
            second--;
            bg.repaint();
            if(second == 0) {
                cl.next(this);
            }
        });
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public CardLayout getCl() {
        return cl;
    }

    public Gameplay getBg() {
        return bg;
    }
}
