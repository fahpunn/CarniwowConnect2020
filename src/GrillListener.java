import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

public class GrillListener implements MouseListener {

    private final StaticItem grill;
    private final Gameplay gp;

    public GrillListener(StaticItem g, Gameplay gp) {

        this.grill = g;
        this.gp = gp;

    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        int x = evt.getPoint().x;
        int y = evt.getPoint().y;

        if(this.grill.getSize_now() == 0 && mouseOverItem(x, y)) {
            URL urlBg = getClass().getResource("/resource/Grill.png");
            grill.setImg(new ImageIcon(urlBg).getImage());
            this.grill.setSize_now(this.grill.getSize_max());
            gp.getMarshList().clear();
            gp.createMarshmelloBurned(650);
            gp.createMarshmelloBurned(710);
            gp.createMarshmelloBurned(770);
            gp.repaint();
        }
    }

    private boolean mouseOverItem(int x, int y) {
        return this.grill.getX_absolute() <= x
                && this.grill.getX_absolute()+this.grill.getWidth() >= x
                && this.grill.getY_absolute() <= y
                && this.grill.getY_absolute()+this.grill.getHeight() >= y;
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
