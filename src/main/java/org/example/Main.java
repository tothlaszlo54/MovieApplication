package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Movie movie1 = new Movie("Trónok harca", "action", 44);
        Movie movie2 = new Movie("Titanic", "adventure", 55);
        Movie movie3 = new Movie("Hair", "horror", 54);

        List<Movie> movieList1 = new ArrayList<>();
        movieList1.add(movie1);
        movieList1.add(movie2);
        movieList1.add(movie3);


        Room room1 = new Room("room1", 100, movieList1);
        Room room2 = new Room("room2", 150, movieList1);
        Room room3 = new Room("room3", 200, movieList1);


        List<Room> roomList = new ArrayList<>();
        roomList.add(room1);
        roomList.add(room2);
        roomList.add(room3);

        Screening screening1 = new Screening("Trónok harca", "room1", LocalDateTime.of(2023, 1, 2, 9, 0));
        Screening screening2 = new Screening("Titanic", "room1", LocalDateTime.of(2023, 1, 2, 10, 0));
        Screening screening3 = new Screening("Hair", "room1", LocalDateTime.of(2023, 1, 2, 10, 30));


        MovieApplication movieApplication = new MovieApplication(roomList, movieList1);


        Screening screening;
        List<Screening> screeningList = new ArrayList<>();

        System.out.println("Üdvözlöm!");
        System.out.print("Kérem adja meg a nevét!: ");
        String guestName = scanner.nextLine();
        System.out.println("Kedves " + guestName + " Az alábbi funkciók állnak az Ön rendelkezésére:");
        System.out.println("exit => bármikor kilép");
        System.out.println("uploading => Egy vetítés feltöltése");
        System.out.println("listing => Vetítések feltöltésének befejezése");

        String parancs;

        while (true) {
            parancs=scanner.nextLine();
            if("exit".equals(parancs)){
                System.exit(0);
            }

            if ("uploading".equals(parancs)) {
                System.out.print("Adja meg a mozi címét: ");
                String movieTitle = scanner.nextLine();
                System.out.print("Adja meg a mozi termének a nevét: ");
                String roomName = scanner.nextLine();
                System.out.println("Adja meg a mozi kezdő időpontját: ");
                System.out.println("év: ");
                int year = Integer.parseInt(scanner.nextLine());
                System.out.println("hónap: ");
                int month = Integer.parseInt(scanner.nextLine());
                System.out.println("nap: ");
                int day = Integer.parseInt(scanner.nextLine());
                System.out.println("óra: ");
                int hour = Integer.parseInt(scanner.nextLine());
                System.out.println("perc: ");
                int minute = Integer.parseInt(scanner.nextLine());

                screening = new Screening(movieTitle, roomName, LocalDateTime.of(year, month, day, hour, minute));
                screeningList.add(screening);

                System.out.println("A megadott vetítés adatai: (" + movieTitle + ", " + roomName + ", " + year + ", " + month + ", " + day + ", " + hour + ", " + minute + ")");
            }

            if ("listing".equals(parancs)) {
                for (Screening actualScreening : screeningList) {

                    System.out.println(actualScreening.toString());

                }
            }


        }

    }
}
//bekéri a nevemet és üdvözöljön induláskor, aztán informáljon arról, hogy milyen parancsokat használhatok ("exit"= bármikor kilép; uploading nevű parancs esetén
// elkezdhetem feltölteni a vetítéseket (vagyis elkezdi kérdezni, hogy mi a címe sstb)-> ha végeztem egy feltöltéssel, akkor írja ki az előbb feltöltött screeninget tömören)
//listing parancs az, hogy nem akarok több kitöltést csinálni --> írja ki, hogy miket töltöttem fel eddig.