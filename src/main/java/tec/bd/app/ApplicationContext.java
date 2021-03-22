package tec.bd.app;

import tec.bd.app.dao.*;
import tec.bd.app.database.set.Row;
import tec.bd.app.database.set.RowAttribute;
import tec.bd.app.database.set.SetDB;
import tec.bd.app.domain.Curso;
import tec.bd.app.domain.Entity;
import tec.bd.app.domain.Estudiante;
import tec.bd.app.domain.Profesor;
import tec.bd.app.service.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ApplicationContext {

    private SetDB setDB;
    private EstudianteDAO estudianteSetDAO;
    private EstudianteService estudianteServiceSet;

    private CursoDAO cursoSetDAO;
    private CursoService cursoService;

    private ProfesorDAO profesorSetDAO;
    private ProfesorService profesorServiceSet;


    private ApplicationContext() {

    }

    public static ApplicationContext init() {
        ApplicationContext applicationContext = new ApplicationContext();
        applicationContext.setDB = initSetDB();
        applicationContext.estudianteSetDAO = initEstudianteSetDAO(applicationContext.setDB);
        applicationContext.estudianteServiceSet = initEstudianteSetService(applicationContext.estudianteSetDAO);
        applicationContext.cursoSetDAO = initCursoSetDAO(applicationContext.setDB);
        applicationContext.cursoService = initCursoService(applicationContext.cursoSetDAO);
        applicationContext.profesorSetDAO = initProfesorSetDAO(applicationContext.setDB);
        applicationContext.profesorServiceSet = initProfesorServiceSet(applicationContext.profesorSetDAO);
        return applicationContext;
    }

    private static SetDB initSetDB() {
        // Registros de la tabla estudiante
        var juanId = new RowAttribute("id", 1);
        var juanNombre = new RowAttribute("nombre", "Juan");
        var juanApellido = new RowAttribute("apellido", "Perez");
        var juanEdad = new RowAttribute("edad", 20);
        var juanRow = new Row(new RowAttribute[]{ juanId, juanNombre, juanApellido, juanEdad });

        var mariaId = new RowAttribute("id", 3);
        var mariaNombre = new RowAttribute("nombre", "Maria");
        var mariaApellido = new RowAttribute("apellido", "Rojas");
        var mariaEdad = new RowAttribute("edad", 21);
        var mariaRow = new Row(new RowAttribute[]{ mariaId, mariaNombre, mariaApellido, mariaEdad });

        var pedroId = new RowAttribute("id", 2);
        var pedroNombre = new RowAttribute("nombre", "Pedro");
        var pedroApellido = new RowAttribute("apellido", "Infante");
        var pedroEdad = new RowAttribute("edad", 23);
        var pedroRow = new Row(new RowAttribute[]{ pedroId, pedroNombre, pedroApellido, pedroEdad });

        var raquelId = new RowAttribute("id", 10);
        var raquelNombre = new RowAttribute("nombre", "Raquel");
        var raquelApellido = new RowAttribute("apellido", "Arias");
        var raquelEdad = new RowAttribute("edad", 25);
        var raquelRow = new Row(new RowAttribute[]{ raquelId, raquelNombre, raquelApellido, raquelEdad });

        // ---------------------------------------------------------------
        // Registros de la tabla curso
        // ---------------------------------------------------------------

        var discretaId = new RowAttribute("id", 1);
        var discretaNombre = new RowAttribute("nombre", "MateDiscrta");
        var discretaCreditos = new RowAttribute("creditos", 4);
        var discretaDepartamento = new RowAttribute("departamento", "EscuelaDeMates");
        var discretaRow = new Row(new RowAttribute[]{ discretaId, discretaNombre, discretaCreditos, discretaDepartamento });

        var introID = new RowAttribute("id", 2);
        var introNombre = new RowAttribute("nombre", "IntroProgra");
        var introCreditos = new RowAttribute("creditos", 3);
        var introDepartamento = new RowAttribute("departamento", "EscuelaDeCompu");
        var introRow = new Row(new RowAttribute[]{ introID, introNombre, introCreditos, introDepartamento });

        var cdiID = new RowAttribute("id", 3);
        var cdiNombre = new RowAttribute("nombre", "CalculoDI");
        var cdiCreditos = new RowAttribute("creditos", 4);
        var cdiDepartamento = new RowAttribute("departamento", "EscuelaDeMates");
        var cdiRow = new Row(new RowAttribute[]{ cdiID, cdiNombre, cdiCreditos, cdiDepartamento });


        var fundaID = new RowAttribute("id", 4);
        var fundaNombre = new RowAttribute("nombre", "FundaProgra");
        var fundaCreditos = new RowAttribute("creditos", 4);
        var fundaDepartamento = new RowAttribute("departamento", "EscuelaDeCompu");
        var fundaRow = new Row(new RowAttribute[]{ fundaID, fundaNombre, fundaCreditos, fundaDepartamento });



        // ---------------------------------------------------------------
        // Registros de la tabla profesor
        // ---------------------------------------------------------------

        var profe1Id = new RowAttribute("id", 1);
        var profe1Nombre = new RowAttribute("nombre", "Aurelio");
        var profe1Creditos = new RowAttribute("apellido", "Sanabri");
        var profe1Departamento = new RowAttribute("ciudad", "Cartago");
        var profe1Row = new Row(new RowAttribute[]{ profe1Id, profe1Nombre, profe1Creditos, profe1Departamento });

        var profe2ID = new RowAttribute("id", 2);
        var profe2Nombre = new RowAttribute("nombre", "Arnoldo");
        var profe2Creditos = new RowAttribute("apellido", "Ramos");
        var profe2Departamento = new RowAttribute("ciudad", "Curridabat");
        var profe2Row = new Row(new RowAttribute[]{ profe2ID, profe2Nombre, profe2Creditos, profe2Departamento });

        var profe3ID = new RowAttribute("id", 3);
        var profe3Nombre = new RowAttribute("nombre", "Eddy");
        var profe3Creditos = new RowAttribute("apellido", "Ramirez");
        var profe3Departamento = new RowAttribute("ciudad", "SantoDomingo");
        var profe3Row = new Row(new RowAttribute[]{ profe3ID, profe3Nombre, profe3Creditos, profe3Departamento });

        var profe4ID = new RowAttribute("id", 4);
        var profe4Nombre = new RowAttribute("nombre", "Samanta");
        var profe4Creditos = new RowAttribute("apellido", "Ramijan");
        var profe4Departamento = new RowAttribute("ciudad", "Cartago");
        var profe4Row = new Row(new RowAttribute[]{ profe4ID, profe4Nombre, profe4Creditos, profe4Departamento });


        var tables = new HashMap<Class<? extends Entity>, Set<Row>>();
        tables.put(Estudiante.class, new HashSet<>() {{
            add(juanRow);
            add(mariaRow);
            add(pedroRow);
            add(raquelRow);
        }});

        tables.put(Curso.class, new HashSet<>() {{
            add(discretaRow);
            add(introRow);
            add(cdiRow);
            add(fundaRow);

        }})

        ;
        tables.put(Profesor.class, new HashSet<>() {{
            add(profe1Row);
            add(profe2Row);
            add(profe3Row);
            add(profe4Row);

        }});
        // Agregar las filas de curso y estudiante a tables
        // tables.put(Curso.class, new HashSet<>() {{ ... }}
        // tables.put(Profesor.class, new HashSet<>() {{ ... }}

        return new SetDB(tables);
    }

    private static EstudianteDAO initEstudianteSetDAO(SetDB setDB) {
        return new EstudianteDAOImpl(setDB, Estudiante.class);
    }

    private static EstudianteService initEstudianteSetService(EstudianteDAO estudianteDAO) {
        return new EstudianteServiceImpl(estudianteDAO);
    }

    private static CursoDAO initCursoSetDAO(SetDB setDB){
        return new CursoDAOImpl(setDB, Curso.class);
    }

    private static CursoService initCursoService(CursoDAO cursoDAO){
        return new CursoServiceImpl(cursoDAO);
    }

    private static ProfesorDAO initProfesorSetDAO(SetDB setDB){
        return new ProfesorDAOImpl(setDB, Profesor.class);
    }

    private static ProfesorService initProfesorServiceSet(ProfesorDAO profesorDAO){
        return new ProfesorServiceImpl(profesorDAO);
    }

    public SetDB getSetDB() {
        return this.setDB;
    }

    public EstudianteDAO getEstudianteSetDAO() {
        return this.estudianteSetDAO;
    }

    public EstudianteService getEstudianteServiceSet() {
        return this.estudianteServiceSet;
    }

    public CursoDAO getCursoSetDAO() {
        return this.cursoSetDAO;
    }

    public CursoService getCursoService() {
        return this.cursoService;
    }

    public ProfesorDAO getProfesorSetDAO() {
        return this.profesorSetDAO;
    }

    public ProfesorService getProfesorServiceSet() {
        return this.profesorServiceSet;
    }
}
