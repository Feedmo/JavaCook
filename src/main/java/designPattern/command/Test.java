package designPattern.command;

/**
 * created by ran
 */
public class Test {
    public static void main(String[] args) {
        SimpleRemoteControl rc = new SimpleRemoteControl();
        rc.setCommand(new LightOnCommand(new Light()));
        rc.pressButton();
    }
}
