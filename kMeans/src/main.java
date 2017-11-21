import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int k;
        double threshold;
        ArrayList<data> list = new ArrayList<data>();

        kMeans kMeans;

        System.out.print("Jumlah Cluster : ");
        k = input.nextInt();

        System.out.print("Jumlah Threshold : ");
        threshold = input.nextDouble();

        list.add(new data(-8.109, 112.917, 311, 73));
        list.add(new data(-2.584, 121.378, 310.5, 71));
        list.add(new data(0.107, 117.471, 311.3, 74));
        list.add(new data(-8.346, 147.832, 334.4, 86));
        list.add(new data(-8.348, 147.822, 311.6, 50));
        list.add(new data(-2.566, 101.254, 323.5, 77));
        list.add(new data(0.107, 117.473, 313, 81));
        list.add(new data(-8.106, 112.927, 312.1, 78));
        list.add(new data(4.019, 117.308, 325.6, 79));
        list.add(new data(2.817, 113.299, 318.4, 45));
        list.add(new data(2.817, 113.293, 317.9, 37));
        list.add(new data(2.793, 112.135, 335.1, 87));
        list.add(new data(2.783, 112.144, 318.7, 70));
        list.add(new data(2.701, 112.136, 330, 63));
        list.add(new data(0.58, 101.981, 311.3, 35));
        list.add(new data(-7.589, 138.561, 314.1, 60));
        list.add(new data(-8.254, 113.37, 310.8, 43));
        list.add(new data(-2.394, 110.703, 326.3, 79));
        list.add(new data(-2.39, 110.708, 318.5, 70));
        list.add(new data(-2.391, 110.697, 317.4, 65));
        list.add(new data(2.689, 113.127, 314.2, 40));
        list.add(new data(3.836, 113.566, 325.6, 68));
        list.add(new data(-4.203, 122.195, 314.4, 57));
        list.add(new data(3.009, 101.374, 315.7, 0));
        list.add(new data(-1.038, 123.29, 316.5, 57));
        list.add(new data(-0.798, 123.108, 312.1, 52));
        list.add(new data(-9.398, 119.737, 323.8, 40));
        list.add(new data(-8.112, 118.079, 319.8, 0));
        list.add(new data(-8.113, 118.07, 319.8, 51));
        list.add(new data(-6.579, 146.219, 315.5, 54));
        list.add(new data(-2.58, 121.389, 310.7, 39));
        list.add(new data(0.568, 102.16, 312.5, 51));
        list.add(new data(0.275, 102.341, 315.7, 52));
        list.add(new data(-2.517, 104.245, 323.6, 77));
        list.add(new data(-3.693, 104.396, 317, 40));
        list.add(new data(-3.721, 104.375, 350.3, 95));
        list.add(new data(-3.722, 104.386, 321.2, 65));
        list.add(new data(-3.532, 127.947, 317.2, 51));
        list.add(new data(-3.534, 127.938, 321, 56));
        list.add(new data(-4.546, 104.317, 312.6, 55));
        list.add(new data(-4.547, 104.307, 312.7, 55));
        list.add(new data(-3.719, 104.38, 318.9, 53));
        list.add(new data(-3.594, 104.28, 311, 31));
        list.add(new data(-3.481, 103.471, 315.4, 60));
        list.add(new data(-2.817, 103.541, 315.6, 44));
        list.add(new data(-1.396, 102.544, 310.2, 24));
        list.add(new data(0.553, 102.297, 317, 41));
        list.add(new data(13.353, 120.572, 314.4, 61));
        list.add(new data(10.365, 123.033, 312.3, 51));

        kMeans = new kMeans(list, k, threshold);

        kMeans.doClustering(list, k, threshold);
    }
}