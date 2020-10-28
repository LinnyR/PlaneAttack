package com.game.Player;

import com.game.Panel.Main;
import com.game.PlayerBullet.PlayerBulletCreate;

import java.awt.event.KeyEvent;

public class Player implements Runnable{
    public static int health = 3;
    public static int bomb = 3;
    public static int level = 2;
    volatile int key;
    int dir =0;// 1左  5上  2下  3右
    public void setKey(int key){
        this.key = key;
    }

    @Override
    public void run() {
        //开启创建子弹线程
        PlayerBulletCreate playerBullet = new PlayerBulletCreate();
        Thread player_bullet_thread = new Thread(playerBullet);
        player_bullet_thread.start();
        while (true){
            //向上移动
            if(key== KeyEvent.VK_W){
                try{
                    Thread.sleep(8);
                }catch (Exception e){
                    e.printStackTrace();
                }
                Main.player_entity.label.setLocation(Main.player_entity.label.getX(), (Main.player_entity.label.getY()+700-2)%700);
                dir=5;
            }else if(key == KeyEvent.VK_S){
                try{
                    Thread.sleep(8);
                }catch (Exception e){
                    e.printStackTrace();
                }
                Main.player_entity.label.setLocation(Main.player_entity.label.getX(), (Main.player_entity.label.getY()+2)%700);
                dir = 2;
            }else if(key ==KeyEvent.VK_A){
                try{
                    Thread.sleep(8);
                }catch (Exception e){
                    e.printStackTrace();
                }
                Main.player_entity.label.setLocation((Main.player_entity.label.getX()+480-2)%480, Main.player_entity.label.getY());
                dir = 1;
            }else if(key==KeyEvent.VK_D){
                try{
                    Thread.sleep(8);
                }catch (Exception e){
                    e.printStackTrace();
                }
                Main.player_entity.label.setLocation((Main.player_entity.label.getX()+2)%480, Main.player_entity.label.getY());
                dir = 3;
            }else{
                if(dir==5){
                    try{
                        Thread.sleep(8);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    Main.player_entity.label.setLocation(Main.player_entity.label.getX(), (Main.player_entity.label.getY()+700-2)%700);
                }else if(dir==2){
                    try{
                        Thread.sleep(8);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    Main.player_entity.label.setLocation(Main.player_entity.label.getX(), (Main.player_entity.label.getY()+2)%700);
                }else if(dir==1){
                    try{
                        Thread.sleep(8);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    Main.player_entity.label.setLocation((Main.player_entity.label.getX()+480-2)%480, Main.player_entity.label.getY());
                }else if(dir==3){
                    try{
                        Thread.sleep(8);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    Main.player_entity.label.setLocation((Main.player_entity.label.getX()+2)%480, Main.player_entity.label.getY());
                }
            }
            //移动的时候判断碰撞
            Main.player_entity.collision();
        }
    }
}
