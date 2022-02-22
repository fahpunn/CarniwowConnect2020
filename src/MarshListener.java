import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import java.util.ArrayList;

public class MarshListener implements MouseListener, MouseMotionListener {
    private final ArrayList<Item> itemList;
    private final StaticItem bin;
    private final StaticItem grill;
    private final Gameplay gp;

    private Item item;
    private int dragOffsetX;
    private int dragOffsetY;


    public MarshListener(StaticItem bin, StaticItem g, ArrayList<Item> itemList, Gameplay gp) {
        this.bin = bin;
        this.grill = g;
        this.itemList = itemList;
        this.gp = gp;
    }

    public boolean isOverlapping(StaticItem obj, MouseEvent evt) {
        if (obj.getY_absolute() > evt.getY()
                || obj.getY_absolute()+ obj.getHeight() < evt.getY()) {
            return false;
        }
        return obj.getX_absolute() + obj.getWidth() >= evt.getX()
                && obj.getX_absolute() <= evt.getX();
    }

    public boolean isOverlappingCustomer(Customer obj, MouseEvent evt) {
        if (obj.getY() > evt.getY()
                || obj.getY()+ obj.getHeight() < evt.getY()) {
            return false;
        }
        return obj.getX() + obj.getWidth() >= evt.getX()
                && obj.getX() <= evt.getX();
    }

    @Override
    public void mousePressed(MouseEvent evt) {
        int x = evt.getPoint().x;
        int y = evt.getPoint().y;

        for (int i = this.itemList.size()-1; i >= 0; i--) {
            Item itemTemp = this.itemList.get(i);

            if( mouseOverItem(itemTemp, x, y)){
                this.dragOffsetX = x - itemTemp.getX();
                this.dragOffsetY = y - itemTemp.getY();
                this.item = itemTemp;
                break;
            }
        }

        if(this.item != null){
            this.itemList.remove(this.item);
            this.itemList.add(this.item);
        }
    }

    private boolean mouseOverItem(Item itemTemp, int x, int y) {
        return itemTemp.getX() <= x
                && itemTemp.getX()+itemTemp.getWidth() >= x
                && itemTemp.getY() <= y
                && itemTemp.getY()+itemTemp.getHeight() >= y;
    }

    @Override
    public void mouseReleased(MouseEvent evt) {
        if(this.item != null){

            // Trashing

            if(isOverlapping(bin, evt)){
                this.itemList.remove(item);
                grill.setSize_now(grill.getSize_now()-1);
            }

            if(isOverlappingCustomer(gp.getC1(), evt)){
                if(item.getName() == gp.getC1().getItem1()){
                    URL urlImg = getClass().getResource("/resource/Correct.png");
                    Image imgTemp = new ImageIcon(urlImg).getImage();
                    gp.getC1().setItem1("");
                    gp.getC1().setItem1Img(imgTemp);
                    itemList.remove(item);
                    grill.setSize_now(grill.getSize_now()-1);
                    if(gp.getC1().getItem1() == "" &&
                       gp.getC1().getItem2() == ""){
                        gp.setScore(gp.getScore()+gp.getC1().getScore()+gp.getS1());
                        gp.setS1(gp.getOverall().getDifficulty());
                        gp.createCustomer1();
                    }
                }
                if(item.getName() == gp.getC1().getItem2()){
                    URL urlImg = getClass().getResource("/resource/Correct.png");
                    Image imgTemp = new ImageIcon(urlImg).getImage();
                    gp.getC1().setItem2("");
                    gp.getC1().setItem2Img(imgTemp);
                    itemList.remove(item);
                    grill.setSize_now(grill.getSize_now()-1);
                    if(gp.getC1().getItem1() == "" &&
                       gp.getC1().getItem2() == ""){
                        gp.setScore(gp.getScore()+gp.getC1().getScore()+gp.getS1());
                        gp.setS1(gp.getOverall().getDifficulty());
                        gp.createCustomer1();
                    }
                }
            }

            if(isOverlappingCustomer(gp.getC2(), evt)){
                if(item.getName() == gp.getC2().getItem1()){
                    URL urlImg = getClass().getResource("/resource/Correct.png");
                    Image imgTemp = new ImageIcon(urlImg).getImage();
                    gp.getC2().setItem1("");
                    gp.getC2().setItem1Img(imgTemp);
                    itemList.remove(item);
                    grill.setSize_now(grill.getSize_now()-1);
                    if(gp.getC2().getItem1() == "" &&
                            gp.getC2().getItem2() == ""){
                        gp.setScore(gp.getScore()+gp.getC2().getScore()+gp.getS2());
                        gp.setS2(gp.getOverall().getDifficulty());
                        gp.createCustomer2();
                    }
                }
                if(item.getName() == gp.getC2().getItem2()){
                    URL urlImg = getClass().getResource("/resource/Correct.png");
                    Image imgTemp = new ImageIcon(urlImg).getImage();
                    gp.getC2().setItem2("");
                    gp.getC2().setItem2Img(imgTemp);
                    itemList.remove(item);
                    grill.setSize_now(grill.getSize_now()-1);
                    if(gp.getC2().getItem1() == "" &&
                            gp.getC2().getItem2() == ""){
                        gp.setScore(gp.getScore()+gp.getC2().getScore()+gp.getS2());
                        gp.setS2(gp.getOverall().getDifficulty());
                        gp.createCustomer2();
                    }
                }
            }

            if(isOverlappingCustomer(gp.getC3(), evt)){
                if(item.getName() == gp.getC3().getItem1()){
                    URL urlImg = getClass().getResource("/resource/Correct.png");
                    Image imgTemp = new ImageIcon(urlImg).getImage();
                    gp.getC3().setItem1("");
                    gp.getC3().setItem1Img(imgTemp);
                    itemList.remove(item);
                    grill.setSize_now(grill.getSize_now()-1);
                    if(gp.getC3().getItem1() == "" &&
                            gp.getC3().getItem2() == ""){
                        gp.setScore(gp.getScore()+gp.getC3().getScore()+gp.getS3());
                        gp.setS3(gp.getOverall().getDifficulty());
                        gp.createCustomer3();
                    }
                }
                if(item.getName() == gp.getC3().getItem2()){
                    URL urlImg = getClass().getResource("/resource/Correct.png");
                    Image imgTemp = new ImageIcon(urlImg).getImage();
                    gp.getC3().setItem2("");
                    gp.getC3().setItem2Img(imgTemp);
                    itemList.remove(item);
                    grill.setSize_now(grill.getSize_now()-1);
                    if(gp.getC3().getItem1() == "" &&
                            gp.getC3().getItem2() == ""){
                        gp.setScore(gp.getScore()+gp.getC3().getScore()+gp.getS3());
                        gp.setS3(gp.getOverall().getDifficulty());
                        gp.createCustomer3();
                    }
                }
            }

            if(isOverlappingCustomer(gp.getC4(), evt)){
                if(item.getName() == gp.getC4().getItem1()){
                    URL urlImg = getClass().getResource("/resource/Correct.png");
                    Image imgTemp = new ImageIcon(urlImg).getImage();
                    gp.getC4().setItem1("");
                    gp.getC4().setItem1Img(imgTemp);
                    itemList.remove(item);
                    grill.setSize_now(grill.getSize_now()-1);
                    if(gp.getC4().getItem1() == "" &&
                            gp.getC4().getItem2() == ""){
                        gp.setScore(gp.getScore()+gp.getC4().getScore()+gp.getS4());
                        gp.setS4(gp.getOverall().getDifficulty());
                        gp.createCustomer4();
                    }
                }
                if(item.getName() == gp.getC4().getItem2()){
                    URL urlImg = getClass().getResource("/resource/Correct.png");
                    Image imgTemp = new ImageIcon(urlImg).getImage();
                    gp.getC4().setItem2("");
                    gp.getC4().setItem2Img(imgTemp);
                    itemList.remove(item);
                    grill.setSize_now(grill.getSize_now()-1);
                    if(gp.getC4().getItem1() == "" &&
                            gp.getC4().getItem2() == ""){
                        gp.setScore(gp.getScore()+gp.getC4().getScore()+gp.getS4());
                        gp.setS4(gp.getOverall().getDifficulty());
                        gp.createCustomer4();
                    }
                }
            }

            if(grill.getSize_now() == 0){
                URL urlBg = getClass().getResource("/resource/Grill_Click.png");
                grill.setImg(new ImageIcon(urlBg).getImage());
            }

            this.item.setX(this.item.getX_absolute());
            this.item.setY(this.item.getY_absolute());
            this.gp.repaint();
            this.item = null;
        }
    }

    @Override
    public void mouseDragged(MouseEvent evt) {
        if(this.item != null){
            this.item.setX(evt.getPoint().x - this.dragOffsetX);
            this.item.setY(evt.getPoint().y - this.dragOffsetY);
            this.gp.repaint();
        }
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {}

    @Override
    public void mouseEntered(MouseEvent arg0) {}

    @Override
    public void mouseExited(MouseEvent arg0) {}

    @Override
    public void mouseMoved(MouseEvent arg0) {}
}
