import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class QuickSelect {



    public static void main(String[] args) throws IOException {

        String fileName = args[0];

        int n;
        ArrayList<Float> weights = new ArrayList<>();
        ArrayList<Integer> xs = new ArrayList<>();
        ArrayList<Integer> ys = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            n = Integer.parseInt(br.readLine());
            for(String line; (line = br.readLine()) != null; ) {
                String[] content = line.split("\\s+");
                weights.add(Float.parseFloat(content[0]));
                xs.add(Integer.parseInt(content[1]));
                ys.add(Integer.parseInt(content[2]));
            }
            // line is not visible here.
        }
        System.out.println(n);
        System.out.println(weights);
        System.out.println(xs);
        System.out.println(ys);
    }

    public static float[] partition(ArrayList<Float> weightList, ArrayList<Integer> xList, ArrayList<Integer> yList, int p, int r){
        int x = xList.get(r);
        int y = yList.get(r);
        int i = p - 1;
        float left = 0;
        float right = 0;
        float[] toReturn = new float[3];

        for (int j = p; j < r; j ++){
            if (compareTo(xList.get(j),yList.get(j),x,y) <= 0){  // is ok to = 0???
                left = left + weightList.get(j);
                i = i + 1;
                int xb = xList.get(j);
                int yb = yList.get(j);
                float wb = weightList.get(j);
                xList.set(j,xList.get(i));
                yList.set(j, yList.get(i));
                weightList.set(j, weightList.get(i));
                xList.set(i, xb);
                yList.set(i, yb);
                weightList.set(i, wb);
            }else {
                right = r + weightList.get(j);
            }
            int xb = xList.get(i + 1);
            int yb = yList.get(i + 1);
            float wb = weightList.get(i + 1);
            xList.set(i + 1,xList.get(r));
            yList.set(i + 1, yList.get(r));
            weightList.set(i + 1, weightList.get(r));
            xList.set(r, xb);
            yList.set(r, yb);
            weightList.set(r, wb);
        }
        toReturn[0] = i + 1;
        toReturn[1] = left;
        toReturn[2] = right;
        return toReturn;
    }

    public static float[] pivot(ArrayList<Float> weightList, ArrayList<Integer> xList, ArrayList<Integer> yList, int p, int r){
        Random random = new Random();
        int i = p + random.nextInt(r - p + 1);
        int xb = xList.get(r);
        int yb = yList.get(r);
        float wb = weightList.get(r);
        xList.set(r,xList.get(i));
        yList.set(r, yList.get(i));
        weightList.set(r, weightList.get(i));
        xList.set(i, xb);
        yList.set(i, yb);
        weightList.set(i, wb);
        return partition(weightList, xList, yList, p, r);
    }

    public static float[] quickSelect(ArrayList<Float> weightList, ArrayList<Integer> xList, ArrayList<Integer> yList, int p, int r, float leftSum, float rightSum){
        float[] toReturn = new float[3];
        if (p < r){
            float[] pivotResult = pivot(weightList, xList, yList, p, r);
            int q = Integer.parseInt(String.valueOf(pivotResult[0]));
            float left = pivotResult[1];
            float right = pivotResult[2];
            if (leftSum + left < rightSum + right){
                return quickSelect(weightList, xList, yList, q+1, r, leftSum+left, rightSum);
            }else if (leftSum + left > rightSum + right){
                return quickSelect(weightList, xList, yList, p, q-1, leftSum, rightSum+right);
            }else {
                toReturn[0] = weightList.get(q);
                toReturn[1] = xList.get(q);
                toReturn[2] = yList.get(q);
                return toReturn;
            }
        }
        return null;
    }





    public static int compareTo(int x1, int y1, int x2, int y2){
        if (x1 != x2){
            return x1 - x2;
        }else {
            return y1 - y2;
        }
    }



}
