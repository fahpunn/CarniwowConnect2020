import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

public class PenguinListener implements MouseListener {

    private final StaticItem penguin;
    private final Gameplay gp;

    public PenguinListener(StaticItem pen, Gameplay gp) {

        this.penguin = pen;
        this.gp = gp;

    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        int x = evt.getPoint().x;
        int y = evt.getPoint().y;

        if(this.penguin.getSize_now() == 0 && mouseOverItem(x, y)) {
            URL urlBg = getClass().getResource("/resource/Penguin_Ice.png");
            penguin.setImg(new ImageIcon(urlBg).getImage());
            this.penguin.setSize_now(penguin.getSize_max());
            gp.createIce(25);
            gp.createIce(110);
            gp.createIce(195);
            gp.repaint();
        }
    }

    private boolean mouseOverItem(int x, int y) {
        return this.penguin.getX_absolute() <= x
                && this.penguin.getX_absolute()+this.penguin.getWidth() >= x
                && this.penguin.getY_absolute() <= y
                && this.penguin.getY_absolute()+this.penguin.getHeight() >= y;
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
