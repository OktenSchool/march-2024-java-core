package demo;

// here we can not extend AbstractJob as the class can be extended with ONE class
public class TyreChange extends AbstractRepair {

    @Override
    public void perform() {
        System.out.println("Tyre Change");
    }
}
