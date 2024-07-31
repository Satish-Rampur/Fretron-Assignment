package Problem3_Kill_All_And_Return_Home;

import java.util.*;

public class CastlePathFinder {

    static class Coordinate {
        int x, y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // Method to find all paths
    public static List<String> findPaths(Coordinate start, List<Coordinate> soldiers) {
        List<String> paths = new ArrayList<>();
        findPathsRecursively(start, soldiers, new ArrayList<>(), paths, "Start");
        return paths;
    }

    // Recursive method to explore paths
    private static void findPathsRecursively(Coordinate current, List<Coordinate> soldiers, List<Coordinate> path, List<String> paths, String currentPath) {
        path.add(current);

        if (path.size() > 1 && current.equals(path.get(0))) { // Reached home
            paths.add(currentPath + ". Arrive");
            return;
        }

        for (Coordinate soldier : soldiers) {
            if (canKill(current, soldier)) {
                List<Coordinate> newPath = new ArrayList<>(path);
                List<Coordinate> remainingSoldiers = new ArrayList<>(soldiers);
                remainingSoldiers.remove(soldier);
                findPathsRecursively(soldier, remainingSoldiers, newPath, paths, currentPath + " Kill (" + soldier.x + "," + soldier.y + "). Turn Left");
            }
        }

        // Case for jumping over soldiers (this is just a placeholder for actual logic)
        Coordinate jumpDestination = findJumpDestination(current, soldiers);
        if (jumpDestination != null) {
            findPathsRecursively(jumpDestination, soldiers, new ArrayList<>(path), paths, currentPath + " Jump to (" + jumpDestination.x + "," + jumpDestination.y + ")");
        }
    }

    // Placeholder methods for checking if the castle can kill and finding a jump destination
    private static boolean canKill(Coordinate from, Coordinate to) {
        // Implement logic to check if the castle can kill the soldier at 'to' from 'from'
        return true; // Simplified for the example
    }

    private static Coordinate findJumpDestination(Coordinate from, List<Coordinate> soldiers) {
        // Implement logic to find a valid jump destination
        return null; // Simplified for the example
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Coordinate> soldiers = new ArrayList<>();

        System.out.println("Enter coordinates for soldiers:");
        for (int i = 0; i < 11; i++) {
            System.out.print("Soldier " + (i + 1) + ": ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            soldiers.add(new Coordinate(x, y));
        }

        System.out.print("Enter coordinates for your special castle: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        Coordinate start = new Coordinate(x, y);

        List<String> paths = findPaths(start, soldiers);
        System.out.println("Thanks. There are " + paths.size() + " unique paths for your 'special_castle'");
        for (int i = 0; i < paths.size(); i++) {
            System.out.println("Path " + (i + 1) + ":");
            System.out.println(paths.get(i));
        }
    }
}
