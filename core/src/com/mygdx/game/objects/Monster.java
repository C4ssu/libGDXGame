package com.mygdx.game.objects;

/**
 * Created by Elias on 12.11.2017.
 */

public class Monster {
    public static final Monster[] monsterList = new Monster [200];
    public static  final Monster slime = new MonsterSlime(0, 3, 10);


    public int id;
    public int health;
    public double speed;

    public Monster(int id, double speed, int health){
        if(monsterList[id] != null) {
            System.out.println("[TowerInitialization] Two enemies with same id");
        }else {
            monsterList[id] = this;

            this.id = id;
            this.health = health;
            this.speed = speed;
        }

    }

    public static void startup() {

    }
}
