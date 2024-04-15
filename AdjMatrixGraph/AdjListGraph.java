
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author mmm
 */
public class AdjListGraph extends Graph{
    
    private final Map<Integer, ArrayList<Integer>> adjListMap;

    public AdjListGraph() {
        adjListMap = new HashMap<>();
    }

    @Override
    public void implementAddVertex() {
        int v = getNumVertices();
        ArrayList<Integer> neighbors = new ArrayList<>(v);
        adjListMap.put(v, neighbors);
    }

    @Override
    public void implementAddEdge(int src, int dest) {
        adjListMap.get(src).add(dest);
    }

    @Override
    public List<Integer> getOutNeighbors(int v) {
        return new ArrayList<>(adjListMap.get(v));
    }

    @Override
    public List<Integer> getTwoHopNeighbors(int v) {
        List<Integer> oneHopNeighbors = adjListMap.get(v);
        List<Integer> twoHopNeighbors = new ArrayList<>();
        for(int i = 0; i < oneHopNeighbors.size(); i++){
            List<Integer> neighborList = adjListMap.get(oneHopNeighbors.get(i));
            for(int j = 0; j < neighborList.size(); j++){
                twoHopNeighbors.add(neighborList.get(j));
            }
        }
        return twoHopNeighbors;
    }

    @Override
    public List<Integer> getInNeighbors(int v) {
        List<Integer> neighbors = new ArrayList<>();
        int size = adjListMap.size(), size2;
        for(int i = 0; i < size; i++){
            size2 = adjListMap.get(i).size();
            for(int j = 0; j < size2; j++){
                if(adjListMap.get(i).get(j) == v){
                    neighbors.add(i);
                }
            }
        }
        return neighbors;
    }
}
