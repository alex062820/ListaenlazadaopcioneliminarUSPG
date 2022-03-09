/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenar.numeros.de.un.arreglo;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author 
 */
public class OrdenarNumerosDeUnArreglo {

    /**
     * @param args the command line arguments
     */

    
     private static int vec[]=new int[10];
        
        public static void main(String[] args) {
            
                Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
            System.out.println("\n----Menu Principal-----");
            System.out.println("1. Ingresar 10 numeros de un arreglo");
            System.out.println("2. Mostrar Valores");
            System.out.println("3. Orden asc");
            System.out.println("4. Orden desc");
            System.out.println("5. Eliminar un registro del arreglo");
            System.out.println("6. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        Scanner scan=new Scanner(System.in);
                        System.out.println("Introduce 10 números enteros y pulse 0 para terminar: ");
                        int datosIntroducidos=0;
                        
                        int i=0;
                        do{
                         datosIntroducidos=scan.nextInt();
 
                        if(datosIntroducidos!=0){
                            vec[i]=datosIntroducidos;
                            i++;
                            }
                        }while(datosIntroducidos!=0);
                        break;
                    case 2:
                        System.out.println("\nVector original");
                        imprimirVector(vec);
                        ordenacionRapida(vec);
                        break;
                    case 3:
                         System.out.println("\nVector ordenado asc");
                         imprimirVector(vec);
                        break;
                    case 4:
                        System.out.println("\nVector ordenado desc");
                        imprimirVector2(vec);
                        break;
                    case 5:
                        System.out.println("\nVector original!, Que registro desea eliminar?");
                        imprimirVector(vec);
                        ordenacionRapida(vec);
                        Scanner scan2=new Scanner(System.in);
                        System.out.println("\nIntroduce un número entero y pulse 0 para terminar: ");
                        int datosIntroducidos2=0;
                        
                        
                        int[] newArr = null;
                        do{
                         datosIntroducidos=scan2.nextInt();
                         boolean val = contains(vec,datosIntroducidos);
                          
                          if (val == true){
                                for (int i2 = 0; i2 < vec.length-1; i2++) {
                                if(vec[i2] == datosIntroducidos){
                                    newArr = new int[vec.length - 1];
                                    for(int index = 0; index < i2; index++){
                                        newArr[index] = vec[index];
                                    }
                                    for(int j = i2; j < vec.length - 1; j++){
                                        newArr[j] = vec[j+1];
                                    }
                                    break;
                        }
                               
                        }
                        System.out.println("Nueva matriz después de eliminar el elemento = "+datosIntroducidos+" y cambiando: "+ Arrays.toString(newArr));
                        vec=newArr;
                          }else{
                              System.out.println("El numero ingresado no existe dentro del array");
                          }
                               
                        }while(datosIntroducidos!=0);
                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 6");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }


                
                
        }

        
        public static boolean contains(final int[] arr, final int key) {
        boolean found = false;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i]==key) {
                found=true;
            }
        }
        return found; 
    }
        public static void ordenacionRapida(int vec[]){
                final int N=vec.length;
                quickSort(vec, 0, N-1);
        }
        
        public static void quickSort(int vec[], int inicio, int fin){
                if(inicio>=fin) return;
                int pivote=vec[inicio];
                int elemIzq=inicio+1;
                int elemDer=fin;
                while(elemIzq<=elemDer){
                        while(elemIzq<=fin && vec[elemIzq]<pivote){
                                elemIzq++;
                        }
                        while(elemDer>inicio && vec[elemDer]>=pivote){
                                elemDer--;
                        }
                        if(elemIzq<elemDer){
                                int temp=vec[elemIzq];
                                vec[elemIzq]=vec[elemDer];
                                vec[elemDer]=temp;
                        }
                }
                
                if(elemDer>inicio){
                        int temp=vec[inicio];
                        vec[inicio]=vec[elemDer];
                        vec[elemDer]=temp;
                }
                quickSort(vec, inicio, elemDer-1);
                quickSort(vec, elemDer+1, fin);
        }
        
        public static void imprimirVector(int vec[]){
                for(int i=0;i<vec.length;i++){
                        System.out.print(vec[i]+" ");
                }
        }
        
       public static void imprimirVector2(int vec[]){
                for(int i= vec.length-1;i>= 0;i--){
                        System.out.print(vec[i]+" ");
                }
        }
 
}
