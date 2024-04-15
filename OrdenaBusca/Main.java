
import java.util.Scanner;

/**
 *
 * @author mmm
 */
public class Main {

    public static void main(String[] args) {
        Long nums[] = {};
        MetodosOrdenamiento.dualPivotQuickSort(nums, new ComparaNumsAscendente());
        for (Long num : nums) {
            System.out.println(num);
        }
        char opcion;
        Scanner sc = new Scanner(System.in);
        int index;
        do {
            System.out.print("pulsa 's' si quieres buscar un indice, de lo contrario pulsa cualquier otro caracter: ");
            opcion = sc.next().charAt(0);
            if (opcion == 's') {
                System.out.print("Ingresa el entero al que le quieres buscar su indice: ");
                long valor = sc.nextLong();
                index = MetodosBusqueda.linearSearch(nums, valor);
                if (index < 0) {
                    System.out.println("Ese entero no existe en la coleccion de datos");
                } else {
                    System.out.println("Indice para " + nums[index] + " es: " + index);

                }
            } else {
                System.out.println("largate pues");
            }
        } while (opcion == 's');
    }

    private static Long[] getEnteros(int cantidad, int min, int max) {
        Long nums[] = new Long[cantidad];
        for (int i = 0; i < cantidad; i++) {
            nums[i] = (long) (Math.random() * (max - min + 1) + min);
        }
        return nums;
    }
//    
//    private static String[] getStrings(int cantidad, int min, int max){
//        String strings[] = new String[cantidad];
//        StringBuilder str = new StringBuilder();
//        for (int i = 0; i < cantidad; i++) {
//            long strLength = (long) (Math.random()* (max - min + 1) + min);
//            for (int j = 0; j < strLength; j++) {
//                char ch = (char) (Math.random() * 26 + 97); 
//                str.append(ch);
//            }
//            strings[i] = str.toString();
//            str.delete(0, str.length());
//        }
//        return strings;
//    }
}
