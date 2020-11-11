package com.game.Enemy;

import com.game.Panel.Main;
import com.game.Util.GameMusic;

import javax.swing.*;

public class Enemy_Entity {
    public int num;//编号
    public int health;//生命值
    public JLabel lable;//图片资源
    public Enemy_Entity(int num,int health,JLabel lable){
        this.num = num;
        this.health = health;
        this.lable = lable;
    }

}
