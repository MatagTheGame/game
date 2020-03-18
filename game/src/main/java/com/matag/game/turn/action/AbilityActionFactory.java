package com.matag.game.turn.action;

import com.matag.cardinstance.ability.AbilityAction;
import com.matag.cards.ability.type.AbilityType;
import com.matag.game.turn.action.attach.AttachAction;
import com.matag.game.turn.action.draw.DrawXCardsAction;
import com.matag.game.turn.action.life.AddXLifeAction;
import com.matag.game.turn.action.life.EachPlayersAddXLifeAction;
import com.matag.game.turn.action.selection.SelectedPermanentsGetXUntilEndOfTurnAction;
import com.matag.game.turn.action.shuffle.ShuffleTargetGraveyardIntoLibraryAction;
import com.matag.game.turn.action.target.ThatTargetsGetAction;
import org.springframework.stereotype.Component;

@Component
public class AbilityActionFactory {
  private final ThatTargetsGetAction thatTargetsGetAction;
  private final DrawXCardsAction drawXCardsAction;
  private final AddXLifeAction addXLifeAction;
  private final EachPlayersAddXLifeAction eachPlayersAddXLifeAction;
  private final ShuffleTargetGraveyardIntoLibraryAction shuffleTargetGraveyardIntoLibraryAction;
  private final SelectedPermanentsGetXUntilEndOfTurnAction selectedPermanentsGetXUntilEndOfTurnAction;
  private final AttachAction attachAction;

  public AbilityActionFactory(ThatTargetsGetAction thatTargetsGetAction, DrawXCardsAction drawXCardsAction,
                              AddXLifeAction addXLifeAction, EachPlayersAddXLifeAction eachPlayersAddXLifeAction, ShuffleTargetGraveyardIntoLibraryAction shuffleTargetGraveyardIntoLibraryAction,
                              SelectedPermanentsGetXUntilEndOfTurnAction selectedPermanentsGetXUntilEndOfTurnAction, AttachAction attachAction) {
    this.thatTargetsGetAction = thatTargetsGetAction;
    this.drawXCardsAction = drawXCardsAction;
    this.addXLifeAction = addXLifeAction;
    this.eachPlayersAddXLifeAction = eachPlayersAddXLifeAction;
    this.shuffleTargetGraveyardIntoLibraryAction = shuffleTargetGraveyardIntoLibraryAction;
    this.selectedPermanentsGetXUntilEndOfTurnAction = selectedPermanentsGetXUntilEndOfTurnAction;
    this.attachAction = attachAction;
  }

  public AbilityAction getAbilityAction(AbilityType abilityType) {
    if (abilityType == null) {
      return null;
    }

    switch (abilityType) {
      case DRAW_X_CARDS:
        return drawXCardsAction;
      case ADD_X_LIFE:
        return addXLifeAction;
      case EACH_PLAYERS_ADD_X_LIFE:
        return eachPlayersAddXLifeAction;
      case SHUFFLE_GRAVEYARD_INTO_LIBRARY_FOR_TARGET_PLAYER:
        return shuffleTargetGraveyardIntoLibraryAction;
      case THAT_TARGETS_GET:
        return thatTargetsGetAction;
      case SELECTED_PERMANENTS_GET:
        return selectedPermanentsGetXUntilEndOfTurnAction;
      case ENCHANTED_CREATURE_GETS:
      case EQUIPPED_CREATURE_GETS:
        return attachAction;
      default:
        return null;
    }
  }

}