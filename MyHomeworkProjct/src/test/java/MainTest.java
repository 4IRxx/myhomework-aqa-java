import com.myaqa.Main;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    @Test
    public void testAddition() {
            int result = Main.add(6, 9);
            assertEquals(15, result, "Expected sum is incorrect");
        }
    }