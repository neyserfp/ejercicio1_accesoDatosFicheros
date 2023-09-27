package com.neyser;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Metodos {
    static Scanner sc1 = new Scanner(System.in);

    public Metodos() {
    }

    public void menu() throws IOException {

        limpiarPantalla();

        System.out.println("Selecciona alguna de las opciones a ejecutar");
        System.out.println("1. Crear Directorio\n" +
                "2. Crear Directorios\n" +
                "3. Crear Fichero\n" +
                "4. Escribir Fichero 1 (write)\n" +
                "5. Escribir Fichero 2 (BufferedWriter)\n" +
                "6. Leer Fichero 1 (Scanner)\n" +
                "7. Leer Fichero 2 (BufferedReader)\n" +
                "8. Información de Fichero\n" +
                "9. Eliminar Fichero\n" +
                "0. Cerrar Programa");

        String opcion = sc1.nextLine();

        switch (opcion)
        {
            case "1":
                crearDirectorio();
                break;
            case "2":
                crearDirectorios();
                break;
            case "3":
                crearFichero();
                break;
            case "4":
                escribirFichero1();
                break;
            case "5":
                escribirFichero2();
                break;
            case "6":
                leerFichero1();
                break;
            case "7":
                leerFichero2();
                break;
            case "8":
                datosSobreFichero();
                break;
            case "9":
                eliminarFichero();
                break;
            case "0":
                System.exit(0);
            default:
                limpiarPantalla();
                System.out.println("Debe seleccionar una opción válida");

        }

    }

    public void crearDirectorio() throws IOException
    {
        System.out.println("Escriba el nombre del directorio");
        String directorio = sc1.nextLine();

        File dir1 = new File(directorio);

        if (dir1.mkdir())
        {
            System.out.println("El directorio SI ha sido creado");
        } else
        {
            System.out.println("El directorio NO ha sido creado");
        }

        menu();

    }

    public void crearDirectorios() throws IOException
    {

        System.out.println("Escriba el nombre del directorio padre");
        String directorioPadre = sc1.nextLine();

        System.out.println("Escriba el nombre del directorio hijo");
        String directorioHijo = sc1.nextLine();

        File dir2 = new File(directorioPadre+"/"+directorioHijo);

        if (dir2.mkdirs())
        {
            System.out.println("Los directorios han sido creados");
        } else
        {
            System.out.println("Los directorios NO han sido creados");
        }

        menu();

    }

    public void crearFichero() throws IOException
    {
        File dir1 = new File("Ejemplo");
        dir1.mkdir();

        System.out.println("Escriba el nombre del fichero");
        String fichero = sc1.nextLine();

        File file1 = new File("Ejemplo/"+fichero);

        try
        {
            if (file1.createNewFile())
            {
                System.out.println("El fichero ha sido creado");
            } else
            {
                System.out.println("El fichero NO ha sido creado");
            }
        } catch (IOException e)
        {
            System.out.println("Error, no se pudo crear el fichero "+e.getMessage());
            e.printStackTrace();
        }
        menu();

    }

    public void escribirFichero1() throws IOException
    {
        File dir1 = new File("Ejemplo2");
        dir1.mkdir();

        File file1 = new File("Ejemplo2/demo.txt");
        file1.createNewFile();

        FileWriter fileWriter1 = new FileWriter(file1, false);
        fileWriter1.write("Línea 1\n");
        fileWriter1.write("Línea 2\n");
        fileWriter1.write("Línea 3\n");

        fileWriter1.close();
        System.out.println("Se ha escrito en el fichero");

        menu();

    }

    public void escribirFichero2() throws IOException
    {
        File dir1 = new File("Ejemplo3");
        dir1.mkdir();

        File file1 = new File("Ejemplo3/demo2.txt");
        file1.createNewFile();

        FileWriter fileWriter1 = new FileWriter(file1, false);
        BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter1);

        bufferedWriter1.write("Línea 1\n");
        bufferedWriter1.write("Línea 2\n");
        bufferedWriter1.write("Línea 3");
        bufferedWriter1.close();
        System.out.println("Se ha escrito en el fichero");

        menu();

    }

    public void leerFichero1() throws IOException
    {

        File dir1 = new File("Ejemplo4");
        dir1.mkdir();

        File file1 = new File("Ejemplo4/demo4.txt");
        file1.createNewFile();

        FileWriter fileWriter1 = new FileWriter(file1, false);
        BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter1);

        bufferedWriter1.write("Línea demo 1\n");
        bufferedWriter1.write("Línea demo 2\n");
        bufferedWriter1.close();

        try
        {
            Scanner scanner1 = new Scanner(file1);
            while (scanner1.hasNextLine())
            {
                String datosLeidos1 = scanner1.nextLine();
                System.out.println(datosLeidos1);
            }
            scanner1.close();

        } catch (IOException e)
        {
            System.out.println("NO SE HA PODIDO LEER EN EL FICHERO");

            e.printStackTrace();
        }
        menu();

    }

    public void leerFichero2() throws IOException
    {

        File dir1 = new File("Ejemplo5");
        dir1.mkdir();

        File file1 = new File("Ejemplo5/demo4.txt");
        file1.createNewFile();

        FileWriter fileWriter1 = new FileWriter(file1, false);
        BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter1);

        bufferedWriter1.write("Línea demo4 1\n");
        bufferedWriter1.write("Línea demo4 2\n");
        bufferedWriter1.close();

        try
        {
            FileReader fileReader1 = new FileReader(file1);
            BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
            String strCurrentLine;
            while ((strCurrentLine=bufferedReader1.readLine()) != null)
            {
                System.out.println(strCurrentLine);
            }

            if (fileReader1 != null)
            {
                fileReader1.close();
            }

        } catch (FileNotFoundException e1)
        {
            e1.printStackTrace();
        } catch (IOException e2)
        {
            e2.printStackTrace();
        }
    }

    public void datosSobreFichero() throws IOException {

        /*
        File dir1 = new File("carpetaDatos1");
        File file1 = new File("carpetaDatos1/datos1.txt");
        dir1.mkdirs();
        file1.createNewFile();

        */


            /*
            System.out.println("Nombre del fichero:" +file1.getName());
            System.out.println("Ruta Absoluta: "+file1.getAbsolutePath());
            System.out.println("Ruta Relativa: "+file1.getPath());
            System.out.println("Fichero editable: "+file1.canWrite());
            System.out.println("Fichero leible: "+file1.canRead());
            System.out.println("Tamaño del fichero(bytes): "+file1.length());
            // Nombre de directorios y ficheros
            File file2 = new File("carpetaDatos1");

             */

            File file2 = new File("./");
            String[] pathnames;
            pathnames = file2.list();

            for (String pathname: pathnames) {
                System.out.println("Nombre de fichero: "+pathname);
            }

    }

    public void eliminarFichero()
    {
        File file1 = new File("carpetaDatos1/datos1.txt");

        /*
        File file2 = new File("carpetaDatos1");
        File file3 = new File("carpetaDatos1/datos1.txt");
        file2.mkdir();
        file3.createNewFile();
         */

        if (file1.delete())
        {
            System.out.println("El fichero ha sido eliminado");
        } else{
            System.out.println("El fichero NO ha sido eliminado");
        }

    }


    public static void limpiarPantalla() {

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }


    }
}
