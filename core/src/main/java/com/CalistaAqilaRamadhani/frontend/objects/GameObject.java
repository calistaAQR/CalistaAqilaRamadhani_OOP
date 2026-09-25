package com.CalistaAqilaRamadhani.frontend.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public abstract class GameObject implements Collidable {

    protected float x;
    protected float y;
    protected float width;
    protected float height;
    protected float speed;
    protected Color color;

    // Object starts as active
    protected boolean active = true;


    // Constructor
    public GameObject(float x, float y, float width, float height,
                      float speed, Color color) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.color = color;
    }


    // Every subclass must implement update()
    public abstract void update(float delta);


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


    public boolean isDestroyed() {
        return !active;
    }


    public void destroy() {
        active = false;
    }



    public boolean isOffScreen(float screenWidth, float screenHeight) {

        return x < -50
            || x > screenWidth + 50
            || y < -50
            || y > screenHeight + 50;
    }


    public void render(ShapeRenderer shapeRenderer) {

        if (shapeRenderer != null && color != null && active) {

            shapeRenderer.setColor(color);
            shapeRenderer.rect(x, y, width, height);
        }
    }



    public float getX() {
        return x;
    }


    public float getY() {
        return y;
    }


    public float getWidth() {
        return width;
    }


    public float getHeight() {
        return height;
    }


    public float getSpeed() {
        return speed;
    }


    public Color getColor() {
        return color;
    }


    public void setX(float x) {
        this.x = x;
    }


    public void setY(float y) {
        this.y = y;
    }


    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
