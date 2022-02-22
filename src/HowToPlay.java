import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class HowToPlay extends JPanel {

    private final Image bg, back;

    public HowToPlay() {
        URL urlBg = getClass().getResource("/resource/How_Background.png");
        this.bg = new ImageIcon(urlBg).getImage();

        urlBg = getClass().getResource("/resource/Back_Button.png");
        this.back = new ImageIcon(urlBg).getImage();
    }

    protected void paintComponent(Graphics g) {
        g.drawImage(this.bg, 0, 0, null);
        g.drawImage(this.back, 1100, 550, null);
    }

}
