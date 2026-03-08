import java.util.*;

/*
 * ProjectMain.java
 * Option A: Cafeteria Line Manager
 *
 * Single-file Java program using:
 * - ArrayDeque for the cafeteria line
 * - HashMap for storing arrival times
 *
 * Commands:
 * HELP
 * ARRIVE <name>
 * VIP_ARRIVE <name>
 * SERVE
 * LEAVE <name>
 * PEEK
 * SIZE
 * PRINT
 * TICK <minutes>
 * STATS
 * EXIT
 */

public class ProjectMain {

    // Queue of students in line
    static ArrayDeque<String> line = new ArrayDeque<>();

    // Stores each student's arrival time
    static HashMap<String, Integer> arrivalTime = new HashMap<>();

    // Simulated current time in minutes
    static int currentTime = 0;

    // Statistics
    static int servedCount = 0;
    static int totalWait = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printHelp();

        while (true) {
            System.out.print("\n> ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                continue;
            }

            String[] parts = input.split("\\s+");
            String command = parts[0].toUpperCase();

            switch (command) {
                case "HELP":
                    printHelp();
                    break;

                case "ARRIVE":
                    arrive(parts);
                    break;

                case "VIP_ARRIVE":
                    vipArrive(parts);
                    break;

                case "SERVE":
                    serve();
                    break;

                case "LEAVE":
                    leave(parts);
                    break;

                case "PEEK":
                    peek();
                    break;

                case "SIZE":
                    size();
                    break;

                case "PRINT":
                    printLine();
                    break;

                case "TICK":
                    tick(parts);
                    break;

                case "STATS":
                    stats();
                    break;

                case "EXIT":
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Unknown command. Type HELP to see the list of commands.");
            }
        }
    }

    // Prints all available commands
    static void printHelp() {
        System.out.println("=== Cafeteria Line Manager ===");
        System.out.println("Commands:");
        System.out.println("HELP");
        System.out.println("ARRIVE <name>");
        System.out.println("VIP_ARRIVE <name>");
        System.out.println("SERVE");
        System.out.println("LEAVE <name>");
        System.out.println("PEEK");
        System.out.println("SIZE");
        System.out.println("PRINT");
        System.out.println("TICK <minutes>");
        System.out.println("STATS");
        System.out.println("EXIT");
    }

    // Regular student joins the back of the line
    static void arrive(String[] parts) {
        if (parts.length < 2) {
            System.out.println("Usage: ARRIVE <name>");
            return;
        }

        String name = parts[1];

        if (!isValidName(name)) {
            System.out.println("Invalid name. Use a single word without spaces.");
            return;
        }

        if (arrivalTime.containsKey(name)) {
            System.out.println("This student is already in the system.");
            return;
        }

        line.addLast(name);
        arrivalTime.put(name, currentTime);

        System.out.println(name + " joined the back of the line at time " + currentTime + ".");
        System.out.println("Current line size: " + line.size());
    }

    // VIP student joins the front of the line
    static void vipArrive(String[] parts) {
        if (parts.length < 2) {
            System.out.println("Usage: VIP_ARRIVE <name>");
            return;
        }

        String name = parts[1];

        if (!isValidName(name)) {
            System.out.println("Invalid name. Use a single word without spaces.");
            return;
        }

        if (arrivalTime.containsKey(name)) {
            System.out.println("This student is already in the system.");
            return;
        }

        line.addFirst(name);
        arrivalTime.put(name, currentTime);

        System.out.println("VIP " + name + " joined the front of the line at time " + currentTime + ".");
        System.out.println("Current line size: " + line.size());
    }

    // Serves the student at the front
    static void serve() {
        if (line.isEmpty()) {
            System.out.println("No one is waiting in line.");
            return;
        }

        String name = line.removeFirst();
        int waitedMinutes = currentTime - arrivalTime.get(name);

        servedCount++;
        totalWait += waitedMinutes;

        arrivalTime.remove(name);

        System.out.println("Served: " + name);
        System.out.println("Wait time: " + waitedMinutes + " minute(s).");
        System.out.println("Current line size: " + line.size());
    }

    // Removes a specific student from the line
    static void leave(String[] parts) {
        if (parts.length < 2) {
            System.out.println("Usage: LEAVE <name>");
            return;
        }

        String name = parts[1];

        if (!arrivalTime.containsKey(name)) {
            System.out.println("Student not found in the line.");
            return;
        }

        boolean removed = line.removeFirstOccurrence(name);

        if (removed) {
            arrivalTime.remove(name);
            System.out.println(name + " left the line voluntarily.");
            System.out.println("Current line size: " + line.size());
        } else {
            System.out.println("Student not found in the line.");
        }
    }

    // Shows who is next
    static void peek() {
        if (line.isEmpty()) {
            System.out.println("The line is empty.");
            return;
        }

        System.out.println("Next student to be served: " + line.peekFirst());
    }

    // Prints current line size
    static void size() {
        System.out.println("Current line size: " + line.size());
    }

    // Prints the whole line
    static void printLine() {
        if (line.isEmpty()) {
            System.out.println("The line is empty.");
            return;
        }

        System.out.println("Line (front -> back): " + line);
    }

    // Advances simulated time
    static void tick(String[] parts) {
        if (parts.length < 2) {
            System.out.println("Usage: TICK <minutes>");
            return;
        }

        try {
            int minutes = Integer.parseInt(parts[1]);

            if (minutes < 0) {
                System.out.println("Minutes must be 0 or greater.");
                return;
            }

            currentTime += minutes;
            System.out.println("Time advanced by " + minutes + " minute(s).");
            System.out.println("Current time: " + currentTime);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number of minutes.");
        }
    }

    // Shows service statistics
    static void stats() {
        double averageWait = 0.0;

        if (servedCount > 0) {
            averageWait = (double) totalWait / servedCount;
        }

        System.out.println("=== Statistics ===");
        System.out.println("Students served: " + servedCount);
        System.out.println("Total waiting time: " + totalWait + " minute(s)");
        System.out.printf("Average waiting time: %.2f minute(s)%n", averageWait);
        System.out.println("Students currently in line: " + line.size());
    }

    // Validates student name
    static boolean isValidName(String name) {
        return name != null && !name.isEmpty() && !name.contains(" ");
    }
}