package lab6;

import tasks.Task;

public class UtilsTask implements Task {
    @Override
    public void run() {
        var utils = new ComputerUtils();
        utils.setSize(500, 500);
        utils.setLocation(200, 200);
        utils.setVisible(true);
    }
}
