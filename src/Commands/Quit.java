package Commands;

public class Quit extends Command {
    @Override
    public String getLabel() {
        return "Quitter";
    }

    @Override
    public void execute() {
        System.out.println("Au revoir !");
        System.exit(0);
    }
}
