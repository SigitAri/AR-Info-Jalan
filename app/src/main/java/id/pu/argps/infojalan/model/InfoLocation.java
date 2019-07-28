package id.pu.argps.infojalan.model;

import com.google.ar.sceneform.rendering.ModelRenderable;

public class InfoLocation {
    private ModelRenderable modelRenderable;
    private String title;
    private String date;
    private String biaya;
    private String peresmi;
    private String payload;
    private int idImage;

    public ModelRenderable getModelRenderable() {
        return modelRenderable;
    }

    public void setModelRenderable(ModelRenderable modelRenderable) {
        this.modelRenderable = modelRenderable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title.toLowerCase();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBiaya() {
        return biaya;
    }

    public void setBiaya(String biaya) {
        this.biaya = biaya;
    }

    public String getPeresmi() {
        return peresmi;
    }

    public void setPeresmi(String peresmi) {
        this.peresmi = peresmi;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }
}
