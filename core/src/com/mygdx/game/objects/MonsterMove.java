package com.mygdx.game.objects;

/**
 * Created by Elias on 12.11.2017.
 */

public class MonsterMove {

    Monster monster;


    int xPos;
    int yPos;

    int routePosX;
    int routePosY;

    int health;

    public MonsterMove(Monster monster,SpawnPoint spawnPoint) {
        this.monster = monster;
        this.routePosX = spawnPoint.getX();
        this.routePosY = spawnPoint.getY();

        this.health = monster.health;

    }

    public MonsterMove update() {
        MonsterMove currentMonster = this;

        if(currentMonster.health <= 0) {
            return null;
        }

        return currentMonster;
    }
}
