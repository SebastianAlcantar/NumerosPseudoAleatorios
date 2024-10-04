import java.util.Scanner;
public class Principal {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        Metodos m = new Metodos();
        do{
            System.out.println("\n        ESCOJE UNA OPCION       ");
            System.out.println("1)  Metodo de medios cuadrados");
            System.out.println("2)  Metodo de Newman");
            System.out.println("0)  Salir");
            opc = sc.nextInt();
            switch(opc){
                case 1:
                    m.metodoDeMediosCuadrados();
                    break;
                case 2:
                    m.metodoDeNewman();
            }
        }while(opc != 0);
    }
}
