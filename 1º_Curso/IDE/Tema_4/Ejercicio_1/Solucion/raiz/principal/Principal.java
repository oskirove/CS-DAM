import java.util.Scanner;
import sumas.A;
import hola.B;

public class Principal {
	public static void main(String args[]){
	 	Scanner sc = new Scanner(System.in);

		A metodo = new A();
		B saludo = new B();
		saludo.f2();

		System.out.print("Ingresa el primer número: ");
		int a = sc.nextInt();

		System.out.print("Ingresa el segundo número: ");
		int b = sc.nextInt();

		System.out.println(metodo.f1(a, b));	
	}
}
