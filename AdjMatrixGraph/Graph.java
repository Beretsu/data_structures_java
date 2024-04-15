
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author mmm
 */
public abstract class Graph {

    private int numVertices;
    private int numEdges;

    public void addVertex() {
        implementAddVertex();
        numVertices++;
    }

    public void addEdge(int src, int dest) {
        if(src < numVertices && dest < numVertices){
            implementAddEdge(src, dest);
            numEdges++;
        }else{
            throw new IndexOutOfBoundsException();
        }
        
    }
    
    public List<Integer> degreeSequence(){
        List<Integer> sequence = new ArrayList<>();
        for(int i = 0; i < numVertices; i++){
            sequence.add(getOutNeighbors(i).size() + getInNeighbors(i).size());
        }
        Collections.sort(sequence, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        return sequence;
    }

    public abstract void implementAddVertex();

    public abstract void implementAddEdge(int src, int dest);

    public abstract List<Integer> getOutNeighbors(int v);
    
    public abstract List<Integer> getInNeighbors(int v);
    
    public abstract List<Integer> getTwoHopNeighbors(int v);

    public int getNumVertices() {
        return numVertices;
    }

    public int getNumEdges() {
        return numEdges;
    }
}
