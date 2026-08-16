package util;

import java.io.IOException;
import java.util.logging.*;

public final class AppLogger {

    private static final Logger LOGGER =
            Logger.getLogger("StudentGradeManagementSystem");

    static {
        try {
            FileHandler fileHandler =
                    new FileHandler("student-grade-management.log", true);

            fileHandler.setFormatter(
                    new SimpleFormatter()
            );

            LOGGER.addHandler(fileHandler);

            LOGGER.setLevel(Level.INFO);

            LOGGER.setUseParentHandlers(false);

        } catch (IOException e) {
            System.err.println(
                    "Unable to initialize application logger."
            );
        }
    }

    private AppLogger() {
    }

    public static void info(String message) {
        LOGGER.info(message);
    }

    public static void warning(String message) {
        LOGGER.warning(message);
    }

    public static void error(String message) {
        LOGGER.severe(message);
    }
}