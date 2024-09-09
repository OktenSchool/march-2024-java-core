package demo;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Data
@Builder
public class University extends Building {

    private ArrayList<Student> students;

    private double area;

    public void delete() {
        // students should not be deleted
    }

    @Override
    public double getTotalArea() {
        return area;
    }
}
