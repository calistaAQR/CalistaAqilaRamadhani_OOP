package com.CalistaAqilaRamadhani.frontend.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;

public abstract class GameObject implements Collidable {

    protected float x;
    protected float y;
    protected float width;
    protected float height;
    protected float speed;
    protected Color color;

    public GameObject(float x, float y, float width, float height,
                      float speed, Color color) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.color = color;
    }

    @Override
    public Rectangle getCoreHitbox() {
        return new Rectangle(x, y, width, height);
    }

    @Override
    public Rectangle getGrazeHitbox() {
        return new Rectangle(
            x - 10,
            y - 10,
            width + 20,
            height + 20
        );
    }

    @Override
    public void onCollision(Collidable other) {
        // Base collision handler
    }

    // getter dan setter lama kamu tetap di bawah
}
