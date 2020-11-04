package com.game.Bomb;

import com.game.Enemy.Enemy;
import com.game.EnemyBullet.EnemyBullet;
import com.game.Panel.Main;
import com.game.Player.Player_Entity;
import com.game.PlayerBullet.PlayerBulletCreate;
import com.game.Util.GameMusic;

import javax.swing.*;
import java.awt.*;

public class Bomb implements Runnable{

    public static ImageIcon icon1_1;//敌人1销毁1
    public static ImageIcon icon1_2;//敌人1销毁2
    public static ImageIcon icon1_3;//敌人1销毁3
    public static ImageIcon icon1_4;//敌人1销毁4

    public static ImageIcon icon2_1;//敌人2销毁1
    public static ImageIcon icon2_2;//敌人2销毁2
    public static ImageIcon icon2_3;//敌人2销毁3
    public static ImageIcon icon2_4;//敌人2销毁4

    public static ImageIcon icon3_1;//敌人3销毁1
    public static ImageIcon icon3_2;//敌人3销毁2
    public static ImageIcon icon3_3;//敌人3销毁3
    public static ImageIcon icon3_4;//敌人3销毁4
    public static ImageIcon icon3_5;//敌人3销毁5
    public static ImageIcon icon3_6;//敌人3销毁6

    public static ImageIcon icon_skill;//地狱火炮字体

    public static volatile boolean isUse = false;

    static{
        //修建敌人1死亡1图片
        icon1_1 = new ImageIcon("src/img/enemy1_down1.png");
        Image temp1_1 = icon1_1.getImage().getScaledInstance(57, 43, icon1_1.getImage().SCALE_DEFAULT);
        icon1_1 = new ImageIcon(temp1_1);
        //修建敌人1死亡2图片
        icon1_2 = new ImageIcon("src/img/enemy1_down2.png");
        Image temp1_2 = icon1_2.getImage().getScaledInstance(57, 43, icon1_2.getImage().SCALE_DEFAULT);
        icon1_2 = new ImageIcon(temp1_2);
        //修建敌人1死亡3图片
        icon1_3 = new ImageIcon("src/img/enemy1_down3.png");
        Image temp1_3 = icon1_3.getImage().getScaledInstance(57, 43, icon1_3.getImage().SCALE_DEFAULT);
        icon1_3 = new ImageIcon(temp1_3);
        //修建敌人1死亡4图片
        icon1_4 = new ImageIcon("src/img/enemy1_down4.png");
        Image temp1_4 = icon1_4.getImage().getScaledInstance(57, 43, icon1_4.getImage().SCALE_DEFAULT);
        icon1_4 = new ImageIcon(temp1_4);



        //修建敌人2死亡1图片
        icon2_1 = new ImageIcon("src/img/enemy2_down1.png");
        Image temp2_1 = icon2_1.getImage().getScaledInstance(69, 99, icon2_1.getImage().SCALE_DEFAULT);
        icon2_1 = new ImageIcon(temp2_1);
        //修建敌人2死亡2图片
        icon2_2 = new ImageIcon("src/img/enemy2_down2.png");
        Image temp2_2 = icon2_2.getImage().getScaledInstance(69, 99, icon2_2.getImage().SCALE_DEFAULT);
        icon2_2 = new ImageIcon(temp2_2);
        //修建敌人2死亡3图片
        icon2_3 = new ImageIcon("src/img/enemy2_down3.png");
        Image temp2_3 = icon2_3.getImage().getScaledInstance(69, 99, icon2_3.getImage().SCALE_DEFAULT);
        icon2_3 = new ImageIcon(temp2_3);
        //修建敌人2死亡4图片
        icon2_4 = new ImageIcon("src/img/enemy2_down4.png");
        Image temp2_4 = icon2_4.getImage().getScaledInstance(69, 99, icon2_4.getImage().SCALE_DEFAULT);
        icon2_4 = new ImageIcon(temp2_4);



        //修建敌人3死亡1图片
        icon3_1 = new ImageIcon("src/img/enemy3_down1.png");
        Image temp3_1 = icon3_1.getImage().getScaledInstance(111, 171, icon3_1.getImage().SCALE_DEFAULT);
        icon3_1 = new ImageIcon(temp3_1);
        //修建敌人3死亡2图片
        icon3_2 = new ImageIcon("src/img/enemy3_down2.png");
        Image temp3_2 = icon3_2.getImage().getScaledInstance(111, 171, icon3_2.getImage().SCALE_DEFAULT);
        icon3_2 = new ImageIcon(temp3_2);
        //修建敌人3死亡3图片
        icon3_3 = new ImageIcon("src/img/enemy3_down3.png");
        Image temp3_3 = icon3_3.getImage().getScaledInstance(111, 171, icon3_3.getImage().SCALE_DEFAULT);
        icon3_3 = new ImageIcon(temp3_3);
        //修建敌人3死亡4图片
        icon3_4 = new ImageIcon("src/img/enemy3_down4.png");
        Image temp3_4 = icon3_4.getImage().getScaledInstance(111, 171, icon3_4.getImage().SCALE_DEFAULT);
        icon3_4 = new ImageIcon(temp3_4);
        //修建敌人3死亡5图片
        icon3_5 = new ImageIcon("src/img/enemy3_down5.png");
        Image temp3_5 = icon3_5.getImage().getScaledInstance(111, 171, icon3_5.getImage().SCALE_DEFAULT);
        icon3_5 = new ImageIcon(temp3_5);
        //修建敌人3死亡6图片
        icon3_6 = new ImageIcon("src/img/enemy3_down6.png");
        Image temp3_6 = icon3_6.getImage().getScaledInstance(111, 171, icon3_6.getImage().SCALE_DEFAULT);
        icon3_6 = new ImageIcon(temp3_6);

        //地狱火炮
        icon_skill = new ImageIcon("src/img/地狱火炮.png");
        Image temp_skill = icon_skill.getImage().getScaledInstance(423, 296, icon_skill.getImage().SCALE_DEFAULT);
        icon_skill = new ImageIcon(temp_skill);


    }

    @Override
    public void run() {
        while (true){
            if(isUse){
                //如果炸弹数>0
                if(Main.player_entity.bomb>0){
                    //玩家炸弹数-1
                    Main.player_entity.bomb--;
                    //重新设置炸弹数量
                    Main.label_bomb_count.setText(" X "+Main.player_entity.bomb);

                    //暂停PlayerBulletCreate线程（不要继续创建以及移动子弹啦）  isTrue是PlayerBulletCreate的标志位
                    PlayerBulletCreate.isActive=false;
                    //暂停EnemyBullet线程（不要继续创建以及移动敌人子弹啦）
                    EnemyBullet.isTrue=false;
                    //暂停玩家collision方法（不要继续判断玩家碰撞检测方法了）
                    Player_Entity.isTure = false;
                    //暂停Enemy线程（不要继续创建及移动敌人）
                    Enemy.isTure = false;
                    //缓冲20ms 不能直接清空集合，否则数组下标越界
                    try{
                        Thread.sleep(20);
                    }catch (Exception E){
                        E.printStackTrace();
                    }
                    //开启一个线程播放地狱火炮特效
                    new Thread(()->{
                        //创建地狱火炮label
                        JLabel label = new JLabel();
                        label.setIcon(icon_skill);
                        label.setBounds(415, 120, 423, 296);
                        //将字体特效添加到面板
                        Main.jp1.add(label);
                        //字体入场特效
                        for(int i=1;i<=190;i++){
                            try {
                                Thread.sleep(1);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            label.setLocation(label.getX()-2, label.getY());
                        }

                        try {
                            Thread.sleep(1000);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        for(int i=1;i<=190;i++){
                            try {
                                Thread.sleep(1);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            label.setLocation(label.getX()-2, label.getY());
                        }
                        Main.jp1.remove(label);
                    }).start();

                    //开启一个线程播放全屏炸弹音乐
                    new Thread(()->{
                        GameMusic.Play("src/music/地狱火炮.wav",2);
                    }).start();

                    //遍历子弹集合
                    for(int j=0;j<Main.bullets_list.size();j++){
                        //从面板上删除该子弹
                        Main.jp1.remove(Main.bullets_list.get(j));
                        //从子弹集合中删除该子弹
                        Main.bullets_list.remove(Main.bullets_list.get(j));
                        j--;
                    }
                    //对panel1本身进行重绘
                    Main.jp1.repaint();
                    //遍历敌人子弹集合
                    for(int j=0;j<Main.enemy_bullets_list.size();j++){
                        //从面板上删除该敌人子弹
                        Main.jp1.remove(Main.enemy_bullets_list.get(j).label);
                        //从敌人子弹集合中删除该子弹
                        Main.enemy_bullets_list.remove(Main.enemy_bullets_list.get(j));
                        j--;
                    }
                    //对panel1本身进行重绘
                    Main.jp1.repaint();
                    //从面板上删除所有敌人
                    for(int i=0;i<Main.enemy_list.size();i++){
                        //待死亡
                        if(Main.enemy_list.get(i).num==1){
                            //设置敌人1销毁图片1-4
                            Main.enemy_list.get(i).label.setIcon(icon1_1);
                            try{
                                Thread.sleep(100);
                            }catch (Exception E){
                                E.printStackTrace();
                            }
                            Main.enemy_list.get(i).label.setIcon(icon1_2);
                            try{
                                Thread.sleep(100);
                            }catch (Exception E){
                                E.printStackTrace();
                            }
                            Main.enemy_list.get(i).label.setIcon(icon1_3);
                            try{
                                Thread.sleep(100);
                            }catch (Exception E){
                                E.printStackTrace();
                            }
                            Main.enemy_list.get(i).label.setIcon(icon1_4);
                        }else if(Main.enemy_list.get(i).num==2){
                            //设置敌人2销毁图片1-4
                            Main.enemy_list.get(i).label.setIcon(icon2_1);
                            try{
                                Thread.sleep(100);
                            }catch (Exception E){
                                E.printStackTrace();
                            }
                            Main.enemy_list.get(i).label.setIcon(icon2_2);
                            try{
                                Thread.sleep(100);
                            }catch (Exception E){
                                E.printStackTrace();
                            }
                            Main.enemy_list.get(i).label.setIcon(icon2_3);
                            try{
                                Thread.sleep(100);
                            }catch (Exception E){
                                E.printStackTrace();
                            }
                            Main.enemy_list.get(i).label.setIcon(icon2_4);
                        }else{
                            //设置敌人3销毁图片1-6
                            Main.enemy_list.get(i).label.setIcon(icon3_1);
                            try{
                                Thread.sleep(60);
                            }catch (Exception E){
                                E.printStackTrace();
                            }
                            Main.enemy_list.get(i).label.setIcon(icon3_2);
                            try{
                                Thread.sleep(60);
                            }catch (Exception E){
                                E.printStackTrace();
                            }
                            Main.enemy_list.get(i).label.setIcon(icon3_3);
                            try{
                                Thread.sleep(60);
                            }catch (Exception E){
                                E.printStackTrace();
                            }
                            Main.enemy_list.get(i).label.setIcon(icon3_4);
                            try{
                                Thread.sleep(60);
                            }catch (Exception E){
                                E.printStackTrace();
                            }
                            Main.enemy_list.get(i).label.setIcon(icon3_5);
                            try{
                                Thread.sleep(60);
                            }catch (Exception E){
                                E.printStackTrace();
                            }
                            Main.enemy_list.get(i).label.setIcon(icon3_6);
                        }
                        try{
                            Thread.sleep(100);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        //积分增加
                        Main.score+=Main.enemy_list.get(i).num*10;
                        //重新设置积分榜显示
                        Main.label_Score.setText("当前积分:"+Main.score);
                        //从面板中删除该敌人
                        Main.jp1.remove(Main.enemy_list.get(i).label);
                        //从集合中删除该敌人
                        Main.enemy_list.remove(Main.enemy_list.get(i));
                        i--;
                        Main.jp1.repaint();//对panel1本身进行重绘
                    }
                    //重新开启Enemy线程（继续创建及移动敌人）
                    Enemy.isTure = true;
                    //重新开始玩家碰撞检测方法
                    Player_Entity.isTure = true;
                    //重新开启PlayerBulletCreate线程
                    PlayerBulletCreate.isActive=true;
                    //先生成敌人再生成敌人子弹
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    //重新开启EnemyBullet线程
                    EnemyBullet.isTrue=true;

                }else{
                    new Thread(()->{
                        GameMusic.Play("src/music/全屏炸弹不足.wav",2);
                    }).start();
                }

                isUse = false;
            }
        }
    }
}
