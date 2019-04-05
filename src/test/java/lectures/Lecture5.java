package lectures;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {

    @Test
    public void understandingFilter() throws Exception {
        ImmutableList<Car> cars = MockData.getCars();
        Predicate<Car> predicate = car -> car.getPrice() < 10000;

        List cheapCars = cars.stream()
                .filter(predicate)
                .collect(Collectors.toList());
        cars.forEach(System.out::println);
    }

    @Test
    public void ourFirstMapping() throws Exception {
        // transform from one data type to another
        List<Person> peoples = MockData.getPeople();
        List<PersonDTO> personDTO = peoples
                .stream()
                //.map(person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge()))
                .map(PersonDTO::map)
                .collect(Collectors.toList());

        personDTO.forEach(System.out::println);
    }

    @Test
    public void averageCarPrice() throws Exception {
        // calculate average of car prices
        List<Car> cars = MockData.getCars();
        OptionalDouble price = cars.stream().mapToDouble(Car::getPrice).average();
        System.out.println(price.getAsDouble());

    }

    @Test
    public void test() throws Exception {
        MockData.getCars().forEach(System.out::println);
    }

}



