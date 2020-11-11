package com.game.Boss;

import com.game.Enemy.Enemy;
import com.game.EnemyBullet.EnemyBullet;
import com.game.Panel.Main;
import com.game.Player.Player_Entity;
import com.game.PlayerBullet.PlayerBulletCreate;
import com.game.Util.GameMusic;

import javax.swing.*;
import java.awt.*;

public class Boss implements Runnable {


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


    public static ImageIcon icon_warning;//警告
    public static ImageIcon icon_boss_health;//血量
    public static ImageIcon icon_boss_health_bottom;//血量底
    public static ImageIcon icon_boss1;//boss1
    public static ImageIcon icon_boss2;//boss2
    public static ImageIcon icon_boss3;//boss3

    public static volatile boolean boss_appear = false;

    static {
        //修建敌人1死亡1图片
        icon1_1 = new ImageIcon("src/img/enemy1_down1.png");
        Image temp1_1 = icon1_1.getImage().getScaledInstance(71, 44, icon1_1.getImage().SCALE_DEFAULT);
        icon1_1 = new ImageIcon(temp1_1);
        //修建敌人1死亡2图片
        icon1_2 = new ImageIcon("src/img/enemy1_down2.png");
        Image temp1_2 = icon1_2.getImage().getScaledInstance(71, 44, icon1_2.getImage().SCALE_DEFAULT);
        icon1_2 = new ImageIcon(temp1_2);
        //修建敌人1死亡3图片
        icon1_3 = new ImageIcon("src/img/enemy1_down3.png");
        Image temp1_3 = icon1_3.getImage().getScaledInstance(71, 44, icon1_3.getImage().SCALE_DEFAULT);
        icon1_3 = new ImageIcon(temp1_3);
        //修建敌人1死亡4图片
        icon1_4 = new ImageIcon("src/img/enemy1_down4.png");
        Image temp1_4 = icon1_4.getImage().getScaledInstance(71, 44, icon1_4.getImage().SCALE_DEFAULT);
        icon1_4 = new ImageIcon(temp1_4);


        //修建敌人2死亡1图片
        icon2_1 = new ImageIcon("src/img/enemy2_down1.png");
        Image temp2_1 = icon2_1.getImage().getScaledInstance(118, 92, icon2_1.getImage().SCALE_DEFAULT);
        icon2_1 = new ImageIcon(temp2_1);
        //修建敌人2死亡2图片
        icon2_2 = new ImageIcon("src/img/enemy2_down2.png");
        Image temp2_2 = icon2_2.getImage().getScaledInstance(118, 92, icon2_2.getImage().SCALE_DEFAULT);
        icon2_2 = new ImageIcon(temp2_2);
        //修建敌人2死亡3图片
        icon2_3 = new ImageIcon("src/img/enemy2_down3.png");
        Image temp2_3 = icon2_3.getImage().getScaledInstance(118, 92, icon2_3.getImage().SCALE_DEFAULT);
        icon2_3 = new ImageIcon(temp2_3);
        //修建敌人2死亡4图片
        icon2_4 = new ImageIcon("src/img/enemy2_down4.png");
        Image temp2_4 = icon2_4.getImage().getScaledInstance(118, 92, icon2_4.getImage().SCALE_DEFAULT);
        icon2_4 = new ImageIcon(temp2_4);


        //修建敌人3死亡1图片
        icon3_1 = new ImageIcon("src/img/enemy3_down1.png");
        Image temp3_1 = icon3_1.getImage().getScaledInstance(186, 116, icon3_1.getImage().SCALE_DEFAULT);
        icon3_1 = new ImageIcon(temp3_1);
        //修建敌人3死亡2图片
        icon3_2 = new ImageIcon("src/img/enemy3_down2.png");
        Image temp3_2 = icon3_2.getImage().getScaledInstance(186, 116, icon3_2.getImage().SCALE_DEFAULT);
        icon3_2 = new ImageIcon(temp3_2);
        //修建敌人3死亡3图片
        icon3_3 = new ImageIcon("src/img/enemy3_down3.png");
        Image temp3_3 = icon3_3.getImage().getScaledInstance(186, 116, icon3_3.getImage().SCALE_DEFAULT);
        icon3_3 = new ImageIcon(temp3_3);
        //修建敌人3死亡4图片
        icon3_4 = new ImageIcon("src/img/enemy3_down4.png");
        Image temp3_4 = icon3_4.getImage().getScaledInstance(186, 116, icon3_4.getImage().SCALE_DEFAULT);
        icon3_4 = new ImageIcon(temp3_4);
        //修建敌人3死亡5图片
        icon3_5 = new ImageIcon("src/img/enemy3_down5.png");
        Image temp3_5 = icon3_5.getImage().getScaledInstance(186, 116, icon3_5.getImage().SCALE_DEFAULT);
        icon3_5 = new ImageIcon(temp3_5);
        //修建敌人3死亡6图片
        icon3_6 = new ImageIcon("src/img/enemy3_down6.png");
        Image temp3_6 = icon3_6.getImage().getScaledInstance(186, 116, icon3_6.getImage().SCALE_DEFAULT);
        icon3_6 = new ImageIcon(temp3_6);

        //修建警告图片
        icon_warning = new ImageIcon("src/img/警告.png");
        Image temp_warning = icon_warning.getImage().getScaledInstance(225, 148, icon_warning.getImage().SCALE_DEFAULT);
        icon_warning = new ImageIcon(temp_warning);

        //修建血量图片
        icon_boss_health = new ImageIcon("src/img/血量.png");
        Image temp_boss_health= icon_boss_health.getImage().getScaledInstance(450, 8, icon_boss_health.getImage().SCALE_DEFAULT);
        icon_boss_health = new ImageIcon(temp_boss_health);
        //修建血量底图片
        icon_boss_health_bottom = new ImageIcon("src/img/血量底.png");
        Image temp_health_bottom = icon_boss_health_bottom.getImage().getScaledInstance(450, 8, icon_boss_health_bottom.getImage().SCALE_DEFAULT);
        icon_boss_health_bottom = new ImageIcon(temp_health_bottom);
        //修建boss1图片
        icon_boss1 = new ImageIcon("src/img/boss1.png");
        Image temp_boss = icon_boss1.getImage().getScaledInstance(203, 216, icon_boss1.getImage().SCALE_DEFAULT);
        icon_boss1 = new ImageIcon(temp_boss);
    }

    public void run(){
        int appear_score=300;
        while (true){
            //如果分数达到boss出现标准
            if(Main.score>=appear_score){
                //创建boss图片
                JLabel label_boss = new JLabel();
                label_boss.setIcon(icon_boss1);
                label_boss.setBounds(30, -200, 203, 216);
                //赋值给boss实体类
                Main.boss = new Boss_Entity(2000,2000, label_boss,1);

                boss_appear = true;//禁止使用炸弹
                //等Bomb线程都设置为true后再执行
                try{
                    Thread.sleep(2000);
                }catch (Exception E){
                    E.printStackTrace();
                }
                System.out.println("BOSS出现");
                //暂停PlayerBulletCreate线程（不要继续创建以及移动子弹啦）  isTrue是PlayerBulletCreate的标志位
                PlayerBulletCreate.isActive=false;
                //必须延迟20ms 否则PlayerBulletCreate玩家子弹击中敌人 加分后 会重新开启Enemy线程 继续创建及移动敌人
                //Enemy: false 爆炸 加分 false(!让他延后)  true
                try{
                    Thread.sleep(30);
                }catch (Exception E){
                    E.printStackTrace();
                }
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


                //遍历玩家子弹集合
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
                    //从面板中删除该敌人
                    Main.jp1.remove(Main.enemy_list.get(i).label);
                    //从集合中删除该敌人
                    Main.enemy_list.remove(Main.enemy_list.get(i));
                    i--;
                    Main.jp1.repaint();//对panel1本身进行重绘
                }
                //设置警告图片及特效
                JLabel label_warning = new JLabel();
                Main.jp1.add(label_warning);
                label_warning.setIcon(icon_warning);
                label_warning.setBounds(500, 220, 225, 148);
                //开启一个线程播放警告音效
                new Thread(()->{
                    GameMusic.Play("src/music/警告.wav", 2.0);
                }).start();
                //警告图片滑动进入
                for (int i=1;i<=190;i++){
                    try {
                        Thread.sleep(1);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    label_warning.setLocation(label_warning.getX()-2, label_warning.getY());
                }
                try {
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }
                //闪烁八次
                for(int i=0;i<8;i++){
                    label_warning.setVisible(false);
                    try {
                        Thread.sleep(160);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    Main.jp1.repaint();
                    label_warning.setVisible(true);
                    try {
                        Thread.sleep(160);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    Main.jp1.repaint();
                }
                //滑动出场
                for (int i=1;i<=190;i++){
                    try {
                        Thread.sleep(1);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    label_warning.setLocation(label_warning.getX()-2, label_warning.getY());
                }
                //删除该警告图片
                Main.jp1.remove(label_warning);

                //创建血量与血量底label
                JLabel label_health = new JLabel();
                JLabel label_health_bottom = new JLabel();
                Main.jp1.add(label_health);
                Main.jp1.add(label_health_bottom);
                label_health.setIcon(icon_boss_health);
                label_health_bottom.setIcon(icon_boss_health_bottom);

                label_health.setBounds(10, 560,450,8);
                label_health_bottom.setBounds(10, 560,450,8);


                //将boss图片添加到面板
                Main.jp1.add(Main.boss.label);
                //boss下滑入场
                for(int i=1;i<=210;i++){
                    try{
                        Thread.sleep(5);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    label_boss.setLocation(Main.boss.label.getX(), Main.boss.label.getY()+1);
                }
                //重新开启PlayerBulletCreate线程
                PlayerBulletCreate.isActive=true;
                //重新开启玩家collision方法（继续判断玩家碰撞检测方法了）
                Player_Entity.isTure = true;
                //如果boss还有血
                while (Main.boss.cur_health>0){
                    //左右移动
                    for(int i=1;i<=210;i++){
                        try{
                            Thread.sleep(10);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        //重新设置血条
                        label_health.setBounds(label_health.getX(), label_health.getY(), (int)(((double)Main.boss.cur_health/Main.boss.total_health)*450),8);
                        //Boss移动
                        Main.boss.label.setLocation(Main.boss.label.getX()+Main.boss.dir, Main.boss.label.getY());
                    }
                    //方向相反
                    Main.boss.dir = -Main.boss.dir;
                }
//                while (health>=0){
//                    health-=3;
//                    try {
//                        Thread.sleep(100);
//                    }catch (Exception e){
//                        e.printStackTrace();
//                    }
//                    label_health.setBounds(10, 560, (int)(((double)health/1000)*label_health.getWidth()), label_health.getHeight());
//                }

                //设置背景图片
                appear_score+=300;
            }
        }

    }
}
