package integration;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.matag.cards.Cards;
import com.matag.game.adminclient.AdminClient;
import com.matag.game.cardinstance.CardInstanceFactory;
import com.matag.game.player.PlayerFactory;
import com.matag.game.stack.SpellStack;
import com.matag.game.status.GameStatusFactory;
import com.matag.game.turn.Turn;

import integration.cardinstance.CardsTestConfiguration;
import integration.deck.DeckTestConfiguration;
import integration.player.PlayerTestConfiguration;
import integration.status.GameStatusTestConfiguration;

@Configuration
@Import({CardsTestConfiguration.class, GameStatusTestConfiguration.class, PlayerTestConfiguration.class, Turn.class, SpellStack.class, DeckTestConfiguration.class})
public class TestUtilsConfiguration {
  @Bean
  public TestUtils testUtils(GameStatusFactory gameStatusFactory, PlayerFactory playerFactory, CardInstanceFactory cardInstanceFactory, Cards cards) {
    return new TestUtils(gameStatusFactory, playerFactory, cardInstanceFactory, cards);
  }

  @Bean
  public AdminClient adminClient() {
    return Mockito.mock(AdminClient.class);
  }
}