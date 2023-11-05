import java.util.ArrayList;
import java.util.Scanner;

// Deklarasi 
class MenuItem {
    String nama;
    int harga;

    MenuItem(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }
}

public class Menu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<MenuItem> menu = new ArrayList<>();
        menu.add(new MenuItem("Nasi Goreng", 15000));
        menu.add(new MenuItem("Mie Goreng", 17000));
        menu.add(new MenuItem("Ayam Bakar", 20000));
        menu.add(new MenuItem("Es Teh", 7000));
        menu.add(new MenuItem("Es Jeruk", 10000));
        menu.add(new MenuItem("Kopi", 8000));

        ArrayList<MenuItem> pesanan = new ArrayList<>();
        int totalHarga = 0;
        int pilihan;

        do {
            tampilkanMenu(menu);
            System.out.print("Pilih menu (0 untuk selesai): ");
            pilihan = input.nextInt();
            
            if (pilihan >= 1 && pilihan <= menu.size()) {
                pesanan.add(menu.get(pilihan - 1));
                totalHarga += menu.get(pilihan - 1).harga;
                System.out.println("Menu " + menu.get(pilihan - 1).nama + " telah ditambahkan ke pesanan.");
                System.out.println();
            } else if (pilihan != 0) {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 0);

        // Menampilkan pesanan dan total harga
        System.out.println("Pesanan Anda:");
        for (MenuItem item : pesanan) {
            System.out.println("- " + item.nama + " = Rp." + item.harga);
        }
        System.out.println("Total Harga: Rp." + totalHarga);
        System.out.println("Terima kasih telah memesan menu disini silahkan tunggu");
        System.out.println();
    }

    // Fungsi untuk menampilkan menu
    public static void tampilkanMenu(ArrayList<MenuItem> menu) {
        System.out.println("==============================");
        System.out.println("|     Menu Warung Raihan     |");
        System.out.println("==============================");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i).nama + " - Rp." + menu.get(i).harga);
        }
        System.out.println("0. Selesai");
    }
}
