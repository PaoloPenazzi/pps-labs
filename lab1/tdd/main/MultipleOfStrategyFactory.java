package lab01.tdd;

public class MultipleOfStrategyFactory implements AbstractStrategyFactory {
    private final int dividend;

    public MultipleOfStrategyFactory(int dividend) {
        this.dividend = dividend;
    }

    @Override
    public SelectStrategy createStrategy() {
        return new SelectStrategy() {
            @Override
            public boolean apply(int element) {
                return (element % dividend) == 0;
            }
        };
    }
}
