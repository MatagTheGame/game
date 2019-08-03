package com.aa.mtg.cards.ability;

import com.aa.mtg.cards.ability.target.Target;
import com.aa.mtg.cards.ability.target.TargetPowerToughnessConstraint;
import com.aa.mtg.cards.ability.target.TargetType;
import com.aa.mtg.cards.ability.trigger.Trigger;
import com.aa.mtg.cards.ability.type.AbilityType;
import com.aa.mtg.cards.modifiers.PowerToughness;

import java.util.List;
import java.util.stream.Collectors;

import static com.aa.mtg.cards.ability.target.TargetPowerToughnessConstraint.PowerOrToughness.POWER;
import static com.aa.mtg.cards.ability.target.TargetPowerToughnessConstraint.PowerOrToughness.TOUGHNESS;
import static com.aa.mtg.cards.ability.target.TargetSelectionConstraint.GREATER_OR_EQUAL;
import static com.aa.mtg.cards.ability.target.TargetStatusType.ATTACKING;
import static com.aa.mtg.cards.ability.target.TargetStatusType.BLOCKING;
import static com.aa.mtg.cards.ability.trigger.TriggerSubtype.WHEN_IT_ENTERS_THE_BATTLEFIELD;
import static com.aa.mtg.cards.ability.trigger.TriggerType.ACTIVATED_ABILITY;
import static com.aa.mtg.cards.ability.trigger.TriggerType.CAST;
import static com.aa.mtg.cards.ability.trigger.TriggerType.TRIGGERED_ABILITY;
import static com.aa.mtg.cards.ability.type.AbilityType.*;
import static com.aa.mtg.cards.modifiers.PowerToughness.powerToughness;
import static com.aa.mtg.cards.properties.Cost.COLORLESS;
import static com.aa.mtg.cards.properties.Type.*;
import static com.aa.mtg.game.player.PlayerType.PLAYER;
import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

public class Abilities {
    public static Ability CREATURES_YOU_CONTROL_GET_PLUS_2_0_UNTIL_END_OF_TURN = new Ability(CREATURES_YOU_CONTROL_GET_X_UNTIL_END_OF_TURN, emptyList(), singletonList("+2/+0"), new Trigger(CAST));
    public static Ability CREATURES_YOU_CONTROL_GET_PLUS_1_1_UNTIL_END_OF_TURN = new Ability(CREATURES_YOU_CONTROL_GET_X_UNTIL_END_OF_TURN, emptyList(), singletonList("+1/+1"), new Trigger(CAST));
    public static Ability CREATURES_YOU_CONTROL_GET_TRAMPLE_UNTIL_END_OF_TURN = new Ability(CREATURES_YOU_CONTROL_GET_X_UNTIL_END_OF_TURN, emptyList(), singletonList("TRAMPLE"), new Trigger(CAST));
    public static Ability DEAL_1_DAMAGE_TO_CREATURE_YOU_CONTROL_THAT_CREATURE_GAINS_TRAMPLE = new Ability(singletonList(THAT_TARGETS_GETS), singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(singletonList(CREATURE)).targetControllerType(PLAYER).build()), asList("DAMAGE:1", "TRAMPLE"), new Trigger(CAST));
    public static Ability DEAL_3_DAMAGE_TO_ANY_TARGET = new Ability(THAT_TARGETS_GETS, singletonList(Target.builder().targetType(TargetType.ANY).build()), singletonList("DAMAGE:3"), new Trigger(CAST));
    public static Ability DEAL_4_DAMAGE_TO_TARGET_ATTACKING_OR_BLOCKING_CREATURE = new Ability(THAT_TARGETS_GETS, singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(singletonList(CREATURE)).targetStatusTypes(asList(ATTACKING, BLOCKING)).build()), singletonList("DAMAGE:4"), new Trigger(CAST));
    public static Ability DEAL_3_DAMAGE_TO_TARGET_CREATURE = new Ability(THAT_TARGETS_GETS, singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(singletonList(CREATURE)).build()), singletonList("DAMAGE:3"), new Trigger(CAST));
    public static Ability DEAL_4_DAMAGE_TO_TARGET_CREATURE = new Ability(THAT_TARGETS_GETS, singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(singletonList(CREATURE)).build()), singletonList("DAMAGE:4"), new Trigger(CAST));
    public static Ability DEAL_4_DAMAGE_TO_TARGET_CREATURE_2_DAMAGE_TO_CONTROLLER = new Ability(THAT_TARGETS_GETS, singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(singletonList(CREATURE)).build()), asList("DAMAGE:4", "CONTROLLER_DAMAGE:2"), new Trigger(CAST));
    public static Ability DEAL_5_DAMAGE_TO_TARGET_CREATURE = new Ability(THAT_TARGETS_GETS, singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(singletonList(CREATURE)).build()), singletonList("DAMAGE:5"), new Trigger(CAST));
    public static Ability DEATHTOUCH = new Ability(AbilityType.DEATHTOUCH);
    public static Ability DRAW_1_CARD = new Ability(DRAW_X_CARDS, emptyList(), singletonList("1"), new Trigger(CAST));
    public static Ability DRAW_2_CARD = new Ability(DRAW_X_CARDS, emptyList(), singletonList("2"), new Trigger(CAST));
    public static Ability ENCHANTED_CREATURE_GETS_FLYING = new Ability(ENCHANTED_CREATURE_GETS, singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(singletonList(CREATURE)).build()), singletonList("FLYING"), new Trigger(CAST));
    public static Ability ENCHANTED_CREATURE_GETS_PLUS_1_1_AND_FLYING = new Ability(ENCHANTED_CREATURE_GETS, singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(singletonList(CREATURE)).build()), asList("+1/+1", "FLYING"), new Trigger(CAST));
    public static Ability ENCHANTED_CREATURE_GETS_PLUS_2_2_AND_FLYING = new Ability(ENCHANTED_CREATURE_GETS, singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(singletonList(CREATURE)).build()), asList("+2/+2", "FLYING"), new Trigger(CAST));
    public static Ability ENCHANTED_CREATURE_GETS_PLUS_2_2_AND_HASTE = new Ability(ENCHANTED_CREATURE_GETS, singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(singletonList(CREATURE)).build()), asList("+2/+2", "HASTE"), new Trigger(CAST));
    public static Ability ENCHANTED_CREATURE_GETS_PLUS_2_2_AND_LIFELINK = new Ability(ENCHANTED_CREATURE_GETS, singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(singletonList(CREATURE)).build()), asList("+2/+2", "LIFELINK"), new Trigger(CAST));
    public static Ability ENCHANTED_CREATURE_GETS_PLUS_3_2_AND_VIGILANCE = new Ability(ENCHANTED_CREATURE_GETS, singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(singletonList(CREATURE)).build()), asList("+3/+2", "VIGILANCE"), new Trigger(CAST));
    public static Ability ENCHANTED_CREATURE_GETS_PLUS_3_3 = new Ability(ENCHANTED_CREATURE_GETS, singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(singletonList(CREATURE)).build()), singletonList("+3/+3"), new Trigger(CAST));
    public static Ability ENCHANTED_CREATURE_GETS_PLUS_7_7_AND_TRAMPLE = new Ability(ENCHANTED_CREATURE_GETS, singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(singletonList(CREATURE)).build()), asList("+7/+7", "TRAMPLE"), new Trigger(CAST));
    public static Ability ENCHANTED_CREATURE_GETS_MINUS_2_2 = new Ability(ENCHANTED_CREATURE_GETS, singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(singletonList(CREATURE)).build()), singletonList("-2/-2"), new Trigger(CAST));
    public static Ability FLYING = new Ability(AbilityType.FLYING);
    public static Ability GAIN_2_LIFE = new Ability(GAIN_X_LIFE, emptyList(), singletonList("2"), new Trigger(CAST));
    public static Ability GAIN_3_LIFE = new Ability(GAIN_X_LIFE, emptyList(), singletonList("3"), new Trigger(CAST));
    public static Ability HASTE = new Ability(AbilityType.HASTE);
    public static Ability LIFELINK = new Ability(AbilityType.LIFELINK);
    public static Ability PAY_1_EQUIP_CREATURE_GETS_FLYING = new Ability(EQUIPPED_CREATURE_GETS, singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(singletonList(CREATURE)).build()), singletonList("FLYING"), new Trigger(ACTIVATED_ABILITY, singletonList(COLORLESS)));
    public static Ability PAY_1_EQUIP_CREATURE_GETS_PLUS_1_1 = new Ability(EQUIPPED_CREATURE_GETS, singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(singletonList(CREATURE)).build()), singletonList("+1/+1"), new Trigger(ACTIVATED_ABILITY, singletonList(COLORLESS)));
    public static Ability PAY_1_EQUIP_CREATURE_GETS_PLUS_1_1_AND_HASTE = new Ability(EQUIPPED_CREATURE_GETS, singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(singletonList(CREATURE)).build()), asList("+1/+1", "HASTE"), new Trigger(ACTIVATED_ABILITY, singletonList(COLORLESS)));
    public static Ability PAY_2_EQUIP_CREATURE_GETS_PLUS_2_0 = new Ability(EQUIPPED_CREATURE_GETS, singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(singletonList(CREATURE)).build()), singletonList("+2/+0"), new Trigger(ACTIVATED_ABILITY, asList(COLORLESS, COLORLESS)));
    public static Ability REACH = new Ability(AbilityType.REACH);
    public static Ability SHUFFLE_GRAVEYARD_INTO_LIBRARY_OF_TARGET_PLAYER = new Ability(SHUFFLE_GRAVEYARD_INTO_LIBRARY_FOR_TARGET_PLAYER, singletonList(Target.builder().targetType(TargetType.PLAYER).build()), emptyList(), new Trigger(CAST));
    public static Ability TARGET_ARTIFACT_CREATURE_OR_PLANESWALKER_GETS_DESTROYED = new Ability(THAT_TARGETS_GETS, singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(asList(ARTIFACT, CREATURE, PLANESWALKER)).build()), singletonList(":DESTROYED"), new Trigger(CAST));
    public static Ability TARGET_ARTIFACT_OR_ENCHANTMENT_GETS_DESTROYED = new Ability(THAT_TARGETS_GETS, singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(asList(ARTIFACT, ENCHANTMENT)).build()), singletonList(":DESTROYED"), new Trigger(CAST));
    public static Ability TARGET_ARTIFACT_OR_LAND_GETS_DESTROYED = new Ability(THAT_TARGETS_GETS, singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(asList(ARTIFACT, LAND)).build()), singletonList(":DESTROYED"), new Trigger(CAST));
    public static Ability TARGET_ATTACKING_CREATURE_GETS_DESTROYED = new Ability(THAT_TARGETS_GETS, singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(singletonList(CREATURE)).targetStatusTypes(singletonList(ATTACKING)).build()), singletonList(":DESTROYED"), new Trigger(CAST));
    public static Ability TARGET_CREATURE_GETS_DEATHTOUCH_UNTIL_END_OF_TURN = new Ability(THAT_TARGETS_GETS, singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(singletonList(CREATURE)).build()), singletonList("DEATHTOUCH"), new Trigger(CAST));
    public static Ability TARGET_CREATURE_GETS_DESTROYED_2_DAMAGE_TO_CONTROLLER = new Ability(THAT_TARGETS_GETS, singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(singletonList(CREATURE)).targetPowerToughnessConstraint(new TargetPowerToughnessConstraint(POWER, GREATER_OR_EQUAL, 4)).build()), asList(":DESTROYED", "CONTROLLER_DAMAGE:2"), new Trigger(CAST));
    public static Ability TARGET_CREATURE_GETS_MINUS_2_2_UNTIL_END_OF_TURN = new Ability(THAT_TARGETS_GETS, singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(singletonList(CREATURE)).build()), singletonList("-2/-2"), new Trigger(CAST));
    public static Ability TARGET_CREATURE_GETS_PLUS_1_0_UNTIL_END_OF_TURN = new Ability(THAT_TARGETS_GETS, singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(singletonList(CREATURE)).build()), singletonList("+1/+0"), new Trigger(CAST));
    public static Ability TARGET_CREATURE_GETS_PLUS_1_1_UNTIL_END_OF_TURN = new Ability(THAT_TARGETS_GETS, singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(singletonList(CREATURE)).build()), singletonList("+1/+1"), new Trigger(CAST));
    public static Ability TARGET_CREATURE_GETS_PLUS_1_3_UNTIL_END_OF_TURN = new Ability(THAT_TARGETS_GETS, singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(singletonList(CREATURE)).build()), singletonList("+1/+3"), new Trigger(CAST));
    public static Ability TARGET_CREATURE_GETS_PLUS_1_7_UNTIL_END_OF_TURN = new Ability(THAT_TARGETS_GETS, singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(singletonList(CREATURE)).build()), singletonList("+1/+7"), new Trigger(CAST));
    public static Ability TARGET_CREATURE_GETS_PLUS_2_2_AND_FLYING_UNTIL_END_OF_TURN = new Ability(THAT_TARGETS_GETS, singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(singletonList(CREATURE)).build()), asList("+2/+2", "FLYING"), new Trigger(CAST));
    public static Ability TARGET_CREATURE_GETS_PLUS_3_3_AND_TRAMPLE_UNTIL_END_OF_TURN = new Ability(THAT_TARGETS_GETS, singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(singletonList(CREATURE)).build()), asList("+3/+3", "TRAMPLE"), new Trigger(CAST));
    public static Ability TARGET_CREATURE_GETS_MINUS_4_0_UNTIL_END_OF_TURN = new Ability(THAT_TARGETS_GETS, singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(singletonList(CREATURE)).build()), singletonList("-4/-0"), new Trigger(CAST));
    public static Ability TARGET_CREATURE_WITH_POWER_GREATER_OR_EQUAL_4_GETS_DESTROYED = new Ability(THAT_TARGETS_GETS, singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(singletonList(CREATURE)).targetPowerToughnessConstraint(new TargetPowerToughnessConstraint(POWER, GREATER_OR_EQUAL, 4)).build()), singletonList(":DESTROYED"), new Trigger(CAST));
    public static Ability TARGET_CREATURE_WITH_TOUGHNESS_GREATER_OR_EQUAL_4_GETS_DESTROYED = new Ability(THAT_TARGETS_GETS, singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(singletonList(CREATURE)).targetPowerToughnessConstraint(new TargetPowerToughnessConstraint(TOUGHNESS, GREATER_OR_EQUAL, 4)).build()), singletonList(":DESTROYED"), new Trigger(CAST));
    public static Ability TARGET_ENCHANTMENT_GETS_DESTROYED = new Ability(THAT_TARGETS_GETS, singletonList(Target.builder().targetType(TargetType.PERMANENT).ofType(singletonList(ENCHANTMENT)).build()), singletonList(":DESTROYED"), new Trigger(CAST));
    public static Ability TRAMPLE = new Ability(AbilityType.TRAMPLE);
    public static Ability VIGILANCE = new Ability(AbilityType.VIGILANCE);
    public static Ability WHEN_IT_ENTERS_THE_BATTLEFIELD_CREATURES_YOU_CONTROL_GET_PLUS_1_1_UNTIL_END_OF_TURN = new Ability(CREATURES_YOU_CONTROL_GET_X_UNTIL_END_OF_TURN, emptyList(), singletonList("+1/+1"), new Trigger(TRIGGERED_ABILITY, WHEN_IT_ENTERS_THE_BATTLEFIELD));
    public static Ability WHEN_IT_ENTERS_THE_BATTLEFIELD_CREATURES_YOU_CONTROL_GET_PLUS_1_1_AND_VIGILANCE_UNTIL_END_OF_TURN = new Ability(CREATURES_YOU_CONTROL_GET_X_UNTIL_END_OF_TURN, emptyList(), asList("+1/+1", "VIGILANCE"), new Trigger(TRIGGERED_ABILITY, WHEN_IT_ENTERS_THE_BATTLEFIELD));
    public static Ability WHEN_IT_ENTERS_THE_BATTLEFIELD_DRAW_A_CARD = new Ability(DRAW_X_CARDS, emptyList(), singletonList("1"), new Trigger(TRIGGERED_ABILITY, WHEN_IT_ENTERS_THE_BATTLEFIELD));
    public static Ability WHEN_IT_ENTERS_THE_BATTLEFIELD_GAIN_4_LIFE = new Ability(GAIN_X_LIFE, emptyList(), singletonList("4"), new Trigger(TRIGGERED_ABILITY, WHEN_IT_ENTERS_THE_BATTLEFIELD));
    public static Ability WHEN_IT_ENTERS_THE_BATTLEFIELD_GAIN_5_LIFE = new Ability(GAIN_X_LIFE, emptyList(), singletonList("5"), new Trigger(TRIGGERED_ABILITY, WHEN_IT_ENTERS_THE_BATTLEFIELD));
    public static Ability WHEN_IT_ENTERS_THE_BATTLEFIELD_EACH_PLAYERS_GAIN_4_LIFE = new Ability(EACH_PLAYERS_GAIN_X_LIFE, emptyList(), singletonList("4"), new Trigger(TRIGGERED_ABILITY, WHEN_IT_ENTERS_THE_BATTLEFIELD));


    private static Ability get(String ability) {
        try {
            return (Ability) Abilities.class.getField(ability).get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Ability " + ability  + " does not exist.");
        }
    }

    public static PowerToughness powerToughnessFromParameters(List<String> parameters) {
        return parameters.stream()
                .filter(parameter -> parameter.contains("/"))
                .map(PowerToughness::powerToughness)
                .findFirst()
                .orElse(powerToughness("0/0"));
    }

    public static List<Ability> abilitiesFromParameters(List<String> parameters) {
        return parameters.stream()
                .filter(parameter -> !parameter.contains("/") && !parameter.contains(":"))
                .map(Abilities::get)
                .collect(Collectors.toList());
    }

    public static int damageFromParameters(List<String> parameters) {
        return parameters.stream()
                .filter(parameter -> parameter.startsWith("DAMAGE:"))
                .findFirst()
                .map(parameter -> parseInt(parameter.replace("DAMAGE:", "")))
                .orElse(0);
    }

    public static int controllerDamageFromParameters(List<String> parameters) {
        return parameters.stream()
                .filter(parameter -> parameter.startsWith("CONTROLLER_DAMAGE:"))
                .findFirst()
                .map(parameter -> parseInt(parameter.replace("CONTROLLER_DAMAGE:", "")))
                .orElse(0);
    }

    public static boolean destroyedFromParameters(List<String> parameters) {
        return parameters.contains(":DESTROYED");
    }
}
