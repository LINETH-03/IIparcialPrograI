package com.company;
import java.util.Scanner;

public class Main {
    public static Scanner esc = new Scanner(System.in);
    public static int Seleccion = 0;
    public static int contc = 0, contp = 0,clsel=0,elpe=0;
    public static clientes[] listaclientes = new clientes[1];
    public static peliculas[] listapeliculas = new peliculas[1];
    public static String[] red = new String[1];
    public static int[] cont1 = new int [1];
    public final static int x = 1;
    public static int inc=0;
    public static clientes Lclientes;


    public static void main(String[] args) {
        //menu pricipal---------------------------------------------------------------------------------------------------------------------
        do {
            System.out.println("//////////////////////////////////////////////////// ");
            System.out.println("/                      NECFLIS                     /");
            System.out.println("////////////////////////////////////////////////////  \n");
            System.out.println("Bienvenido! elija entre nuestras opciones");
            System.out.println("\n 1.CLIENTES" + "\n 2.PELICULAS" + "\n 3.SALIR");
            System.out.print("Ingrese Opción: ");
            Seleccion = esc.nextInt();
            switch (Seleccion) {
          //menu clientes------------------------------------------------------------------------------
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
                                System.out.println("LISTADO DE CLIENTES"+"\n");
                                mostrarlistc();
                                break;
                            case 2:
                                System.out.println("INGRESE LOS DATOS DEL CLIENTE"+"\n");
                                llenarcliente();





                                break;
                            case 3:
                                System.out.println("SELECCIONE EL CLIENTE QUE DESEA OBSERVAR");
                                casee();
                                int OB = 0;
                                do {

                                    System.out.println("\n 1.PLAYLIST" + "\n 2.AGREGAR PELICULA" + "\n 3.ATRAS");
                                    System.out.print("Ingrese Opción: ");
                                    OB = esc.nextInt();
                                    switch (OB) {
                                        case 1:
                                            System.out.println("PLAYLIST");
                                            playlisclient();


                                            break;
                                        case 2:
                                            System.out.println("AGREGAR PELICULA");
                                            ingresar();

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
                        System.out.print("Ingrese Opción: "+"\n");
                        pelis = esc.nextInt();
                        switch (pelis) {
                            case 1:
                                System.out.println( "\n"+"LISTADO DE PELICULAS.");
                                mostrarlistp();
                                break;
                            case 2:
                                System.out.println( "\n"+"CREE NUEVA PELICULA."+ "\n");
                                llenarpeliculas();


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
        listaclientes = incrementarlistc(listaclientes);


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


    public static void playlisclient(){
        if(cont1[clsel-1] == 0){

            System.out.println("No hay peliculas en la Playlist de "+ Lclientes.nombre);

        }else{

            clientes Lclientes = listaclientes[clsel - 1];
            System.out.println("Playlist de "+ Lclientes.nombre);
            System.out.println("-"+red[clsel-1]);

        }
    }

    public static void ingresar(){
        esc.nextLine();
        if(contp == 0){

            System.out.println("Aún no se registran peliculas");

        }else{

            for (int i = 0; i < listapeliculas.length-1; i++) {
                peliculas Lpeliculas = listapeliculas[i];
                System.out.println(i+1+"   "+Lpeliculas.nombrep);
            }

            System.out.println("INGRESE NUMERO DE PELICULA");
            elpe = esc.nextInt();

            while(elpe > listapeliculas.length){

                System.out.println("NO EXISTE OPCION");
                System.out.println("INGRESE NUMERO DE PELICULA");
                elpe = esc.nextInt();

            }
            cont1[clsel-1] += 1;
            peliculas Lpeliculas = listapeliculas[elpe-1];
            red[clsel-1] += Lpeliculas.nombrep+"\n";
            inc++;

        }
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
        listapeliculas = incrementarlistp(listapeliculas);
    }

    public static void mostrarlistp() {
        if (contp == 0) {
            System.out.println("La lista esta vacia");
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

    public static String [] arregloex(String[] red){
        String [] cop = new String[red.length + x];
        System.arraycopy(red, 0, cop, 0, red.length);
        return cop;
    }

    public static int [] arreglox(int[] cont1){
        int [] redmi = new int[cont1.length + x];
        System.arraycopy(cont1, 0, redmi, 0, cont1.length);
        return redmi;
    }

    public static void casee() {
        if (contc == 0) {

            System.out.println("No hay clientes registrados");

        } else {

            for (int i = 0; i < listaclientes.length - 1; i++) {
                Lclientes = listaclientes[i];
                System.out.println(i + 1 + "--" + Lclientes.nombre);
            }
            System.out.println("SELECCIONE CLIENTE: ");
            clsel = esc.nextInt();
            while (clsel > listaclientes.length) {
                System.out.println("NO EXISTE ESE NUMERO DE PELICULA");
                System.out.println("SELECCIONE CLIENTE: ");
                clsel = esc.nextInt();

            }
        }
    }


}
