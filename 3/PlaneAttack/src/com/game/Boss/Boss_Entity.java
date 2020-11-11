package com.game.Boss;

import com.game.Panel.Main;
import com.game.PlayerBullet.PlayerBulletCreate;
import com.game.Util.GameMusic;

import javax.swing.*;

public class Boss_Entity {
    public int total_health;
    public int cur_health;
    public JLabel label;
    public int dir;
    public Boss_Entity(int total_health,int cur_health,JLabel label,int dir){
        this.total_health = total_health;
        this.cur_health = cur_health;
        this.label = label;
        this.dir = dir;
    }
}
