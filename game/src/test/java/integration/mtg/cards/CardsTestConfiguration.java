package integration.mtg.cards;

import com.aa.mtg.cards.CardsConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CardsConfiguration.class)
public class CardsTestConfiguration {

}