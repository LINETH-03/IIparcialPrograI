package com.company;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static Scanner esc = new Scanner(System.in);
    public static int Seleccion = 0;
    public static int contc = 0, contp = 0;
    public static clientes[] listaclientes = new clientes[1];
    public static peliculas[] listapeliculas = new peliculas[1];
    public final static int x = 1;

    public static void main(String[] args) {


        //---------------------------------------------------------------------------------------------------------------------

        do {
            System.out.println("//////////////////////////////////////////////////// ");
            System.out.println("/                      NECFLIS                     /");
            System.out.println("////////////////////////////////////////////////////  \n");
            System.out.println("Bienvenido! elija entre nuestras opciones");
            System.out.println("\n 1.CLIENTES" + "\n 2.PELICULAS" + "\n 3.SALIR");
            System.out.print("Ingrese Opción: ");
            Seleccion = esc.nextInt();
            switch (Seleccion) {
                //CLIENTES-----------------------
                case 1:
                    int costumer = 0;
                    do {
                        System.out.println("\n" + "        SE ENCUENTRA EN EL PANEL DE CLIENTES");
                        System.out.println("//////////////////////////////////////////////////// ");
                        System.out.println("Ingrese una opcion...");
                        System.out.println("\n 1.Ver listado de clientes." + "\n 2.Crear nuevo cliente" + "\n 3.seleccionar cliente" + "\n 4.Atras" + "\n");
                        costumer = esc.nextInt();
                        switch (costumer) {
                            case 1:
                                System.out.println("LISTADO DE CLIENTES");
                                mostrarlistc();
                                break;
                            case 2:
                                System.out.println("INGRESE LOS DATOS DEL CLIENTE");
                                llenarcliente();
                                listaclientes = incrementarlistc(listaclientes);


                                break;
                            case 3:
                                System.out.println("SELECCIONE EL CLIENTE QUE DESEA OBSERVAR");
                                //PLALIST DEL CLIENTE
                                int OB = 0;
                                do {

                                    System.out.println("\n 1.PLAYLIST" + "\n 2.AGREGAR PELICULA" + "\n 3.ATRAS");
                                    System.out.print("Ingrese Opción: ");
                                    OB = esc.nextInt();
                                    switch (OB) {
                                        case 1:
                                            System.out.println("PLAYLIST");

                                            break;
                                        case 2:
                                            System.out.println("AGREGAR PELICULA");

                                            break;
                                        default:
                                            System.out.println("Volviendo atras..." + "\n");
                                    }

                                } while (OB != 3);
                                break;
                            default:
                                System.out.println("Volveviendo Atras..." + "\n");
                        }

                    } while (costumer < 4);
                    break;
                //peliculas---------------------------------------------------------------------------------------------------------------
                case 2:
                    int pelis = 0;
                    System.out.println("\n" + "    SE ENCUENTRA EN EL PANEL DE PELICULAS");
                    System.out.println("//////////////////////////////////////////////////// ");
                    do {
                        System.out.println("\n 1.VER LISTADO DE PELICULAS." + "\n 2. CREAR PELICULA." + "\n 3.ATRAS.");
                        System.out.print("Ingrese Opción: ");
                        pelis = esc.nextInt();
                        switch (pelis) {
                            case 1:
                                System.out.println("LISTADO DE PELICULAS.");
                                mostrarlistp();
                                break;
                            case 2:
                                System.out.println("CREE NUEVA PELICULA.");
                                llenarpeliculas();
                                listapeliculas = incrementarlistp(listapeliculas);

                                break;
                            default:
                                System.out.println("Volviendo atrás..." + "\n");
                        }
                    } while (pelis != 3);
            }
        } while (Seleccion != 3);
    }
    //case 1 clientes---------------------------------------------------------------------------------------------------------------------
    //case 2 ingresar datos del cliente
    public static void llenarcliente() {
        esc.nextLine();
        System.out.println("INGRESE NOMBRE:");
        String nombre = esc.nextLine();
        System.out.println("INGRESE DIRECCION:");
        String direccion = esc.nextLine();
        System.out.println("INGRESE EDAD:");
        int edad = esc.nextInt();
        System.out.println("\n Se ha agregado el nuevo cliente...");
        clientes Lclientes = new clientes(nombre, direccion, edad);
        listaclientes[contc] = Lclientes;
        contc++;
    }

    // case 1 imprimir lista
    public static void mostrarlistc() {
        if (contc == 0) {
            System.out.println("No hay clientes en la lista");
        } else {
            for (int i = 0; i < listaclientes.length - 1; i++) {
                clientes Lclientes = listaclientes[i];
                System.out.println(i + 1 + ". Nombre: " + Lclientes.nombre + "  Direccion : " + Lclientes.direccion + "    Edad: " + Lclientes.edad);
            }
        }

    }

    //aumentar listaclientes
    public static clientes[] incrementarlistc(clientes[] listaclientes) {
        clientes[] listaclientesredim = new clientes[listaclientes.length + x];
        System.arraycopy(listaclientes, 0, listaclientesredim, 0, listaclientes.length);
        return listaclientesredim;

    }
    // case 2 Peliculas------------------------------------------------------------------------------------------------------------
    public static void llenarpeliculas() {
        esc.nextLine();
        System.out.println("INGRESE NOMBRE:");
        String nombrep = esc.nextLine();
        System.out.println("INGRESE TIPO(Serie/Pelicula):");
        String tipo = esc.nextLine();
        System.out.println("INGRESE GENERO(Drama, Comedia, Terror, Suspenso):");
        String genero = esc.nextLine();
        System.out.println("INGRESE SINOPSIS(Resumen):");
        String sinopsis = esc.nextLine();
        System.out.println("\n Se ha agregado nueva pelicula...");
        peliculas Lpeliculas = new peliculas(nombrep, tipo, genero, sinopsis);
        listapeliculas[contp] = Lpeliculas;
        contp++;


    }

    public static void mostrarlistp() {
        if (contp == 0) {
            System.out.println("No hay peliculas en la lista");
        } else {
            for (int i = 0; i < listapeliculas.length - 1; i++) {
                peliculas Lpeliculas = listapeliculas[i];
                System.out.println(i + 1 + ". Nombre: " + Lpeliculas.nombrep + "  Tipo:  " + Lpeliculas.tipo + "    Género: " + Lpeliculas.genero+"    sinopsis: "+Lpeliculas.sinopsis);
            }
        }

    }

    public static peliculas[] incrementarlistp(peliculas[] listapeliculas){
        peliculas [] listapeliculasredim = new peliculas[listapeliculas.length + x];
        System.arraycopy(listapeliculas, 0, listapeliculasredim, 0, listapeliculas.length);
        return listapeliculasredim;
    }






}
