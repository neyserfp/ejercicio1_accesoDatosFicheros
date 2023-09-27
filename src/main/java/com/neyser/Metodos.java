package com.neyser;

import java.io.*;
import java.util.Scanner;

public class Metodos {
    static Scanner sc1 = new Scanner(System.in);

    public Metodos() {
    }

    public void menu() throws IOException {


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
                System.out.println("Debe seleccionar una opción vàlida");

        }

    }

    public void crearDirectorio() throws IOException {
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

    public void crearDirectorios()
    {
        File file2 = new File("./carpetaDatos1/carpetaDatos2");

        if (file2.mkdirs())
        {
            System.out.println("El directorio ha sido creado");
        } else
        {
            System.out.println("El directorio no ha sido creado");
        }

    }

    public void crearFichero() {
        File file1 = new File("carpetaDatos1/datos1.txt");

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

    }

    public void escribirFichero1()
    {



    }

    public void escribirFichero2() throws IOException {
        // Creamos un objeto que permita escribir en un fichero
        // FileWriter: false, sobreescribe datos
        // FileWriter: true, añadir datos


        FileWriter fileWriter1 = new FileWriter("carpetaDatos1/datos1.txt", false);
        BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter1);

        bufferedWriter1.write("Línea 1\n");
        bufferedWriter1.write("Línea 2\n");
        bufferedWriter1.write("Línea 3");
        bufferedWriter1.close();
        System.out.println("Se ha escrito en el fichero");

    }

    public void leerFichero1()
    {
        //File file1 = new File("carpetaDatos1");
        File file1 = new File("carpetaDatos1/datos1.txt");

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

    }

    public void leerFichero2()
    {
        File file1 = new File("carpetaDatos1/datos1.txt");

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

        File dir1 = new File("carpetaDatos1");
        File file1 = new File("carpetaDatos1/datos1.txt");
        dir1.mkdirs();
        file1.createNewFile();

        if (file1.exists())
        {
            System.out.println("Nombre del fichero:" +file1.getName());
            System.out.println("Ruta Absoluta: "+file1.getAbsolutePath());
            System.out.println("Ruta Relativa: "+file1.getPath());
            System.out.println("Fichero editable: "+file1.canWrite());
            System.out.println("Fichero leible: "+file1.canRead());
            System.out.println("Tamaño del fichero(bytes): "+file1.length());
            // Nombre de directorios y ficheros
            File file2 = new File("carpetaDatos1");

            String[] pathnames;
            pathnames = file2.list();

            for (String pathname: pathnames) {
                System.out.println("Nombre de fichero: "+pathname);
            }

        }

    }

    public void eliminarFichero()
    {

    }
}
