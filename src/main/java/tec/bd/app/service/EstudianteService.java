package tec.bd.app.service;

import tec.bd.app.bd.SetDB;
import tec.bd.app.domain.Estudiante;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EstudianteService {

    private SetDB database;

    public EstudianteService(SetDB database) {
        this.database = database;
    }

    public List<Estudiante> getAll() {
        return this.database.getEstudianteTable().stream().collect(Collectors.toList());
    }

    public Estudiante getById(long carne) {
        return this.database.getEstudianteTable().stream().filter(e -> e.getCarne() == carne).findFirst().get();
    }

    public void addNew(Estudiante e) {
        // Verificar si el estudiante que viene por parametro ya existe en la BD
        boolean condicion = false;
        var tabla_actual = this.database.getEstudianteTable();

        for(Estudiante iterado : tabla_actual){
            if(iterado.getCarne() == e.getCarne()){
                condicion = true;
                break;
            }
        }

        if (!condicion){
            this.database.getEstudianteTable().add(e);
        }

        else {
            System.out.println("\n---------------------[ Este estudainte ya existe ]---------------------");
        }
    }

    public void updateStudent(Estudiante e) {
        // Implementar codigo de actualizacion
        // Traer el estudiante con carne X
        // modificar el estudiante con los datos del estudiante e
        boolean condicion = false;
        var tabla_actual = this.database.getEstudianteTable();

        for(Estudiante iterado : tabla_actual){
            if(iterado.getCarne() == e.getCarne()){
                iterado.setNombre(e.getNombre());
                iterado.setApellido(e.getApellido());
                iterado.setEdad(e.getEdad());
                condicion = true;
            }
        }

        if(!condicion){
            System.out.println("\n---------------------[ Este estudainte NO existe ]---------------------");
        }
    }

    public void deleteStudent(long carne) {
        // implementar codigo de borrado
        // HashSet.remove(e);
        boolean condicion = false;
        var tabla_actual = this.database.getEstudianteTable();

        for(Estudiante iterado : tabla_actual){
            if(iterado.getCarne() == carne){
                this.database.getEstudianteTable().remove(iterado);
                condicion = true;
                break;
            }
        }

        if(!condicion){
            System.out.println("\n---------------------[ Este estudainte NO existe ]---------------------");
        }
    }

}
