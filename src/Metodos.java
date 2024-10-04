import java.util.Scanner;
import java.util.Random;
import java.util.LinkedList;
public class Metodos {
    public static void metodoDeMediosCuadrados(){
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        LinkedList lista = new LinkedList<Integer>();
        int opc = 0;
        int num = 0;
        int[] digitos = new int[8];
        //Menu
        do{
            System.out.println("\n***     Metodo de los medios cuadrados      ***");
            System.out.println("1)  Semilla por teclado");
            System.out.println("2)  Semilla por función");
            System.out.println("0)  Salir");
            System.out.print("Escoja una opción: ");
            opc = sc.nextInt();
            switch (opc) {
                case 1:     //Semilla por teclado
                    boolean validacion = true;
                    //Pregunta por la semilla y la valida 
                    while(validacion == true){
                    System.out.print("Introduzca una semilla de 4 digitos: ");
                    num = sc.nextInt();
                    if (num >= 1000 && num <= 9999)
                        validacion = false;
                    else
                        System.out.println("Numero no valido, vuelva a intentarlo");
                    }
                    int num2 = num;
                    
                    do{
                    lista.add(num2);
                    num = num2;
                    //Cuadrado de la semilla y la longitud de este 
                    int numCuadrado = (int) (Math.pow(num, 2));
                    int longitudLC = Integer.toString(numCuadrado).length();
                    String numString = Integer.toString(numCuadrado);
                    num2 = num;
                    String num2String = "";
                    //Validar si el numero cuadrado tiene 8 digitos
                    if(longitudLC < 8){
                        //Se agegan los ceros que falta 
                        int cerosFaltantes = 8-longitudLC;
                        for(int i = 0; i < cerosFaltantes; i++){
                            digitos[i] = 0; 
                        }
                        int aux=0;
                        for(int i = cerosFaltantes; i < 8; i++){
                            digitos[i] = Integer.parseInt(Character.toString(numString.charAt(aux)));
                            aux++;
                        }
                    }else{
                        //Separar los caracteres del numero
                        for(int i = 0; i < 8; i++){
                            digitos[i] = Integer.parseInt(Character.toString(numString.charAt(i)));
                        }
                    }
                    for(int i =5; i > 1; i--){
                        num2String = Integer.toString(digitos[i])+num2String;
                    }
                    num2 = Integer.parseInt(num2String);
                    
                    }while(lista.contains(num2) == false);
                    lista.add(num2);
                    //Imprimir lista
                    for(int i = 0 ; i < lista.size(); i++){
                        System.out.printf("X%2d  = %8d\n",i, lista.get(i));
                    }
                    lista.clear();
                    break;
                case 2:     //Semilla por funcion 
                    num = (int)(r.nextDouble() * 8999+1000);
                    System.out.println(num); 
                    num2 = num;
                    do{
                    lista.add(num2);
                    num = num2;
                    //Cuadrado de la semilla y la longitud de este 
                    int numCuadrado = (int) (Math.pow(num, 2));
                    int longitudLC = Integer.toString(numCuadrado).length();
                    String numString = Integer.toString(numCuadrado);
                    num2 = num;
                    String num2String = "";
                    //Validar si el numero cuadrado tiene 8 digitos
                    if(longitudLC < 8){
                        //Se agegan los ceros que falta 
                        int cerosFaltantes = 8-longitudLC;
                        for(int i = 0; i < cerosFaltantes; i++){
                            digitos[i] = 0; 
                        }
                        int aux=0;
                        for(int i = cerosFaltantes; i < 8; i++){
                            digitos[i] = Integer.parseInt(Character.toString(numString.charAt(aux)));
                            aux++;
                        }
                    }else{
                        //Separar los caracteres del numero
                        for(int i = 0; i < 8; i++){
                            digitos[i] = Integer.parseInt(Character.toString(numString.charAt(i)));
                        }
                    }
                    for(int i =5; i > 1; i--){
                        num2String = Integer.toString(digitos[i])+num2String;
                    }
                    num2 = Integer.parseInt(num2String);
                    
                    }while(lista.contains(num2) == false);
                    lista.add(num2);
                    //Imprimir lista
                    for(int i = 0 ; i < lista.size(); i++){
                        System.out.printf("X%2d  = %8d\n",i, lista.get(i));
                    }
                    lista.clear();
                    break;
            }
        }while(opc != 0);
    }
    public static void metodoDeNewman(){
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        LinkedList lista = new LinkedList<>();
        int opc = 0;
        int num = 0;
        long[] digitos = new long[20];
        //menu
        do{
            
            System.out.println("\n***     Metodo de Newman      ***");
            System.out.println("1)  Semilla por teclado");
            System.out.println("2)  Semilla por función");
            System.out.println("0)  Salir");
            System.out.print("Escoja una opción: ");
            opc = sc.nextInt();
            switch (opc) {
                case 1: //Semilla por teclado
                    //Pregunta por la semilla y la valida 
                    
                    System.out.print("Introduzca una semilla de 10 digitos: ");
                    long num1 = sc.nextLong();
                    long num2 = num1;
                    do{
                        lista.add(num2);
                        num1 = num2;
                        long numCuadrado = (long) Math.pow(num1, 2);
                        long longitudLC = Long.toString(numCuadrado).length();
                        String numString = Long.toString(numCuadrado);
                        String num2String = "";
                        int centro = 0;
                        //Separar el numero en digitos
                        if(longitudLC % 2 == 0){
                            //Se agegan los ceros que falta
                            digitos[0] = 0; 
                            for(int i = 1; i < longitudLC; i++){
                                digitos[i] = Long.parseLong(Character.toString(numString.charAt(i)));
                            }
                            centro = (int) (longitudLC/2);
                        }else{
                            for(int i = 0; i < longitudLC; i++){
                                digitos[i] = Long.parseLong(Character.toString(numString.charAt(i)));
                            }
                            centro = (int)((longitudLC+1)/2);
                        }
                        for(int i = centro+1; i > (centro -4); i--){
                            num2String = Long.toString(digitos[i])+num2String;
                        }
                        num2 = Long.parseLong(num2String);
                        if(num2 == 0){
                            break;
                        }
                    }while(lista.contains(num2) == false );
                    lista.add(num2);
                    //Imprimir lista
                    for(int i = 0 ; i < lista.size(); i++){
                        System.out.printf("X%2d  = %8d\n",i, lista.get(i));
                    }
                    lista.clear();
                    break;

                case 2: //Semilla por función
                    num1 = ((long)(r.nextDouble()*2147483647+999999999));
                    num2 = num1;
                    do{
                        lista.add(num2);
                        num1 = num2;
                        long numCuadrado = (long) Math.pow(num1, 2);
                        long longitudLC = Long.toString(numCuadrado).length();
                        String numString = Long.toString(numCuadrado);
                        String num2String = "";
                        int centro = 0;
                        //Separar el numero en digitos
                        if(longitudLC % 2 == 0){
                            //Se agegan los ceros que falta
                            digitos[0] = 0; 
                            for(int i = 1; i < longitudLC; i++){
                                digitos[i] = Long.parseLong(Character.toString(numString.charAt(i)));
                            }
                            centro = (int) (longitudLC/2);
                        }else{
                            for(int i = 0; i < longitudLC; i++){
                                digitos[i] = Long.parseLong(Character.toString(numString.charAt(i)));
                            }
                            centro = (int)((longitudLC+1)/2);
                        }
                        for(int i = centro+1; i > (centro -4); i--){
                            num2String = Long.toString(digitos[i])+num2String;
                        }
                        num2 = Long.parseLong(num2String);
                        if(num2 == 0){
                            break;
                        }
                    }while(lista.contains(num2) == false );
                    lista.add(num2);
                    //Imprimir lista
                    for(int i = 0 ; i < lista.size(); i++){
                        System.out.printf("X%2d  = %8d\n",i, lista.get(i));
                    }
                    lista.clear();
                    break;
            }
        }while(opc != 0);
    }
}
