import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OverallMenu extends JPanel implements MouseListener {

    private final CardLayout cl;
    private final GameMenu gm;
    private final HowToPlay htp;
    private final JFrame frame;
    private int active = 0;

    public OverallMenu(JFrame fr) {
        frame = fr;
        cl = new CardLayout();
        gm = new GameMenu();
        htp = new HowToPlay();

        this.setLayout(cl);
        this.addMouseListener(this);

        this.add(gm, "1");
        this.add(htp, "2");

        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        int x = evt.getPoint().x;
        int y = evt.getPoint().y;

        if(mouseOverStart(x, y) && active == 0){
            frame.setContentPane(new Overall());
            frame.revalidate();
            frame.repaint();
        }

        if(mouseOverHowToPlay(x, y) && active == 0){
            this.active = 1;
            cl.next(this);
        }

        if(mouseOverBack(x, y) && active == 1){
            this.active = 0;
            cl.previous(this);
        }

    }

    private boolean mouseOverStart(int x, int y) {
        return 440 <= x && 440+415 >= x && 370 <= y && 370+96 >= y;
    }

    private boolean mouseOverHowToPlay(int x, int y) {
        return 440 <= x && 440+415 >= x && 490 <= y && 490+96 >= y;
    }

    private boolean mouseOverBack(int x, int y) {
        return 1100 <= x && 1100+129 >= x && 550 <= y && 550+108 >= y;
    }

    @Override
    public void mousePressed(MouseEvent arg0) {

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {

    }

    @Override
    public void mouseExited(MouseEvent arg0) {

    }

}
