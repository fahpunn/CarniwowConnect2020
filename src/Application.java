import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Application extends JFrame implements MouseListener {

        private Gameplay bg;
        private Overall oa;
        private Loading lo;

    public Application() {

        oa = new Overall();
        bg = new Gameplay(oa);
        lo = new Loading(this);

        this.setTitle("Carniwow Connect");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.setContentPane(lo);
        this.setResizable(false);
        this.setSize(bg.getBg().getWidth(null), bg.getBg().getHeight(null));

        this.addMouseListener(this);

        lo.fill();

    }

    public static void main(String[] args) {
        new Application();
    }

    @Override
    public void mouseClicked(MouseEvent evt) {

        if(lo.counter > 100) {
            this.setContentPane(new OverallMenu(this));
            this.revalidate();
            this.repaint();
        }

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
