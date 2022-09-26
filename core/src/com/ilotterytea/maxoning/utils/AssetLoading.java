package com.ilotterytea.maxoning.utils;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.ilotterytea.maxoning.anim.SpriteUtils;
import com.ilotterytea.maxoning.player.MaxonItemEnum;
import com.ilotterytea.maxoning.player.MaxonItemRegister;
import com.ilotterytea.maxoning.ui.AnimatedImage;

public class AssetLoading {
    public static void queue(AssetManager am) {
        // Texture atlases:
        am.load("sprites/env/environment.atlas", TextureAtlas.class);
        am.load("sprites/gui/brand.atlas", TextureAtlas.class);
        am.load("sprites/gui/icons.atlas", TextureAtlas.class);
        am.load("sprites/gui/ilotterytea.atlas", TextureAtlas.class);
        am.load("sprites/gui/widgets.atlas", TextureAtlas.class);

        // Cat item textures:
        am.load("sprites/sheet/loadingCircle.png", Texture.class);
        am.load("sprites/sheet/bror.png", Texture.class);
        am.load("sprites/sheet/manlooshka.png", Texture.class);
        am.load("sprites/sheet/furios_cat.png", Texture.class);
        am.load("sprites/sheet/sandwich_cat.png", Texture.class);
        am.load("sprites/sheet/thirsty_cat.png", Texture.class);

        // Music:
        am.load("mus/menu/mus_menu_intro.ogg", Music.class);
        am.load("mus/menu/mus_menu_loop.ogg", Music.class);
        // Sounds:
    }

    public static void registerItems(AssetManager am, I18N i18n) {
        MaxonItemRegister.register(
                0, i18n.TranslatableText("pet.bror.name"), i18n.TranslatableText("pet.bror.desc"),
                new AnimatedImage(SpriteUtils.splitToTextureRegions(am.get("sprites/sheet/bror.png", Texture.class), 112, 112, 11, 7)),
                MaxonItemEnum.SLAVE,
                600,
                0.1f
        );

        MaxonItemRegister.register(
                1, i18n.TranslatableText("pet.sandwich.name"), i18n.TranslatableText("pet.sandwich.desc"),
                new AnimatedImage(SpriteUtils.splitToTextureRegions(am.get("sprites/sheet/sandwich_cat.png", Texture.class), 112, 112, 4, 7)),
                MaxonItemEnum.SLAVE,
                2000,
                0.5f
        );

        MaxonItemRegister.register(
                2, i18n.TranslatableText("pet.manlooshka.name"), i18n.TranslatableText("pet.manlooshka.desc"),
                new AnimatedImage(SpriteUtils.splitToTextureRegions(am.get("sprites/sheet/manlooshka.png", Texture.class), 112, 112, 10, 4)),
                MaxonItemEnum.SLAVE,
                8000,
                5f
        );

        MaxonItemRegister.register(
                3, i18n.TranslatableText("pet.thirsty.name"), i18n.TranslatableText("pet.thirsty.desc"),
                new AnimatedImage(SpriteUtils.splitToTextureRegions(am.get("sprites/sheet/thirsty_cat.png", Texture.class), 112, 112, 6, 3)),
                MaxonItemEnum.SLAVE,
                20000,
                15f
        );

        MaxonItemRegister.register(
                4, i18n.TranslatableText("pet.furios.name"), i18n.TranslatableText("pet.furios.desc"),
                new AnimatedImage(SpriteUtils.splitToTextureRegions(am.get("sprites/sheet/furios_cat.png", Texture.class), 112, 112, 7, 4)),
                MaxonItemEnum.SLAVE,
                75000,
                80f
        );
    }
}
