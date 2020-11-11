package com.game.Supply;

import com.game.Panel.Main;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Supply implements Runnable{
    private static ImageIcon icon1;
    private static ImageIcon icon2;

    static {
        //修建炸弹补给图片
        icon1 = new ImageIcon("src/img/bomb_supply.png");
        Image temp1 = icon1.getImage().getScaledInstance(60, 107, icon1.getImage().SCALE_DEFAULT);
        icon1 = new ImageIcon(temp1);

        //修建弹药补给图片
        icon2 = new ImageIcon("src/img/bullet_supply.png");
        Image temp2 = icon2.getImage().getScaledInstance(58, 88, icon2.getImage().SCALE_DEFAULT);
        icon2 = new ImageIcon(temp2);
    }

    @Override
    public void run() {
        Random random = new Random();
        int count = 0;
        int dir=1;//方向变量
        while (true){
           count++;
           //每循环999999990次 并且 集合集合<1时 产生一个补给
           if(count%524288==0&&Main.supply_list.size()<1){
               //随机生成两种补给
               int num = random.nextInt(2
               )+1;//1 炸弹补给 2 子弹补给
               //生成一个随机数 位置
               int x = random.nextInt(400);//0-399
               //创建补给图片
               JLabel label_supply = new JLabel();
               if(num==1){//炸弹补给
                   label_supply.setIcon(icon1);
                   label_supply.setBounds(x,-110, 60, 107);
               }else{//弹药补给
                   label_supply.setIcon(icon2);
                   label_supply.setBounds(x,-90, 58, 88);
               }
               //设置给补给实体
               Supply_Entity supply_entity = new Supply_Entity(num, label_supply);
               //将补给图片加入面板当中
               Main.jp1.add(supply_entity.label);
               //将补给实体加入集合当中
               Main.supply_list.add(supply_entity);
               //重绘jpnel1
               Main.jp1.repaint();
               count = 0;
           }

           //移动集合中的补给
            for(int i=0;i<Main.supply_list.size();i++){
                try {
                    Thread.sleep(15);
                }catch (Exception e){
                    e.printStackTrace();
                }
                Main.supply_list.get(i).label.setLocation(Main.supply_list.get(i).label.getX()+dir, Main.supply_list.get(i).label.getY()+1);
                if( Main.supply_list.get(i).label.getY()>700){
                    //从面板中删除该补给
                    Main.jp1.remove(Main.supply_list.get(i).label);
                    //从集合中删除该补给
                    Main.supply_list.remove(Main.supply_list.get(i));
                    i--;
                }
                //增强玩家的方法
                Supply_Entity.supply_player();
            }
            //方向取反
            if(count%100==0){
                dir = -dir;
            }

        }
    }
}
