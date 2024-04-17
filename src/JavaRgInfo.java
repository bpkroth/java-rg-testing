// a simple main java class that prints some system info like the number of
// processes detected and the number of threads running and then sleeps for a while
// and repeats

import java.util.InputMismatchException;

public class JavaRgInfo {
    public static void main(String[] args) {
        int sleepSeconds = 5;
	int count = 10;
        if (args.length >= 1) {
            sleepSeconds = Integer.parseInt(args[0].trim());
	}
        if (args.length >= 2) {
            count = Integer.parseInt(args[1].trim());
	}
        if (args.length > 2) {
            throw new InputMismatchException("Too many args: " + String.join(" ", args));
        }

	for (int i = 0; i < count; i++) {
            System.out.println("Current time: " + System.currentTimeMillis() / 1000);
            // Get number of available processors
            int processors = Runtime.getRuntime().availableProcessors();
            System.out.println("Number of available processors: " + processors);

            // Get number of JVM threads running
            int threads = Thread.getAllStackTraces().keySet().size();
            System.out.println("Number of JVM threads running: " + threads);

            // Sleep
            try {
                Thread.sleep(sleepSeconds * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
