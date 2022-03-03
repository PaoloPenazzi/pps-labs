package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private final List<Integer> circularList;
    private int index;

    public CircularListImpl() {
        this.circularList = new ArrayList<>();
        this.index = 0;
    }

    @Override
    public int size() {
        return this.circularList.size();
    }

    @Override
    public void add(int element) {
        this.circularList.add(element);
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public Optional<Integer> next() {
        if (!this.isEmpty()) {
            int currentIndex = this.index;
            increaseIndex();
            return Optional.of(this.circularList.get(currentIndex));
        } else {
            return Optional.empty();
        }
    }

    private void increaseIndex() {
        if (this.index == this.size()-1) {
            this.index = 0;
        }  else {
            this.index++;
        }
    }

    @Override
    public Optional<Integer> previous() {
        if(!this.isEmpty()) {
            int currentIndex = this.index;
            decreaseIndex();
            return Optional.of(this.circularList.get(currentIndex));
        } else {
            return Optional.empty();
        }
    }

    private void decreaseIndex() {
        if (this.index == 0) {
            this.index = this.size() - 1;
        } else {
            this.index--;
        }
    }

    @Override
    public void reset() {
        this.index = 0;
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        for(int i = 0; i < this.size(); i++) {
            if(strategy.apply(this.next().get())) {
                decreaseIndex();
                return Optional.ofNullable(this.circularList.get(this.index));
            }
        }
        return Optional.empty();
    }
}
