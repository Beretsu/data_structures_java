
import java.util.Comparator;

/**
 *
 * @author mmm
 */
public class ComparaNumsAscendente implements Comparator<Long>{

    @Override
    public int compare(Long o1, Long o2) {
        return (int)(o1 - o2);
    }
    
}
