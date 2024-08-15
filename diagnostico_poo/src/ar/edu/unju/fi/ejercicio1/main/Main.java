package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("Ingrese palabra: ");
		String palabra=scanner.nextLine();	
		System.out.println("Número de subcadenas especiales: "+substringCount(palabra));	
		scanner.close();
	}
	
	public static boolean cadenaEspecial(String palabra) {
		boolean valida=true;		
		int i=0,j=palabra.length()-1;
		while(i<j && valida) {
			if (palabra.charAt(i)!=palabra.charAt(j)) {
				valida=false;
			}
			i++;
			j--;
		}	
		return valida;
	}
	
	public static boolean esMinuscula(String palabra) {
        return palabra.equals(palabra.toLowerCase());
    }
	
	public static List<String> generarSubcadenas(String cadena) {
		List<String> listaSubcadenas=new ArrayList<>();
        for (int i=0;i<cadena.length();i++) {
            for (int j=i+1;j<=cadena.length();j++) {               
                listaSubcadenas.add(cadena.substring(i,j));
            }
        }
        return listaSubcadenas;
	}
	
	public static int substringCount(String cadena) {
		int subcadenasEspeciales=0;
		if(cadena.length()>=1 && cadena.length()<=Math.pow(10,6) && esMinuscula(cadena))
		for (String palabra : generarSubcadenas(cadena)) {
			if (cadenaEspecial(palabra)) {				
				subcadenasEspeciales++;
			}			
		}
		return subcadenasEspeciales;
	}

}

