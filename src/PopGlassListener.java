import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

public class PopGlassListener implements MouseListener {

    private final StaticItem popGlass;
    private final Gameplay gp;

    private Timer timer;
    private int totalTime;
    private int count;

    public PopGlassListener(StaticItem s, Gameplay gp) {

        count = 2;
        totalTime = 2;

        this.popGlass = s;
        this.gp = gp;

    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        int x = evt.getPoint().x;
        int y = evt.getPoint().y;

        if(this.popGlass.getSize_now() == 0 && mouseOverItem(x, y)) {
            gp.createPopcorn(860);
            gp.createPopcorn(935);
            gp.createPopcorn(1010);
            URL urlBg = getClass().getResource("/resource/Container_Popcorn_Full.png");
            popGlass.setImg(new ImageIcon(urlBg).getImage());
            this.popGlass.setSize_now(this.popGlass.getSize_max());
            gp.repaint();
        }

    }

    private boolean mouseOverItem(int x, int y) {
        return this.popGlass.getX_absolute() <= x
                && this.popGlass.getX_absolute()+this.popGlass.getWidth() >= x
                && this.popGlass.getY_absolute() <= y
                && this.popGlass.getY_absolute()+this.popGlass.getHeight() >= y;
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
