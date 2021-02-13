package TwilightCultist.cards;

import TwilightCultist.TwilightCultistMod;
import basemod.AutoAdd;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import TwilightCultist.characters.TwilightCultist;

import static TwilightCultist.TwilightCultistMod.makeCardPath;

public class TwilightCultist_Defend extends AbstractDynamicCard {


    // TEXT DECLARATION


    public static final String ID = TwilightCultistMod.makeID(TwilightCultist_Defend.class.getSimpleName());
    public static final String IMG = TwilightCultistMod.imgFromId(ID);
    // This does mean that you will need to have an image with the same NAME as the card in your image folder for it to run correctly.


    // /TEXT DECLARATION/


    // STAT DECLARATION

    private static final CardRarity RARITY = CardRarity.BASIC; //  Up to you, I like auto-complete on these
    private static final CardTarget TARGET = CardTarget.ENEMY;  //   since they don't change much.
    private static final CardType TYPE = CardType.SKILL;       //
    public static final CardColor COLOR = TwilightCultist.Enums.COLOR_GRAY;

    private static final int COST = 1;
    private static final int UPGRADED_COST = 1;

    private static final int BLOCK = 5;
    private static final int UPGRADED_BLOCK_INCREASE = 3;

    // /STAT DECLARATION/


    public TwilightCultist_Defend() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        baseBlock = BLOCK;
    }


    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new GainBlockAction(p, this.block));
    }


    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeBlock(UPGRADED_BLOCK_INCREASE);
            upgradeBaseCost(UPGRADED_COST);
            initializeDescription();
        }
    }
}
