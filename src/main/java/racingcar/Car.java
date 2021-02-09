package racingcar;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private static final int CONDITION = 4;

    private final CarName carName;

    private int position = 0;

    public Car(CarName carName) {
        this.carName = carName;
    }

    public void moveForwardByRandomNumber(int randomNumber) {
        if (randomNumber >= CONDITION) {
            position += 1;
        }
    }

    public boolean isMaxPosition(int maxDistance) {
        return this.position == maxDistance;
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName.getCarName();
    }

    @Override
    public int compareTo(Car o) {
        return o.getPosition() - this.getPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }

    //todo : toString은 개발자가 보는 용도도
    @Override
    public String toString() {
        StringBuilder positionBar = new StringBuilder();
        for (int i = 0; i < this.position; i++) {
            positionBar.append("-");
        }
        return this.carName.getCarName() + " : " + positionBar;
    }
}
