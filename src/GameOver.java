import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class GameOver extends JPanel {

    private final Image bg;
    private final Image score;
    private final Gameplay gp;

    public GameOver(Gameplay gp) {

        this.gp = gp;

        URL urlBg = getClass().getResource("/resource/Background.png");
        this.bg = new ImageIcon(urlBg).getImage();

        urlBg = getClass().getResource("/resource/Game_Over.png");
        this.score = new ImageIcon(urlBg).getImage();

        this.setLayout(new BorderLayout());

    }

    protected void paintComponent(Graphics g) {
        g.drawImage(this.bg, 0, 0, null);

        g.drawImage(this.score, 320, 20, null);

        g.setColor(Color.white);
        g.setFont(new Font("Blogger Sans Medium", Font.BOLD, 80));
        g.drawString(this.gp.getScore()+"", 520, 500);
    }

}
