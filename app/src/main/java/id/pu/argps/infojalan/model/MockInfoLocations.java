package id.pu.argps.infojalan.model;

import android.content.Context;
import com.google.ar.sceneform.rendering.ModelRenderable;
import java.util.HashMap;
import java.util.LinkedHashMap;

import id.pu.argps.infojalan.R;

public class MockInfoLocations {

    private static MockInfoLocations mockInfoLocations;

    public static MockInfoLocations getInstance(Context context){
        if(mockInfoLocations == null){
            mockInfoLocations = new MockInfoLocations(context);
        }
        return mockInfoLocations;
    }

    public MockInfoLocations(Context context){
        this.context = context;
    }

    private HashMap<String, InfoLocation> infoLocationHashMap = new LinkedHashMap<>();
    private Context context;

    public void mock(){
        ModelRenderable.builder()
                .setSource(context, R.raw.jln_tegal_melati)
                .build()
                .thenAccept(renderable -> {
                    InfoLocation tegalMelatiStreet = new InfoLocation();
                    tegalMelatiStreet.setModelRenderable(renderable);
                    tegalMelatiStreet.setTitle("jalan tegal melati");
                    tegalMelatiStreet.setDate("02/02/2014 - 10/12/2016");
                    tegalMelatiStreet.setBiaya("Rp 30.000.000.000.000");
                    tegalMelatiStreet.setPeresmi("Joko Widodo");
                    tegalMelatiStreet.setPayload("Kementerian Pekerjaan Umum dan Perumahan Rakyat (PUPR) menyatakan kesiapannya memulai pelelangan dini paket pengerjaan konstruksi tahun anggaran 2017 pada bulan ini.\n\nEmpat Direktorat Jenderal terbesar di kementerian itu telah menyiapkan paket pengerjaan yang siap dilelang mulai bulan Oktober 2016 senilai Rp9,65 triliun untuk mempercepat realisasi penyerapan anggaran tahun depan.\n\nDirjen Bina Marga Kementerian PUPR Arie Setiadi Moerwanto mengungkapkan bulan ini akan melelang 205 paket, dengan nilai Rp6,7 triliun.\n\nSelanjutnya dia memerinci 2 bulan berikutnya secara bertahap, pada November akan melelang 258 paket senilai Rp7,8 triliun, lalu hingga akhir Desember akan ada 366 paket sebesar Rp5,6 triliun.");
                    tegalMelatiStreet.setIdImage(R.drawable.backgrd);
                    infoLocationHashMap.put(tegalMelatiStreet.getTitle(),tegalMelatiStreet);
                });
        //=====================================================================================================================

        ModelRenderable.builder()
                .setSource(context, R.raw.jln_magelang)
                .build()
                .thenAccept(renderable -> {
                    InfoLocation tegalMelatiStreet = new InfoLocation();
                    tegalMelatiStreet.setModelRenderable(renderable);
                    tegalMelatiStreet.setTitle("jalan magelang");
                    tegalMelatiStreet.setDate("02/02/2014 - 10/12/2016");
                    tegalMelatiStreet.setBiaya("Rp 30.000.000.000.000");
                    tegalMelatiStreet.setPeresmi("Joko Widodo");
                    tegalMelatiStreet.setPayload("Kementerian Pekerjaan Umum dan Perumahan Rakyat (PUPR) menyatakan kesiapannya memulai pelelangan dini paket pengerjaan konstruksi tahun anggaran 2017 pada bulan ini.\n\nEmpat Direktorat Jenderal terbesar di kementerian itu telah menyiapkan paket pengerjaan yang siap dilelang mulai bulan Oktober 2016 senilai Rp9,65 triliun untuk mempercepat realisasi penyerapan anggaran tahun depan.\n\nDirjen Bina Marga Kementerian PUPR Arie Setiadi Moerwanto mengungkapkan bulan ini akan melelang 205 paket, dengan nilai Rp6,7 triliun.\n\nSelanjutnya dia memerinci 2 bulan berikutnya secara bertahap, pada November akan melelang 258 paket senilai Rp7,8 triliun, lalu hingga akhir Desember akan ada 366 paket sebesar Rp5,6 triliun.");
                    tegalMelatiStreet.setIdImage(R.drawable.backgrd);
                    infoLocationHashMap.put(tegalMelatiStreet.getTitle(),tegalMelatiStreet);
                });
        //=====================================================================================================================

        ModelRenderable.builder()
                .setSource(context, R.raw.jln_pakuningratan)
                .build()
                .thenAccept(renderable -> {
                    InfoLocation tegalMelatiStreet = new InfoLocation();
                    tegalMelatiStreet.setModelRenderable(renderable);
                    tegalMelatiStreet.setTitle("jalan pakuningratan");
                    tegalMelatiStreet.setDate("02/02/2014 - 10/12/2016");
                    tegalMelatiStreet.setBiaya("Rp 30.000.000.000.000");
                    tegalMelatiStreet.setPeresmi("Joko Widodo");
                    tegalMelatiStreet.setPayload("Kementerian Pekerjaan Umum dan Perumahan Rakyat (PUPR) menyatakan kesiapannya memulai pelelangan dini paket pengerjaan konstruksi tahun anggaran 2017 pada bulan ini.\n\nEmpat Direktorat Jenderal terbesar di kementerian itu telah menyiapkan paket pengerjaan yang siap dilelang mulai bulan Oktober 2016 senilai Rp9,65 triliun untuk mempercepat realisasi penyerapan anggaran tahun depan.\n\nDirjen Bina Marga Kementerian PUPR Arie Setiadi Moerwanto mengungkapkan bulan ini akan melelang 205 paket, dengan nilai Rp6,7 triliun.\n\nSelanjutnya dia memerinci 2 bulan berikutnya secara bertahap, pada November akan melelang 258 paket senilai Rp7,8 triliun, lalu hingga akhir Desember akan ada 366 paket sebesar Rp5,6 triliun.");
                    tegalMelatiStreet.setIdImage(R.drawable.backgrd);
                    infoLocationHashMap.put(tegalMelatiStreet.getTitle(),tegalMelatiStreet);
                });
        //=====================================================================================================================

        ModelRenderable.builder()
                .setSource(context, R.raw.jln_kaliurang)
                .build()
                .thenAccept(renderable -> {
                    InfoLocation tegalMelatiStreet = new InfoLocation();
                    tegalMelatiStreet.setModelRenderable(renderable);
                    tegalMelatiStreet.setTitle("jalan kaliurang");
                    tegalMelatiStreet.setDate("02/02/2014 - 10/12/2016");
                    tegalMelatiStreet.setBiaya("Rp 30.000.000.000.000");
                    tegalMelatiStreet.setPeresmi("Joko Widodo");
                    tegalMelatiStreet.setPayload("Kementerian Pekerjaan Umum dan Perumahan Rakyat (PUPR) menyatakan kesiapannya memulai pelelangan dini paket pengerjaan konstruksi tahun anggaran 2017 pada bulan ini.\n\nEmpat Direktorat Jenderal terbesar di kementerian itu telah menyiapkan paket pengerjaan yang siap dilelang mulai bulan Oktober 2016 senilai Rp9,65 triliun untuk mempercepat realisasi penyerapan anggaran tahun depan.\n\nDirjen Bina Marga Kementerian PUPR Arie Setiadi Moerwanto mengungkapkan bulan ini akan melelang 205 paket, dengan nilai Rp6,7 triliun.\n\nSelanjutnya dia memerinci 2 bulan berikutnya secara bertahap, pada November akan melelang 258 paket senilai Rp7,8 triliun, lalu hingga akhir Desember akan ada 366 paket sebesar Rp5,6 triliun.");
                    tegalMelatiStreet.setIdImage(R.drawable.backgrd);
                    infoLocationHashMap.put(tegalMelatiStreet.getTitle(),tegalMelatiStreet);
                });
        //=====================================================================================================================
    }


    public InfoLocation getInfoLocations(String street){
        return infoLocationHashMap.get(street.toLowerCase());
    }

}
