package hw12;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StringChangerServiceTest {

    @InjectMocks
    private StringChangerService stringChangerService;

    @Mock
    private StringLowerUpperService lowerUpperService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddStart() {
        // Arrange
        String start = "Hello";
        String input = "World";

        // Act
        String result = stringChangerService.addStart(start, input);

    }

    @Test
    public void testAddEnd() {

    }

    @Test
    public void testAddStartUpperInputLower() {

    }

    @Test
    public void testAddStartAndEnd() {

    }

    @Test
    public void testAddStartAndEndUpper() {

    }

    @Test
    public void testAddStartAndEndTotalLower() {

    }
}
