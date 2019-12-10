import agh.cs.position.MapDirection;
import agh.cs.position.Vector2d;
import org.junit.jupiter.api.Test;

import static agh.cs.position.MapDirection.*;
import static org.junit.jupiter.api.Assertions.*;


public class MapDirectionTest {
    @Test
    void rotation() {
        assertEquals(EAST.rotation(0), EAST);
        assertEquals(EAST.rotation(1), SOUTHEAST);
        assertEquals(EAST.rotation(2), SOUTH);
        assertEquals(EAST.rotation(3), SOUTHWEST);
        assertEquals(EAST.rotation(4), WEST);
        assertEquals(EAST.rotation(5), NORTHWEST);
        assertEquals(EAST.rotation(6), NORTH);
        assertEquals(EAST.rotation(7), NORTHEAST);
        assertThrows(IllegalArgumentException.class, () -> {
            EAST.rotation(-1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            EAST.rotation(8);
        });
    }

    @Test
    void toUnitVector(){
        assertEquals(NORTH.toUnitVector(), new Vector2d(0,1));
        assertEquals(NORTHEAST.toUnitVector(), new Vector2d(1,1));
        assertEquals(EAST.toUnitVector(), new Vector2d(1,0));
        assertEquals(SOUTHEAST.toUnitVector(), new Vector2d(1,-1));
        assertEquals(SOUTH.toUnitVector(), new Vector2d(0,-1));
        assertEquals(SOUTHWEST.toUnitVector(), new Vector2d(-1,-1));
        assertEquals(WEST.toUnitVector(), new Vector2d(-1,0));
        assertEquals(NORTHWEST.toUnitVector(), new Vector2d(-1,1));
    }

    @Test
    void getRandomDirection(){
        for (int i=0; i< 16; i++) {
            MapDirection direction = MapDirection.getRandomDirection();
            assertTrue(direction == NORTH || direction == NORTHEAST || direction == EAST || direction == SOUTHEAST || direction == SOUTH || direction == SOUTHWEST || direction == WEST || direction == NORTHWEST);
        }
    }
}
