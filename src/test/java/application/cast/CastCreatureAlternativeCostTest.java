package application.cast;

import application.AbstractApplicationTest;
import application.InitTestServiceDecorator;
import com.aa.mtg.MtgApplication;
import com.aa.mtg.game.init.test.InitTestService;
import com.aa.mtg.game.status.GameStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static application.browser.BattlefieldHelper.FIRST_LINE;
import static com.aa.mtg.cards.Cards.MOUNTAIN;
import static com.aa.mtg.cards.properties.Color.BLUE;
import static com.aa.mtg.cards.properties.Color.RED;
import static com.aa.mtg.cards.properties.Color.WHITE;
import static com.aa.mtg.cards.sets.Ixalan.HEADWATER_SENTRIES;
import static com.aa.mtg.cards.sets.RavnicaAllegiance.AZORIUS_GUILDGATE;
import static com.aa.mtg.game.player.PlayerType.PLAYER;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MtgApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import({CastCreatureAlternativeCostTest.InitGameTestConfiguration.class})
public class CastCreatureAlternativeCostTest extends AbstractApplicationTest {

    @Autowired
    private InitTestServiceDecorator initTestServiceDecorator;

    public void setupGame() {
        initTestServiceDecorator.setInitTestService(new CastCreatureAlternativeCostTest.InitTestServiceForTest());
    }

    @Test
    public void castCreatureAlternativeCost() {
        // When click on creature without paying the cost
        browser.player1().getHandHelper(PLAYER).getFirstCard(HEADWATER_SENTRIES).click();

        // Then stack is still empty
        browser.player1().getStackHelper().toHaveSize(0);

        // When clicking the dual landÎ
        browser.player1().getBattlefieldHelper(PLAYER, FIRST_LINE).getFirstCard(AZORIUS_GUILDGATE).click();

        // Then it's possible to chose which mana generate
        browser.player1().getPlayableAbilitiesHelper().toHaveAbilities(asList("TAP: add WHITE", "TAP: add BLUE"));

        // When clicking on the WHITE
        browser.player1().getPlayableAbilitiesHelper().playAbility(0);

        // Then WHITE mana is generated
        browser.player1().getBattlefieldHelper(PLAYER, FIRST_LINE).getFirstCard(AZORIUS_GUILDGATE).isFrontendTapped();
        browser.player1().getPlayerActiveManaHelper().toHaveMana(singletonList(WHITE));

        // When clicking on other lands and try to play the creature
        browser.player1().getBattlefieldHelper(PLAYER, FIRST_LINE).getCard(MOUNTAIN, 0).click();
        browser.player1().getBattlefieldHelper(PLAYER, FIRST_LINE).getCard(MOUNTAIN, 1).click();
        browser.player1().getBattlefieldHelper(PLAYER, FIRST_LINE).getCard(MOUNTAIN, 2).click();
        browser.player1().getHandHelper(PLAYER).getFirstCard(HEADWATER_SENTRIES).click();

        // Then the creature is not played
        browser.player1().getHandHelper(PLAYER).contains(HEADWATER_SENTRIES);

        // When clicking the dual land
        browser.player1().getBattlefieldHelper(PLAYER, FIRST_LINE).getFirstCard(AZORIUS_GUILDGATE).click();

        // The dual land gets untapped
        browser.player1().getBattlefieldHelper(PLAYER, FIRST_LINE).getFirstCard(AZORIUS_GUILDGATE).isNotFrontendTapped();
        browser.player1().getPlayerActiveManaHelper().toHaveMana(asList(RED, RED, RED));

        // When clicking the dual land for BLUE
        browser.player1().getBattlefieldHelper(PLAYER, FIRST_LINE).getFirstCard(AZORIUS_GUILDGATE).click();
        browser.player1().getPlayableAbilitiesHelper().playAbility(1);

        // Then BLUE mana is generated
        browser.player1().getBattlefieldHelper(PLAYER, FIRST_LINE).getFirstCard(AZORIUS_GUILDGATE).isFrontendTapped();
        browser.player1().getPlayerActiveManaHelper().toHaveMana(asList(BLUE, RED, RED, RED));

        // When clicking on the creature
        browser.player1().getHandHelper(PLAYER).getFirstCard(HEADWATER_SENTRIES).click();

        // creature is now played
        browser.player1().getStackHelper().contains(HEADWATER_SENTRIES);
    }

    static class InitTestServiceForTest extends InitTestService {
        @Override
        public void initGameStatus(GameStatus gameStatus) {
            addCardToCurrentPlayerHand(gameStatus, HEADWATER_SENTRIES);
            addCardToCurrentPlayerBattlefield(gameStatus, AZORIUS_GUILDGATE);
            addCardToCurrentPlayerBattlefield(gameStatus, MOUNTAIN);
            addCardToCurrentPlayerBattlefield(gameStatus, MOUNTAIN);
            addCardToCurrentPlayerBattlefield(gameStatus, MOUNTAIN);
        }
    }
}