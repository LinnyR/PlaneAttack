package com.game.Player;

import com.game.Panel.Main;
import com.game.PlayerBullet.PlayerBulletCreate;
import com.game.Util.GameMusic;

import javax.swing.*;
import java.awt.*;

public class Player_Entity {
    public int health = 3;
    public int bomb = 3;
    public int level = 1;
    public JLabel label = new JLabel();//图片资源
    public static ImageIcon icon;//玩家图片
    public static ImageIcon icon1;//玩家图片1
    public static ImageIcon icon2;//玩家图片2
    public static ImageIcon icon3;//玩家图片3
    public static ImageIcon icon4;//玩家图片4
    public static volatile boolean isTure = true;
    static{
        //修建玩家图片
        icon = new ImageIcon("src/img/玩家.png");
        Image temp = icon.getImage().getScaledInstance(63, 78, icon.getImage().SCALE_DEFAULT);
        icon = new ImageIcon(temp);
        //修建玩家死亡1图片
        icon1 = new ImageIcon("src/img/me_destroy_1.png");
        Image temp1 = icon1.getImage().getScaledInstance(63, 78, icon1.getImage().SCALE_DEFAULT);
        icon1 = new ImageIcon(temp1);
        //修建玩家死亡2图片
        icon2 = new ImageIcon("src/img/me_destroy_2.png");
        Image temp2 = icon2.getImage().getScaledInstance(63, 78, icon2.getImage().SCALE_DEFAULT);
        icon2 = new ImageIcon(temp2);
        //修建玩家死亡3图片
        icon3 = new ImageIcon("src/img/me_destroy_3.png");
        Image temp3 = icon3.getImage().getScaledInstance(63, 78, icon3.getImage().SCALE_DEFAULT);
        icon3 = new ImageIcon(temp3);
        //修建玩家死亡4图片
        icon4 = new ImageIcon("src/img/me_destroy_4.png");
        Image temp4 = icon4.getImage().getScaledInstance(63, 78, icon4.getImage().SCALE_DEFAULT);
        icon4 = new ImageIcon(temp4);
    }

    public void collision(){
        if(isTure){
            for(int i = 0; i< Main.enemy_list.size(); i++){
                if(!isTure){
                    break;
                }
                if(Main.enemy_list.get(i).num==1){
                    if(Main.enemy_list.get(i).label.getX()-Main.player_entity.label.getX()<=45&&
                            Main.player_entity.label.getY()-Main.enemy_list.get(i).label.getY()<=25&&
                            Main.enemy_list.get(i).label.getY()-Main.player_entity.label.getY()<=45&&
                            Main.player_entity.label.getX()-Main.enemy_list.get(i).label.getX()<=55

                    ){
                        //暂停PlayerBulletCreate线程（不要继续创建以及移动子弹啦）  isTrue是PlayerBulletCreate的标志位
                        PlayerBulletCreate.isActive=false;
                        //执行该方法时已经处于Player线程当中，所以根本不会再进行碰撞检测
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
                        //恢复玩家图片
                        Main.player_entity.label.setIcon(icon);
                        //回到初始位置
                        Main.player_entity.label.setLocation(200,500);
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
                            JOptionPane.showMessageDialog(null,"时间结束！\n玩家积分为"+Main.label_Score.getText(),"时间结束", JOptionPane.WARNING_MESSAGE);
                            System.exit(0);
                        }
                        //1000ms无敌时间
                        try{
                            Thread.sleep(1000);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        //重新开启PlayerBulletCreate线程
                        PlayerBulletCreate.isActive=true;
                        break;
                    }
                }else if(Main.enemy_list.get(i).num==2){
                    if(Main.enemy_list.get(i).label.getX()-Main.player_entity.label.getX()<=50&&
                            Main.player_entity.label.getY()-Main.enemy_list.get(i).label.getY()<=50&&
                            Main.enemy_list.get(i).label.getY()-Main.player_entity.label.getY()<=30&&
                            Main.player_entity.label.getX()-Main.enemy_list.get(i).label.getX()<=50

                    ){
                        //暂停PlayerBulletCreate线程（不要继续创建以及移动子弹啦）  isTrue是PlayerBulletCreate的标志位
                        PlayerBulletCreate.isActive = false;
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
                        //恢复玩家图片
                        Main.player_entity.label.setIcon(icon);
                        //回到初始位置
                        Main.player_entity.label.setLocation(200,500);
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
                            JOptionPane.showMessageDialog(null,"时间结束！\n玩家积分为"+Main.label_Score.getText(),"时间结束", JOptionPane.WARNING_MESSAGE);
                            System.exit(0);
                        }
                        //1000ms无敌时间后再重新开启碰撞检测
                        try{
                            Thread.sleep(1000);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        //重新开启PlayerBulletCreate线程
                        PlayerBulletCreate.isActive=true;
                        break;
                    }
                }else{
                    if(Main.enemy_list.get(i).label.getX()-Main.player_entity.label.getX()<=40&&
                            Main.player_entity.label.getY()-Main.enemy_list.get(i).label.getY()<=150&&
                            Main.enemy_list.get(i).label.getY()-Main.player_entity.label.getY()<=20&&
                            Main.player_entity.label.getX()-Main.enemy_list.get(i).label.getX()<=80

                    ){
                        //暂停PlayerBulletCreate线程（不要继续创建以及移动子弹啦）  isTrue是PlayerBulletCreate的标志位
                        PlayerBulletCreate.isActive = false;
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
                        //恢复玩家图片
                        Main.player_entity.label.setIcon(icon);
                        //回到初始位置
                        Main.player_entity.label.setLocation(200,500);
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
                            JOptionPane.showMessageDialog(null,"时间结束！\n玩家积分为"+Main.label_Score.getText(),"时间结束", JOptionPane.WARNING_MESSAGE);
                            System.exit(0);
                        }
                        //1000ms无敌时间后再重新开启碰撞检测
                        try{
                            Thread.sleep(1000);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        //重新开启PlayerBulletCreate线程
                        PlayerBulletCreate.isActive=true;
                        break;
                    }
                }
            }
        }


    }
}
