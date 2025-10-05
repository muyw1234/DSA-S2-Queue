
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;   // Reemplaza @Before
import org.junit.jupiter.api.Test;         // Para @Test
import static org.junit.jupiter.api.Assertions.*; // assertEquals, assertTrue, etc.

public class QueueImpltest {
    Queue<String> q;

    @BeforeEach
    public void before() throws FullQueueException {
        this.q = new QueueImpl<String>(5);
        this.q.push("1");
        this.q.push("2");
        this.q.push("3");
    }

    @AfterEach
    public void after(){
        this.q = null;
    }
    @Test
    public void testPush() throws FullQueueException {
        Assertions.assertEquals(3, this.q.size());
        this.q.push("4");
        Assertions.assertEquals(4, this.q.size());
    }
    @Test
    public void testPop() throws EmptyQueueException {
        Assertions.assertEquals("1",this.q.pop());
    }

    @Test
    public void testFull() throws FullQueueException {
        this.q.push("4");
        this.q.push("5");
        Assertions.assertThrows(FullQueueException.class, () ->
                this.q.push("6"));
        Assertions.assertEquals(5, this.q.size());
    }

    @Test
    public void testEmpty() throws EmptyQueueException {
        this.q.pop();
        Assertions.assertEquals(2, this.q.size());
        this.q.pop();
        Assertions.assertEquals(1, this.q.size());
        this.q.pop();
        Assertions.assertEquals(0, this.q.size());
        Assertions.assertThrows(EmptyQueueException.class, () ->
                this.q.pop());
    }
}
