import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

public class SyrupListener implements MouseListener {

    private final StaticItem mSyrup;
    private final Gameplay gp;

    public SyrupListener(StaticItem g, Gameplay gp) {

        this.mSyrup = g;
        this.gp = gp;

    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        int x = evt.getPoint().x;
        int y = evt.getPoint().y;

        if(this.mSyrup.getSize_now() == 0 && this.mSyrup.getName() == "Syrup_Red" && mouseOverItem(x, y)) {
            URL urlBg = getClass().getResource("/resource/Syrup_Red_Full.png");
            mSyrup.setImg(new ImageIcon(urlBg).getImage());
            this.mSyrup.setSize_now(this.mSyrup.getSize_max());
            gp.repaint();
        }

        if(this.mSyrup.getSize_now() == 0 && this.mSyrup.getName() == "Syrup_Yellow" && mouseOverItem(x, y)) {
            URL urlBg = getClass().getResource("/resource/Syrup_Yellow_Full.png");
            mSyrup.setImg(new ImageIcon(urlBg).getImage());
            this.mSyrup.setSize_now(this.mSyrup.getSize_max());
            gp.repaint();
        }

        if(this.mSyrup.getSize_now() == 0 && this.mSyrup.getName() == "Syrup_Blue" && mouseOverItem(x, y)) {
            URL urlBg = getClass().getResource("/resource/Syrup_Blue_Full.png");
            mSyrup.setImg(new ImageIcon(urlBg).getImage());
            this.mSyrup.setSize_now(this.mSyrup.getSize_max());
            gp.repaint();
        }

        if(this.mSyrup.getSize_now() == 0 && this.mSyrup.getName() == "Sprinkle" && mouseOverItem(x, y)) {
            URL urlBg = getClass().getResource("/resource/Sprinkle_Full.png");
            mSyrup.setImg(new ImageIcon(urlBg).getImage());
            this.mSyrup.setSize_now(this.mSyrup.getSize_max());
            gp.repaint();
        }

        if(this.mSyrup.getSize_now() == 0 && this.mSyrup.getName() == "Ojo" && mouseOverItem(x, y)) {
            URL urlBg = getClass().getResource("/resource/Ojo_Full.png");
            mSyrup.setImg(new ImageIcon(urlBg).getImage());
            this.mSyrup.setSize_now(this.mSyrup.getSize_max());
            gp.repaint();
        }
    }

    private boolean mouseOverItem(int x, int y) {
        return this.mSyrup.getX_absolute() <= x
                && this.mSyrup.getX_absolute()+this.mSyrup.getWidth() >= x
                && this.mSyrup.getY_absolute() <= y
                && this.mSyrup.getY_absolute()+this.mSyrup.getHeight() >= y;
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
