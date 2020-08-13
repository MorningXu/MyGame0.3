package cn.MorningXu.game;

import java.awt.Color;
import java.awt.Graphics;


public class Shell extends GameObject{
    double degree;

    public Shell (){
        x = 200;
        y = 200;
        degree = Math.random()*2*Math.PI;
        width = 10;
        height = 10;
        speed = 3;
    }

    public void draw(Graphics g){
        Color c = g.getColor();
        g.setColor (Color.YELLOW) ;
        g.fillOval((int)x , (int) y , width , height);
        x += speed*Math.cos(degree);
        y += speed*Math.sin(degree);
        if(y<20 || y > Constands.FRAME_HEIGHT - height){
            degree = -degree;
        }
        if(x < 0 || x > Constands.FRAME_WIDTH - width){
            degree = Math.PI - degree;
        }
        g.setColor(c);
    }
}
