package cn.MorningXu.game;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyGameFrame extends JFrame{

    Image bgImg = GameUtil.getImage("Image/bg.jpg");
    Image planeImg = GameUtil.getImage("Image/plane.png");
    Plane plane = new Plane(planeImg,300,300);

    public void paint(Graphics g){
        g.drawImage(bgImg,0,0,null);
        plane.drawMySelf(g);
    }

    class PaintThread extends Thread{
        public void run(){
            while(true){
                repaint();
                try{
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public void launchFrame(){
        setTitle("MyGame");//设置标题
        setSize(500,500);
        setVisible(true);
        setLocation(300,300);
        //增加关闭窗口监听
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        new PaintThread().start();
    }

    public static void main(String[] args) {
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();
    }

    //private class Thrend {
   // }
}