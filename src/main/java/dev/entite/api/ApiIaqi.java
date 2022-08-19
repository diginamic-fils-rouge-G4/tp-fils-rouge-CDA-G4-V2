package dev.entite.api;

import dev.entite.api.polluant.*;

public class ApiIaqi {

    H H;
    P P;
    Pm25 Pm25;
    T T;
    W W;
    Wg Wg;


    public dev.entite.api.polluant.H getH() {
        return H;
    }

    public void setH(dev.entite.api.polluant.H h) {
        H = h;
    }

    public dev.entite.api.polluant.P getP() {
        return P;
    }

    public void setP(dev.entite.api.polluant.P p) {
        P = p;
    }

    public dev.entite.api.polluant.Pm25 getPm25() {
        return Pm25;
    }

    public void setPm25(dev.entite.api.polluant.Pm25 pm25) {
        Pm25 = pm25;
    }

    public dev.entite.api.polluant.T getT() {
        return T;
    }

    public void setT(dev.entite.api.polluant.T t) {
        T = t;
    }

    public dev.entite.api.polluant.W getW() {
        return W;
    }

    public void setW(dev.entite.api.polluant.W w) {
        W = w;
    }

    public dev.entite.api.polluant.Wg getWg() {
        return Wg;
    }

    public void setWg(dev.entite.api.polluant.Wg wg) {
        Wg = wg;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ApiIaqi{");
        sb.append("H=").append(H);
        sb.append(", P=").append(P);
        sb.append(", Pm25=").append(Pm25);
        sb.append(", T=").append(T);
        sb.append(", W=").append(W);
        sb.append(", Wg=").append(Wg);
        sb.append(", h=").append(getH());
        sb.append(", p=").append(getP());
        sb.append(", pm25=").append(getPm25());
        sb.append(", t=").append(getT());
        sb.append(", w=").append(getW());
        sb.append(", wg=").append(getWg());
        sb.append('}');
        return sb.toString();
    }
}
