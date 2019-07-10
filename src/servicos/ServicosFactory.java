
package servicos;


public class ServicosFactory {

    private static MedicoServicos medicoServicos= new  MedicoServicos();

   public static MedicoServicos getMedicoServicos(){
       
       return medicoServicos;                                
   }
   
   private static PacienteServicos pacienteServicos= new PacienteServicos();

   public static PacienteServicos getPacienteServicos(){
       
       return pacienteServicos;                                
   }
 
   private static ConsultaServicos consultaServicos= new ConsultaServicos();

   public static ConsultaServicos getConsultaServicos(){
       
       return consultaServicos;                                
   }
    
}    



