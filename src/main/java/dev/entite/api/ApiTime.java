package dev.entite.api;

public class ApiTime {

    private String s;
    private String tz;
    private float v;
    private String iso;


    // Getter Methods

    public String getS() {
        return s;
    }

    public String getTz() {
        return tz;
    }

    public float getV() {
        return v;
    }

    public String getIso() {
        return iso;
    }

    // Setter Methods

    public void setS(String s) {
        this.s = s;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }

    public void setV(float v) {
        this.v = v;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ApiTime{");
        sb.append("s='").append(s).append('\'');
        sb.append(", tz='").append(tz).append('\'');
        sb.append(", v=").append(v);
        sb.append(", iso='").append(iso).append('\'');
        sb.append('}');
        return sb.toString();
    }
}