/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

/**
 *
 * @author Alunos
 */
public class ServicosFactory {

    private static MedicoServicos medicoServicos= new  MedicoServicos();

   public static MedicoServicos getMedicoServicos(){
       
       return medicoServicos;                                
   }//fecha metodo
   
   private static PacienteServicos pacienteServicos= new PacienteServicos();

   public static PacienteServicos getPacienteServicos(){
       
       return pacienteServicos;                                
   }//fecha metodo
 
   private static ConsultaServicos consultaServicos= new ConsultaServicos();

   public static ConsultaServicos getConsultaServicos(){
       
       return consultaServicos;                                
   }//fecha metodo
    
}//fecha classe    



