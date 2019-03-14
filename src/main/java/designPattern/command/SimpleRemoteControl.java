package designPattern.command;

/**
 * created by ran
 */
public class SimpleRemoteControl {
    Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    void pressButton() {
        command.execute();
    }
}
