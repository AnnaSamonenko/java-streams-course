package lectures;

import beans.Person;
import com.google.common.collect.ImmutableList;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;


public class Lecture1 {

    @Test
    public void imperativeApproach() throws IOException {
        List<Person> peoples = MockData.getPeople();
        List<Person> children = Lists.newArrayList();

        // 1. Find people aged less or equal 18
        // 2. Then change implementation to find first 10 people
        final int limit = 10;
        int counter = 0;

        for (Person person : peoples) {
            if (person.getAge() <= 18) {
                children.add(person);
                counter++;
                if (counter == limit)
                    break;
            }
        }

        for (Person person : children)
            System.out.println(person.getAge());
    }

    @Test
    public void declarativeApproachUsingStreams() throws Exception {
        ImmutableList<Person> peoples = MockData.getPeople();
        final int limit = 10;

        peoples.stream()
                .filter(p -> p.getAge() <= 18)
                .limit(limit)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

}
