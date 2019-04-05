package lectures;


import java.util.Arrays;

import org.junit.Test;

public class Lecture9 {

    @Test
    public void reduce() throws Exception {
        Integer[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};

        int sum = Arrays.stream(integers).reduce((a, b) -> a + b).get();
        System.out.println(sum);
    }

}

