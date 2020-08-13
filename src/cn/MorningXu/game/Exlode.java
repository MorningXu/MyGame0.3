package cn.MorningXu.game;

import java.awt.Image;
import java.awt.Graphics;

public class Exlode {
    double x,y;
    static Image[] images = new Image[16];
    static{
        for(int i = 0 ;i <16; i++){
            images[i] = GameUtil.getImage("Image/exlode/e"+(i+1)+".gif");
            images[i].getWidth(null);
        }
    }
    int count;

    public void draw(Graphics g){
        if(count<=15){
            g.drawImage(images[count],(int) x ,(int) y , null );
            count++;
        }

    }

    public Exlode(double x, double y ){
        this.x = x;
        this.y = y;
    }
}
