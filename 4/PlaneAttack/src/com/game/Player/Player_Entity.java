package com.game.Player;

import com.game.Enemy.Enemy_Entity;
import com.game.EnemyBullet.EnemyBullet;
import com.game.Panel.Main;
import com.game.PlayerBullet.PlayerBulletCreate;
import com.game.Util.GameMusic;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Player_Entity {
    public int health = 3;
    public int bomb = 4;
    public int level = 1;
    public static volatile int player_index = 1;//战机编号
    public JLabel label = new JLabel();//图片资源
    public static ImageIcon icon;//玩家图片
    public static ImageIcon icon1;//玩家死亡图片1
    public static ImageIcon icon2;//玩家死亡图片2
    public static ImageIcon icon3;//玩家死亡图片3
    public static ImageIcon icon4;//玩家死亡图片4
    public static ImageIcon icon5_1;//无敌图片1
    public static ImageIcon icon5_2;//无敌图片2
    public static ImageIcon icon5_3;//无敌图片3
    public static ImageIcon icon5_4;//无敌图片4
    public static ImageIcon icon5_5;//无敌图片5
    public static ImageIcon icon5_6;//无敌图片6
    public static ImageIcon icon5_7;//无敌图片7
    public static ImageIcon icon_protect;//保护罩图片
    public static volatile boolean isTure = true;
    static{

        //修建玩家死亡1图片
        icon1 = new ImageIcon("src/img/me_destroy_1.png");
        Image temp1 = icon1.getImage().getScaledInstance(85, 62, icon1.getImage().SCALE_DEFAULT);
        icon1 = new ImageIcon(temp1);
        //修建玩家死亡2图片
        icon2 = new ImageIcon("src/img/me_destroy_2.png");
        Image temp2 = icon2.getImage().getScaledInstance(85, 62, icon2.getImage().SCALE_DEFAULT);
        icon2 = new ImageIcon(temp2);
        //修建玩家死亡3图片
        icon3 = new ImageIcon("src/img/me_destroy_3.png");
        Image temp3 = icon3.getImage().getScaledInstance(85, 62, icon3.getImage().SCALE_DEFAULT);
        icon3 = new ImageIcon(temp3);
        //修建玩家死亡4图片
        icon4 = new ImageIcon("src/img/me_destroy_4.png");
        Image temp4 = icon4.getImage().getScaledInstance(85, 62, icon4.getImage().SCALE_DEFAULT);
        icon4 = new ImageIcon(temp4);

        //修建无敌1图片
        icon5_1 = new ImageIcon("src/img/无敌1.png");
        Image temp5_1 = icon5_1.getImage().getScaledInstance(246, 161, icon5_1.getImage().SCALE_DEFAULT);
        icon5_1 = new ImageIcon(temp5_1);
        //修建无敌2图片
        icon5_2 = new ImageIcon("src/img/无敌2.png");
        Image temp5_2 = icon5_2.getImage().getScaledInstance(246, 161, icon5_2.getImage().SCALE_DEFAULT);
        icon5_2 = new ImageIcon(temp5_2);
        //修建无敌3图片
        icon5_3 = new ImageIcon("src/img/无敌3.png");
        Image temp5_3 = icon5_3.getImage().getScaledInstance(246, 161, icon5_3.getImage().SCALE_DEFAULT);
        icon5_3 = new ImageIcon(temp5_3);
        //修建无敌4图片
        icon5_4 = new ImageIcon("src/img/无敌4.png");
        Image temp5_4 = icon5_4.getImage().getScaledInstance(246, 161, icon5_4.getImage().SCALE_DEFAULT);
        icon5_4 = new ImageIcon(temp5_4);
        //修建无敌5图片
        icon5_5 = new ImageIcon("src/img/无敌5.png");
        Image temp5_5 = icon5_5.getImage().getScaledInstance(246, 161, icon5_5.getImage().SCALE_DEFAULT);
        icon5_5 = new ImageIcon(temp5_5);
        //修建无敌6图片
        icon5_6 = new ImageIcon("src/img/无敌6.png");
        Image temp5_6 = icon5_6.getImage().getScaledInstance(246, 161, icon5_6.getImage().SCALE_DEFAULT);
        icon5_6 = new ImageIcon(temp5_6);
        //修建无敌7图片
        icon5_7 = new ImageIcon("src/img/无敌7.png");
        Image temp5_7 = icon5_7.getImage().getScaledInstance(246, 161, icon5_7.getImage().SCALE_DEFAULT);
        icon5_7 = new ImageIcon(temp5_7);
        //修建保护罩图片
        icon_protect = new ImageIcon("src/img/保护罩.png");
        Image temp_protect = icon_protect.getImage().getScaledInstance(100, 100, icon_protect.getImage().SCALE_DEFAULT);
        icon_protect = new ImageIcon(temp_protect);

    }

    public void collision(){

        //修建玩家图片
        icon = new ImageIcon("src/img/玩家"+Player_Entity.player_index+"_1.png");
        Image temp = icon.getImage().getScaledInstance(85, 62, icon.getImage().SCALE_DEFAULT);
        icon = new ImageIcon(temp);

        if(isTure){
            //开启一个线程播放玩家死亡动画
            new Thread(()->{
                for(int i = 0; i< Main.enemy_list.size(); i++){
                    if(!isTure){
                        break;
                    }
                    System.out.println(Main.enemy_list);
                    if(i< Main.enemy_list.size()){
                        if(Main.enemy_list.get(i).num==1){
                            if(Main.enemy_list.get(i).label.getX()-Main.player_entity.label.getX()<=85&&
                                    Main.player_entity.label.getY()-Main.enemy_list.get(i).label.getY()<=44&&
                                    Main.enemy_list.get(i).label.getY()-Main.player_entity.label.getY()<=62&&
                                    Main.player_entity.label.getX()-Main.enemy_list.get(i).label.getX()<=71

                            ){
                                //暂停PlayerBulletCreate线程（不要继续创建以及移动子弹啦）  isTrue是PlayerBulletCreate的标志位
                                PlayerBulletCreate.isActive=false;
                                //暂停EnemyBullet线程的攻击玩家判定
                                EnemyBullet.isAttack = false;
                                //暂停Player线程碰撞检测
                                Player.isActive = false;
                                //缓冲10ms 因为此时移动子弹的循环可能还没结束 不可以立马清空子弹集合
                                try{
                                    Thread.sleep(10);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
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
                                //开启一个新线程播放玩家死亡音效
                                new Thread(()->{
                                    GameMusic.Play("src/music/玩家死亡.wav",2);
                                }).start();
                                //设置爆炸图片1-4
                                Main.player_entity.label.setIcon(icon1);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon2);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon3);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon4);
                                try{
                                    Thread.sleep(500);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }

                                //回到初始位置
                                Main.player_entity.label.setBounds(120,443,246,161);
                                //无敌1-无敌7特效
                                Main.player_entity.label.setIcon(icon5_1);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_2);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_3);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_4);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_5);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_6);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_7);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_6);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_5);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_4);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_3);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_2);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_1);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                //恢复玩家图片
                                Main.player_entity.label.setIcon(icon);
                                Main.player_entity.label.setBounds(200,500,85, 62);

                                //玩家生命值>0
                                if(Main.player_entity.health>0){
                                    //玩家生命值-1
                                    Main.player_entity.health--;
                                    //重新设置生命数量
                                    Main.label_life_Count.setText(" X "+Main.player_entity.health);
                                    //玩家等级回到1
                                    Main.player_entity.level=1;
                                }else{
                                    //玩家生命值<=0
                                    //游戏结束

                                    //将分数写入记录.txt
                                    try(PrintWriter pw = new PrintWriter(new FileWriter("src/record/记录.txt",true))){
                                        pw.println(Main.label_Score.getText().split(":")[1]);
                                    }catch (Exception e){
                                        e.printStackTrace();
                                    }

                                    JOptionPane.showMessageDialog(null,"时间结束！\n玩家积分为"+Main.label_Score.getText(),"时间结束", JOptionPane.WARNING_MESSAGE);
                                    System.exit(0);
                                }


                                //重新开启Player线程碰撞检测
                                Player.isActive = true;

                                //增加保护罩图片
                                JLabel label_protect = new JLabel();
                                Main.jp1.add(label_protect);
                                label_protect.setIcon(icon_protect);
                                label_protect.setBounds(Main.player_entity.label.getX()-8, Main.player_entity.label.getY()-10, 100, 100);
                                Main.jp1.repaint();

                                //开启一个线程移动保护罩
                                new Thread(()->{
                                    for(int k=1;k<=500;k++){
                                        label_protect.setIcon(icon_protect);
                                        try{
                                            Thread.sleep(4);
                                        }catch (Exception e){
                                            e.printStackTrace();
                                        }
                                        label_protect.setBounds(Main.player_entity.label.getX()-8, Main.player_entity.label.getY()-18, 100, 100);
                                    }
                                }).start();

                                //2000ms无敌时间
                                try{
                                    Thread.sleep(2000);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }

                                //删除保护罩图片
                                Main.jp1.remove(label_protect);
                                //重新开启PlayerBulletCreate线程
                                PlayerBulletCreate.isActive=true;
                                //重新开始EnemyBullet线程的攻击玩家判定
                                EnemyBullet.isAttack = true;

                                break;
                            }
                        }else if(Main.enemy_list.get(i).num==2){
                            if(Main.enemy_list.get(i).label.getX()-Main.player_entity.label.getX()<=85&&
                                    Main.player_entity.label.getY()-Main.enemy_list.get(i).label.getY()<=92&&
                                    Main.enemy_list.get(i).label.getY()-Main.player_entity.label.getY()<=62&&
                                    Main.player_entity.label.getX()-Main.enemy_list.get(i).label.getX()<=118

                            ){
                                //暂停PlayerBulletCreate线程（不要继续创建以及移动子弹啦）  isTrue是PlayerBulletCreate的标志位
                                PlayerBulletCreate.isActive = false;
                                //暂停EnemyBullet线程的攻击玩家判定
                                EnemyBullet.isAttack = false;
                                //暂停Player线程碰撞检测
                                Player.isActive = false;
                                //缓冲10ms 因为此时移动子弹的循环可能还没结束 不可以立马清空子弹集合
                                try{
                                    Thread.sleep(10);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
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
                                //开启一个新线程播放死亡音效
                                new Thread(()->{
                                    GameMusic.Play("src/music/玩家死亡.wav",2);
                                }).start();
                                //设置爆炸图片1-4
                                Main.player_entity.label.setIcon(icon1);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon2);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }Main.player_entity.label.setIcon(icon3);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon4);
                                try{
                                    Thread.sleep(500);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }

                                //回到初始位置
                                Main.player_entity.label.setBounds(120,443,246,161);
                                //无敌1-无敌7特效
                                Main.player_entity.label.setIcon(icon5_1);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_2);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_3);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_4);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_5);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_6);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_7);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_6);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_5);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_4);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_3);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_2);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_1);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                //恢复玩家图片
                                Main.player_entity.label.setIcon(icon);
                                Main.player_entity.label.setBounds(200,500,85, 62);

                                //玩家生命值>0
                                if(Main.player_entity.health>0){
                                    //玩家生命值-1
                                    Main.player_entity.health--;
                                    //重新设置生命数量
                                    Main.label_life_Count.setText(" X "+Main.player_entity.health);
                                    //玩家等级回到1
                                    Main.player_entity.level=1;
                                }else{
                                    //玩家生命值<=0
                                    //游戏结束

                                    //将分数写入记录.txt
                                    try(PrintWriter pw = new PrintWriter(new FileWriter("src/record/记录.txt",true))){
                                        pw.println(Main.label_Score.getText().split(":")[1]);
                                    }catch (Exception e){
                                        e.printStackTrace();
                                    }

                                    JOptionPane.showMessageDialog(null,"时间结束！\n玩家积分为"+Main.label_Score.getText(),"时间结束", JOptionPane.WARNING_MESSAGE);
                                    System.exit(0);
                                }

                                //重新开启Player线程碰撞检测
                                Player.isActive = true;

                                //增加保护罩图片
                                JLabel label_protect = new JLabel();
                                Main.jp1.add(label_protect);
                                label_protect.setIcon(icon_protect);
                                label_protect.setBounds(Main.player_entity.label.getX()-8, Main.player_entity.label.getY()-10, 100, 100);
                                Main.jp1.repaint();

                                //开启一个线程移动保护罩
                                new Thread(()->{
                                    for(int k=1;k<=500;k++){
                                        label_protect.setIcon(icon_protect);
                                        try{
                                            Thread.sleep(4);
                                        }catch (Exception e){
                                            e.printStackTrace();
                                        }
                                        label_protect.setBounds(Main.player_entity.label.getX()-8, Main.player_entity.label.getY()-18, 100, 100);
                                    }
                                }).start();

                                //2000ms无敌时间
                                try{
                                    Thread.sleep(2000);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }

                                //删除保护罩图片
                                Main.jp1.remove(label_protect);

                                //重新开启PlayerBulletCreate线程
                                PlayerBulletCreate.isActive=true;
                                //重新开启EnemyBullet线程的攻击玩家判定
                                EnemyBullet.isAttack = true;

                                break;
                            }
                        }else{
                            if(Main.enemy_list.get(i).label.getX()-Main.player_entity.label.getX()<=85&&
                                    Main.player_entity.label.getY()-Main.enemy_list.get(i).label.getY()<=105&&
                                    Main.enemy_list.get(i).label.getY()-Main.player_entity.label.getY()<=62&&
                                    Main.player_entity.label.getX()-Main.enemy_list.get(i).label.getX()<=165

                            ){
                                //暂停PlayerBulletCreate线程（不要继续创建以及移动子弹啦）  isTrue是PlayerBulletCreate的标志位
                                PlayerBulletCreate.isActive = false;
                                //暂停EnemyBullet线程的攻击玩家判定
                                EnemyBullet.isAttack = false;
                                //暂停Player线程碰撞检测
                                Player.isActive = false;
                                //缓冲10ms 因为此时移动子弹的循环可能还没结束 不可以立马清空子弹集合
                                try{
                                    Thread.sleep(10);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
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
                                //开启一个新线程播放死亡音效
                                new Thread(()->{
                                    GameMusic.Play("src/music/玩家死亡.wav",2);
                                }).start();
                                //设置爆炸图片1-4
                                Main.player_entity.label.setIcon(icon1);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon2);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }Main.player_entity.label.setIcon(icon3);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon4);
                                try{
                                    Thread.sleep(500);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }


                                //回到初始位置
                                Main.player_entity.label.setBounds(120,443,246,161);
                                //无敌1-无敌7特效
                                Main.player_entity.label.setIcon(icon5_1);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_2);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_3);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_4);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_5);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_6);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_7);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_6);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_5);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_4);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_3);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_2);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Main.player_entity.label.setIcon(icon5_1);
                                try{
                                    Thread.sleep(100);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                //恢复玩家图片
                                Main.player_entity.label.setIcon(icon);
                                Main.player_entity.label.setBounds(200,500,85, 62);



                                //玩家生命值>0
                                if(Main.player_entity.health>0){
                                    //玩家生命值-1
                                    Main.player_entity.health--;
                                    //重新设置生命数量
                                    Main.label_life_Count.setText(" X "+Main.player_entity.health);
                                    //玩家等级回到1
                                    Main.player_entity.level=1;
                                }else{
                                    //玩家生命值<=0
                                    //游戏结束

                                    //将分数写入记录.txt
                                    try(PrintWriter pw = new PrintWriter(new FileWriter("src/record/记录.txt",true))){
                                        pw.println(Main.label_Score.getText().split(":")[1]);
                                    }catch (Exception e){
                                        e.printStackTrace();
                                    }

                                    JOptionPane.showMessageDialog(null,"时间结束！\n玩家积分为"+Main.label_Score.getText(),"时间结束", JOptionPane.WARNING_MESSAGE);
                                    System.exit(0);
                                }

                                //重新开启Player线程碰撞检测
                                Player.isActive = true;

                                //增加保护罩图片
                                JLabel label_protect = new JLabel();
                                Main.jp1.add(label_protect);
                                label_protect.setIcon(icon_protect);
                                label_protect.setBounds(Main.player_entity.label.getX()-8, Main.player_entity.label.getY()-10, 100, 100);
                                Main.jp1.repaint();

                                //开启一个线程移动保护罩
                                new Thread(()->{
                                    for(int k=1;k<=500;k++){
                                        label_protect.setIcon(icon_protect);
                                        try{
                                            Thread.sleep(4);
                                        }catch (Exception e){
                                            e.printStackTrace();
                                        }
                                        label_protect.setBounds(Main.player_entity.label.getX()-8, Main.player_entity.label.getY()-18, 100, 100);
                                    }
                                }).start();

                                //2000ms无敌时间
                                try{
                                    Thread.sleep(2000);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }

                                //删除保护罩图片
                                Main.jp1.remove(label_protect);

                                //重新开启PlayerBulletCreate线程
                                PlayerBulletCreate.isActive=true;
                                //重新开启EnemyBullet线程的攻击玩家判定
                                EnemyBullet.isAttack = true;

                                break;
                            }
                        }
                    }

                }
                //是否和Boss碰撞
                if(Main.boss!=null&&Main.boss.label.getX()- Main.player_entity.label.getX()<=85&&Main.boss.label.getY()-Main.player_entity.label.getY()<=62&&
                        Main.player_entity.label.getX()-Main.boss.label.getX()<=203&&Main.player_entity.label.getY()-Main.boss.label.getY()<=216){

                    //暂停PlayerBulletCreate线程（不要继续创建以及移动子弹啦）  isTrue是PlayerBulletCreate的标志位
                    PlayerBulletCreate.isActive=false;
                    //暂停Player线程碰撞检测
                    Player.isActive = false;

                    //缓冲10ms 因为此时移动子弹的循环可能还没结束 不可以立马清空子弹集合
                    try{
                        Thread.sleep(10);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
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
                    //开启一个新线程播放玩家死亡音效
                    new Thread(()->{
                        GameMusic.Play("src/music/玩家死亡.wav",2);
                    }).start();
                    //设置爆炸图片1-4
                    Main.player_entity.label.setIcon(icon1);
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    Main.player_entity.label.setIcon(icon2);
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    Main.player_entity.label.setIcon(icon3);
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    Main.player_entity.label.setIcon(icon4);
                    try{
                        Thread.sleep(500);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    //回到初始位置
                    Main.player_entity.label.setBounds(120,443,246,161);
                    //无敌1-无敌7特效
                    Main.player_entity.label.setIcon(icon5_1);
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    Main.player_entity.label.setIcon(icon5_2);
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    Main.player_entity.label.setIcon(icon5_3);
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    Main.player_entity.label.setIcon(icon5_4);
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    Main.player_entity.label.setIcon(icon5_5);
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    Main.player_entity.label.setIcon(icon5_6);
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    Main.player_entity.label.setIcon(icon5_7);
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    Main.player_entity.label.setIcon(icon5_6);
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    Main.player_entity.label.setIcon(icon5_5);
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    Main.player_entity.label.setIcon(icon5_4);
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    Main.player_entity.label.setIcon(icon5_3);
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    Main.player_entity.label.setIcon(icon5_2);
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    Main.player_entity.label.setIcon(icon5_1);
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    //恢复玩家图片
                    Main.player_entity.label.setIcon(icon);
                    Main.player_entity.label.setBounds(200,500,85, 62);
                    //玩家生命值>0
                    if(Main.player_entity.health>0){
                        //玩家生命值-1
                        Main.player_entity.health--;
                        //重新设置生命数量
                        Main.label_life_Count.setText(" X "+Main.player_entity.health);
                        //玩家等级回到1
                        Main.player_entity.level=1;
                    }else{
                        //玩家生命值<=0
                        //游戏结束

                        //将分数写入记录.txt
                        try(PrintWriter pw = new PrintWriter(new FileWriter("src/record/记录.txt",true))){
                            pw.println(Main.label_Score.getText().split(":")[1]);
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                        JOptionPane.showMessageDialog(null,"时间结束！\n玩家积分为"+Main.label_Score.getText(),"时间结束", JOptionPane.WARNING_MESSAGE);
                        System.exit(0);
                    }

                    //重新开启Player线程碰撞检测
                    Player.isActive = true;

                    //增加保护罩图片
                    JLabel label_protect = new JLabel();
                    Main.jp1.add(label_protect);
                    label_protect.setIcon(icon_protect);
                    label_protect.setBounds(Main.player_entity.label.getX()-8, Main.player_entity.label.getY()-10, 100, 100);
                    Main.jp1.repaint();

                    //开启一个线程移动保护罩
                    new Thread(()->{
                        for(int k=1;k<=500;k++){
                            label_protect.setIcon(icon_protect);
                            try{
                                Thread.sleep(4);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            label_protect.setBounds(Main.player_entity.label.getX()-8, Main.player_entity.label.getY()-18, 100, 100);
                        }
                    }).start();

                    //2000ms无敌时间
                    try{
                        Thread.sleep(2000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    //删除保护罩图片
                    Main.jp1.remove(label_protect);


                    //重新开启PlayerBulletCreate线程
                    PlayerBulletCreate.isActive=true;

                }

            }).start();


        }

    }
}
