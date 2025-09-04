import accidentes.Carro;
import accidentes.Dueno;
import accidentes.Incidente;
import accidentes.Marca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static void lista() {
        System.out.println("----Ingrese una opción----");
        System.out.println("1. Ver cual es la marca más vendida");
        System.out.println("2. Marca de carro con más incidentes");
        System.out.println("3. Pais de origen más común y cuántos carros tiene");
        System.out.println("4. Incidentes de cada dueño");
        System.out.println("5. Registrar una marca");//marca
        System.out.println("6. Registrar un carro");//carro y carro marca
        System.out.println("7. Registrar una persona");//persona
        System.out.println("8. Comprar un carro (carro-persona)");//incidente persona carro
        System.out.println("9. Registrar un incidente"); //relacionar carro persona
        System.out.println("0. Chao 👋🗿");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Marca> marcas = new ArrayList<>();
        ArrayList<Carro> carros = new ArrayList<>();
        ArrayList<Dueno> duenos = new ArrayList<>();
        ArrayList<Incidente> incidentes = new ArrayList<>();

        Marca m1 = new Marca(1, "Jeep", "USA");
        Marca m2 = new Marca(2, "Ford", "USA");
        Marca m3 = new Marca(3, "Toyota", "Japón");
        Marca m4 = new Marca(4, "Renault", "Frances");
        marcas.add(m1);
        marcas.add(m2);
        marcas.add(m3);
        marcas.add(m4);

        Carro c1 = new Carro("ABC123", "Raptor", 2020);
        Carro c2 = new Carro("MJS181", "Wrangler", 2022);
        Carro c3 = new Carro("CNE573", "Prado", 2023);
        Carro c4 = new Carro("ANR395", "Rubicon", 2022);
        Carro c5 = new Carro("NHW914", "Koleos", 2021);
        Carro c6 = new Carro("LFD215", "Arkana", 2023);
        Carro c7 = new Carro("MEW383", "Sahara", 2024);

        c1.setMarca(m2);
        c2.setMarca(m1);
        c3.setMarca(m3);
        c4.setMarca(m1);
        c5.setMarca(m4);
        c6.setMarca(m4);
        c7.setMarca(m1);

        carros.add(c1);
        carros.add(c2);
        carros.add(c3);
        carros.add(c4);
        carros.add(c5);
        carros.add(c6);
        carros.add(c7);

        Dueno d1 = new Dueno(123, "Mao", "Sosa", "1234");
        Dueno d2 = new Dueno(456, "Pepito", "Perez", "5678");
        Dueno d3 = new Dueno(789, "Alejo", "Meowl", "911");
        Dueno d4 = new Dueno(666, "Profe Sebas", "Pone 5", "999");

        duenos.add(d1);
        duenos.add(d2);
        duenos.add(d3);
        duenos.add(d4);

        Incidente i1 = new Incidente(1, "Choque", "2025-01-17", "123");
        Incidente i2 = new Incidente(2, "Falla mecánica", "2025-10-18", "345");
        Incidente i3 = new Incidente(3, "Explosión", "2025-09-03", "45678");
        Incidente i4 = new Incidente(4, "No le puso 5 a Majo", "2025-09-03", "2347238");
        Incidente i5 = new Incidente(5, "Perder POO", "2024-03-04", "123");

        incidentes.add(i1);
        incidentes.add(i2);
        incidentes.add(i3);
        incidentes.add(i4);
        incidentes.add(i5);

        d1.vincularCarro(c4);
        d1.vincularCarro(c2);
        d3.vincularCarro(c3);
        d2.vincularCarro(c1);
        d3.vincularCarro(c5);
        d4.vincularCarro(c6);
        d1.vincularCarro(c7);

        d1.agregarIncidente(i3);
        d3.agregarIncidente(i1);
        d2.agregarIncidente(i2);
        d3.agregarIncidente(i5);
        d4.agregarIncidente(i4);

//        System.out.println(marcas);
//        System.out.println(carros);
//        System.out.println(incidentes);
//        System.out.println(duenos);

        System.out.println("------Sistema de ver que tan mal conductor eres------");
        lista();
        int opcion = Integer.parseInt(sc.nextLine());
        while (true) {
            switch (opcion) {
                case 1: //Marca más vendida
                    int contadorMarca = 0;
                    int maxMarca = 0;
                    Marca marcaMasVendida = marcas.getFirst();
                    for (Marca marca : marcas) {
                        for (Carro carro : carros) {
                            if (marca.getNombre().equals(carro.getMarca().getNombre())) {
                                contadorMarca++;
                            }
                        }
                        if (contadorMarca > maxMarca) {
                            maxMarca = contadorMarca;
                            marcaMasVendida = marca;
                        }
                        contadorMarca = 0;
                    }
                    System.out.println("La marca más vendida es: " + marcaMasVendida.getNombre());
                    break;
                case 2: //Marca con más incidentes
                    //toDo fakin cosa
                    int numIncidentes;
                    int maxIncidente = 0;
                    Marca marcaIncidente = marcas.getFirst();
                    for (int i = 0; i < marcas.size(); i++) {
                        for (int j = 0; j < carros.size(); j++) {
                            for (int k = 0; k < duenos.size(); k++) {
                                numIncidentes = marcas.get(i).getCarros().get(j).getDuenos().get(k).getIncidentes().size();

                                if (numIncidentes > maxIncidente) {
                                    maxIncidente = numIncidentes;
                                    marcaIncidente = marcas.get(i);
                                }
                            }
                        }
                    }
                    System.out.println("La marca con más incidentes es: " + marcaIncidente.getNombre());
                    break;
                case 3: //Pais de origen más común y cantidad
                    int contadorPais = 0;
                    int paisMarca = 0;
                    Marca paisMarcaPrincipal = marcas.getFirst();
                    for (Marca marca : marcas) {
                        for (Carro carro : carros) {
                            if (marca.getPais().equals(carro.getMarca().getPais())) {
                                contadorPais++;
                            }
                        }
                        if (contadorPais > paisMarca) {
                            paisMarca = contadorPais;
                            paisMarcaPrincipal = marca;
                        }
                        contadorPais = 0;
                    }
                    System.out.println("El pais de origen más común es: " + paisMarcaPrincipal.getPais() + " con " + paisMarca + " modelos");
                    break;
                case 4: //Incidentes de cada dueño
                    for (Dueno dueno : duenos) {
                        System.out.println(dueno.getNombre() + ": ");
                        System.out.println(dueno.mostrarIncidentes());
                    }
                    break;
                case 5: //marca
                    break;
                case 6: //carromarca
                    break;
                case 7: //persona
                    break;
                case 8: //persona carro
                    break;
                case 9: //incidente persona carro
                    break;
                case 0: //chao
                    System.out.println("Chao con adiós 👋");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Coloque bien la opción, bobote");

                    break;
            }
            System.out.println("--------------------------");
            lista();
            opcion = Integer.parseInt(sc.nextLine());
        }

        //cosa
    }
}
