package nl.tudelft.jpacman.level;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class levelTest {
    private Level level = mock(Level.class);

    @Test
    void testObservers(){
        level.updateObservers();
        verify(level).updateObservers();
    }
}
