package Problem2My_Money_My_Shares;

import java.util.*;

public class DistributeApples {
    static class Apple {
        int weight;

        public Apple(int weight) {
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Apple> apples = new ArrayList<>();
        System.out.println("Enter apple weight in grams (-1 to stop):");
        while (true) {
            int weight = scanner.nextInt();
            if (weight == -1) {
                break;
            }
            apples.add(new Apple(weight));
        }

        int totalWeight = 0;
        for (Apple apple : apples) {
            totalWeight += apple.weight;
        }

        int ramShare = (int) Math.round((50.0 / 100) * totalWeight);
        int shamShare = (int) Math.round((30.0 / 100) * totalWeight);
        int rahimShare = totalWeight - ramShare - shamShare;

        List<Apple> ramApples = new ArrayList<>();
        List<Apple> shamApples = new ArrayList<>();
        List<Apple> rahimApples = new ArrayList<>();

        distributeApples(apples, ramApples, ramShare);
        distributeApples(apples, shamApples, shamShare);
        distributeApples(apples, rahimApples, rahimShare);

        System.out.println("Distribution Result:");
        System.out.print("Ram: ");
        for (Apple apple : ramApples) {
            System.out.print(apple.weight + " ");
        }
        System.out.println();
        System.out.print("Sham: ");
        for (Apple apple : shamApples) {
            System.out.print(apple.weight + " ");
        }
        System.out.println();
        System.out.print("Rahim: ");
        for (Apple apple : rahimApples) {
            System.out.print(apple.weight + " ");
        }
        System.out.println();
    }

    private static void distributeApples(List<Apple> apples, List<Apple> personApples, int share) {
        int remainingShare = share;
        for (Apple apple : apples) {
            if (apple.weight <= remainingShare) {
                personApples.add(apple);
                remainingShare -= apple.weight;
            }
            if (remainingShare == 0) {
                break;
            }
        }
    }
}