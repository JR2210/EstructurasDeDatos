
public class Prueba {
    public static void main (String [] args) {
        Persona juan = new Persona("Juan Nadie","111111","");
        Persona jose = new Persona("Jose Cuervo","222222","");
        Persona eva = new Persona("Eva Adan","333333","");
        Persona alicia = new Persona("Alicia Maravillas","777777","");
        Persona alan_turing = new Persona("Alan Turing","999999","");
        Persona guillermo = new Persona("Guillermo Tell","159267","");
        Persona julio = new Persona("Julio Catedrales","123456","");
        Persona lucas = new Persona("Lucas Pato","231465","");
        Persona paula = new Persona("Paula Vázquez","654321","");
        Persona clara = new Persona("Clara Oscuro","123654","");

        Persona [] grupos = {juan,jose,eva,alicia,alan_turing,guillermo,julio,lucas,paula,clara};
        AmigosETSISI amigos= new AmigosETSISI(grupos.length, grupos);


        amigos.insertaRelacion(0,1);
        amigos.insertaRelacion(0,3);
        amigos.insertaRelacion(0,4);
        amigos.insertaRelacion(0,5);
        amigos.insertaRelacion(1,4);
        amigos.insertaRelacion(4,5);

        amigos.insertaRelacion(2,7);
        amigos.insertaRelacion(2,9);
        amigos.insertaRelacion(7,9);

        amigos.insertaRelacion(6,8);

        System.out.println("Existen "+amigos.contarGrupos()+ " grupos");
        amigos.mostrarAmigos("Eva Adan");
        System.out.println("¿Lucas y Juan son del mismo grupo?:"+amigos.sonDelMismoGrupo(lucas,juan));
        System.out.println("¿Jose y Guillermo son del mismo grupo?:"+amigos.sonDelMismoGrupo(jose,guillermo));
        System.out.print("Los miembros del grupo de juan son: ");
        amigos.mostrarMiembrosGrupo(juan);
        amigos.mostrarRed();
    }
}
