
package MoledoEntidade;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Adriano
 */
public class Reserva {
    
    private Integer numeroQuarto;
    private Date checkIn;
    private Date checkOut;
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva(Integer numeroQuarto, Date checkin, Date checkout) {
        this.numeroQuarto = numeroQuarto;
        this.checkIn = checkin;
        this.checkOut = checkout;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public Date getCheckin() {
        return checkIn;
    }

    public Date getCheckout() {
        return checkOut;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }
    
    public long duracao(){
        long diferenca = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
    }
    
    public String updateDate(Date checkIn, Date checkOut){
        
        Date agora = new Date();
                if (checkIn.before(agora)|| checkOut.before(agora)){
                    return "Erro na reserva: A data informada não pode ser anterior a data de reserva";
                }
                if(!checkOut.after(checkIn)){
                    System.out.println("Erro na reserva: Data de check-out menor que a data de check-in.");
                }
               
                this.checkIn = checkIn;
                this.checkOut = checkOut;
                return null;
    }
    
    @Override
    public String toString(){
        return "Quarto "
                + numeroQuarto
                +", check-in: "
                + sdf.format(checkIn)
                +", check-out: "
                + sdf.format(checkOut)
                +", "
                + duracao()
                +" noite(s)";
    }
            
      
}
    
    
    

