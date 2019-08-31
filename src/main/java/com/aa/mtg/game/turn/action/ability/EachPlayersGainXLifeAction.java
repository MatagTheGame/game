package com.aa.mtg.game.turn.action.ability;

import com.aa.mtg.cards.CardInstance;
import com.aa.mtg.cards.ability.action.AbilityAction;
import com.aa.mtg.game.player.Player;
import com.aa.mtg.game.status.GameStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class EachPlayersGainXLifeAction implements AbilityAction {
    private static final Logger LOGGER = LoggerFactory.getLogger(EachPlayersGainXLifeAction.class);

    @Override
    public void perform(CardInstance cardInstance, GameStatus gameStatus, String parameter) {
        int lifeToGain = Integer.valueOf(parameter);

        Player currentPlayer = gameStatus.getCurrentPlayer();
        currentPlayer.increaseLife(lifeToGain);

        Player nonCurrentPlayer = gameStatus.getNonCurrentPlayer();
        nonCurrentPlayer.increaseLife(lifeToGain);

        LOGGER.info("Each players gain {} life.", lifeToGain);
    }
}