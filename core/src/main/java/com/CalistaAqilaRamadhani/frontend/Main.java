package com.CalistaAqilaRamadhani.frontend;
import com.CalistaAqilaRamadhani.frontend.objects.GameObject;

import java.util.Iterator;
import java.util.List;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("libgdx.png");
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(image, 140, 210);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}


public <T extends GameObject> void updateAndClean(
    List<T> list,
    float delta,
    float screenWidth,
    float screenHeight
) {

    Iterator<T> iterator = list.iterator();

    while (iterator.hasNext()) {

        T entity = iterator.next();

        entity.update(delta);

        if (entity.isOffScreen(screenWidth, screenHeight)
            || entity.isDestroyed()) {

            System.out.println(
                "Removed via Generic Iterator: "
                    + entity.getClass().getSimpleName()
            );

            iterator.remove();
        }
    }
}
