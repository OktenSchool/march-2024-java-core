package demo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person extends Object {

    private String name;

    private int age;
}
