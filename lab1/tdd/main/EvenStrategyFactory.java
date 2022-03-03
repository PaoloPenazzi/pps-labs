package lab01.tdd;

public class EvenStrategyFactory implements AbstractStrategyFactory {

    @Override
    public SelectStrategy createStrategy() {
        return new SelectStrategy() {
            @Override
            public boolean apply(int element) {
                return (element % 2) == 0;
            }
        };
    }
}
