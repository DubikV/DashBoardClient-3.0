package ua.com.avatlantik.dubyk.i.dashboardclient.dto.Data;

/**
 * Created by i.dubyk on 30.08.2016.
 */
public class BusinessDirectionDTO {
    String name;
    String GUID;

    public BusinessDirectionDTO(String name, String GUID) {
        this.name = name;
        this.GUID = GUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGUID() {
        return GUID;
    }

    public void setGUID(String GUID) {
        this.GUID = GUID;
    }
}
