package utils;

import java.io.File;

public class FileManager {
    private static String path;
    private static String logPath;

    public static String getPath() {
        return path;
    }

    public static String getLogPath() {
        return logPath;
    }

    public static void createDirectory(){
        path = "logs";
        File dirLogs = new File(path);
        if (!dirLogs.exists())
            dirLogs.mkdir();

        path += File.separator + "testLog" + LoggerUtil.getLogCounter();

        File dirLog = new File(path);
        if (!dirLog.exists())
            dirLog.mkdir();

        logPath = path + File.separator + "testLog.log";
        new File(logPath);
    }
}
