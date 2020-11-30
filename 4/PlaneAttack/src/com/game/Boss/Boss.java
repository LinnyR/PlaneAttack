package com.game.Boss;

import com.game.BossBullet.BossBullet;
import com.game.Enemy.Enemy;
import com.game.EnemyBullet.EnemyBullet;
import com.game.Panel.Main;
import com.game.Player.Player_Entity;
import com.game.PlayerBullet.PlayerBulletCreate;
import com.game.Util.GameMusic;

import javax.swing.*;
import java.awt.*;

public class Boss implements Runnable {

    public int appear_score = 1000;//Boss出现分数
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


    public static ImageIcon icon_warning0;//警告0
    public static ImageIcon icon_warning1;//警告1
    public static ImageIcon icon_warning2;//警告2
    public static ImageIcon icon_warning3;//警告3
    public static ImageIcon icon_boss_health;//血量
    public static ImageIcon icon_boss_health_bottom;//血量底
    public static ImageIcon icon_boss1;//boss1
    public static ImageIcon icon_boss2;//boss2
    public static ImageIcon icon_boss3;//boss3
    public static ImageIcon icon_boss1_name;//boss1名字
    public static ImageIcon icon_boss2_name;//boss2名字
    public static ImageIcon icon_boss3_name;//boss3名字

    public static ImageIcon icon_boss_boom_1;//Boss爆炸1
    public static ImageIcon icon_boss_boom_2;//Boss爆炸2
    public static ImageIcon icon_boss_boom_3;//Boss爆炸3
    public static ImageIcon icon_boss_boom_4;//Boss爆炸4
    public static ImageIcon icon_boss_boom_5;//Boss爆炸5
    public static ImageIcon icon_boss_boom_6;//Boss爆炸6


    //Boss是否出现
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
        Image temp3_1 = icon3_1.getImage().getScaledInstance(165, 105, icon3_1.getImage().SCALE_DEFAULT);
        icon3_1 = new ImageIcon(temp3_1);
        //修建敌人3死亡2图片
        icon3_2 = new ImageIcon("src/img/enemy3_down2.png");
        Image temp3_2 = icon3_2.getImage().getScaledInstance(165, 105, icon3_2.getImage().SCALE_DEFAULT);
        icon3_2 = new ImageIcon(temp3_2);
        //修建敌人3死亡3图片
        icon3_3 = new ImageIcon("src/img/enemy3_down3.png");
        Image temp3_3 = icon3_3.getImage().getScaledInstance(165, 105, icon3_3.getImage().SCALE_DEFAULT);
        icon3_3 = new ImageIcon(temp3_3);
        //修建敌人3死亡4图片
        icon3_4 = new ImageIcon("src/img/enemy3_down4.png");
        Image temp3_4 = icon3_4.getImage().getScaledInstance(165, 105, icon3_4.getImage().SCALE_DEFAULT);
        icon3_4 = new ImageIcon(temp3_4);
        //修建敌人3死亡5图片
        icon3_5 = new ImageIcon("src/img/enemy3_down5.png");
        Image temp3_5 = icon3_5.getImage().getScaledInstance(165, 105, icon3_5.getImage().SCALE_DEFAULT);
        icon3_5 = new ImageIcon(temp3_5);
        //修建敌人3死亡6图片
        icon3_6 = new ImageIcon("src/img/enemy3_down6.png");
        Image temp3_6 = icon3_6.getImage().getScaledInstance(165, 105, icon3_6.getImage().SCALE_DEFAULT);
        icon3_6 = new ImageIcon(temp3_6);

        //修建警告0图片
        icon_warning0 = new ImageIcon("src/img/警告0.png");
        Image temp_warning0 = icon_warning0.getImage().getScaledInstance(225, 148, icon_warning0.getImage().SCALE_DEFAULT);
        icon_warning0 = new ImageIcon(temp_warning0);
        //修建警告1图片
        icon_warning1 = new ImageIcon("src/img/警告1.png");
        Image temp_warning1 = icon_warning1.getImage().getScaledInstance(225, 148, icon_warning1.getImage().SCALE_DEFAULT);
        icon_warning1 = new ImageIcon(temp_warning1);
        //修建警告2图片
        icon_warning2 = new ImageIcon("src/img/警告2.png");
        Image temp_warning2 = icon_warning2.getImage().getScaledInstance(225, 148, icon_warning2.getImage().SCALE_DEFAULT);
        icon_warning2 = new ImageIcon(temp_warning2);
        //修建警告3图片
        icon_warning3 = new ImageIcon("src/img/警告3.png");
        Image temp_warning3 = icon_warning3.getImage().getScaledInstance(225, 148, icon_warning3.getImage().SCALE_DEFAULT);
        icon_warning3 = new ImageIcon(temp_warning3);

        //修建血量图片
        icon_boss_health = new ImageIcon("src/img/血量.png");
        Image temp_boss_health= icon_boss_health.getImage().getScaledInstance(450, 10, icon_boss_health.getImage().SCALE_DEFAULT);
        icon_boss_health = new ImageIcon(temp_boss_health);
        //修建血量底图片
        icon_boss_health_bottom = new ImageIcon("src/img/血量底.png");
        Image temp_health_bottom = icon_boss_health_bottom.getImage().getScaledInstance(450, 10, icon_boss_health_bottom.getImage().SCALE_DEFAULT);
        icon_boss_health_bottom = new ImageIcon(temp_health_bottom);

        //修建boss1图片
        icon_boss1 = new ImageIcon("src/img/boss1.png");
        Image temp_boss1 = icon_boss1.getImage().getScaledInstance(203, 216, icon_boss1.getImage().SCALE_DEFAULT);
        icon_boss1 = new ImageIcon(temp_boss1);
        //修建boss2图片
        icon_boss2 = new ImageIcon("src/img/boss2.png");
        Image temp_boss2 = icon_boss2.getImage().getScaledInstance(203, 216, icon_boss2.getImage().SCALE_DEFAULT);
        icon_boss2 = new ImageIcon(temp_boss2);
        //修建boss3图片
        icon_boss3 = new ImageIcon("src/img/boss3.png");
        Image temp_boss3 = icon_boss3.getImage().getScaledInstance(203, 216, icon_boss3.getImage().SCALE_DEFAULT);
        icon_boss3 = new ImageIcon(temp_boss3);

        //修建boss1名称图片
        icon_boss1_name = new ImageIcon("src/img/Boss1名字.png");
        Image temp_boss1_name = icon_boss1_name.getImage().getScaledInstance(141, 49, icon_boss1_name.getImage().SCALE_DEFAULT);
        icon_boss1_name = new ImageIcon(temp_boss1_name);
        //修建boss2名称图片
        icon_boss2_name = new ImageIcon("src/img/Boss2名字.png");
        Image temp_boss2_name = icon_boss2_name.getImage().getScaledInstance(141, 49, icon_boss2_name.getImage().SCALE_DEFAULT);
        icon_boss2_name = new ImageIcon(temp_boss2_name);
        //修建boss3名称图片
        icon_boss3_name = new ImageIcon("src/img/Boss3名字.png");
        Image temp_boss3_name = icon_boss3_name.getImage().getScaledInstance(141, 49, icon_boss3_name.getImage().SCALE_DEFAULT);
        icon_boss3_name = new ImageIcon(temp_boss3_name);

        //修建boss爆炸1图片
        icon_boss_boom_1 = new ImageIcon("src/img/Boss爆炸1.png");
        Image temp_boss_boom_1 = icon_boss_boom_1.getImage().getScaledInstance(256, 256, icon_boss_boom_1.getImage().SCALE_DEFAULT);
        icon_boss_boom_1 = new ImageIcon(temp_boss_boom_1);
        //修建boss爆炸2图片
        icon_boss_boom_2 = new ImageIcon("src/img/Boss爆炸2.png");
        Image temp_boss_boom_2 = icon_boss_boom_2.getImage().getScaledInstance(256, 256, icon_boss_boom_2.getImage().SCALE_DEFAULT);
        icon_boss_boom_2 = new ImageIcon(temp_boss_boom_2);
        //修建boss爆炸3图片
        icon_boss_boom_3 = new ImageIcon("src/img/Boss爆炸3.png");
        Image temp_boss_boom_3 = icon_boss_boom_3.getImage().getScaledInstance(256, 256, icon_boss_boom_3.getImage().SCALE_DEFAULT);
        icon_boss_boom_3 = new ImageIcon(temp_boss_boom_3);
        //修建boss爆炸4图片
        icon_boss_boom_4 = new ImageIcon("src/img/Boss爆炸4.png");
        Image temp_boss_boom_4 = icon_boss_boom_4.getImage().getScaledInstance(256, 256, icon_boss_boom_4.getImage().SCALE_DEFAULT);
        icon_boss_boom_4 = new ImageIcon(temp_boss_boom_4);
        //修建boss爆炸5图片
        icon_boss_boom_5 = new ImageIcon("src/img/Boss爆炸5.png");
        Image temp_boss_boom_5 = icon_boss_boom_5.getImage().getScaledInstance(256, 256, icon_boss_boom_5.getImage().SCALE_DEFAULT);
        icon_boss_boom_5 = new ImageIcon(temp_boss_boom_5);
        //修建boss爆炸1图片
        icon_boss_boom_6 = new ImageIcon("src/img/Boss爆炸6.png");
        Image temp_boss_boom_6 = icon_boss_boom_6.getImage().getScaledInstance(256, 256, icon_boss_boom_6.getImage().SCALE_DEFAULT);
        icon_boss_boom_6 = new ImageIcon(temp_boss_boom_6);
    }

    public void run(){
        int boss_num = 0;//boss编号 依次0 1 2

        //开启BossBullet子弹线程
        BossBullet bossBullet = new BossBullet();
        Thread thread_bossBullet = new Thread(bossBullet);
        thread_bossBullet.start();

        while (true){
            //如果分数达到boss出现标准
            if(Main.score>=appear_score){
                //创建boss图片
                JLabel label_boss = new JLabel();
                if(boss_num==0){
                    //蝎子
                    label_boss.setIcon(icon_boss1);
                    label_boss.setBounds(30, -250, 203, 216);
                }else if(boss_num==1){
                    //狮子
                    label_boss.setIcon(icon_boss2);
                    label_boss.setBounds(30, -250, 203, 216);
                }else{
                    //塔罗人
                    label_boss.setIcon(icon_boss3);
                    label_boss.setBounds(30, -250, 203, 216);
                }

                //赋值给boss实体类
                Main.boss = new Boss_Entity(1000,1000, label_boss,1,boss_num);
                //将boss图片添加到面板
                Main.jp1.add(Main.boss.label);

                //炸弹效果变更为对Boss造成伤害
                boss_appear = true;

                //等Bomb线程都设置为true后再执行
                try{
                    Thread.sleep(3000);
                }catch (Exception E){
                    E.printStackTrace();
                }

                //---------------------------------------------

                //防止刚到达Boss出现分数，就使用炸弹，导致Boss子弹异常出现
                //暂停BossBullet线程（不要继续创建以及移动Boss子弹啦）
                BossBullet.isTrue = false;

                try{
                    Thread.sleep(30);
                }catch (Exception E){
                    E.printStackTrace();
                }

                //遍历Boss子弹集合
                for(int j=0;j<Main.boss_bullets_list.size();j++){
                    if(j<Main.boss_bullets_list.size()){
                        //从面板上删除该敌人子弹
                        Main.jp1.remove(Main.boss_bullets_list.get(j).label);
                        //从敌人子弹集合中删除该子弹
                        Main.boss_bullets_list.remove(Main.boss_bullets_list.get(j));
                        j--;
                    }
                }

                //---------------------------------------------

                //暂停PlayerBulletCreate线程（不要继续创建以及移动子弹啦）  isTrue是PlayerBulletCreate的标志位
                PlayerBulletCreate.isActive=false;
                //必须延迟30ms 否则PlayerBulletCreate玩家子弹击中敌人 加分后 会重新开启Enemy线程 继续创建及移动敌人
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
                label_warning.setIcon(icon_warning0);
                label_warning.setBounds(500, 230, 225, 148);
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
                for(int i=0;i<7;i++){
                    label_warning.setIcon(icon_warning0);
                    try {
                        Thread.sleep(50);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    label_warning.setIcon(icon_warning1);
                    try {
                        Thread.sleep(50);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    label_warning.setIcon(icon_warning2);
                    try {
                        Thread.sleep(50);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    label_warning.setIcon(icon_warning3);
                    try {
                        Thread.sleep(50);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    label_warning.setIcon(icon_warning3);
                    try {
                        Thread.sleep(50);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    label_warning.setIcon(icon_warning2);
                    try {
                        Thread.sleep(50);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    label_warning.setIcon(icon_warning1);
                    try {
                        Thread.sleep(50);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    label_warning.setIcon(icon_warning0);
                    try {
                        Thread.sleep(50);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
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

                label_health.setBounds(10, 560,450,10);
                label_health_bottom.setBounds(10, 560,450,10);

                //创建Boss名字label
                JLabel label_name = new JLabel();
                Main.jp1.add(label_name);

                //根据boss编号设置名字
                if(Main.boss.num==0){
                    label_name.setIcon(icon_boss1_name);
                }else if(Main.boss.num==1){
                    label_name.setIcon(icon_boss2_name);
                }else{
                    label_name.setIcon(icon_boss3_name);
                }

                label_name.setBounds(170, 500, 141, 49);

                //开启一个线程播放Boss出场音效
                new Thread(()->{
                    GameMusic.Play("src/music/Boss出场.wav", 2.0);
                }).start();

                //暂停玩家子弹攻击Boss
                PlayerBulletCreate.isAttack = false;

                //boss下滑入场
                for(int i=1;i<=270;i++){
                    try{
                        Thread.sleep(10);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    label_boss.setLocation(Main.boss.label.getX(), Main.boss.label.getY()+1);
                }

                //重新开启玩家子弹攻击Boss
                PlayerBulletCreate.isAttack = true;

                //重新开启BossBullet线程（继续创建以及移动Boss子弹）
                BossBullet.isTrue=true;
                //重新开启PlayerBulletCreate线程
                PlayerBulletCreate.isActive=true;
                //重新开启玩家collision方法（继续判断玩家碰撞检测方法了）
                Player_Entity.isTure = true;

                //控制Boss释放激光变量
                int count = 1;

                //开启一个线程设置血条
                new Thread(()->{
                    while (Main.boss.cur_health>0) {
                        //重新设置血条
                        label_health.setBounds(label_health.getX(), label_health.getY(), (int) (((double) Main.boss.cur_health / Main.boss.total_health) * 450), 10);
                    }
                }).start();

                //如果boss还有血
                while (Main.boss.cur_health>0){
                    //左右移动
                    for(int i=1;i<=210;i++){
                        if(Main.boss.cur_health<=0){
                            break;
                        }
                        try{
                            Thread.sleep(10);
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                        //Boss释放激光
                        if(count%2==0){
                            //蝎子和狮子的激光
                            if(Main.boss.num<=1){
                                Boss_Entity.shootLaser();
                            }else{
                                //塔罗人的激光
                                Boss_Entity.shoot_double_laser();
                            }
                            count = 1;
                        }

                       //Boss移动
                        Main.boss.label.setLocation(Main.boss.label.getX()+Main.boss.dir, Main.boss.label.getY());
                    }
                    //方向相反
                    Main.boss.dir = -Main.boss.dir;
                    count++;
                }

                //Boss死亡, 炸弹效果变更为全屏炸弹
                boss_appear = false;

                //开启一个线程播放Boss死亡音效
                new Thread(()->{
                    GameMusic.Play("src/music/Boss爆炸.wav", 2.0);
                }).start();

                //设置Boss爆炸1-6效果
                Main.boss.label.setBounds(Main.boss.label.getX(), Main.boss.label.getY(), 256, 256);
                Main.boss.label.setIcon(icon_boss_boom_6);
                try {
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }
                Main.boss.label.setIcon(icon_boss_boom_5);
                try {
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }
                Main.boss.label.setIcon(icon_boss_boom_4);
                try {
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }
                Main.boss.label.setIcon(icon_boss_boom_3);
                try {
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }
                Main.boss.label.setIcon(icon_boss_boom_2);
                try {
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }
                Main.boss.label.setIcon(icon_boss_boom_1);
                try {
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }


                //删除Boss图片
                Main.jp1.remove(Main.boss.label);
                //删除Boss实体
                Main.boss =null;

                //删除血条与血条底
                Main.jp1.remove(label_health);
                Main.jp1.remove(label_health_bottom);

                //删除Boss名字label
                Main.jp1.remove(label_name);


                //暂停BossBullet线程（不要继续创建以及移动子弹啦）
                BossBullet.isTrue = false;

                //缓冲30ms 不能直接清空集合，否则数组下标越界
                try{
                    Thread.sleep(30);
                }catch (Exception E){
                    E.printStackTrace();
                }

                //删除所有Boss子弹
                for(int i=0;i<Main.boss_bullets_list.size();i++){
                    //从面板上删除该敌人子弹
                    Main.jp1.remove(Main.boss_bullets_list.get(i).label);
                    //从敌人子弹集合中删除该子弹
                    Main.boss_bullets_list.remove(Main.boss_bullets_list.get(i));
                    i--;
                }

                //更换背景图片
                Main.map_count = (Main.map_count+1)%Main.map.length;
                ImageIcon icon_map = new ImageIcon("src/img/"+Main.map[Main.map_count]);
                Main.photo.setIcon(icon_map);



                //积分增加
                Main.score+=1000;
                //重新设置积分榜显示
                Main.label_Score.setText("当前积分:"+Main.score);

                Main.jp1.repaint();//对panel1本身进行重绘


                //重新开启Enemy线程（继续创建及移动敌人）
                Enemy.isTure = true;

                //先生成敌人再生成敌人子弹
                try{
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }

                //重新开启EnemyBullet线程
                EnemyBullet.isTrue=true;

                //Boss出现分数增加
                appear_score+=2000;
                //换下一个Boss
                boss_num=(boss_num+1)%3;
            }
        }

    }
}
