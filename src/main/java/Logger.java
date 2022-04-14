import java.time.LocalDateTime;

public class Logger {
    private static Logger logger;
    protected int num = 1;

    private Logger() {
        logger = this;
    }

    public static Logger getInstance() {
        return logger == null ? new Logger() : logger;
    }

    public void log(String msg) {
        System.out.println("[" + LocalDateTime.now() + " " + num++ + "] " + msg);
    }
}