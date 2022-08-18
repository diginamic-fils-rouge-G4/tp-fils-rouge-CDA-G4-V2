package dev.entite.api;

import dev.entite.api.polluant.*;

public class ApiIaqi {

    H HObject;
    P PObject;
    Pm25 Pm25Object;
    T TObject;
    W WObject;
    Wg WgObject;


    // Getter Methods

    public H getH() {
        return HObject;
    }

    public P getP() {
        return PObject;
    }

    public Pm25 getPm25() {
        return Pm25Object;
    }

    public T getT() {
        return TObject;
    }

    public W getW() {
        return WObject;
    }

    public Wg getWg() {
        return WgObject;
    }

    // Setter Methods

    public void setH(H hObject) {
        this.HObject = hObject;
    }

    public void setP(P pObject) {
        this.PObject = pObject;
    }

    public void setPm25(Pm25 pm25Object) {
        this.Pm25Object = pm25Object;
    }

    public void setT(T tObject) {
        this.TObject = tObject;
    }

    public void setW(W wObject) {
        this.WObject = wObject;
    }

    public void setWg(Wg wgObject) {
        this.WgObject = wgObject;
    }

}
