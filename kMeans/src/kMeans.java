import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class kMeans {

    Scanner input = new Scanner(System.in);

    int[] centroidTotal;
    double[][] clusterMemberCount;
    double[][] centroidTable;
    double[][] euclidanTable;
    double[] oldF;
    double[] temp, newF;
    double temp1, temp2, temp3, temp4, fLama, fBaru;
    int count = 0;
    boolean done = false;

    kMeans(ArrayList<data> list, int k, double threshold) {
        centroidTotal = new int[k];
        centroidTable = new double[k][4];
        clusterMemberCount = new double[k][4];
        euclidanTable = new double[list.size()][k];
        temp = new double[k];
        oldF = new double[k];
        newF = new double[k];

        //Melakukan penentuan anggota cluster secara random
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setCluster(ThreadLocalRandom.current().nextInt(1, k + 1));
        }
    }

    public void doClustering(ArrayList<data> list, int k, double threshold) {
        while (done != true) {
            System.out.println("\nLatitude\tLongitude\tBrightness\tConfidence\tCluster");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(
                        list.get(i).getLatitude() + "\t\t" +
                                list.get(i).getLongitude() + "\t\t" +
                                list.get(i).getBrightness() + "\t\t" +
                                list.get(i).getConfidence() + "\t\t\t" +
                                list.get(i).getCluster()
                );

                //Menghitung jumlah anggota dari masing-masing cluster
                centroidTotal[list.get(i).getCluster() - 1]++;

                //Menjumlahkan anggota setiap cluster
                clusterMemberCount[list.get(i).getCluster() - 1][0] += list.get(i).getLatitude();
                clusterMemberCount[list.get(i).getCluster() - 1][1] += list.get(i).getLongitude();
                clusterMemberCount[list.get(i).getCluster() - 1][2] += list.get(i).getBrightness();
                clusterMemberCount[list.get(i).getCluster() - 1][3] += list.get(i).getConfidence();
            }

            System.out.println("\nCentroid 1\tCentroid 2\tCentroid 3\tCentroid 4");

            //Menghitung rata-rata setiap cluster
            for (int i = 0; i < centroidTable.length; i++) {
                centroidTable[i][0] = clusterMemberCount[i][0] / centroidTotal[i];
                centroidTable[i][1] = clusterMemberCount[i][1] / centroidTotal[i];
                centroidTable[i][2] = clusterMemberCount[i][2] / centroidTotal[i];
                centroidTable[i][3] = clusterMemberCount[i][3] / centroidTotal[i];
                temp1 = Math.round(centroidTable[i][0] * 1000);
                temp1 = temp1 / 1000;
                temp2 = Math.round(centroidTable[i][1] * 1000);
                temp2 = temp2 / 1000;
                temp3 = Math.round(centroidTable[i][2] * 1000);
                temp3 = temp3 / 1000;
                temp4 = Math.round(centroidTable[i][3] * 1000);
                temp4 = temp4 / 1000;

                System.out.println(temp1 + "\t\t" + temp2 + "\t\t" + temp3 + "\t\t" + temp4);
            }

            System.out.println();

            for (int i = 0; i < k; i++) {
                System.out.print("Distance to " + (i + 1) + "\t");
            }

            System.out.println("Old Cluster" + "\t" + "New Cluster");

            //Mencari jarak euclidan
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < k; j++) {
                    euclidanTable[i][j] =
                            Math.sqrt(
                                    Math.pow((list.get(i).getLatitude() - centroidTable[j][0]), 2) +
                                            Math.pow((list.get(i).getLongitude() - centroidTable[j][1]), 2) +
                                            Math.pow((list.get(i).getBrightness() - centroidTable[j][2]), 2) +
                                            Math.pow((list.get(i).getConfidence() - centroidTable[j][3]), 2)
                            );

                    temp1 = Math.round(euclidanTable[i][j] * 10000000);
                    temp1 = temp1 / 10000000;
                    System.out.print(temp1 + "\t\t");
                    newF[list.get(i).getCluster() - 1] += euclidanTable[i][j];
                }
                System.out.print(list.get(i).getCluster() + "\t\t\t");
                list.get(i).setCluster(checkMin(i, k));
                System.out.println(list.get(i).getCluster());
            }

            System.out.println();

            //Menghitung Threshold
            for (int i = 0; i < k; i++) {
                if (i + 1 != k) {
                    System.out.print(newF[i] + " + ");
                } else {
                    System.out.print(newF[i] + " = ");
                }
            }

            for (int i = 0; i < k; i++) {
                fLama += oldF[i];
                fBaru += newF[i];
                oldF[i] = newF[i];
                newF[i] = 0;
            }

            System.out.println(fBaru);
            System.out.println("|F Baru - F Lama | = " + fBaru + " - " + fLama + " = " + (fBaru - fLama));

            fBaru = Math.abs(fBaru - fLama);

            if (fBaru < threshold) {
                done = true;
                System.out.println("\nProses Klasterisasi Selesai Dalam " + count + "x Iterasi :)");
            } else {
                done = false;
                fLama = fBaru;
                count++;
                System.out.println("\n=========================Iterasi ke-" + count + "=========================");
            }
        }

    }

    public int checkMin(int index, int cluster) {
        for (int i = 0; i < cluster; i++) {
            temp[i] = euclidanTable[index][i];
        }

        int newCluster = 0;
        double min = temp[0];

        for (int i = 0; i < cluster - 1; i++) {
            for (int j = i + 1; j < cluster; j++) {
                if (temp[i] > temp[j]) {
                    if (temp[j] < min) {
                        newCluster = j;
                        min = temp[j];
                    }
                }
            }
        }
        return newCluster + 1;
    }
}