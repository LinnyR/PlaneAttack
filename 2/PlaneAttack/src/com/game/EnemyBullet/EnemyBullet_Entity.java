package com.game.EnemyBullet;

import com.game.Panel.Main;
import com.game.Player.Player;
import com.game.PlayerBullet.PlayerBulletCreate;
import com.game.Util.GameMusic;

import javax.swing.*;
import java.awt.*;

public class EnemyBullet_Entity {
    public int num;
    public JLabel label;
    public static ImageIcon icon;//玩家图片
    public static ImageIcon icon1;//玩家图片1
    public static ImageIcon icon2;//玩家图片2
    public static ImageIcon icon3;//玩家图片3
    public static ImageIcon icon4;//玩家图片4

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
    public EnemyBullet_Entity(int num,JLabel label){
        this.num = num;
        this.label = label;
    }
    //子弹移动攻击玩家的方法
    public static void attackPlayer(){
        for(int i=0;i< Main.enemy_bullets_list.size();i++){
            if(Main.enemy_bullets_list.get(i).label.getX()-Main.player_entity.label.getX()<=50&&
                    Main.player_entity.label.getY()-Main.enemy_bullets_list.get(i).label.getY()<=11&&
                    Main.enemy_bullets_list.get(i).label.getY()-Main.player_entity.label.getY()<=45&&
                    Main.player_entity.label.getX()-Main.enemy_bullets_list.get(i).label.getX()<=2

            ){
                //开启一个线程来播放玩家死亡的动画
                new Thread(()->{
                    //暂停PlayerBulletCreate玩家子弹发射线程
                    PlayerBulletCreate.isActive = false;
                    //暂停Player玩家移动线程
                    Player.isActive = false;
                    //暂停EnemyBullet线程子弹攻击敌人的方法
                    EnemyBullet.isAttack = false;
                    //缓冲10ms 因为此时移动子弹的循环可能还没结束 不可以立马清空子弹集合
                    try{
                        Thread.sleep(10);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    //清空玩家子弹集合
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
                    //重新开启Player线程
                    Player.isActive = true;
                    //重新开启EnemyBullet线程子弹攻击敌人的方法
                    EnemyBullet.isAttack = true;

                }).start();
                break;
            }
        }
    }
}
