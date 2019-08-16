package com.aa.mtg.game.turn.action;

import com.aa.mtg.cards.CardInstance;
import com.aa.mtg.game.status.GameStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TapTargetService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TapTargetService.class);

    public void tap(GameStatus gameStatus, int targetId) {
        CardInstance cardToTap = gameStatus.findCardByIdFromAnyBattlefield(targetId);
        if (cardToTap != null) {
            cardToTap.getModifiers().tap();
            LOGGER.info("{} tapped.", cardToTap.getIdAndName());

        } else {
            LOGGER.info("target {} is not anymore valid.", targetId);
        }
    }

    public void tapDoesNotUntapNextTurn(GameStatus gameStatus, int targetId) {
        tap(gameStatus, targetId);
        CardInstance cardToTap = gameStatus.findCardByIdFromAnyBattlefield(targetId);
        if (cardToTap != null) {
            cardToTap.getModifiers().doesNotUntapNextTurn();
            LOGGER.info("{} does not untap next turn.", cardToTap.getIdAndName());

        } else {
            LOGGER.info("target {} is not anymore valid.", targetId);
        }
    }
}