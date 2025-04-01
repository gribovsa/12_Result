package services;
/*todo
    В ПО Pet_registry класс не используется
    сделал в качестве примера для решения задания
 */
public class Counter implements AutoCloseable{
    private int counter;
    private boolean closed;

    public Counter() {
        counter = 0;
        closed = false;
    }

    public int getCounter() {
        return counter;
    }
    @Override
    public void close() throws Exception {
        closed = true;
        counter = 0;
    }

    public void add() {
        if (closed) {
            throw new RuntimeException("Счетчик вышел за пределы try_with_resources блока");
        }
        counter++;
    }
}
