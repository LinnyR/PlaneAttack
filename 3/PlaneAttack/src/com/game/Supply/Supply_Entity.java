package com.game.Supply;

import com.game.Panel.Main;
import com.game.Util.GameMusic;

import javax.swing.*;
import java.awt.*;

public class Supply_Entity {
    int num;//1 2 两种补给
    JLabel label;//补给品图片资源
    public static ImageIcon icon_1;//玩家1图片
    public static ImageIcon icon_2;//玩家2图片
    public static ImageIcon icon_3;//玩家3图片
    static {
        //修建玩家1图片
        icon_1 = new ImageIcon("src/img/玩家1.png");
        Image temp = icon_1.getImage().getScaledInstance(85, 62, icon_1.getImage().SCALE_DEFAULT);
        icon_1 = new ImageIcon(temp);
        //修建玩家2图片
        icon_2 = new ImageIcon("src/img/玩家2.png");
        Image temp_2 = icon_2.getImage().getScaledInstance(85, 62, icon_2.getImage().SCALE_DEFAULT);
        icon_2 = new ImageIcon(temp_2);
        //修建玩家3图片
        icon_3 = new ImageIcon("src/img/玩家3.png");
        Image temp_3 = icon_3.getImage().getScaledInstance(85, 62, icon_3.getImage().SCALE_DEFAULT);
        icon_3 = new ImageIcon(temp_3);
    }

    public Supply_Entity(int num,JLabel label){
        this.num = num;
        this.label = label;
    }
    //增强玩家
    public static void supply_player(){
        for(int i=0;i< Main.supply_list.size();i++){
            if(Main.supply_list.get(i).label.getX()-Main.player_entity.label.getX()<=50&&
                    Main.player_entity.label.getY()-Main.supply_list.get(i).label.getY()<=70&&
                    Main.supply_list.get(i).label.getY()-Main.player_entity.label.getY()<=30&&
                    Main.player_entity.label.getX()-Main.supply_list.get(i).label.getX()<=50
            ){
                ////炸弹补给
                if(Main.supply_list.get(i).num==1){
                    //播放获取炸弹音效
                    new Thread(()->{
                        GameMusic.Play("src/music/get_bomb.wav", 2.0);
                    }).start();
                    //玩家炸弹数量+1
                    Main.player_entity.bomb++;
                    //重新设置炸弹数量
                    Main.label_bomb_count.setText(" X "+Main.player_entity.bomb);

                //弹药补给
                }else{
                    //播放获取弹药音效
                    new Thread(()->{
                        GameMusic.Play("src/music/upgrade.wav", 2.0);
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
