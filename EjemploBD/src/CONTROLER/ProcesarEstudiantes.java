package CONTROLER;

import MODEL.Estudiante;
import MODEL.ConeccionDB;
import java.sql.Connection;
import java.util.ArrayList;

public class ProcesarEstudiantes {
    // Se declara un array de estuduantes 
    public ArrayList<Estudiante> lstEstudiantes;
    public ProcesarEstudiantes(ArrayList<Estudiante> lstEstudiantes) {
        this.lstEstudiantes = lstEstudiantes;
    }
   // Metodo para el calcularde promedios 
    public void calculoPromedios(){
        for(Estudiante est : lstEstudiantes)
            est.promedio = (est.nota1 + est.nota2) / 2;
    }
    
    // Metodo para el averiguar el estado de l estudiante si es aprobado  o desaprobado  
    public void calculoEstados(){
        for(Estudiante est : lstEstudiantes)
            est.estado = (est.promedio >= 7) ? "Aprobado" : "Reprobado";
    }
    
    
    public void insertarEstudiante(Estudiante estudiante){
        (new ConeccionDB()).insertarEstudiante(estudiante);
    }
    public ArrayList<Estudiante> getLstEstudiantes() {
        return (new ConeccionDB()).getLstEstudiantes();
    }
    
    public void deleteEstudiante(String id) {
        (new ConeccionDB()).deleteEstudiante(id);
    }

    public void updateEstudiante(Estudiante estudiante) {
        (new ConeccionDB()).updateEstudiante(estudiante);
    }
    
    
    
}
