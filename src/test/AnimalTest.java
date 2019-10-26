import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab4.RectangularMap;
import org.junit.jupiter.api.Test;

import static agh.cs.lab2.MoveDirection.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {
    @Test
    void move(){
        RectangularMap map = new RectangularMap (4,4);
        map.place(new Animal (map));
        Animal dog=map.animals.get(0);
        dog.move(RIGHT);
        assertEquals( dog.toString(), "E" );
        assertEquals(dog.getPosition(), new Vector2d(2,2));
        dog.move(LEFT);
        assertEquals( dog.toString(), "N" );
        assertEquals(dog.getPosition(), new Vector2d(2,2));
        dog.move(FORWARD);
        assertEquals( dog.toString(), "N" );
        assertEquals(dog.getPosition(), new Vector2d(2,3));
        dog.move(BACKWARD);
        assertEquals( dog.toString(), "N" );
        assertEquals(dog.getPosition(), new Vector2d(2,2));
        for (int i=0; i<5; i++)
            dog.move(FORWARD);
        assertEquals(dog.toString(), "N" );
        assertEquals(dog.getPosition(), new Vector2d(2,4));
        for (int i=0; i<8; i++)
            dog.move(BACKWARD);
        assertEquals(dog.toString(), "N" );
        assertEquals(dog.getPosition(), new Vector2d(2,0));
    }
    @Test
    void tooString(){
        Animal dog = new Animal();
        assertEquals(dog.toString(), "N");
        dog.move(RIGHT);
        assertEquals(dog.toString(), "E");
    }
}
