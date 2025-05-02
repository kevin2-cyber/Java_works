package com.digerati.upmap.algorithms;

import com.digerati.upmap.graph.Edge;
import com.digerati.upmap.graph.Graph;
import com.digerati.upmap.graph.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.util.Arrays.stream;

public class VogelsApproximationMethod {

    final static int[] demand = {1, 1, 1, 1, 1};
    final static int[] supply = {1, 1, 1, 1};
    final static int[][] costs = {{16, 16, 13, 22, 17}, {14, 14, 13, 19, 15},
            {19, 19, 20, 23, 50}, {50, 12, 50, 15, 11}};

    final static ArrayList<ArrayList<Double>> graphCosts = new ArrayList<>();

    final static int nRows = supply.length;
    final static int nCols = demand.length;

    static boolean[] rowDone = new boolean[nRows];
    static boolean[] colDone = new boolean[nCols];
    static int[][] result = new int[nRows][nCols];

    static ExecutorService es = Executors.newFixedThreadPool(2);

    public static int getTotalCost(Graph graph, Node source, Node destination){
        ArrayList<Node> nodes = (ArrayList<Node>) graph.getNodes();
        for (int i = 0; i < graph.getNodeSize(); i++) {
            ArrayList<Double> cost = new ArrayList<>();
            for (int j = 0; j < graph.getNodeSize(); j++) {
                Edge edge = graph.getEdge(nodes.get(i), nodes.get(j));
                cost.add(edge.getDistance());
            }
            graphCosts.add(cost);
        }

        int supplyLeft = stream(supply).sum();
        int totalCost = 0;

        while (supplyLeft > 0){
            int[] cell = nextCell();
            int r = cell[0];
            int c = cell[1];

            int quantity = Math.min(demand[c], supply[r]);
            demand[c] -= quantity;
            if (demand[c] == 0)
                colDone[c] = true;

            supply[r] -= quantity;
            if (supply[r] == 0)
                rowDone[r] = true;

            result[r][c] = quantity;
            supplyLeft -= quantity;

            // totalCost += quantity * costs[r][c];
            totalCost += quantity * graphCosts.get(r).get(c);
        }

        stream(result).forEach(a -> System.out.println(Arrays.toString(a)));
        es.shutdown();
        return totalCost;
    }

    static int[] nextCell(){
        Future<int[]> f1 = es.submit(() -> maxPenalty(nRows, nCols, true));
        Future<int[]> f2 = es.submit(() -> maxPenalty(nCols, nRows, false));

        int[] res1;
        int[] res2;
        try{
            res1 = f1.get();
            res2 = f2.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return new int[]{-1};
        }

        if (res1[3] == res2[3])
            return res1[2] < res2[2] ? res1 : res2;

        return (res1[3] > res2[3]) ? res2 : res1;
    }

    static int[] diff(int j, int len, boolean isRow){
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int minP = -1;
        for (int i = 0; i < len; i++) {
            if (isRow ? colDone[i] :rowDone[1] )
                continue;
            int c = isRow ? costs[j][i] : costs[i][j];
            if (c < min1) {
                min2 = min1;
                min1 = c;
                minP = i;
            } else if (c < min2) {
                min2 = c;
            }
        }
        return new int[]{min2 - min1, min1, minP};
    }

    static int[] maxPenalty(int len1, int len2, boolean isRow){
        int md = Integer.MIN_VALUE;
        int pc = -1, pm = -1, mc = -1;
        for (int i = 0; i < len1; i++) {
            if (isRow ? rowDone[i] : colDone[i])
                continue;
            int[] res = diff(i, len2, isRow);
            if (res[0] > md) {
                md = res[0]; // max diff
                pm = i;      // pos of max diff
                mc = res[1]; // min cost
                pc = res[2]; // pos of min cost
            }
        }
        return isRow ? new int[]{pm, pc, mc, md} : new int[]{pc, pm, mc, md};
    }
}
