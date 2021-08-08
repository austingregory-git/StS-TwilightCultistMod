package TwilightCultist.relics;

import TwilightCultist.TwilightCultistMod;
import TwilightCultist.util.TextureLoader;
import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import static TwilightCultist.TwilightCultistMod.*;

public class TwilightMedallion extends CustomRelic {
    public static final String ID = TwilightCultistMod.makeID(TwilightMedallion.class.getSimpleName());
    private static final String PNG = ".png";
    //private static final Texture IMG = TextureLoader.getTexture(makeRelicPath(TwilightMedallion.class.getSimpleName() + PNG));
    private static final Texture IMG = TextureLoader.getTexture(makeRelicPath("AlchemistsNecklace" + PNG));
    //private static final Texture IMG = TextureLoader.getTexture(makeRelicPath("TwilightCultistResources/relics/AlchemistsNecklace.png"));
    //private static final Texture OUTLINE = TextureLoader.getTexture(makeRelicOutlinePath("placeholder_relic.png"));

    public TwilightMedallion() {
        super(ID, IMG, RelicTier.STARTER, LandingSound.SOLID);
    }

    @Override
    public String getUpdatedDescription() {
        return AbstractDungeon.player != null ? this.setDescription(AbstractDungeon.player.chosenClass) : this.setDescription((AbstractPlayer.PlayerClass)null);
    }

    private String setDescription(AbstractPlayer.PlayerClass c) {
        return DESCRIPTIONS[0];
    }

    public void onUsePotion() {
        this.addToBot(new DrawCardAction(2));
    }

    public AbstractRelic makeCopy() {
        return new TwilightMedallion();
    }

}