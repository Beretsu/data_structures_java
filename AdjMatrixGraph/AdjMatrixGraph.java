
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mmm
 */
public class AdjMatrixGraph extends Graph {

    private int[][] matrix;

    public AdjMatrixGraph() {
        matrix = new int[10][10];
    }

    @Override
    public void implementAddVertex() {
        if (getNumVertices() == matrix.length) {
            int[][] newMatrx = new int[matrix.length * 2][matrix.length * 2];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    newMatrx[i][j] = matrix[i][j];
                }
            }
            matrix = newMatrx;
        }

    }

    @Override
    public void implementAddEdge(int src, int dest) {
        matrix[src][dest]++;
    }

    @Override
    public List<Integer> getOutNeighbors(int v) {
        List<Integer> neighbors = new ArrayList<>();
        int num = getNumVertices();
        for (int i = 0; i < num; i++) {
            for(int j = 0; j < matrix[v][i]; j++) {
                neighbors.add(i);
            }
        }
        return neighbors;
    }

    public List<Integer> uglyGetTwoHopNeightbors(int v) {
        List<Integer> neighbors = new ArrayList<>();
        int num = getNumVertices();
        for(int i = 0; i < num; i++){
            for(int j = 0; j < matrix[v][i]; j++){
                neighbors.addAll(getOutNeighbors(matrix[v][i]));
            }
        }
        return neighbors;
    }
    
    @Override
    public List<Integer> getTwoHopNeighbors(int v){
        List<Integer> neighbors = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int a = 0;
            for (int j = 0; j < matrix.length; j++) {
                a += matrix[v][j] * matrix[j][i];
            }
            if(a > 0){
                for (int j = 0; j < a; j++) {
                    neighbors.add(i);
                }
            }
        }
        return neighbors;
    }

    @Override
    public List<Integer> getInNeighbors(int v) {
        List<Integer> neighbors = new ArrayList<>();
        int num = getNumVertices();
        for(int i = 0; i < num; i++){
            for (int j = 0; j < matrix[i][v]; j++) {
                neighbors.add(i);
            }
        }
        return neighbors;
    }
}
