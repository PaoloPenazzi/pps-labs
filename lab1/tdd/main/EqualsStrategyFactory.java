package lab01.tdd;

public class EqualsStrategyFactory implements AbstractStrategyFactory{
    private final int targetValue;

    public EqualsStrategyFactory(int inputValue) {
        this.targetValue = inputValue;
    }

    @Override
    public SelectStrategy createStrategy() {
        return new SelectStrategy() {
            @Override
            public boolean apply(int inputValue) {
                return targetValue == inputValue;
            }
        };
    }
}
