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
            n = Integer.parseInt(br.readLine().split("\\s+")[0]);
            for(String line; (line = br.readLine()) != null; ) {
                String[] content = line.split("\\s+");
                weights.add(Float.parseFloat(content[0]));
                xs.add(Integer.parseInt(content[1]));
                ys.add(Integer.parseInt(content[2]));
            }
        }
        System.out.println(n);
        System.out.println(weights);
        System.out.println(xs);
        System.out.println(ys);

        float[] xMed = quickSelect(weights, xs, ys,0, n-1, 0, 0);
        float[] yMed = quickSelect(weights, ys, xs,0, n-1, 0, 0);

        System.out.println("");
        float sumx = 0;
        float sumy = 0;
        for (int i = 0; i < n; i ++){
            int x = xs.get(i);
            int y = ys.get(i);
            if (x <= xMed[1]){
                sumx = sumx + weights.get(i);
            }
            if (y <= yMed[1]){
                sumy = sumy + weights.get(i);
            }
        }
        System.out.println("x median:");
        System.out.println(xMed[0]);
        System.out.println(xMed[1]);
        System.out.println("y median:");
        System.out.println(yMed[0]);
        System.out.println(yMed[1]);
        System.out.println("validation:");
        System.out.println(sumx);
        System.out.println(sumy);
    }

    public static float[] quickSelect(ArrayList<Float> weightList, ArrayList<Integer> xList, ArrayList<Integer> yList,int p, int r, float leftSum, float rightSum){
        float[] toReturn = new float[2];
        if (p < r){
            float[] pivotResult = pivot(weightList, xList,yList, p, r);
            int q = Math.round(pivotResult[0]);
            float left = pivotResult[1];
            float right = pivotResult[2];
            float mid = weightList.get(q);
            if (leftSum + left == rightSum + right || leftSum + left + mid== rightSum + right){
                toReturn[0] = weightList.get(q);
                toReturn[1] = xList.get(q);
                System.out.println("quickselect return: "+toReturn[0]+", "+toReturn[1]);
                return toReturn;
            }else if (leftSum + left < rightSum + right && !(leftSum + left +mid >= rightSum + right)){
                return quickSelect(weightList, xList,yList, q+1, r, leftSum+left+mid, rightSum);
            }else if (leftSum + left > rightSum + right && !(rightSum + right + mid >= leftSum + left)){
                return quickSelect(weightList, xList,yList, p, q-1, leftSum, rightSum+right+mid);
            }else {
                toReturn[0] = weightList.get(q);
                toReturn[1] = xList.get(q);
                System.out.println("quickselect return: "+toReturn[0]+", "+toReturn[1]);
                return toReturn;
            }
        }
        toReturn[0] = weightList.get(r);
        toReturn[1] = xList.get(r);
        return toReturn;
    }

    public static float[] pivot(ArrayList<Float> weightList, ArrayList<Integer> xList,ArrayList<Integer> yList, int p, int r){
        Random random = new Random();
        int i = p + random.nextInt(r - p + 1);
        swap(weightList, xList, yList, r, i);
        return partition(weightList, xList,yList, p, r);
    }

    public static float[] partition(ArrayList<Float> weightList, ArrayList<Integer> xList,ArrayList<Integer> yList, int p, int r){
        int x = xList.get(r);
        int i = p - 1;
        float left = 0;
        float right = 0;
        float[] toReturn = new float[3];

        for (int j = p; j < r; j ++){
            if (xList.get(j) <= x){
                left = left + weightList.get(j);
                i = i + 1;
                swap(weightList, xList, yList, j, i);
            }else {
                right = right + weightList.get(j);
            }
        }
        swap(weightList, xList, yList, i+1,r);
        toReturn[0] = i + 1;
        toReturn[1] = left;
        toReturn[2] = right;
        return toReturn;
    }

    public static void swap(ArrayList<Float> weightList, ArrayList<Integer> xList, ArrayList<Integer> yList,int i1, int i2){
        int xb = xList.get(i1);
        int yb = yList.get(i1);
        float wb = weightList.get(i1);

        xList.set(i1,xList.get(i2));
        yList.set(i1,yList.get(i2));
        weightList.set(i1, weightList.get(i2));

        xList.set(i2, xb);
        yList.set(i2, yb);
        weightList.set(i2, wb);
    }
}
