import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import java.util.ArrayList;

public class IceListener implements MouseListener, MouseMotionListener {

    private final ArrayList<Item> itemList;
    private final StaticItem penguin;
    private final StaticItem syrupRed;
    private final StaticItem syrupYellow;
    private final StaticItem syrupBlue;
    private final StaticItem ojo;
    private final StaticItem sprinkle;
    private final StaticItem bin;
    private final Gameplay gp;

    private Item item;
    private int dragOffsetX;
    private int dragOffsetY;


    public IceListener(StaticItem pen, StaticItem bin, StaticItem r,
                       StaticItem y, StaticItem b, StaticItem ojo,
                       StaticItem s, ArrayList<Item> itemList, Gameplay gp) {
        this.penguin = pen;
        this.bin = bin;
        this.syrupRed = r;
        this.syrupYellow = y;
        this.syrupBlue = b;
        this.itemList = itemList;
        this.ojo = ojo;
        this.sprinkle = s;
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

            // Color Mixing 81-1453

            if(syrupRed.getSize_now() > 0 && isOverlapping(syrupRed, evt) &&
                    item.getName().equals("Ice_Empty")){
                URL urlImg = getClass().getResource("/resource/Ice_Red.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Red");
                this.item.setImg(imgTemp);

                if(this.syrupRed.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Syrup_Red_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupRed.setImg(imgTemp);
                    this.syrupRed.setSize_now(2);
                }
                else if(this.syrupRed.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Syrup_Red_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupRed.setImg(imgTemp);
                    this.syrupRed.setSize_now(1);
                }
                else if(this.syrupRed.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Syrup_Red_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupRed.setImg(imgTemp);
                    this.syrupRed.setSize_now(0);
                }
            }

            if(syrupRed.getSize_now() > 0 && isOverlapping(syrupRed, evt) && item.getName().equals("Ice_Yellow")){
                URL urlImg = getClass().getResource("/resource/Ice_Orange.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Orange");
                this.item.setImg(imgTemp);

                if(this.syrupRed.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Syrup_Red_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupRed.setImg(imgTemp);
                    this.syrupRed.setSize_now(2);
                }
                else if(this.syrupRed.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Syrup_Red_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupRed.setImg(imgTemp);
                    this.syrupRed.setSize_now(1);
                }
                else if(this.syrupRed.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Syrup_Red_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupRed.setImg(imgTemp);
                    this.syrupRed.setSize_now(0);
                }
            }

            if(syrupRed.getSize_now() > 0 && isOverlapping(syrupRed, evt) && item.getName().equals("Ice_Blue")){
                URL urlImg = getClass().getResource("/resource/Ice_Purple.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Purple");
                this.item.setImg(imgTemp);

                if(this.syrupRed.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Syrup_Red_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupRed.setImg(imgTemp);
                    this.syrupRed.setSize_now(2);
                }
                else if(this.syrupRed.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Syrup_Red_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupRed.setImg(imgTemp);
                    this.syrupRed.setSize_now(1);
                }
                else if(this.syrupRed.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Syrup_Red_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupRed.setImg(imgTemp);
                    this.syrupRed.setSize_now(0);
                }
            }

            if(syrupRed.getSize_now() > 0 && isOverlapping(syrupRed, evt) && item.getName().equals("Ice_Green")){
                URL urlImg = getClass().getResource("/resource/Ice_Brown.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Brown");
                this.item.setImg(imgTemp);

                if(this.syrupRed.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Syrup_Red_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupRed.setImg(imgTemp);
                    this.syrupRed.setSize_now(2);
                }
                else if(this.syrupRed.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Syrup_Red_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupRed.setImg(imgTemp);
                    this.syrupRed.setSize_now(1);
                }
                else if(this.syrupRed.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Syrup_Red_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupRed.setImg(imgTemp);
                    this.syrupRed.setSize_now(0);
                }
            }

            if(syrupYellow.getSize_now() > 0 && isOverlapping(syrupYellow, evt) && item.getName().equals("Ice_Empty")){
                URL urlImg = getClass().getResource("/resource/Ice_Yellow.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Yellow");
                this.item.setImg(imgTemp);

                if(this.syrupYellow.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Syrup_Yellow_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupYellow.setImg(imgTemp);
                    this.syrupYellow.setSize_now(2);
                }
                else if(this.syrupYellow.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Syrup_Yellow_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupYellow.setImg(imgTemp);
                    this.syrupYellow.setSize_now(1);
                }
                else if(this.syrupYellow.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Syrup_Yellow_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupYellow.setImg(imgTemp);
                    this.syrupYellow.setSize_now(0);
                }
            }

            if(syrupYellow.getSize_now() > 0 && isOverlapping(syrupYellow, evt) && item.getName().equals("Ice_Red")){
                URL urlImg = getClass().getResource("/resource/Ice_Orange.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Orange");
                this.item.setImg(imgTemp);

                if(this.syrupYellow.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Syrup_Yellow_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupYellow.setImg(imgTemp);
                    this.syrupYellow.setSize_now(2);
                }
                else if(this.syrupYellow.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Syrup_Yellow_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupYellow.setImg(imgTemp);
                    this.syrupYellow.setSize_now(1);
                }
                else if(this.syrupYellow.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Syrup_Yellow_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupYellow.setImg(imgTemp);
                    this.syrupYellow.setSize_now(0);
                }
            }

            if(syrupYellow.getSize_now() > 0 && isOverlapping(syrupYellow, evt) && item.getName().equals("Ice_Blue")){
                URL urlImg = getClass().getResource("/resource/Ice_Green.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Green");
                this.item.setImg(imgTemp);

                if(this.syrupYellow.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Syrup_Yellow_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupYellow.setImg(imgTemp);
                    this.syrupYellow.setSize_now(2);
                }
                else if(this.syrupYellow.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Syrup_Yellow_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupYellow.setImg(imgTemp);
                    this.syrupYellow.setSize_now(1);
                }
                else if(this.syrupYellow.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Syrup_Yellow_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupYellow.setImg(imgTemp);
                    this.syrupYellow.setSize_now(0);
                }
            }

            if(syrupYellow.getSize_now() > 0 && isOverlapping(syrupYellow, evt) && item.getName().equals("Ice_Purple")){
                URL urlImg = getClass().getResource("/resource/Ice_Brown.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Brown");
                this.item.setImg(imgTemp);

                if(this.syrupYellow.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Syrup_Yellow_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupYellow.setImg(imgTemp);
                    this.syrupYellow.setSize_now(2);
                }
                else if(this.syrupYellow.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Syrup_Yellow_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupYellow.setImg(imgTemp);
                    this.syrupYellow.setSize_now(1);
                }
                else if(this.syrupYellow.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Syrup_Yellow_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupYellow.setImg(imgTemp);
                    this.syrupYellow.setSize_now(0);
                }
            }

            if(syrupBlue.getSize_now() > 0 && isOverlapping(syrupBlue, evt) && item.getName().equals("Ice_Empty")){
                URL urlImg = getClass().getResource("/resource/Ice_Blue.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Blue");
                this.item.setImg(imgTemp);

                if(this.syrupBlue.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Syrup_Blue_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupBlue.setImg(imgTemp);
                    this.syrupBlue.setSize_now(2);
                }
                else if(this.syrupBlue.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Syrup_Blue_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupBlue.setImg(imgTemp);
                    this.syrupBlue.setSize_now(1);
                }
                else if(this.syrupBlue.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Syrup_Blue_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupBlue.setImg(imgTemp);
                    this.syrupBlue.setSize_now(0);
                }
            }

            if(syrupBlue.getSize_now() > 0 && isOverlapping(syrupBlue, evt) && item.getName().equals("Ice_Red")){
                URL urlImg = getClass().getResource("/resource/Ice_Purple.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Purple");
                this.item.setImg(imgTemp);

                if(this.syrupBlue.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Syrup_Blue_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupBlue.setImg(imgTemp);
                    this.syrupBlue.setSize_now(2);
                }
                else if(this.syrupBlue.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Syrup_Blue_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupBlue.setImg(imgTemp);
                    this.syrupBlue.setSize_now(1);
                }
                else if(this.syrupBlue.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Syrup_Blue_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupBlue.setImg(imgTemp);
                    this.syrupBlue.setSize_now(0);
                }
            }

            if(syrupBlue.getSize_now() > 0 && isOverlapping(syrupBlue, evt) && item.getName().equals("Ice_Yellow")){
                URL urlImg = getClass().getResource("/resource/Ice_Green.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Green");
                this.item.setImg(imgTemp);

                if(this.syrupBlue.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Syrup_Blue_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupBlue.setImg(imgTemp);
                    this.syrupBlue.setSize_now(2);
                }
                else if(this.syrupBlue.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Syrup_Blue_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupBlue.setImg(imgTemp);
                    this.syrupBlue.setSize_now(1);
                }
                else if(this.syrupBlue.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Syrup_Blue_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupBlue.setImg(imgTemp);
                    this.syrupBlue.setSize_now(0);
                }
            }

            if(syrupBlue.getSize_now() > 0 && isOverlapping(syrupBlue, evt) && item.getName().equals("Ice_Orange")){
                URL urlImg = getClass().getResource("/resource/Ice_Brown.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Brown");
                this.item.setImg(imgTemp);

                if(this.syrupBlue.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Syrup_Blue_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupBlue.setImg(imgTemp);
                    this.syrupBlue.setSize_now(2);
                }
                else if(this.syrupBlue.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Syrup_Blue_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupBlue.setImg(imgTemp);
                    this.syrupBlue.setSize_now(1);
                }
                else if(this.syrupBlue.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Syrup_Blue_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.syrupBlue.setImg(imgTemp);
                    this.syrupBlue.setSize_now(0);
                }
            }

            if(sprinkle.getSize_now() > 0 && isOverlapping(sprinkle, evt) && item.getName().equals("Ice_Red")){
                URL urlImg = getClass().getResource("/resource/Ice_Red_S.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Red_S");
                this.item.setImg(imgTemp);

                if(this.sprinkle.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Sprinkle_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(2);
                }
                else if(this.sprinkle.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Sprinkle_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(1);
                }
                else if(this.sprinkle.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Sprinkle_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(0);
                }
            }

            if(sprinkle.getSize_now() > 0 && isOverlapping(sprinkle, evt) && item.getName().equals("Ice_Yellow")){
                URL urlImg = getClass().getResource("/resource/Ice_Yellow_S.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Yellow_S");
                this.item.setImg(imgTemp);

                if(this.sprinkle.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Sprinkle_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(2);
                }
                else if(this.sprinkle.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Sprinkle_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(1);
                }
                else if(this.sprinkle.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Sprinkle_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(0);
                }
            }

            if(sprinkle.getSize_now() > 0 && isOverlapping(sprinkle, evt) && item.getName().equals("Ice_Blue")){
                URL urlImg = getClass().getResource("/resource/Ice_Blue_S.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Blue_S");
                this.item.setImg(imgTemp);

                if(this.sprinkle.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Sprinkle_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(2);
                }
                else if(this.sprinkle.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Sprinkle_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(1);
                }
                else if(this.sprinkle.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Sprinkle_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(0);
                }
            }

            if(sprinkle.getSize_now() > 0 && isOverlapping(sprinkle, evt) && item.getName().equals("Ice_Purple")){
                URL urlImg = getClass().getResource("/resource/Ice_Purple_S.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Purple_S");
                this.item.setImg(imgTemp);

                if(this.sprinkle.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Sprinkle_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(2);
                }
                else if(this.sprinkle.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Sprinkle_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(1);
                }
                else if(this.sprinkle.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Sprinkle_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(0);
                }
            }
            if(sprinkle.getSize_now() > 0 && isOverlapping(sprinkle, evt) && item.getName().equals("Ice_Orange")){
                URL urlImg = getClass().getResource("/resource/Ice_Orange_S.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Orange_S");
                this.item.setImg(imgTemp);

                if(this.sprinkle.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Sprinkle_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(2);
                }
                else if(this.sprinkle.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Sprinkle_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(1);
                }
                else if(this.sprinkle.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Sprinkle_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(0);
                }
            }

            if(sprinkle.getSize_now() > 0 && isOverlapping(sprinkle, evt) && item.getName().equals("Ice_Green")){
                URL urlImg = getClass().getResource("/resource/Ice_Green_S.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Green_S");
                this.item.setImg(imgTemp);

                if(this.sprinkle.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Sprinkle_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(2);
                }
                else if(this.sprinkle.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Sprinkle_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(1);
                }
                else if(this.sprinkle.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Sprinkle_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(0);
                }
            }

            if(sprinkle.getSize_now() > 0 && isOverlapping(sprinkle, evt) && item.getName().equals("Ice_Brown")){
                URL urlImg = getClass().getResource("/resource/Ice_Brown_S.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Brown_S");
                this.item.setImg(imgTemp);

                if(this.sprinkle.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Sprinkle_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(2);
                }
                else if(this.sprinkle.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Sprinkle_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(1);
                }
                else if(this.sprinkle.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Sprinkle_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(0);
                }
            }

            if(sprinkle.getSize_now() > 0 && isOverlapping(sprinkle, evt) && item.getName().equals("Ice_Red_O")){
                URL urlImg = getClass().getResource("/resource/Ice_Red_SO.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Red_SO");
                this.item.setImg(imgTemp);

                if(this.sprinkle.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Sprinkle_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(2);
                }
                else if(this.sprinkle.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Sprinkle_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(1);
                }
                else if(this.sprinkle.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Sprinkle_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(0);
                }
            }

            if(sprinkle.getSize_now() > 0 && isOverlapping(sprinkle, evt) && item.getName().equals("Ice_Yellow_O")){
                URL urlImg = getClass().getResource("/resource/Ice_Yellow_SO.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Yellow_SO");
                this.item.setImg(imgTemp);

                if(this.sprinkle.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Sprinkle_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(2);
                }
                else if(this.sprinkle.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Sprinkle_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(1);
                }
                else if(this.sprinkle.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Sprinkle_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(0);
                }
            }

            if(sprinkle.getSize_now() > 0 && isOverlapping(sprinkle, evt) && item.getName().equals("Ice_Blue_O")){
                URL urlImg = getClass().getResource("/resource/Ice_Blue_SO.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Blue_SO");
                this.item.setImg(imgTemp);

                if(this.sprinkle.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Sprinkle_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(2);
                }
                else if(this.sprinkle.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Sprinkle_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(1);
                }
                else if(this.sprinkle.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Sprinkle_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(0);
                }
            }

            if(sprinkle.getSize_now() > 0 && isOverlapping(sprinkle, evt) && item.getName().equals("Ice_Purple_O")){
                URL urlImg = getClass().getResource("/resource/Ice_Purple_SO.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Purple_SO");
                this.item.setImg(imgTemp);

                if(this.sprinkle.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Sprinkle_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(2);
                }
                else if(this.sprinkle.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Sprinkle_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(1);
                }
                else if(this.sprinkle.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Sprinkle_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(0);
                }
            }
            if(sprinkle.getSize_now() > 0 && isOverlapping(sprinkle, evt) && item.getName().equals("Ice_Orange_O")){
                URL urlImg = getClass().getResource("/resource/Ice_Orange_SO.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Orange_SO");
                this.item.setImg(imgTemp);

                if(this.sprinkle.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Sprinkle_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(2);
                }
                else if(this.sprinkle.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Sprinkle_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(1);
                }
                else if(this.sprinkle.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Sprinkle_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(0);
                }
            }

            if(sprinkle.getSize_now() > 0 && isOverlapping(sprinkle, evt) && item.getName().equals("Ice_Green_O")){
                URL urlImg = getClass().getResource("/resource/Ice_Green_SO.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Green_SO");
                this.item.setImg(imgTemp);

                if(this.sprinkle.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Sprinkle_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(2);
                }
                else if(this.sprinkle.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Sprinkle_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(1);
                }
                else if(this.sprinkle.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Sprinkle_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(0);
                }
            }

            if(sprinkle.getSize_now() > 0 && isOverlapping(sprinkle, evt) && item.getName().equals("Ice_Brown_O")){
                URL urlImg = getClass().getResource("/resource/Ice_Brown_SO.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Brown_SO");
                this.item.setImg(imgTemp);

                if(this.sprinkle.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Sprinkle_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(2);
                }
                else if(this.sprinkle.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Sprinkle_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(1);
                }
                else if(this.sprinkle.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Sprinkle_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.sprinkle.setImg(imgTemp);
                    this.sprinkle.setSize_now(0);
                }
            }

            if(ojo.getSize_now() > 0 && isOverlapping(ojo, evt) && item.getName().equals("Ice_Red")){
                URL urlImg = getClass().getResource("/resource/Ice_Red_O.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Red_O");
                this.item.setImg(imgTemp);

                if(this.ojo.getSize_now() == 7){
                    urlImg = getClass().getResource("/resource/Ojo_6.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(6);
                }
                else if(this.ojo.getSize_now() == 6){
                    urlImg = getClass().getResource("/resource/Ojo_5.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(5);
                }
                else if(this.ojo.getSize_now() == 5){
                    urlImg = getClass().getResource("/resource/Ojo_4.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(4);
                }
                else if(this.ojo.getSize_now() == 4){
                    urlImg = getClass().getResource("/resource/Ojo_3.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(3);
                }
                else if(this.ojo.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Ojo_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(2);
                }
                else if(this.ojo.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Ojo_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(1);
                }
                else if(this.ojo.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Ojo_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(0);
                }
            }

            if(ojo.getSize_now() > 0 && isOverlapping(ojo, evt) && item.getName().equals("Ice_Yellow")){
                URL urlImg = getClass().getResource("/resource/Ice_Yellow_O.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Yellow_O");
                this.item.setImg(imgTemp);

                if(this.ojo.getSize_now() == 7){
                    urlImg = getClass().getResource("/resource/Ojo_6.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(6);
                }
                else if(this.ojo.getSize_now() == 6){
                    urlImg = getClass().getResource("/resource/Ojo_5.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(5);
                }
                else if(this.ojo.getSize_now() == 5){
                    urlImg = getClass().getResource("/resource/Ojo_4.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(4);
                }
                else if(this.ojo.getSize_now() == 4){
                    urlImg = getClass().getResource("/resource/Ojo_3.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(3);
                }
                else if(this.ojo.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Ojo_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(2);
                }
                else if(this.ojo.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Ojo_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(1);
                }
                else if(this.ojo.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Ojo_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(0);
                }
            }

            if(ojo.getSize_now() > 0 && isOverlapping(ojo, evt) && item.getName().equals("Ice_Blue")){
                URL urlImg = getClass().getResource("/resource/Ice_Blue_O.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Blue_O");
                this.item.setImg(imgTemp);

                if(this.ojo.getSize_now() == 7){
                    urlImg = getClass().getResource("/resource/Ojo_6.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(6);
                }
                else if(this.ojo.getSize_now() == 6){
                    urlImg = getClass().getResource("/resource/Ojo_5.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(5);
                }
                else if(this.ojo.getSize_now() == 5){
                    urlImg = getClass().getResource("/resource/Ojo_4.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(4);
                }
                else if(this.ojo.getSize_now() == 4){
                    urlImg = getClass().getResource("/resource/Ojo_3.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(3);
                }
                else if(this.ojo.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Ojo_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(2);
                }
                else if(this.ojo.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Ojo_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(1);
                }
                else if(this.ojo.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Ojo_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(0);
                }
            }

            if(ojo.getSize_now() > 0 && isOverlapping(ojo, evt) && item.getName().equals("Ice_Purple")){
                URL urlImg = getClass().getResource("/resource/Ice_Purple_O.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Purple_O");
                this.item.setImg(imgTemp);

                if(this.ojo.getSize_now() == 7){
                    urlImg = getClass().getResource("/resource/Ojo_6.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(6);
                }
                else if(this.ojo.getSize_now() == 6){
                    urlImg = getClass().getResource("/resource/Ojo_5.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(5);
                }
                else if(this.ojo.getSize_now() == 5){
                    urlImg = getClass().getResource("/resource/Ojo_4.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(4);
                }
                else if(this.ojo.getSize_now() == 4){
                    urlImg = getClass().getResource("/resource/Ojo_3.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(3);
                }
                else if(this.ojo.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Ojo_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(2);
                }
                else if(this.ojo.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Ojo_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(1);
                }
                else if(this.ojo.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Ojo_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(0);
                }
            }
            if(ojo.getSize_now() > 0 && isOverlapping(ojo, evt) && item.getName().equals("Ice_Orange")){
                URL urlImg = getClass().getResource("/resource/Ice_Orange_O.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Orange_O");
                this.item.setImg(imgTemp);

                if(this.ojo.getSize_now() == 7){
                    urlImg = getClass().getResource("/resource/Ojo_6.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(6);
                }
                else if(this.ojo.getSize_now() == 6){
                    urlImg = getClass().getResource("/resource/Ojo_5.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(5);
                }
                else if(this.ojo.getSize_now() == 5){
                    urlImg = getClass().getResource("/resource/Ojo_4.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(4);
                }
                else if(this.ojo.getSize_now() == 4){
                    urlImg = getClass().getResource("/resource/Ojo_3.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(3);
                }
                else if(this.ojo.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Ojo_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(2);
                }
                else if(this.ojo.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Ojo_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(1);
                }
                else if(this.ojo.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Ojo_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(0);
                }
            }

            if(ojo.getSize_now() > 0 && isOverlapping(ojo, evt) && item.getName().equals("Ice_Green")){
                URL urlImg = getClass().getResource("/resource/Ice_Green_O.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Green_O");
                this.item.setImg(imgTemp);

                if(this.ojo.getSize_now() == 7){
                    urlImg = getClass().getResource("/resource/Ojo_6.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(6);
                }
                else if(this.ojo.getSize_now() == 6){
                    urlImg = getClass().getResource("/resource/Ojo_5.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(5);
                }
                else if(this.ojo.getSize_now() == 5){
                    urlImg = getClass().getResource("/resource/Ojo_4.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(4);
                }
                else if(this.ojo.getSize_now() == 4){
                    urlImg = getClass().getResource("/resource/Ojo_3.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(3);
                }
                else if(this.ojo.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Ojo_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(2);
                }
                else if(this.ojo.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Ojo_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(1);
                }
                else if(this.ojo.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Ojo_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(0);
                }
            }

            if(ojo.getSize_now() > 0 && isOverlapping(ojo, evt) && item.getName().equals("Ice_Brown")){
                URL urlImg = getClass().getResource("/resource/Ice_Brown_O.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Brown_O");
                this.item.setImg(imgTemp);

                if(this.ojo.getSize_now() == 7){
                    urlImg = getClass().getResource("/resource/Ojo_6.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(6);
                }
                else if(this.ojo.getSize_now() == 6){
                    urlImg = getClass().getResource("/resource/Ojo_5.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(5);
                }
                else if(this.ojo.getSize_now() == 5){
                    urlImg = getClass().getResource("/resource/Ojo_4.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(4);
                }
                else if(this.ojo.getSize_now() == 4){
                    urlImg = getClass().getResource("/resource/Ojo_3.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(3);
                }
                else if(this.ojo.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Ojo_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(2);
                }
                else if(this.ojo.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Ojo_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(1);
                }
                else if(this.ojo.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Ojo_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(0);
                }
            }

            if(ojo.getSize_now() > 0 && isOverlapping(ojo, evt) && item.getName().equals("Ice_Red_S")){
                URL urlImg = getClass().getResource("/resource/Ice_Red_SO.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Red_SO");
                this.item.setImg(imgTemp);

                if(this.ojo.getSize_now() == 7){
                    urlImg = getClass().getResource("/resource/Ojo_6.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(6);
                }
                else if(this.ojo.getSize_now() == 6){
                    urlImg = getClass().getResource("/resource/Ojo_5.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(5);
                }
                else if(this.ojo.getSize_now() == 5){
                    urlImg = getClass().getResource("/resource/Ojo_4.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(4);
                }
                else if(this.ojo.getSize_now() == 4){
                    urlImg = getClass().getResource("/resource/Ojo_3.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(3);
                }
                else if(this.ojo.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Ojo_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(2);
                }
                else if(this.ojo.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Ojo_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(1);
                }
                else if(this.ojo.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Ojo_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(0);
                }
            }

            if(ojo.getSize_now() > 0 && isOverlapping(ojo, evt) && item.getName().equals("Ice_Yellow_S")){
                URL urlImg = getClass().getResource("/resource/Ice_Yellow_SO.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Yellow_SO");
                this.item.setImg(imgTemp);

                if(this.ojo.getSize_now() == 7){
                    urlImg = getClass().getResource("/resource/Ojo_6.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(6);
                }
                else if(this.ojo.getSize_now() == 6){
                    urlImg = getClass().getResource("/resource/Ojo_5.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(5);
                }
                else if(this.ojo.getSize_now() == 5){
                    urlImg = getClass().getResource("/resource/Ojo_4.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(4);
                }
                else if(this.ojo.getSize_now() == 4){
                    urlImg = getClass().getResource("/resource/Ojo_3.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(3);
                }
                else if(this.ojo.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Ojo_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(2);
                }
                else if(this.ojo.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Ojo_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(1);
                }
                else if(this.ojo.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Ojo_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(0);
                }
            }

            if(ojo.getSize_now() > 0 && isOverlapping(ojo, evt) && item.getName().equals("Ice_Blue_S")){
                URL urlImg = getClass().getResource("/resource/Ice_Blue_SO.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Blue_SO");
                this.item.setImg(imgTemp);

                if(this.ojo.getSize_now() == 7){
                    urlImg = getClass().getResource("/resource/Ojo_6.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(6);
                }
                else if(this.ojo.getSize_now() == 6){
                    urlImg = getClass().getResource("/resource/Ojo_5.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(5);
                }
                else if(this.ojo.getSize_now() == 5){
                    urlImg = getClass().getResource("/resource/Ojo_4.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(4);
                }
                else if(this.ojo.getSize_now() == 4){
                    urlImg = getClass().getResource("/resource/Ojo_3.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(3);
                }
                else if(this.ojo.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Ojo_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(2);
                }
                else if(this.ojo.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Ojo_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(1);
                }
                else if(this.ojo.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Ojo_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(0);
                }
            }

            if(ojo.getSize_now() > 0 && isOverlapping(ojo, evt) &&
                    item.getName().equals("Ice_Purple_S")){
                URL urlImg = getClass().getResource("/resource/Ice_Purple_SO.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Purple_SO");
                this.item.setImg(imgTemp);

                if(this.ojo.getSize_now() == 7){
                    urlImg = getClass().getResource("/resource/Ojo_6.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(6);
                }
                else if(this.ojo.getSize_now() == 6){
                    urlImg = getClass().getResource("/resource/Ojo_5.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(5);
                }
                else if(this.ojo.getSize_now() == 5){
                    urlImg = getClass().getResource("/resource/Ojo_4.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(4);
                }
                else if(this.ojo.getSize_now() == 4){
                    urlImg = getClass().getResource("/resource/Ojo_3.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(3);
                }
                else if(this.ojo.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Ojo_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(2);
                }
                else if(this.ojo.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Ojo_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(1);
                }
                else if(this.ojo.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Ojo_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(0);
                }
            }
            if(ojo.getSize_now() > 0 && isOverlapping(ojo, evt) && item.getName().equals("Ice_Orange_S")){
                URL urlImg = getClass().getResource("/resource/Ice_Orange_SO.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Orange_SO");
                this.item.setImg(imgTemp);

                if(this.ojo.getSize_now() == 7){
                    urlImg = getClass().getResource("/resource/Ojo_6.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(6);
                }
                else if(this.ojo.getSize_now() == 6){
                    urlImg = getClass().getResource("/resource/Ojo_5.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(5);
                }
                else if(this.ojo.getSize_now() == 5){
                    urlImg = getClass().getResource("/resource/Ojo_4.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(4);
                }
                else if(this.ojo.getSize_now() == 4){
                    urlImg = getClass().getResource("/resource/Ojo_3.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(3);
                }
                else if(this.ojo.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Ojo_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(2);
                }
                else if(this.ojo.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Ojo_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(1);
                }
                else if(this.ojo.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Ojo_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(0);
                }
            }

            if(ojo.getSize_now() > 0 && isOverlapping(ojo, evt) && item.getName().equals("Ice_Green_S")){
                URL urlImg = getClass().getResource("/resource/Ice_Green_SO.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Green_SO");
                this.item.setImg(imgTemp);

                if(this.ojo.getSize_now() == 7){
                    urlImg = getClass().getResource("/resource/Ojo_6.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(6);
                }
                else if(this.ojo.getSize_now() == 6){
                    urlImg = getClass().getResource("/resource/Ojo_5.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(5);
                }
                else if(this.ojo.getSize_now() == 5){
                    urlImg = getClass().getResource("/resource/Ojo_4.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(4);
                }
                else if(this.ojo.getSize_now() == 4){
                    urlImg = getClass().getResource("/resource/Ojo_3.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(3);
                }
                else if(this.ojo.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Ojo_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(2);
                }
                else if(this.ojo.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Ojo_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(1);
                }
                else if(this.ojo.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Ojo_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(0);
                }
            }

            if(ojo.getSize_now() > 0 && isOverlapping(ojo, evt) && item.getName().equals("Ice_Brown_S")){
                URL urlImg = getClass().getResource("/resource/Ice_Brown_SO.png");
                Image imgTemp = new ImageIcon(urlImg).getImage();
                this.item.setName("Ice_Brown_SO");
                this.item.setImg(imgTemp);

                if(this.ojo.getSize_now() == 7){
                    urlImg = getClass().getResource("/resource/Ojo_6.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(6);
                }
                else if(this.ojo.getSize_now() == 6){
                    urlImg = getClass().getResource("/resource/Ojo_5.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(5);
                }
                else if(this.ojo.getSize_now() == 5){
                    urlImg = getClass().getResource("/resource/Ojo_4.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(4);
                }
                else if(this.ojo.getSize_now() == 4){
                    urlImg = getClass().getResource("/resource/Ojo_3.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(3);
                }
                else if(this.ojo.getSize_now() == 3){
                    urlImg = getClass().getResource("/resource/Ojo_2.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(2);
                }
                else if(this.ojo.getSize_now() == 2){
                    urlImg = getClass().getResource("/resource/Ojo_1.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(1);
                }
                else if(this.ojo.getSize_now() == 1){
                    urlImg = getClass().getResource("/resource/Ojo_Empty_Click.png");
                    imgTemp = new ImageIcon(urlImg).getImage();
                    this.ojo.setImg(imgTemp);
                    this.ojo.setSize_now(0);
                }
            }

            // Trashing 1454

            if(isOverlapping(bin, evt)){
                this.itemList.remove(item);
                penguin.setSize_now(penguin.getSize_now()-1);
            }

            if(isOverlappingCustomer(gp.getC1(), evt)){
                if(item.getName() == gp.getC1().getItem1()){
                    URL urlImg = getClass().getResource("/resource/Correct.png");
                    Image imgTemp = new ImageIcon(urlImg).getImage();
                    gp.getC1().setItem1("");
                    gp.getC1().setItem1Img(imgTemp);
                    itemList.remove(item);
                    penguin.setSize_now(penguin.getSize_now()-1);
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
                    penguin.setSize_now(penguin.getSize_now()-1);
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
                    penguin.setSize_now(penguin.getSize_now()-1);
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
                    penguin.setSize_now(penguin.getSize_now()-1);
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
                    penguin.setSize_now(penguin.getSize_now()-1);
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
                    penguin.setSize_now(penguin.getSize_now()-1);
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
                    penguin.setSize_now(penguin.getSize_now()-1);
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
                    penguin.setSize_now(penguin.getSize_now()-1);
                    if(gp.getC4().getItem1() == "" &&
                            gp.getC4().getItem2() == ""){
                        gp.setScore(gp.getScore()+gp.getC4().getScore()+gp.getS4());
                        gp.setS4(gp.getOverall().getDifficulty());
                        gp.createCustomer4();
                    }
                }
            }

            if(penguin.getSize_now() == 0){
                URL urlBg = getClass().getResource("/resource/Penguin_Ice_Click.png");
                penguin.setImg(new ImageIcon(urlBg).getImage());
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
