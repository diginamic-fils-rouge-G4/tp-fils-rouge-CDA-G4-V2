package dev.entite.donneeApiQualiteAir.polluant;

public class P {

    private float v;


    // Getter Methods

    public float getV() {
        return v;
    }

    // Setter Methods

    public void setV(float v) {
        this.v = v;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("H{");
        sb.append("v=").append(v);
        sb.append('}');
        return sb.toString();
    }

}
