package lectures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import beans.Car;
import com.google.common.base.Functions;
import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;

public class Lecture8 {

    @Test
    public void simpleGrouping() throws Exception {
        Map<String, List<Car>> carsByMaker =
                MockData.getCars().stream().collect(Collectors.groupingBy(Car::getMake));

        carsByMaker.forEach((maker, cars) -> {
            System.out.println(maker);
            cars.forEach(System.out::println);
        });
    }

    @Test
    public void groupingAndCounting() throws Exception {
        ArrayList<String> names = Lists
                .newArrayList(
                        "John",
                        "John",
                        "Mariam",
                        "Alex",
                        "Mohammado",
                        "Mohammado",
                        "Vincent",
                        "Alex",
                        "Alex"
                );

        Map<String, Long> counting = names
                .stream()
                .collect(Collectors.groupingBy(Functions.identity(), Collectors.counting()));

        counting.forEach((name, count) -> System.out.println(name + " " + count));

    }

}