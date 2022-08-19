package dev.entite.donneeApiQualiteAir;

public class ApiDebug {

    private String sync;


    // Getter Methods

    public String getSync() {
        return sync;
    }

    // Setter Methods

    public void setSync(String sync) {
        this.sync = sync;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ApiDebug{");
        sb.append("sync='").append(sync).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
