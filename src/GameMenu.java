import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class GameMenu extends JPanel {

    private final Image bg, start, how;

    public GameMenu() {
        URL urlBg = getClass().getResource("/resource/Menu_Background.png");
        this.bg = new ImageIcon(urlBg).getImage();

        urlBg = getClass().getResource("/resource/Play_Button.png");
        this.start = new ImageIcon(urlBg).getImage();

        urlBg = getClass().getResource("/resource/How_Button.png");
        this.how = new ImageIcon(urlBg).getImage();
    }

    protected void paintComponent(Graphics g) {
        g.drawImage(this.bg, 0, 0, null);
        g.drawImage(this.start, 440, 370, null);
        g.drawImage(this.how, 440, 490, null);
    }
}
