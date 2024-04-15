
import java.util.Comparator;

/**
 *
 * @author mmm
 */
public class MetodosOrdenamiento {
    
    
    public static void quickSort(Object[] arr, Comparator cmp){
        quickSort(arr, 0, arr.length-1, cmp);
    }
    
    private static int partition(Object[] arr, int start, int end, Comparator cmp){
        int partitionIndex = start;
        for(int i = start; i < end; i++){
            if(cmp.compare(arr[i], arr[end]) <= 0){
                Object temp = arr[partitionIndex];
                arr[partitionIndex] = arr[i];
                arr[i] = temp;
                partitionIndex++;
            }
        }
        Object temp = arr[partitionIndex];
        arr[partitionIndex] = arr[end];
        arr[end] = temp;
        return partitionIndex;
    }
    
    private static int randomizedPartition(Object[] arr, int start, int end, Comparator cmp){
        int pindex = (int)(Math.random()*(end-start)+start);
        Object temp = arr[pindex];
        arr[pindex] = arr[end];
        arr[end] = temp;
        return partition(arr, start, end, cmp);
    }
    
    private static void quickSort(Object[] arr, int start, int end, Comparator cmp){
        if(start < end){
            int pindex = randomizedPartition(arr, start, end, cmp);
            quickSort(arr, start, pindex-1, cmp);
            quickSort(arr, pindex+1, end, cmp);
        }
    }
    
    public static void bubbleSort(Object[] arr, Comparator cmp){
        int n = arr.length-1;
        for (int i = 0; i < n; i++) {
            boolean bandera = true;
            for (int j = 0; j < n-i; j++) {
                if(cmp.compare(arr[j], arr[j+1]) > 0){
                    Object temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    bandera = false;
                }
            }
            if(bandera){
                break;
            }
        }
    }
    
    public static void insertionSort(Object[] arr, Comparator cmp){
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int hoyo = i;
            Object valor = arr[i];
            while(hoyo > 0 && cmp.compare(arr[hoyo-1], valor) > 0){
                arr[hoyo] = arr[hoyo-1];
                hoyo--;
            }
            arr[hoyo] = valor;
        }
    }
    
    private static void merge(Object[] destiny, Object[] left, Object[] right, Comparator cmp){
        int i = 0, j = 0, k = 0;
        int leftl = left.length, rightl = right.length;
        while(i < leftl && j < rightl){
            if(cmp.compare(left[i], right[j]) <= 0){
                destiny[k] = left[i];
                i++;
            }else{
                destiny[k] = right[j];
                j++;
            }
            k++;
        }
        while(i < leftl){
            destiny[k] = left[i];
            i++;
            k++;
        }
        while(j < rightl){
            destiny[k] = right[j];
            j++;
            k++;
        }
    }
    
    public static void mergeSort(Object arr[], Comparator cmp){
        int length = arr.length;
        if(length < 2){
            return;
        }
        int mid = length/2;
        Object[] left = new Object[mid];
        Object[] right = new Object[length-mid];
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = 0; i < length-mid; i++) {
            right[i] = arr[i+mid];
        }
        mergeSort(left, cmp);
        mergeSort(right, cmp);
        merge(arr, left, right, cmp);
        
    }
    
    public static void shellSort(Object arr[], Comparator cmp){
        int n = arr.length;
        for(int gap = n/2; gap > 0; gap /= 2){
            for(int i = gap; i < n;  i++){
                Object temp = arr[i];
                int j;
                for(j = i; j >= gap; j -= gap){
                    if(cmp.compare(arr[j-gap], temp) > 0){
                        arr[j] = arr[j-gap];
                    }else{
                        break;
                    }
                }
                arr[j] = temp;
            }
        }
    }
    
    public static void dualPivotQuickSort(Object arr[], Comparator cmp){
        dualPivotQuickSort(arr, cmp, 0, arr.length - 1);
    }
    
    private static void dualPivotQuickSort(Object arr[], Comparator cmp, int start, int end){
        if(start < end){
            int pIndex[] = {start, end};
            dualPivotPartition(arr, cmp, pIndex);
            dualPivotQuickSort(arr, cmp, start, pIndex[0] - 1);
            dualPivotQuickSort(arr, cmp, pIndex[0] + 1, pIndex[1] - 1);
            dualPivotQuickSort(arr, cmp, pIndex[1] + 1, end);
        }
    }
    
    private static void dualPivotPartition(Object arr[],  Comparator cmp, int pivot[]){
        if(cmp.compare(arr[pivot[0]], arr[pivot[1]]) > 0){
            Object temp = arr[pivot[0]];
            arr[pivot[0]] = arr[pivot[1]];
            arr[pivot[1]] = temp;
        }
        int leftPIndex = pivot[0] + 1;
        int iterator = leftPIndex;
        int rightPIndex = pivot[1] - 1;
        while(iterator <= rightPIndex){
            // if elements are less than the left pivot 
            if(cmp.compare(arr[iterator], arr[pivot[0]]) < 0 ){
                Object temp = arr[iterator];
                arr[iterator] = arr[leftPIndex];
                arr[leftPIndex] = temp;
                leftPIndex++;
            // if elements are greater than the right pivot 
            }else if(cmp.compare(arr[iterator], arr[pivot[1]]) > 0){
                while(iterator < rightPIndex && cmp.compare(arr[rightPIndex], arr[pivot[1]]) > 0){
                    rightPIndex--;
                }
                Object temp = arr[rightPIndex];
                arr[rightPIndex] = arr[iterator];
                arr[iterator] = temp;
                rightPIndex--;
                if(cmp.compare(arr[iterator], arr[pivot[0]]) < 0){
                    temp = arr[iterator];
                    arr[iterator] = arr[leftPIndex];
                    arr[leftPIndex] = temp;
                    leftPIndex++;
                }
            }
            iterator++;
        }
        leftPIndex--;
        rightPIndex++;
        // bring pivots to their appropriate positions.
        Object temp = arr[leftPIndex];
        arr[leftPIndex] = arr[pivot[0]];
        arr[pivot[0]] = temp;
        temp = arr[rightPIndex];
        arr[rightPIndex] = arr[pivot[1]];
        arr[pivot[1]] = temp;
        //modify the array 
        pivot[0] = leftPIndex;
        pivot[1] = rightPIndex;
    }
}
