package application.enter;

import static application.browser.BattlefieldHelper.FIRST_LINE;
import static application.browser.BattlefieldHelper.SECOND_LINE;
import static com.matag.game.turn.phases.combat.DeclareAttackersPhase.DA;
import static com.matag.game.turn.phases.main1.Main1Phase.M1;
import static com.matag.game.turn.phases.main2.Main2Phase.M2;
import static com.matag.player.PlayerType.OPPONENT;
import static com.matag.player.PlayerType.PLAYER;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.beans.factory.annotation.Autowired;

import com.matag.cards.Cards;
import com.matag.game.init.test.InitTestService;
import com.matag.game.status.GameStatus;

import application.AbstractApplicationTest;
import application.InitTestServiceDecorator;
import application.testcategory.Regression;

@Category(Regression.class)
public class CreatureEntersTheBattlefieldWithTargetAbilityTapDoesNotUntapTest extends AbstractApplicationTest {

  @Autowired
  private InitTestServiceDecorator initTestServiceDecorator;

  @Autowired
  private Cards cards;

  public void setupGame() {
    initTestServiceDecorator.setInitTestService(new CreatureEntersTheBattlefieldWithTargetAbilityTapDoesNotUntapTest.InitTestServiceForTest());
  }

  @Test
  public void creatureEntersTheBattlefieldWithTargetAbilityTapDoesNotUntapTest() {
    // When Playing Frost Lynx
    browser.player1().getBattlefieldHelper(PLAYER, FIRST_LINE).getCard(cards.get("Island"), 0).tap();
    browser.player1().getBattlefieldHelper(PLAYER, FIRST_LINE).getCard(cards.get("Island"), 1).tap();
    browser.player1().getBattlefieldHelper(PLAYER, FIRST_LINE).getCard(cards.get("Island"), 2).tap();
    browser.player1().getHandHelper(PLAYER).getFirstCard(cards.get("Frost Lynx")).click();
    browser.player2().getActionHelper().clickContinueAndExpectPhase(M1, PLAYER);

    // Player 1 cannot resolve without choosing a target if there are targets available
    browser.player1().getActionHelper().clickContinueAndExpectPhase(M1, PLAYER);
    int frostLynxId = browser.player1().getBattlefieldHelper(PLAYER, SECOND_LINE).getFirstCard(cards.get("Frost Lynx")).getCardIdNumeric();
    browser.player1().getMessageHelper().hasMessage("\"" + frostLynxId + " - Frost Lynx\" requires a valid target.");
    browser.player1().getMessageHelper().close();

    // Player 1 chooses a target
    browser.player1().getBattlefieldHelper(OPPONENT, SECOND_LINE).getFirstCard(cards.get("Canopy Spider")).click();
    browser.player1().getBattlefieldHelper(OPPONENT, SECOND_LINE).getFirstCard(cards.get("Canopy Spider")).isTargeted();

    // Player 2 just continues
    browser.player2().getPhaseHelper().is(M1, PLAYER);
    browser.player2().getBattlefieldHelper(PLAYER, SECOND_LINE).getFirstCard(cards.get("Canopy Spider")).isTargeted();
    browser.player2().getActionHelper().clickContinueAndExpectPhase(M1, PLAYER);

    // Player 1 has priority again and target is tapped
    browser.player1().getBattlefieldHelper(OPPONENT, SECOND_LINE).getFirstCard(cards.get("Canopy Spider")).isTappedDoesNotUntapNextTurn();

    // Next turn target is still tapped
    browser.player1().getActionHelper().clickContinueAndExpectPhase(M2, PLAYER);
    browser.player1().getActionHelper().clickContinueAndExpectPhase(M1, OPPONENT);
    browser.player2().getBattlefieldHelper(PLAYER, SECOND_LINE).getFirstCard(cards.get("Canopy Spider")).isTapped();
    browser.player2().getHandHelper(PLAYER).contains(cards.get("Forest"));
    browser.player2().getActionHelper().clickContinueAndExpectPhase(M2, OPPONENT);
    browser.player2().getActionHelper().clickContinueAndExpectPhase(M1, PLAYER);

    // Next next turn target is still tapped
    browser.player2().getBattlefieldHelper(PLAYER, SECOND_LINE).getFirstCard(cards.get("Canopy Spider")).isTapped();
    browser.player1().getHandHelper(PLAYER).contains(cards.get("Island"));
    browser.player1().getActionHelper().clickContinueAndExpectPhase(DA, PLAYER);
    browser.player1().getActionHelper().clickContinueAndExpectPhase(M2, PLAYER);
    browser.player1().getActionHelper().clickContinueAndExpectPhase(M1, OPPONENT);

    // Next next next turn target is untapped
    browser.player2().getHandHelper(PLAYER).contains(cards.get("Forest"), cards.get("Forest"));
    browser.player2().getBattlefieldHelper(PLAYER, SECOND_LINE).getFirstCard(cards.get("Canopy Spider")).isNotTapped();
  }

  static class InitTestServiceForTest extends InitTestService {
    @Override
    public void initGameStatus(GameStatus gameStatus) {
      addCardToCurrentPlayerHand(gameStatus, cards.get("Frost Lynx"));
      addCardToCurrentPlayerBattlefield(gameStatus, cards.get("Island"));
      addCardToCurrentPlayerBattlefield(gameStatus, cards.get("Island"));
      addCardToCurrentPlayerBattlefield(gameStatus, cards.get("Island"));
      addCardToCurrentPlayerLibrary(gameStatus, cards.get("Island"));

      addCardToNonCurrentPlayerBattlefield(gameStatus, cards.get("Canopy Spider"));
      addCardToNonCurrentPlayerLibrary(gameStatus, cards.get("Forest"));
      addCardToNonCurrentPlayerLibrary(gameStatus, cards.get("Forest"));
    }
  }
}
