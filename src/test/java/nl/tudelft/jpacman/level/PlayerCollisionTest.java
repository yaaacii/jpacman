package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.board.Board;
import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.sprite.EmptySprite;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.extractProperty;
import static org.mockito.Mockito.*;

public class PlayerCollisionTest {
    private static final PacManSprites SPRITE_STORE = new PacManSprites();
    private PlayerFactory Factory = new PlayerFactory(SPRITE_STORE);
    private Player ThePlayer = Factory.createPacMan();
    private static final EmptySprite emptySprite = new EmptySprite();
    public Pellet ThePellet = new Pellet(1, emptySprite);
    private final PointCalculator pointCalc = mock(PointCalculator.class);
    public PlayerCollisions ThePlayerCollision = new PlayerCollisions(pointCalc);
    private Ghost TheGhost = mock(Ghost.class);
    @Test
    void testPlayerVPellet() {
        int beforeScore = ThePlayer.getScore();
        ThePlayerCollision.playerVersusPellet(ThePlayer, ThePellet);
//        verify(ThePellet, times(0)).leaveSquare();
        assertThat(ThePlayer.getScore() > beforeScore);
    }
    @Test
    void testPlayerVGhost() {
        ThePlayerCollision.playerVersusGhost(ThePlayer, TheGhost);
        assertThat(ThePlayer.isAlive()).isEqualTo(false);
//        verify(ThePlayer, times(0)).setKiller(any());
    }
}
