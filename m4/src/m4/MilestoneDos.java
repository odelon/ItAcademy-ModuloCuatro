package m4;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MilestoneDos {

	public static void main(String[] args) {
		
		DecimalFormat df2 = new DecimalFormat("#.##");
		try (Scanner sc = new Scanner(System.in)) {
			
			String pedidoUsuario = "";
			List<String> platosUsuario = new ArrayList<String>();
			HashMap<String, Double> menu = new HashMap<String, Double>();			
			String mostrarPlatosConError = "El/Los siguiente/s plato/s no existe/n: \n";
			int seguir = 1;
			double precioComida = 0;		

			menu.put("Judías verdes con tomate y jamón y pechuga de pollo a la plancha", 10.50);
			menu.put("Tallarines de calabacín con carne", 11.30);
			menu.put("Lentejas con calabaza en olla exprés", 11.20);
			menu.put("Arroz con picadillo habanero", 10.80);
			menu.put("Lomo de cerdo con pak choi y verduras", 15.02);
			menu.put("Bonito marinado al curry con calabacín a la plancha", 16.45);
			menu.put("Berenjenas agridulces con hamburguesa de ternera a la plancha", 14.90);
			menu.put("Trucha marinada con salsa de albahaca y champiñones al ajillo", 16.78);
			menu.put("Mousse de frutas del bosque", 8.90);
			menu.put("Soufflé de mango y coco", 7.55);
			menu.put("Pastel de zanahoria de la casa", 6.95);
			menu.put("Cheesecake", 7.65);
          
			 Double [] precio = menu.values().toArray(new Double[0]);
			 String [] plato = menu.keySet().toArray(new String[0]);
			 
			 System.out.println("Estos son nuestros platos: ");
			 for (int i = 0; i < precio.length; i++) {        	 
				 System.out.println("- " + plato[i] + ": " + precio[i] + "€");        	    
			}
			 
			try {
			
				System.out.println("Que quieres comer? ");
			
				while(seguir != 0) {				
					pedidoUsuario = sc.nextLine();
					platosUsuario.add(pedidoUsuario);
				
					try {
						System.out.println("Para pedir otro pulsa 1, para finalizar pulsa 0.");
						seguir = Integer.parseInt(sc.nextLine());
					} catch (Exception continuar) {
						System.out.println("Error al hacer la selección, por favor, pulsa 1 para pedir otro plato o 0 para finalizar.");
					}
				}
			 
			
				for(String platoUsuario: platosUsuario) {
					if(Arrays.asList(plato).contains(platoUsuario)){
						int indice = Arrays.asList(plato).indexOf(platoUsuario);
						precioComida += precio[indice];
					}else {
						mostrarPlatosConError += platoUsuario + "\n";        		
					}        	
				}
			System.out.println("El precio total es: " + df2.format(precioComida));
			} catch (Exception pedido) {
				System.out.println(mostrarPlatosConError);
			}			
			
		} catch (Exception e) {
			System.out.println("Ha habido un error!!");
		}

	}
}
