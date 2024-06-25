import java.util.Scanner;
/**
 *  Created By : Gavyn Ahmad Fata
 *  Created At : 10:50 Senin, 10 July 2024
 */
public class GajiPNSGavynAF {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String namaPegawai, ruangKerja;
        int golonganPangkat, masaKerja, jumlahAnak, statusPernikahan;

        System.out.println("----- Aplikasi Perhitungan Gaji PNS ----");
        System.out.print("Nama        : ");
        namaPegawai = cekNama(input.nextLine());
        System.out.print("Gol Pangkat : ");   
        golonganPangkat = CekGolonganPangkat(input.nextInt());
        System.out.print("Ruang Kerja : ");
        ruangKerja = CekTipeGolongan(input.next(), golonganPangkat);
        System.out.print("Masa Kerja  : ");
        masaKerja = CekMasaKerja(input.nextInt());
        System.out.print("Status Pernikahan(Belum Kawin, Kawin, Cerai ): ");
        statusPernikahan = CekStatusPernikahan(input.nextLine());
        System.out.print("Jumlah Anak : ");
        jumlahAnak = CekJumlahAnak(input.nextInt());

        int gajiPokok = kalkulasiGajiPokok(masaKerja, ruangKerja, golonganPangkat);
        double tunjanganKeluarga = kalkulasiTunjanganKeluarga(statusPernikahan, gajiPokok);
        double tunjanganAnak = kalkulasiTunjanganAnak(jumlahAnak, gajiPokok);
        int tunjanganBeras = kalkulasiTunjanganBeras(statusPernikahan, jumlahAnak);
        int tunjanganUmumJabatan = kalkulasiTunjanganUmumJabatan(golonganPangkat);
        double gajiKotor = kalkulasiGajiKotor(gajiPokok, tunjanganKeluarga, tunjanganAnak, tunjanganBeras, tunjanganUmumJabatan);
        double potonganPpH = kalkulasiPotonganPPH(gajiPokok, statusPernikahan, gajiKotor, jumlahAnak, tunjanganKeluarga, tunjanganAnak);
        double potonganIWP = kalkulasiPotonganIWP(gajiPokok, tunjanganAnak, tunjanganKeluarga);
        int potonganTaperum = kalkulasiPotonganTaperum(golonganPangkat);
        double gajiBersih = kalkulasiGajiBersih(gajiKotor, potonganPpH, potonganIWP, potonganTaperum);

        displayOutput(namaPegawai, gajiPokok, tunjanganKeluarga, tunjanganAnak, tunjanganBeras, tunjanganUmumJabatan, gajiKotor, potonganPpH, potonganIWP, potonganTaperum, gajiBersih);
    }

    public static double kalkulasiTunjanganKeluarga(int statusPernikahan,int gajiPokok){
        double tunjanganKeluarga = 0;

        if (statusPernikahan==1) {
            tunjanganKeluarga = gajiPokok*0.1;
        }
        return tunjanganKeluarga;
    }

    public static double kalkulasiTunjanganAnak(int jumlahAnak,int gajiPokok){
        double tunjanganAnak = 0;
        if (jumlahAnak==1) {
            tunjanganAnak = gajiPokok*0.02;
        } else if(jumlahAnak>=2){
            tunjanganAnak = (gajiPokok*0.02)*2;
        }
        return tunjanganAnak;
    }
    public static int kalkulasiTunjanganBeras(int statusPernikahan, int jumlahAnak){
        int tunjanganBeras=0;
        int beras = 150000;
        
        int anggotaKeluarga = 1;
        if (statusPernikahan==1) {
            anggotaKeluarga+=1;
        }
        if (jumlahAnak==1) {
            anggotaKeluarga +=1;
        } else if(jumlahAnak>=2){
            anggotaKeluarga +=2;
        }

        tunjanganBeras = anggotaKeluarga*beras;

        return tunjanganBeras;
    }

    public static int kalkulasiTunjanganUmumJabatan(int golonganPangkat){
        int[] tunjanganJabatan={175000,180000,185000,190000};

        return tunjanganJabatan[golonganPangkat-1];
    }

    public static double kalkulasiGajiKotor(int gajiPokok,Double tunjanganAnak,Double tunjanganKeluarga,int tunjanganUmumJabatan,int tunjanganBeras){
        double gajiKotor = gajiPokok+tunjanganKeluarga+tunjanganAnak+tunjanganBeras+tunjanganUmumJabatan;

        return gajiKotor;
    }

    public static double kalkulasiPotonganPPH(int gajiPokok,int statusPernikahan,double gajiKotor,int jumlahAnak,double tunjanganKeluarga,double tunjanganAnak){
        double potonganPPH=0, biayaJabatan, iuranPensiun, jumlahPengurangan, penghasilanNetoBulan, penghasilanNetoTahun, jumlahPTKP, PKP;
        int WPsendiri, WPpasangan=0, WPanak=0;

        if (gajiKotor>4500000) {
            //pengurangan
            biayaJabatan = gajiKotor*0.05;
            iuranPensiun = (gajiPokok+tunjanganKeluarga+tunjanganAnak)*0.0475;
            jumlahPengurangan = biayaJabatan+iuranPensiun;

            //neto
            penghasilanNetoBulan = gajiKotor-jumlahPengurangan;
            penghasilanNetoTahun = penghasilanNetoBulan*12;

            //PTKP
            WPsendiri = 36000000;
            if (statusPernikahan==1) {
                WPpasangan = 3000000;
            }
            int x = Math.min(jumlahAnak, 3);
            for (int i = 0; i < x; i++) {
                WPanak += 3000000;
            }
            jumlahPTKP = WPsendiri+WPpasangan+WPanak;

            //PKP(penghasilan kena pajak)
            PKP = penghasilanNetoTahun-jumlahPTKP;

            //pph
            potonganPPH = (PKP*0.05)/12;
        } 
        return potonganPPH;
    }
    static public double kalkulasiPotonganIWP(int gajiPokok,Double tunjanganAnak,Double tunjanganKeluarga){
        double IWP = (gajiPokok+tunjanganAnak+tunjanganKeluarga)*0.1;
        return IWP;

    }
    static public int kalkulasiPotonganTaperum(int golonganPangkat){
        int taperum = 0;
        switch (golonganPangkat) {
            case 1:
                taperum = 3000;
                break;
            case 2:
                taperum = 5000;
                break;
            case 3:
                taperum = 7000;
                break;
            case 4:
                taperum = 10000;
                break;
            default:
                break;
        }
        return taperum;
    }

    static public double kalkulasiGajiBersih(Double gajiKotor, Double potonganPPH, Double potonganIWP,int potonganTaperum){
        return gajiKotor-(potonganPPH+potonganIWP+potonganTaperum);
    }

    public static String FormatCurrency(double gajibersih) {
        StringBuilder format = new StringBuilder();

        String angka = String.format("%.2f", gajibersih);

        int z = 0,pangjang;
        pangjang = angka.length();
        for (int i = (pangjang-3)-1; i >= 0 ; i--) {
            boolean koma=true;
            format.append(angka.charAt(z));
            if (i%3==0&&i!=0) {
                format.append(",");
            }
            z++;
            //0 1 2, 3 45, 678,
        }
        for (int j = pangjang-1; j > (pangjang-3)-1; j--) {
            format.append(angka.charAt(z));
            z++;
        }
        return format.toString();
    }
    
    static public void displayOutput(String nama,int gajiPokok,Double tunjanganKeluarga, Double tunjanganAnak, int tunjanganBeras, int tunjanganUmumJabatan, Double gajiKotor, Double potonganPPH, Double potonganIWP, int potonganTaperum, Double gajiBersih){
        System.out.println("------------Perhitungan Gaji PNS------------");
        System.out.println("| "+nama+" |");
        System.out.println("--------------------------------------------");
        System.out.println("| Gaji Pokok             | Rp" + FormatCurrency(gajiPokok));
        System.out.println("| Tunjangan Keluarga     | Rp" + FormatCurrency(tunjanganKeluarga));
        System.out.println("| Tunjangan Anak         | Rp" + FormatCurrency(tunjanganAnak));
        System.out.println("| Tunjangan Beras        | Rp" + FormatCurrency(tunjanganBeras));
        System.out.println("| Tunjangan Umum Jabatan | Rp" + FormatCurrency(tunjanganUmumJabatan));
        System.out.println("| Gaji Bruto             | Rp" + FormatCurrency(gajiKotor));
        System.out.println("| Potongan PpH           | Rp" + FormatCurrency(potonganPPH));
        System.out.println("| Potongan IWP           | Rp" + FormatCurrency(potonganIWP));
        System.out.println("| Potongan Taperum       | Rp" + FormatCurrency(potonganTaperum));
        System.out.println("| Gaji Take Home Pay     | Rp" + FormatCurrency(gajiBersih));
        System.out.println("--------------------------------------------");
    }

    public static int kalkulasiGajiPokok(int masaKerja, String tipeGolongan,int golonganPangkat){
        int golongan=0, gajiPokok=0;
        switch (tipeGolongan) {
            case "A":
                golongan = 0;
                break;
            case "B":
                golongan = 1;
                break;
            case "C":
                golongan = 2;
                break;
            case "D":
                golongan = 3;
                break;
            case "E":
                golongan = 4;
                break;
            default:
                break;
        }

        int[][][] golonganPNS = {
            {
            {1560800,1560800,1560800,1560800},
            {1560800,1560800,1560800,1560800},
            {1610000,1610000,1610000,1610000},
            {1610000,1704500,1776600,1851800},
            {1660700,1704500,1776600,1851800},
            {1660700,1758200,1832600,1910100},
            {1713000,1758200,1832600,1910100},
            {1713000,1813600,1890300,1970200},
            {1766900,1813600,1890300,1970200},
            {1766900,1870700,1949800,2032300},
            {1822600,1870700,1949800,2032300},
            {1822600,1929600,2011200,2096300},
            {1880000,1929600,2011200,2096300},
            {1880000,1990400,2074600,2162300},
            {1939200,1990400,2074600,2162300},
            {1939200,2053100,2139900,2230400},
            {2000300,2053100,2139900,2230400},
            {2000300,2117700,2207300,2300700},
            {2063300,2117700,2207300,2300700},
            {2063300,2184400,2276800,2373100},
            {2128300,2184400,2276800,2373100},
            {2128300,2253200,2348500,2447900},
            {2195300,2253200,2348500,2447900},
            {2195300,2324200,2422500,2525000},
            {2264400,2324200,2422500,2525000},
            {2264400,2397400,2498800,2604500},
            {2335800,2397400,2498800,2604500},
            {2335800,2472900,2557500,2686500}
        },
        {
            {2022200,2022200,2022200,2022200},
            {2054100,2054100,2054100,2054100},
            {2054100,2054100,2054100,2054100},
            {2118800,2208400,2301800,2399200},
            {2118800,2208400,2301800,2399200},
            {2185500,2277900,2374300,2474700},
            {2185500,2277900,2374300,2474700},
            {2254300,2349700,2449100,2552700},
            {2254300,2349700,2449100,2552700},
            {2325300,2423700,2526200,2633100},
            {2325300,2423700,2526200,2633100},
            {2398600,2500000,2605800,2716000},
            {2398600,2500000,2605800,2716000},
            {2474100,2578800,2687800,2801500},
            {2474100,2578800,2687800,2801500},
            {2552000,2660000,2772500,2889800},
            {2552000,2660000,2772500,2889800},
            {2632400,2743800,2859800,2980800},
            {2632400,2743800,2859800,2980800},
            {2715300,2830200,2949900,3074700},
            {2715300,2830200,2949900,3074700},
            {2800800,2919300,3042800,3171500},
            {2800800,2919300,3042800,3171500},
            {2889100,3011200,3138600,3271400},
            {2889100,3011200,3138600,3271400},
            {2980000,3106100,3237500,3374400},
            {2980000,3106100,3237500,3374400},
            {3073900,3203900,3339400,3480700},
            {3073900,3203900,3339400,3480700},
            {3170700,3304800,3444600,3590300},
            {3170700,3304800,3444600,3590300},
            {3270600,3408900,3553100,3703400},
            {3270600,3408900,3553100,3703400},
            {3373600,3516300,3665000,3820000}
        },
        {
            {2579400,2688500,2802300,2920800},
            {2579400,2688500,2802300,2920800},
            {2660700,2773200,2890500,3012800},
            {2660700,2773200,2890500,3012800},
            {2744500,2860500,2981500,3107700},
            {2744500,2860500,2981500,3107700},
            {2830900,2950600,3075500,3205500},
            {2830900,2950600,3075500,3205500},
            {2920100,3043600,3172300,3306500},
            {2920100,3043600,3172300,3306500},
            {3012000,3139400,3272200,3410600},
            {3012000,3139400,3272200,3410600},
            {3106900,3238300,3375300,3518100},
            {3106900,3238300,3375300,3518100},
            {3204700,3340300,3481600,3628900},
            {3204700,3340300,3481600,3628900},
            {3305700,3445500,3591200,3743100},
            {3305700,3445500,3591200,3743100},
            {3409800,3554000,3704300,3861000},
            {3409800,3554000,3704300,3861000},
            {3517200,3665900,3821000,3982600},
            {3517200,3665900,3821000,3982600},
            {3627900,3781400,3941400,4108100},
            {3627900,3781400,3941400,4108100},
            {3742200,3900500,4065500,4237500},
            {3742200,3900500,4065500,4237500},
            {3860100,4023300,4193500,4370900},
            {3860100,4023300,4193500,4370900},
            {3981600,4150100,4325600,4508600},
            {3981600,4150100,4325600,4508600},
            {4107000,4280800,4461800,4650600},
            {4107000,4280800,4461800,4650600},
            {4236400,4415600,4602400,4797000}
        },
        {
            {3044300,3173100,3307300,3447200,3593100},
            {3044300,3173100,3307300,3447200,3593100},
            {3140200,3272100,3411500,3555800,3706200},
            {3140200,3272100,3411500,3555800,3706200},
            {3239100,3376100,3518900,3667800,3822900},
            {3239100,3376100,3518900,3667800,3822900},
            {3341100,3482500,3629800,3783300,3943300},
            {3341100,3482500,3629800,3783300,3943300},
            {3446400,3592100,3744100,3902500,4067500},
            {3446400,3592100,3744100,3902500,4067500},
            {3554900,3705300,3862000,4025400,4195700},
            {3554900,3705300,3862000,4025400,4195700},
            {3666900,3822000,3983600,4152200,4327800},
            {3666900,3822000,3983600,4152200,4327800},
            {3782400,3942400,4109100,4282900,4462100},
            {3782400,3942400,4109100,4282900,4462100},
            {3901500,4066500,4238500,4417800,4604700},
            {3901500,4066500,4238500,4417800,4604700},
            {4024400,4194600,4372000,4557000,4749700},
            {4024400,4194600,4372000,4557000,4749700},
            {4151100,4326700,4509700,4700500,4899300},
            {4151100,4326700,4509700,4700500,4899300},
            {4281800,4463000,4651800,4848500,5053600},
            {4281800,4463000,4651800,4848500,5053600},
            {4416700,4603500,4798300,5001200,5212800},
            {4416700,4603500,4798300,5001200,5212800},
            {4555800,4748500,4949400,5158700,5377000},
            {4555800,4748500,4949400,5158700,5377000},
            {4699300,4898100,5105300,5321200,5546300},
            {4699300,4898100,5105300,5321200,5546300},
            {4847300,5052300,5266100,5488800,5721000},
            {4847300,5052300,5266100,5488800,5721000},
            {5000000,5211500,5431900,5661700,5901200}
        }};
        //int masaKerja, String tipeGolongan,int golonganPangkat golongan[masakerja][golongan]
        int x = masaKerja;

        if (golonganPangkat == 1) {
            if (masaKerja>golonganPNS[0].length-1) {
                x = 27;
            } 
            gajiPokok = golonganPNS[0][x][golongan];
        } else if(golonganPangkat == 2) {
            if (masaKerja>golonganPNS[1].length-1) {
                x = 33;
            } 
            gajiPokok = golonganPNS[1][x][golongan];
        }else if(golonganPangkat == 3) {
            if (masaKerja>golonganPNS[2].length-1) {
                x = 32;
            } 
            gajiPokok = golonganPNS[2][x][golongan];
        }else if(golonganPangkat == 4) {
            if (masaKerja>golonganPNS[3].length-1) {
                x = 32;
            } 
            gajiPokok = golonganPNS[3][x][golongan];
        }
        return gajiPokok;
    }

    public static String cekNama(String namaPegawai) {
        Scanner input = new Scanner(System.in);
        boolean kondisi = false;
        
        StringBuilder nama = new StringBuilder();
        char[] alfabet = {'q','w','e','r','t','y','u','i','o','p',
                        'a','s','d','f','g','h','j','k','l',
                        'z','x','c','v','b','n','m',' '
                        };
          
        while (!kondisi) {
            char[] karakter = namaPegawai.toCharArray();
            int panjang=0;
            for (int i = 0; i < karakter.length; i++) {
                for (int j = 0; j < alfabet.length; j++) {
                    if (Character.toLowerCase(karakter[i])==alfabet[j]) {
                        panjang++;
                        break;
                    }
                }
            }
            if (panjang==namaPegawai.length()) {
                namaPegawai = namaPegawai;
                kondisi = true;
            } else {
                System.out.print("Input Nama Salah, input kembali : ");
                namaPegawai = input.nextLine();
            }
        }
        return namaPegawai;
    }

    public static int CekGolonganPangkat(int golonganPangkat) {
        Scanner input = new Scanner(System.in);
        boolean kondisi = false;
        while (!kondisi) {
            if (golonganPangkat>=1&&golonganPangkat<=4) {
                golonganPangkat = golonganPangkat;
                kondisi = true;
            } else {
                System.out.print("Input Golongan Pangkat Salah, input kembali : ");
                golonganPangkat = input.nextInt();
            }
        }
        return golonganPangkat;
    }

    public static String CekTipeGolongan(String ruangKerja, int golonganPangkat) {
        Scanner input = new Scanner(System.in);
        String[] tipe = {"A","B","C","D","E"};
        boolean kondisi = false;
        while (!kondisi) {
            if (golonganPangkat>=1&&golonganPangkat<=3) {
                for (int i = 0; i < tipe.length-1; i++) {
                    if (ruangKerja.equalsIgnoreCase(tipe[i])) {
                        kondisi = true;
                    }
                }
            } else if(golonganPangkat==4){
                for (int i = 0; i < tipe.length; i++) {
                    if (ruangKerja.equalsIgnoreCase(tipe[i])) {
                        kondisi = true;
                    }
                }
            }
            if (!kondisi) {
                System.out.print("Input Tipe Golongan Salah, input kembali : ");
                ruangKerja = input.next();
            }            
        }
        return ruangKerja;
    }

    public static int CekMasaKerja(int masaKerja) {
        Scanner input = new Scanner(System.in);
        boolean kondisi = false;
        while (!kondisi) {
            if (masaKerja>=0&&masaKerja<=50) {
                kondisi =true;
            }else{
                System.out.print("Input Masa Kerja Salah, input kembali : ");
                masaKerja = input.nextInt();
            }
        }
        return masaKerja;
    }

    public static int CekStatusPernikahan(String status) {
        Scanner input = new Scanner(System.in);
        int x = 0;
        boolean kondisi = false;
        status = input.nextLine();
        while (!kondisi) {
            if (status.equalsIgnoreCase("belum kawin")) {
                x = 0;
                kondisi = true;
            } else if(status.equalsIgnoreCase("kawin")){
                x = 1;
                kondisi = true;
            }else if(status.equalsIgnoreCase("cerai")){
                x = 2;
                kondisi = true;
            }else{
                System.out.print("Input Status Pernikahan Salah, input kembali : ");
                status = input.nextLine();
            }
        }
        
        return x;
    }

    public static int CekJumlahAnak(int jumlahAnak) {
        Scanner input = new Scanner(System.in);
        boolean kondisi = false;
        while (!kondisi) {
            if (jumlahAnak>=0) {
                kondisi =true;
            }else{
                System.out.print("Input Jumlah Anak Salah, input kembali : ");
                jumlahAnak = input.nextInt();
            }
        }
        return jumlahAnak;
    }

}