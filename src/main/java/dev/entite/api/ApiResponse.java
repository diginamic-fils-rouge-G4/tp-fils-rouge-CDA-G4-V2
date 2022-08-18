package dev.entite.api;

import javax.xml.crypto.Data;

public class ApiResponse {
    private String status;
    ApiData DataObject;

    // Getter Methods

    public String getStatus() {
        return status;
    }
    public ApiData getData() {
        return DataObject;
    }
    // Setter Methods

    public void setStatus(String status) {
        this.status = status;
    }

    public void setData(ApiData dataObject) {
        this.DataObject = dataObject;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ApiResponse{");
        sb.append("status='").append(status).append('\'');
        sb.append(", DataObject=").append(DataObject);
        sb.append(", data=").append(getData());
        sb.append('}');
        return sb.toString();
    }
}



