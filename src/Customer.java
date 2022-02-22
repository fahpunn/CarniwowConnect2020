import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class Customer {

    private Random rand;
    private ArrayList<String> itemList1, itemList2;
    private String item1, item2;
    private Image item1Img, item2Img;
    private Image img;
    private int x;
    private int y;
    private int score;

    public Customer(Image img, int x, int y) {

        score = 0;

        itemList1 = new ArrayList<String>();
        itemList1.add("Ice_Empty");
        itemList1.add("Ice_Red");itemList1.add("Ice_Red_O");itemList1.add("Ice_Red_SO");
        itemList1.add("Ice_Yellow");itemList1.add("Ice_Yellow_O");itemList1.add("Ice_Yellow_SO");
        itemList1.add("Ice_Blue");itemList1.add("Ice_Blue_O");itemList1.add("Ice_Blue_SO");
        itemList1.add("Ice_Green");itemList1.add("Ice_Green_O");itemList1.add("Ice_Green_SO");
        itemList1.add("Ice_Orange");itemList1.add("Ice_Orange_O");itemList1.add("Ice_Orange_SO");
        itemList1.add("Ice_Purple");itemList1.add("Ice_Purple_O");itemList1.add("Ice_Purple_SO");
        itemList1.add("Ice_Brown");itemList1.add("Ice_Brown_O");itemList1.add("Ice_Brown_SO");

        itemList2 = new ArrayList<String>();
        itemList2.add("Marshmello_Burned");itemList2.add("Popcorn_Empty");
        itemList2.add("Popcorn_Star");itemList2.add("Popcorn_Sun");itemList2.add("Popcorn_Moon");

        rand = new Random();
        int r1 = rand.nextInt(itemList1.size());
        int r2 = rand.nextInt(itemList2.size());

        item1 = itemList1.get(r1);
        item2 = itemList2.get(r2);

        URL urlBg = getClass().getResource("/resource/"+item1+".png");
        item1Img = new ImageIcon(urlBg).getImage();

        urlBg = getClass().getResource("/resource/"+item2+".png");
        item2Img = new ImageIcon(urlBg).getImage();

        this.img = img;
        this.x = x;
        this.y = y;

        if(item1 == "Ice_Empty"){
            score += 30;
        }
        else if(item1 == "Ice_Red" || item1 == "Ice_Yellow" || item1 == "Ice_Blue"||
                item1 == "Ice_Green" || item1 == "Ice_Orange" || item1 == "Ice_Purple" ||
                item1 == "Ice_Brown"){
            score += 40;
        }
        else if(item1 == "Ice_Red_S" || item1 == "Ice_Yellow_S" || item1 == "Ice_Blue_S"||
                item1 == "Ice_Green_S" || item1 == "Ice_Orange_S" || item1 == "Ice_Purple_S" ||
                item1 == "Ice_Brown_S"|| item1 == "Ice_Yellow_O" || item1 == "Ice_Blue_O"||
                item1 == "Ice_Green_O" || item1 == "Ice_Orange_O" || item1 == "Ice_Purple_O" ||
                item1 == "Ice_Brown_O" || item1 == "Ice_Red_O"){
            score += 50;
        }
        else if(item1 == "Ice_Red_SO" || item1 == "Ice_Yellow_SO" || item1 == "Ice_Blue_SO"||
                item1 == "Ice_Green_SO" || item1 == "Ice_Orange_SO" || item1 == "Ice_Purple_SO" ||
                item1 == "Ice_Brown_SO"){
            score += 60;
        }

        if(item2 == "Popcorn_Empty" || item2 == "Marshmello_Burned"){
            score += 30;
        }
        else if(item2 == "Popcorn_Moon" || item2 == "Popcorn_Sun" || item2 == "Popcorn_Star"){
            score += 40;
        }

    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getItem1() {
        return item1;
    }

    public void setItem1(String item1) {
        this.item1 = item1;
    }

    public String getItem2() {
        return item2;
    }

    public void setItem2(String item2) {
        this.item2 = item2;
    }

    public Image getItem1Img() {
        return item1Img;
    }

    public void setItem1Img(Image item1Img) {
        this.item1Img = item1Img;
    }

    public Image getItem2Img() {
        return item2Img;
    }

    public void setItem2Img(Image item2Img) {
        this.item2Img = item2Img;
    }

    public int getWidth() {
        return img.getWidth(null);
    }

    public int getHeight() {
        return img.getHeight(null);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
