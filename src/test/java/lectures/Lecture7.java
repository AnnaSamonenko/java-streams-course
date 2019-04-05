package lectures;

import beans.Car;
import beans.Person;
import com.google.common.collect.ImmutableList;

import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import mockdata.MockData;
import org.junit.Test;

public class Lecture7 {

    @Test
    public void count() throws Exception {
        ImmutableList<Person> persons = MockData.getPeople();
        long amount = persons.stream().filter(p -> p.getGender().equalsIgnoreCase("Female")).count();
        System.out.println(amount);
    }

    @Test
    public void min() throws Exception {
        Double price = MockData
                .getCars()
                .stream()
                .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
                .mapToDouble(Car::getPrice)
                .min()
                .getAsDouble();

        System.out.println(price);
    }

    @Test
    public void max() throws Exception {
        Double price = MockData
                .getCars()
                .stream()
                .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
                .mapToDouble(Car::getPrice)
                .max()
                .getAsDouble();

        System.out.println(price);
    }


    @Test
    public void average() throws Exception {
        List<Car> cars = MockData.getCars();
        double res = cars.stream().mapToDouble(Car::getPrice).average().getAsDouble();
        System.out.println(res);
    }

    @Test
    public void sum() throws Exception {
        List<Car> cars = MockData.getCars();

        double res =  cars.stream().mapToDouble(Car::getPrice).sum();
        System.out.println(res);
        BigDecimal bigDecimal = BigDecimal.valueOf(res);
        System.out.println(bigDecimal);
    }

    @Test
    public void statistics() throws Exception {
        List<Car> cars = MockData.getCars();
        DoubleSummaryStatistics statistics = cars.stream()
                .mapToDouble(Car::getPrice)
                .summaryStatistics();
        System.out.println(statistics);
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getCount());
        System.out.println(statistics.getMax());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getSum());
    }

}