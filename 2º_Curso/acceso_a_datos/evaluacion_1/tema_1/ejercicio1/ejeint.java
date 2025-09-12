import java.io.File;

/**
 * Muestra, por separado, la lista de ficheros
 * y directorios de un directorio dado.
 */
public class ejeint {
    public static void main(String[] args) {
        File carpeta = new File("2º_Curso/acceso_a_datos/evaluacion_1/tema_1/ejercicio1/carpeta");
        File array[] = carpeta.listFiles();

        for (int i = 0; i < carpeta.listFiles().length; i++) {
            if (array[i].isFile()) {
                System.out.print("Fichero: ");
                System.out.print(array[i].getName());
                System.out.println();
            } else {
                System.out.print("Directorio: ");
                System.out.print(array[i].getName());
                System.out.println();
            }
        }
    }
}
