package com.game.BossBullet;

import com.game.Panel.Main;

import javax.swing.*;
import java.awt.*;

public class BossBullet implements Runnable{

    public static ImageIcon icon_bullet1;
    public static ImageIcon icon_bullet2;
    public static ImageIcon icon_bullet3;
    public static volatile boolean isTrue = false; //是否继续创建及移动子弹
    public static volatile  boolean isAttack = true;//是否攻击玩家

    static{
        //修建Boss1子弹图片
        icon_bullet1 = new ImageIcon("src/img/boss1子弹.png");
        Image temp_bullet1 = icon_bullet1.getImage().getScaledInstance(28, 29, icon_bullet1.getImage().SCALE_DEFAULT);
        icon_bullet1 = new ImageIcon(temp_bullet1);
        //修建Boss2子弹图片
        icon_bullet2 = new ImageIcon("src/img/boss2子弹.png");
        Image temp_bullet2 = icon_bullet2.getImage().getScaledInstance(28, 29, icon_bullet2.getImage().SCALE_DEFAULT);
        icon_bullet2 = new ImageIcon(temp_bullet2);
        //修建Boss3子弹图片
        icon_bullet3 = new ImageIcon("src/img/boss3子弹.png");
        Image temp_bullet3 = icon_bullet3.getImage().getScaledInstance(28, 29, icon_bullet3.getImage().SCALE_DEFAULT);
        icon_bullet3 = new ImageIcon(temp_bullet3);

    }
    @Override
    public void run() {
        int count=0;
        //子弹X方向数组
        int[] dir_x = {-2,-1,0,1,2,2,1,0,-1,-2};
        int index=0;
        while (true) {
            if (isTrue){
                count++;
                //每循环30次创建一个子弹
                if(count%30==0&&Main.boss_bullets_list.size()<5){
                    if(Main.boss!=null){
                        //创建子弹并设置图片
                        JLabel label_bullet = new JLabel();
                        //蝎子
                        if(Main.boss.num==0){
                            label_bullet.setIcon(icon_bullet1);
                            label_bullet.setBounds(Main.boss.label.getX()+(Main.boss.label.getWidth())/2, Main.boss.label.getY()+Main.boss.label.getHeight(), 28, 29);

                        }else if(Main.boss.num==1){
                            //狮子
                            label_bullet.setIcon(icon_bullet2);
                            label_bullet.setBounds(Main.boss.label.getX()+(Main.boss.label.getWidth())/2, Main.boss.label.getY()+Main.boss.label.getHeight(), 28, 29);

                        }else{
                            //人
                            label_bullet.setIcon(icon_bullet3);
                            label_bullet.setBounds(Main.boss.label.getX()+(Main.boss.label.getWidth())/2, Main.boss.label.getY()+Main.boss.label.getHeight(), 28, 29);

                        }
                        //赋值给实体类                                                            依次为-2,-1,0,1,2
                        BossBullet_Entity bossBullet_entity = new BossBullet_Entity(label_bullet,dir_x[index],1);
                        index = (index+1)%dir_x.length;
                        //将子弹加入面板当中
                        Main.jp1.add(bossBullet_entity.label);
                        //将子弹加入到list当中
                        Main.boss_bullets_list.add(bossBullet_entity);
                        count=0;
                    }

                }
                //移动子弹
                for(int i=0;i<Main.boss_bullets_list.size();i++){
                    try {
                        Thread.sleep(2);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    // X每次增加x_dir    y每次增加y_dir
                    Main.boss_bullets_list.get(i).label.setLocation(Main.boss_bullets_list.get(i).label.getX()+Main.boss_bullets_list.get(i).x_dir,Main.boss_bullets_list.get(i).label.getY()+Main.boss_bullets_list.get(i).y_dir);
                    //如果子弹到达指定位置
                    if(Main.boss_bullets_list.get(i).label.getX()<0||Main.boss_bullets_list.get(i).label.getX()>480||Main.boss_bullets_list.get(i).label.getY()>700){
                        //从面板中删除该子弹
                        Main.jp1.remove(Main.boss_bullets_list.get(i).label);
                        //从集合中删除该子弹
                        Main.boss_bullets_list.remove(Main.boss_bullets_list.get(i));
                        i--;
                    }
                    if(isAttack){
                        BossBullet_Entity.attackPlayer();
                    }
                }
            }
        }
    }
}
