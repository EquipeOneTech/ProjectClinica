/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Consulta;
import modelo.Medico;
import modelo.Paciente;

/**
 *
 * @author Alunos
 */
public class DaoFactory {
      
    private static MedicoDao medicoDao = new MedicoDao();
    
    public static MedicoDao getMedicoDao(){
        return medicoDao;
      }//fecha método
    
    
    private static PacienteDao pacienteDao = new PacienteDao();
    
    public static PacienteDao getPacienteDao(){
        return pacienteDao;
      }//fecha método
    
    private static ConsultaDao consultaDao = new ConsultaDao();
    
    public static ConsultaDao getConsultaDao(){
        return consultaDao;
      }//fecha método

       
}
