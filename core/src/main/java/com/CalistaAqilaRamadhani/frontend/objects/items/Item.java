package com.CalistaAqilaRamadhani.frontend.objects.items;

import com.CalistaAqilaRamadhani.frontend.objects.Collidable;
import com.CalistaAqilaRamadhani.frontend.objects.GameObject;
import com.CalistaAqilaRamadhani.frontend.objects.Player;
import com.badlogic.gdx.graphics.Color;

public class Item extends GameObject {

    private String itemType;
    private ItemType itemTypeEnum;
    private long scoreValue;


    // Constructor 1
    public Item(float x, float y, ItemType itemTypeEnum) {

        super(x, y, 16, 16, 100f, Color.WHITE);

        this.itemTypeEnum = itemTypeEnum;
        this.itemType = itemTypeEnum.name();
        this.scoreValue = itemTypeEnum.getScoreValue();
    }


    // Constructor 2
    public Item(
        float x,
        float y,
        float width,
        float height,
        float speed,
        ItemType itemTypeEnum,
        long scoreValue
    ) {

        super(x, y, width, height, speed, Color.WHITE);

        this.itemTypeEnum = itemTypeEnum;
        this.itemType = itemTypeEnum.name();
        this.scoreValue = scoreValue;
    }


    // Item moves downward
    @Override
    public void update(float delta) {
        y -= speed * delta;
    }


    // Getters
    public String getItemType() {
        return itemType;
    }

    public ItemType getItemTypeEnum() {
        return itemTypeEnum;
    }

    public long getScoreValue() {
        return scoreValue;
    }


    // Collision
    @Override
    public void onCollision(Collidable other) {

        if (other instanceof Player) {
            System.out.println("Item touches player");
        }
    }
}
