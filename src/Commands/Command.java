package Commands;

public abstract class Command {
    public Object Entity;
    public Command() {
        this.Entity = Entity;
    }

    public abstract String getLabel();
    public abstract void execute();
}
