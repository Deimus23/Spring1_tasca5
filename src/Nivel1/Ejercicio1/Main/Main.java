package Nivel1.Ejercicio1.Main;

public class Main {
    public static void main(String[] args) {

     if(args.length!=1){
         System.out.println("The argument isn't correct");
     }else {
         String path = args[0];
         ListDirectory.listDirectory(path);
        }
    }


}