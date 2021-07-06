
package tratamentoexceptions1;

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

    public static void main(String[] args) throws ParseException {
        
            Scanner sc = new Scanner(System.in); 
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            System.out.print("Insira o numero do quarto: ");
            int numero = sc.nextInt();
            System.out.print("Data do Check-in: ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Data do Check-out: ");
            Date checkOut = sdf.parse(sc.next());
            
            if(!checkOut.after(checkIn)){
                System.out.println("Erro na reserva: Data de check-out menor que a data de check-in.");
            }else{
                Reserva reserva = new Reserva(numero, checkIn, checkOut);
                System.out.println("Reserva: "+ reserva);
                
                System.out.println();
                System.out.println("Informe a data de atualização das reservas: ");
                System.out.print("Data do Check-in: ");
                checkIn = sdf.parse(sc.next());
                System.out.print("Data do Check-out: ");
                checkOut = sdf.parse(sc.next());
                
                Date agora = new Date();
                if (checkIn.before(agora)|| checkOut.before(agora)){
                    System.out.println("Erro na reserva: A data informada não pode ser anterior a data de reserva");
                }else if(!checkOut.after(checkIn)){
                    System.out.println("Erro na reserva: Data de check-out menor que a data de check-in.");
                    
                }else{
                     reserva.updateDate(checkIn, checkOut);
                     System.out.println("Reserva: "+ reserva);
                }
               
                        
               
            }
            
            
            
          
            
            sc.close();
            
        
                
    }
}
    

