import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Random;

public class Loading extends JPanel {

    private Random rand;
    private Image bg;
    private JProgressBar bar;
    private JFrame frame;
    public int counter;

    public Loading(JFrame fr) {
        rand = new Random();
        frame = fr;
        bar = new JProgressBar();

        URL urlBg = getClass().getResource("/resource/Loading_Background.png");
        this.bg = new ImageIcon(urlBg).getImage();

        this.setLayout(new BorderLayout());
        this.add(bar, BorderLayout.SOUTH);
        bar.setValue(0);
        bar.setStringPainted(true);
        bar.setFont(new Font("Blogger Sans Medium", Font.BOLD, 20));
        bar.setForeground(Color.decode("#222f4b"));
        bar.setBackground(Color.WHITE);

    }

    protected void paintComponent(Graphics g) {
        g.drawImage(this.bg, 0, 0, null);
    }

    public void fill() {
        counter = 0;
        while(counter <= 100) {
            bar.setValue(counter);
            try {
                Thread.sleep(50);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter += rand.nextInt(3);
        }
        bar.setValue(100);
        bar.setString("Click Anywhere To Continue.");
    }
}
