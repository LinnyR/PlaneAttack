package com.game.Supply;

import com.game.Panel.Main;
import com.game.Player.Player_Entity;
import com.game.Util.GameMusic;

import javax.swing.*;
import java.awt.*;

public class Supply_Entity {
    int num;//1 2 两种补给
    JLabel label;//补给品图片资源
    public static ImageIcon icon_1;//玩家1图片
    public static ImageIcon icon_2;//玩家2图片
    public static ImageIcon icon_3;//玩家3图片
    public static ImageIcon icon_bomb_effect;//必杀+1
    public static ImageIcon icon_bullet_effect;//武器升级
    public static ImageIcon icon_health_effect;//生命+1
    static {
        //修建玩家1图片
        icon_1 = new ImageIcon("src/img/玩家"+ Player_Entity.player_index+"_1.png");
        Image temp = icon_1.getImage().getScaledInstance(85, 62, icon_1.getImage().SCALE_DEFAULT);
        icon_1 = new ImageIcon(temp);
        //修建玩家2图片
        icon_2 = new ImageIcon("src/img/玩家"+Player_Entity.player_index+"_2.png");
        Image temp_2 = icon_2.getImage().getScaledInstance(85, 62, icon_2.getImage().SCALE_DEFAULT);
        icon_2 = new ImageIcon(temp_2);
        //修建玩家3图片
        icon_3 = new ImageIcon("src/img/玩家"+Player_Entity.player_index+"_3.png");
        Image temp_3 = icon_3.getImage().getScaledInstance(85, 62, icon_3.getImage().SCALE_DEFAULT);
        icon_3 = new ImageIcon(temp_3);
        //修建必杀+1图片
        icon_bomb_effect = new ImageIcon("src/img/必杀+1.png");
        Image temp_bomb_effect = icon_bomb_effect.getImage().getScaledInstance(118, 35, icon_bomb_effect.getImage().SCALE_DEFAULT);
        icon_bomb_effect = new ImageIcon(temp_bomb_effect);
        //修建武器升级图片
        icon_bullet_effect = new ImageIcon("src/img/武器升级.png");
        Image temp_bullet_effect = icon_bullet_effect.getImage().getScaledInstance(134, 43, icon_bullet_effect.getImage().SCALE_DEFAULT);
        icon_bullet_effect = new ImageIcon(temp_bullet_effect);
        //修建生命+1图片
        icon_health_effect = new ImageIcon("src/img/生命+1.png");
        Image temp_health_effect = icon_health_effect.getImage().getScaledInstance(118, 35, icon_health_effect.getImage().SCALE_DEFAULT);
        icon_health_effect = new ImageIcon(temp_health_effect);
    }

    public Supply_Entity(int num,JLabel label){
        this.num = num;
        this.label = label;
    }
    //增强玩家
    public static void supply_player(){
        for(int i=0;i< Main.supply_list.size();i++){
            if(Main.supply_list.get(i).label.getX()-Main.player_entity.label.getX()<=85&&
                    Main.player_entity.label.getY()-Main.supply_list.get(i).label.getY()<=88&&
                    Main.supply_list.get(i).label.getY()-Main.player_entity.label.getY()<=62&&
                    Main.player_entity.label.getX()-Main.supply_list.get(i).label.getX()<=58
            ){
                //炸弹补给
                if(Main.supply_list.get(i).num==1){
                    //播放获取炸弹音效
                    new Thread(()->{
                        GameMusic.Play("src/music/upgrade.wav", 2.0);
                    }).start();
                    //开启一个线程播放必杀+1
                    new Thread(()->{
                        //创建一个必杀+1 label
                        JLabel label = new JLabel();
                        Main.jp1.add(label);
                        label.setIcon(icon_bomb_effect);
                        label.setBounds(940, 300, 118, 35);

                        //label向左滑入
                        for(int j=1;j<=190;j++){
                            try {
                                Thread.sleep(1);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            label.setLocation(label.getX()-4, label.getY());
                        }
                        //label停留1s
                        try {
                            Thread.sleep(1000);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        //label向左滑出
                        for(int j=1;j<=190;j++){
                            try {
                                Thread.sleep(1);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            label.setLocation(label.getX()-4, label.getY());
                        }
                        //删除该图片
                        Main.jp1.remove(label);
                    }).start();
                    //玩家炸弹数量+1
                    Main.player_entity.bomb++;
                    //重新设置炸弹数量
                    Main.label_bomb_count.setText(" X "+Main.player_entity.bomb);

                //弹药补给
                }else if(Main.supply_list.get(i).num==2){
                    //播放获取弹药音效
                    new Thread(()->{
                        GameMusic.Play("src/music/upgrade.wav", 2.0);
                    }).start();

                    //开启一个线程播放 武器升级 图片
                    new Thread(()->{
                        //创建一个 武器升级 label
                        JLabel label = new JLabel();
                        Main.jp1.add(label);
                        label.setIcon(icon_bullet_effect);
                        label.setBounds(935, 300, 134, 43);

                        //label向左滑入
                        for(int j=1;j<=190;j++){
                            try {
                                Thread.sleep(1);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            label.setLocation(label.getX()-4, label.getY());
                        }
                        //label停留1s
                        try {
                            Thread.sleep(1000);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        //label向左滑出
                        for(int j=1;j<=190;j++){
                            try {
                                Thread.sleep(1);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            label.setLocation(label.getX()-4, label.getY());
                        }
                        //删除该图片
                        Main.jp1.remove(label);
                    }).start();
                    //玩家等级+1
                    if(Main.player_entity.level<3){
                        Main.player_entity.level++;
                        //升级更换玩家图片
                        if(Main.player_entity.level==2){
                            Main.player_entity.label.setIcon(icon_2);
                        }else if(Main.player_entity.level==3){
                            Main.player_entity.label.setIcon(icon_3);
                        }
                    }

                 //生命补给
                }else{
                    //播放获取生命音效
                    new Thread(()->{
                        GameMusic.Play("src/music/upgrade.wav", 2.0);
                    }).start();
                    //开启一个线程播放生命+1
                    new Thread(()->{
                        //创建一个生命+1 label
                        JLabel label = new JLabel();
                        Main.jp1.add(label);
                        label.setIcon(icon_health_effect);
                        label.setBounds(940, 300, 118, 35);

                        //label向左滑入
                        for(int j=1;j<=190;j++){
                            try {
                                Thread.sleep(1);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            label.setLocation(label.getX()-4, label.getY());
                        }
                        //label停留1s
                        try {
                            Thread.sleep(1000);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        //label向左滑出
                        for(int j=1;j<=190;j++){
                            try {
                                Thread.sleep(1);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            label.setLocation(label.getX()-4, label.getY());
                        }
                        //删除该图片
                        Main.jp1.remove(label);
                    }).start();
                    //玩家生命值+1
                    Main.player_entity.health++;
                    //重新设置生命数量
                    Main.label_life_Count.setText(" X "+Main.player_entity.health);
                }
                //从面板中删除该补给品
                Main.jp1.remove(Main.supply_list.get(i).label);
                //从集合中删除该补给品
                Main.supply_list.remove(Main.supply_list.get(i));
                //面板jpanel1重绘
                Main.jp1.repaint();



            }
        }
    }
}
