
package tratamentoexceptions1;

import ModeloExceptions.DominioExceptions;
import MoledoEntidade.Reserva;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Adriano
 */
public class TratamentoExceptions1 {

    public static void main(String[] args)  {
        
            Scanner sc = new Scanner(System.in); 
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            try {
                System.out.print("Insira o numero do quarto: ");
                int numero = sc.nextInt();
                System.out.print("Data do Check-in: ");
                Date checkIn = sdf.parse(sc.next());
                System.out.print("Data do Check-out: ");
                Date checkOut = sdf.parse(sc.next());
            

                Reserva reserva = new Reserva(numero, checkIn, checkOut);
                System.out.println("Reserva: "+ reserva);
                
                System.out.println();
                System.out.println("Informe a data de atualização das reservas: ");
                System.out.print("Data do Check-in: ");
                checkIn = sdf.parse(sc.next());
                System.out.print("Data do Check-out: ");
                checkOut = sdf.parse(sc.next());
                
               
                reserva.updateDate(checkIn, checkOut);
                System.out.println("Reserva: "+ reserva);
            }   
            catch(ParseException e){
                System.out.println("A data indormada é invalida");
            }
            catch (DominioExceptions e){
                System.out.println("Erro na reserva: "+ e.getMessage());
            }
            catch(RuntimeException e){
                System.out.println("ERRO INESPERADO, LIGAR PARA O SUPORTE");
            }
            sc.close();
                  
    }
}
    

