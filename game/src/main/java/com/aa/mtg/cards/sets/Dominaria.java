package com.aa.mtg.cards.sets;

import com.aa.mtg.cards.Card;
import com.aa.mtg.cards.properties.Color;
import com.aa.mtg.cards.properties.Cost;

import java.util.ArrayList;
import java.util.List;

import static com.aa.mtg.cards.ability.Abilities.*;
import static com.aa.mtg.cards.properties.Rarity.*;
import static com.aa.mtg.cards.properties.Subtype.*;
import static com.aa.mtg.cards.properties.Type.*;
import static java.util.Arrays.asList;
import static java.util.Collections.*;
import static org.hibernate.validator.internal.util.CollectionHelper.asSet;

public class Dominaria implements MtgSet {

    public static final String DOM = "DOM";

    public static Card ARCANE_FLIGHT = new Card("Arcane Flight", singleton(Color.BLUE), singletonList(Cost.BLUE), singleton(ENCHANTMENT), singleton(AURA), COMMON, "Enchant creature. Enchanted creature gets +1/+1 and has flying.", 0, 0, singletonList(ENCHANTED_CREATURE_GETS_PLUS_1_1_AND_FLYING));
    public static Card AVEN_SENTRY = new Card("Aven Sentry", singleton(Color.WHITE), asList(Cost.WHITE, Cost.COLORLESS, Cost.COLORLESS, Cost.COLORLESS), singleton(CREATURE), asSet(BIRD, SOLDIER), COMMON, "Flying.", 3, 2, singletonList(FLYING));
    public static Card BEFUDDLE = new Card("Befuddle", singleton(Color.BLUE), asList(Cost.BLUE, Cost.COLORLESS, Cost.COLORLESS), singleton(INSTANT), emptySet(), COMMON, "Target creature gets -4/-0 until end of turn. Draw a card.", 0, 0, asList(TARGET_CREATURE_GETS_MINUS_4_0_UNTIL_END_OF_TURN, DRAW_1_CARD));
    public static Card BENALISH_MARSHAL = new Card("Benalish Marshal", singleton(Color.WHITE), asList(Cost.WHITE, Cost.WHITE, Cost.WHITE), singleton(CREATURE), asSet(HUMAN, KNIGHT), RARE, "Other creatures you control get +1/+1.", 3, 3, singletonList(OTHER_CREATURES_YOU_CONTROL_GET_PLUS_1_1));
    public static Card CABAL_EVANGEL = new Card("Cabal Evangel", singleton(Color.BLACK), asList(Cost.BLACK, Cost.COLORLESS), singleton(CREATURE), asSet(HUMAN, CLERIC), COMMON, ".", 2, 2, emptyList());
    public static Card CHARGE = new Card("Charge", singleton(Color.WHITE), singletonList(Cost.WHITE), singleton(INSTANT), emptySet(), COMMON, "Creatures you control get +1/+1 until end of turn.", 0, 0, singletonList(CREATURES_YOU_CONTROL_GET_PLUS_1_1_UNTIL_END_OF_TURN));
    public static Card DIVINATION = new Card("Divination", singleton(Color.BLUE), asList(Cost.BLUE, Cost.COLORLESS, Cost.COLORLESS), singleton(SORCERY), emptySet(), COMMON, "Draw 2 cards.", 0, 0, singletonList(DRAW_2_CARDS));
    public static Card DREAD_SHADE = new Card("Dread Shade", singleton(Color.BLACK), asList(Cost.BLACK, Cost.BLACK, Cost.BLACK), singleton(CREATURE), singleton(SHADE), RARE, "Pay BLACK: Dread Shade gets +1/+1 until end of turn.", 3, 3, singletonList(PAY_BLACK_IT_GETS_PLUS_1_PLUS_1_UNTIL_END_OF_TURN));
    public static Card EVISCERATE = new Card("Eviscerate", singleton(Color.BLACK), asList(Cost.BLACK, Cost.COLORLESS, Cost.COLORLESS, Cost.COLORLESS), singleton(SORCERY), emptySet(), COMMON, "Destroy target creature.", 0, 0, singletonList(DESTROY_TARGET_CREATURE));
    public static Card FERAL_ABOMINATION = new Card("Feral Abomination", singleton(Color.BLACK), asList(Cost.BLACK, Cost.COLORLESS, Cost.COLORLESS, Cost.COLORLESS, Cost.COLORLESS, Cost.COLORLESS), singleton(CREATURE), singleton(THRULL), COMMON, "Deathtouch", 5, 5, singletonList(DEATHTOUCH));
    public static Card FIRE_ELEMENTAL = new Card("Fire Elemental", singleton(Color.RED), asList(Cost.RED, Cost.RED, Cost.COLORLESS, Cost.COLORLESS, Cost.COLORLESS), singleton(CREATURE), singleton(ELEMENTAL), COMMON, "", 5, 4, emptyList());
    public static Card GIDEONS_REPROACH = new Card("Gideon's Reproach", singleton(Color.WHITE), asList(Cost.WHITE, Cost.COLORLESS), singleton(INSTANT), emptySet(), COMMON, "Gideon's Reproach deals 4 damage to target attacking or blocking creature.", 0, 0, singletonList(DEAL_4_DAMAGE_TO_TARGET_ATTACKING_OR_BLOCKING_CREATURE));
    public static Card INVOKE_THE_DIVINE = new Card("Invoke the Divine", singleton(Color.WHITE), asList(Cost.WHITE, Cost.COLORLESS, Cost.COLORLESS), singleton(INSTANT), emptySet(), COMMON, "Destroy target artifact or enchantment. You gain 4 life.", 0, 0, asList(DESTROY_TARGET_ARTIFACT_OR_ENCHANTMENT, GAIN_4_LIFE));
    public static Card KNIGHT_OF_NEW_BENALIA = new Card("Knight of New Benalia", singleton(Color.WHITE), asList(Cost.WHITE, Cost.COLORLESS), singleton(CREATURE), asSet(HUMAN, KNIGHT), COMMON, "", 3, 1, emptyList());
    public static Card LLANOWAR_ELVES = new Card("Llanowar Elves", singleton(Color.GREEN), singletonList(Cost.GREEN), singleton(CREATURE), asSet(ELF, DRUID), COMMON, "Tap: Add GREEN to your mana pool.", 1, 1, singletonList(TAP_ADD_GREEN_MANA));
    public static Card MAMMOTH_SPIDER = new Card("Mammoth Spider", singleton(Color.GREEN), asList(Cost.GREEN, Cost.COLORLESS, Cost.COLORLESS, Cost.COLORLESS, Cost.COLORLESS), singleton(CREATURE), singleton(SPIDER), COMMON, "Reach", 3, 5, singletonList(REACH));
    public static Card MESA_UNICORN = new Card("Mesa Unicorn", singleton(Color.WHITE), asList(Cost.WHITE, Cost.COLORLESS), singleton(CREATURE), singleton(UNICORN), COMMON, "Lifelink", 2, 2, singletonList(LIFELINK));
    public static Card PARDIC_WANDERER = new Card("Pardic Wanderer", emptySet(), asList(Cost.COLORLESS, Cost.COLORLESS, Cost.COLORLESS, Cost.COLORLESS, Cost.COLORLESS, Cost.COLORLESS), asSet(ARTIFACT, CREATURE), singleton(GOLEM), COMMON, "Trample", 5, 5, singletonList(TRAMPLE));
    public static Card PRIMORDIAL_WURM = new Card("Primordial Wurm", singleton(Color.GREEN), asList(Cost.GREEN, Cost.GREEN, Cost.COLORLESS, Cost.COLORLESS, Cost.COLORLESS, Cost.COLORLESS), singleton(CREATURE), singleton(WURM), COMMON, "", 7, 6, emptyList());
    public static Card PYROMANTIC_PILGRIM = new Card("Pyromantic Pilgrim", singleton(Color.RED), asList(Cost.RED, Cost.COLORLESS, Cost.COLORLESS), singleton(CREATURE), asSet(HUMAN, WIZARD), COMMON, "Haste", 3, 1, singletonList(HASTE));
    public static Card SERRA_ANGEL = new Card("Serra Angel", singleton(Color.WHITE), asList(Cost.WHITE, Cost.WHITE, Cost.COLORLESS, Cost.COLORLESS, Cost.COLORLESS), singleton(CREATURE), singleton(ANGEL), UNCOMMON, "Flying, vigilance", 4, 4, asList(FLYING, VIGILANCE));
    public static Card SHORT_SWORD = new Card("Short Sword", emptySet(), singletonList(Cost.COLORLESS), singleton(ARTIFACT), singleton(EQUIPMENT), COMMON, "Equipment Creatures get +1/+1. Equip 2", 0, 0, singletonList(PAY_1_EQUIP_CREATURE_GETS_PLUS_1_1));
    public static Card SPARRING_CONSTRUCT = new Card("Sparring Construct", emptySet(), singletonList(Cost.COLORLESS), asSet(ARTIFACT, CREATURE), singleton(CONSTRUCT), COMMON, "When Sparring Construct dies, put a +1/+1 counter on target creature you control.", 1, 1, singletonList(WHEN_IT_DIES_PUT_A_PLUS_1_COUNTER_ON_TARGET_CREATURE_YOU_CONTROL));
    public static Card TOLARIAN_SCOLAR = new Card("Tolarian Scolar", singleton(Color.BLUE), asList(Cost.BLUE, Cost.COLORLESS, Cost.COLORLESS), singleton(CREATURE), asSet(HUMAN, WIZARD), COMMON, "", 2, 3, emptyList());
    public static Card YARGLE_GLUTTON_OF_URBORG = new Card("Yargle, Glutton of Urborg", singleton(Color.BLACK), asList(Cost.BLACK, Cost.COLORLESS, Cost.COLORLESS, Cost.COLORLESS, Cost.COLORLESS), asSet(LEGENDARY, CREATURE), asSet(FROG, SPIRIT), UNCOMMON, "", 9, 3, emptyList());

    private static Dominaria instance;

    private List<Card> cards = new ArrayList<>();

    private Dominaria() {
        cards.add(ARCANE_FLIGHT);
        cards.add(AVEN_SENTRY);
        cards.add(BEFUDDLE);
        cards.add(BENALISH_MARSHAL);
        cards.add(CABAL_EVANGEL);
        cards.add(CHARGE);
        cards.add(DIVINATION);
        cards.add(DREAD_SHADE);
        cards.add(EVISCERATE);
        cards.add(FERAL_ABOMINATION);
        cards.add(FIRE_ELEMENTAL);
        cards.add(GIDEONS_REPROACH);
        cards.add(INVOKE_THE_DIVINE);
        cards.add(KNIGHT_OF_NEW_BENALIA);
        cards.add(LLANOWAR_ELVES);
        cards.add(MAMMOTH_SPIDER);
        cards.add(MESA_UNICORN);
        cards.add(PRIMORDIAL_WURM);
        cards.add(PARDIC_WANDERER);
        cards.add(PYROMANTIC_PILGRIM);
        cards.add(SERRA_ANGEL);
        cards.add(SHORT_SWORD);
        cards.add(SPARRING_CONSTRUCT);
        cards.add(TOLARIAN_SCOLAR);
        cards.add(YARGLE_GLUTTON_OF_URBORG);
    }

    @Override
    public String getName() {
        return "Ixalan";
    }

    @Override
    public String getCode() {
        return DOM;
    }

    @Override
    public List<Card> getCards() {
        return cards;
    }

    public static Dominaria dominaria() {
        if (instance == null) {
            instance = new Dominaria();
        }
        return instance;
    }
}