import java.util.Scanner;

public class GajiPokok {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String kota, jabatan;
        int lama;
        boolean status;

        kota = input.nextLine();
        jabatan = input.nextLine();
        lama = input.nextInt();
        status = input.nextBoolean();

        int gaji = UMK(kota);
        int gajipokok = GajiPokok(jabatan, lama, gaji);
        int tj = tunjanganJabatan(lama, gajipokok);
        int tp = tunjanganPegawai(jabatan)+tunjanganKeluarga(status, gajipokok)+tj;
        int gajikotor = GajiKotor(gajipokok, tp);
        int PotonganPensiun = PotonganPensiun(gajikotor);
        int PotonganBPJS = PotonganBPJS(gajikotor);
        int PotonganPPH = PotonganPPH(gajikotor);

        System.out.println(gajipokok);
        System.out.println(tunjanganKeluarga(status, gajipokok));
        System.out.println(tj);
        System.out.println(tunjanganPegawai(jabatan));
        // System.out.println(tp);
        System.out.println(gajikotor);
        System.out.println(PotonganPensiun);
        System.out.println(PotonganBPJS);
        System.out.println(PotonganPPH);
        System.out.println(gajibersih(gajikotor, PotonganBPJS, PotonganPensiun, PotonganPPH));
    }

    public static int UMK(String kota) {
        int umk=0;
        switch (kota) {
            case "Garut":
                umk = 1961085;
                break;
            case "Bandung":
                umk = 3742276;
                break;
            case "Jakarta":
                umk = 4453935;
                break;
            case "Bekasi":
                umk = 4782935;
                break;
            case "Bogor":
                umk = 4330249;
                break;
            case "Palembang":
                umk = 3289409;
                break;
            default:
                break;
        }

        return umk;
    }
    public static int GajiPokok(String jabatan, int lama, int gaji) {
        int gajipokok = 0;
        if (jabatan.equals("Admin")) {  
            if (lama < 2) {
                gajipokok = gaji;
            } else {
                gajipokok = (int) (1.2 * gaji);  
            }
        } else if (jabatan.equals("Coordinator")) {
            if (lama < 3) {
                gajipokok = (int) (1.1 * gaji);  
            } else {
                gajipokok = (int) (1.3 * gaji);  
            }
        } else if (jabatan.equals("SPV")) {
            if (lama < 2) {
                gajipokok = (int) (1.25 * gaji); 
            } else if (lama >= 2 && lama <= 4) {
                gajipokok = (int) (1.4 * gaji);  
            } else if (lama > 4) {
                gajipokok = (int) (1.5 * gaji);  
            }
        } else if (jabatan.equals("Manager")) {
            if (lama < 3) {
                gajipokok = (int) (1.5 * gaji); 
            } else {
                gajipokok = 2 * gaji;
            }
        } else if (jabatan.equals("Sprinter")) {
            gajipokok = (int) (0.9 * gaji);  
        } else if (jabatan.equals("Officer")) {
            gajipokok = gaji;
        }
    
        return gajipokok;
    }

    public static int tunjanganJabatan(int lama, int gajipokok) {
        int tj=0;
        if (lama>4) {
            tj = (int) (0.05*gajipokok);
        }
        return tj;
    }

    public static int tunjanganKeluarga(Boolean status, int gajipokok) {
        int tK=0;
        if (status) {
            tK = (int)(0.1*gajipokok);
        } 
        return tK;
    }

    public static int tunjanganPegawai(String jabatan) {
        int tP=0;
        if (jabatan.equals("Admin")) {
            tP=200000;
        } else if(jabatan.equals("Coordinator")){
            tP=500000;
        }else if(jabatan.equals("SPV")){
            tP=700000;
        }else if(jabatan.equals("Manager")){
            tP=1000000;
        }else if(jabatan.equals("Sprinter")){
            tP=200000;
        }else if(jabatan.equals("Officer")){
            tP=200000;
        }
        return tP;
    }

    public static int GajiKotor(int GajiPokok, int tp) {
        int gk =0;
        gk = GajiPokok+tp;
        return gk;
    }
    
    public static int PotonganPensiun(int GajiKotor) {
        int pp = 0;
        pp = (int)(0.02*GajiKotor);
        return pp;
    }

    public static int PotonganBPJS(int GajiKotor) {
        int bpjs = 0;
        bpjs = (int)(0.02*GajiKotor);
        return bpjs;
    }
    public static int PotonganPPH(int GajiKotor) {
        int pph = 0;
        pph = (int)(0.05*GajiKotor);
        return pph;
    }

    public static int gajibersih(int GajiKotor, int PotonganBPJS, int PotonganPensiun, int PotonganPPH) {
        int gb;
        gb = GajiKotor-(PotonganBPJS+PotonganPPH+PotonganPensiun);
        return gb;
    }
}
