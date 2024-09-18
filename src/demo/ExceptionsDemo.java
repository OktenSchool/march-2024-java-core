package demo;

public class ExceptionsDemo {

    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = null;

        try {
            savePersonToFile("test.txt", person1);
        } catch (PersonNotValidException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Finally 1");
        }

        try {
            savePersonToFile(null, person1);
        } catch (PersonNotValidException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal argument: " + e.getMessage());
        } finally {
            System.out.println("Finally 2");
        }

        System.out.println("Program ended");
    }

    private static void savePersonToFile(String fileName, Person person) throws PersonNotValidException, IllegalArgumentException {
        if (fileName == null) {
            throw new IllegalArgumentException("File name cannot be null");
        }

        if (person == null) {
            throw new PersonNotValidException();
        }

        System.out.println("Saving person to file with name: " + fileName);
    }
}
