package TwilightCultist.cards;

import TwilightCultist.TwilightCultistMod;
import TwilightCultist.characters.TwilightCultist;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TwilightCultist.TwilightCultistMod.makeCardPath;


public class TwilightCultist_MagicStrike extends AbstractDynamicCard {

    // TEXT DECLARATION

    public static final String ID = TwilightCultistMod.makeID(TwilightCultist_MagicStrike.class.getSimpleName());
    //public static final String IMG = TwilightCultistMod.imgFromId(ID);
    public static final String IMG = makeCardPath("Attack.png");;
    // This does mean that you will need to have an image with the same NAME as the card in your image folder for it to run correctly.


    // /TEXT DECLARATION/


    // STAT DECLARATION

    private static final CardRarity RARITY = CardRarity.BASIC; //  Up to you, I like auto-complete on these
    private static final CardTarget TARGET = CardTarget.ENEMY;  //   since they don't change much.
    private static final CardType TYPE = CardType.ATTACK;       //
    public static final CardColor COLOR = TwilightCultist.Enums.COLOR_GRAY;

    private static final int COST = 1;  // COST = 1
    private static final int UPGRADED_COST=1; // UPGRADED_COST = 1

    private static final int DAMAGE = 6;    // DAMAGE = 6
    private static final int UPGRADED_DAMAGE_INCREASE = 3;

    // /STAT DECLARATION/


    public TwilightCultist_MagicStrike() { // public TwilightCultist_Strike() - This one and the one right under the imports are the most important ones, don't forget them
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        baseMagicalDamage = DAMAGE;
    }


    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(
                new DamageAction(m, new DamageInfo(p, magicalDamage, damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
    }


    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeDamage(UPGRADED_DAMAGE_INCREASE);
            upgradeBaseCost(UPGRADED_COST);
            initializeDescription();
        }
    }
}
