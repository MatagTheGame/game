package integration.turn.action.leave;

import com.matag.game.cardinstance.CardInstance;
import com.matag.game.cardinstance.CardInstanceFactory;
import com.matag.cards.Cards;
import com.matag.game.status.GameStatus;
import com.matag.game.turn.action.leave.ReturnPermanentToHandService;
import integration.TestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = LeaveTestConfiguration.class)
public class ReturnPermanentToHandServiceTest {

  @Autowired
  private ReturnPermanentToHandService returnPermanentToHandService;

  @Autowired
  private CardInstanceFactory cardInstanceFactory;

  @Autowired
  private TestUtils testUtils;

  @Autowired
  private Cards cards;

  @Test
  public void testMarkReturnToHand() {
    // Given
    GameStatus gameStatus = testUtils.testGameStatus();
    CardInstance cardInstance = cardInstanceFactory.create(61, cards.get("Canopy Spider"), "player-name", "player-name");
    gameStatus.getPlayer1().getBattlefield().addCard(cardInstance);

    // When
    returnPermanentToHandService.markAsToBeReturnedToHand(gameStatus, 61);

    // Then
    assertThat(cardInstance.getModifiers().getModifiersUntilEndOfTurn().isToBeReturnedToHand()).isTrue();
  }

  @Test
  public void testReturnToHand() {
    // Given
    GameStatus gameStatus = testUtils.testGameStatus();
    CardInstance cardInstance = cardInstanceFactory.create(61, cards.get("Canopy Spider"), "player-name", "player-name");
    gameStatus.getPlayer1().getBattlefield().addCard(cardInstance);

    // When
    returnPermanentToHandService.returnPermanentToHand(gameStatus, 61);

    // Then
    assertThat(gameStatus.getPlayer1().getBattlefield().size()).isEqualTo(0);
    assertThat(gameStatus.getPlayer1().getHand().getCards()).contains(cardInstance);
  }
}