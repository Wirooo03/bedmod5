package Penerapan;

import java.util.*;

public class SiswaManager {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 1. Array 1D: daftar nama siswa
        String[] namaSiswa = {"Wira", "Umam", "Yanto"};

        // 2. Array 2D: nilai ujian (3 siswa x 2 ujian)
        int[][] nilaiUjian = {
                {80, 90},
                {70, 75},
                {85, 95}
        };

        // 3. ArrayList multidimensi: daftar nilai per siswa
        ArrayList<ArrayList<Integer>> daftarNilai = new ArrayList<>();
        for (int i = 0; i < namaSiswa.length; i++) {
            daftarNilai.add(new ArrayList<>());
            for (int j = 0; j < nilaiUjian[i].length; j++) {
                daftarNilai.get(i).add(nilaiUjian[i][j]);
            }
        }

        // 4. Iterator: menampilkan semua nilai
        System.out.println("=== Nilai Ujian ===");
        for (int i = 0; i < namaSiswa.length; i++) {
            System.out.print(namaSiswa[i] + ": ");
            Iterator<Integer> itr = daftarNilai.get(i).iterator();
            while (itr.hasNext()) {
                System.out.print(itr.next() + " ");
            }
            System.out.println();
        }

        // 5. ListIterator: ubah nilai (misalnya menambahkan bonus nilai)
        System.out.println("\n=== Tambah bonus 5 poin pada semua nilai ===");
        for (ArrayList<Integer> nilai : daftarNilai) {
            ListIterator<Integer> listItr = nilai.listIterator();
            while (listItr.hasNext()) {
                int nilaiAwal = listItr.next();
                listItr.set(nilaiAwal + 5);
            }
        }

        // Cetak lagi
        for (int i = 0; i < namaSiswa.length; i++) {
            System.out.print(namaSiswa[i] + ": ");
            System.out.println(daftarNilai.get(i));
        }

        // 6. Wrapper Class: mengonversi input string jadi integer (autoboxing)
        try {
            System.out.print("\nMasukkan nilai ujian baru (0-100): ");
            String inputNilai = input.nextLine();
            Integer nilaiBaru = Integer.parseInt(inputNilai); // Wrapper

            // 7. Throw custom exception kalau nilai tidak valid
            if (nilaiBaru < 0 || nilaiBaru > 100) {
                throw new InvalidScoreException("Nilai harus antara 0-100.");
            }

            daftarNilai.get(0).add(nilaiBaru);
            System.out.println("Nilai baru ditambahkan ke " + namaSiswa[0]);

        } catch (InvalidScoreException e) {
            System.out.println("❌ ERROR: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("❌ ERROR: Input harus angka!");
        } finally {
            System.out.println("=== Program selesai (blok finally dieksekusi) ===");
        }
    }
}
