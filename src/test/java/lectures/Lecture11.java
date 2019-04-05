package lectures;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class Lecture11 {

    @Test
    public void joiningStrings() throws Exception {
        List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
        StringBuilder string = new StringBuilder();
        names.forEach(str -> string.append(str + ", "));
        System.out.println(string.substring(0, string.length() - 2));


    }

    @Test
    public void joiningStringsWithStream() throws Exception {
        List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");

        String res = names
                .stream()
                .collect(Collectors.joining(", "));

        System.out.println(res);
    }
}
