package cn.MorningXu.game;

import java.awt.Graphics;
import java.awt.Image;

public class Plane extends GameObject{
    @Override
    public void drawMySelf(Graphics g){
        super.drawMySelf(g);

        this.x = x+3;
    }

    public Plane(Image img , double x , double y){
        this.img = img;
        this.x = x;
        this.y = y;

    }
}
