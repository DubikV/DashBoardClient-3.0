package ua.com.avatlantik.dubyk.i.dashboardclient.dto;

import java.util.ArrayList;
import java.util.Date;

import ua.com.avatlantik.dubyk.i.dashboardclient.dto.Data.BranchDTO;
import ua.com.avatlantik.dubyk.i.dashboardclient.dto.Data.BusinessDirectionDTO;
import ua.com.avatlantik.dubyk.i.dashboardclient.dto.Data.DataDTO;
import ua.com.avatlantik.dubyk.i.dashboardclient.dto.Data.ManagerDTO;

/**
 * Created by i.dubyk on 11.07.2016.
 */
public class DataStoreDTO {
    private Date dateDownload;

    ArrayList<BusinessDirectionDTO> businessDirectionDTO;
    ArrayList<BranchDTO> branchDTO;
    ArrayList<ManagerDTO> managerDTO;
    ArrayList<DataDTO> salesUGK;
    ArrayList<DataDTO> salesMoney;
    ArrayList<DataDTO> salesPrice;

    private static volatile DataStoreDTO _instance = null;

    private DataStoreDTO() {}

    public static DataStoreDTO getInstance() {

        if (_instance == null)
            synchronized (DataStoreDTO.class) {
                if (_instance == null)
                    _instance = new DataStoreDTO();
            }

        return _instance;

    }

    public Date getDateDownload() {
        return dateDownload;
    }

    public void setDateDownload(Date dateDownload) {
        this.dateDownload = dateDownload;
    }

    public ArrayList<DataDTO> getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(ArrayList<DataDTO> salesPrice) {
        this.salesPrice = salesPrice;
    }

    public ArrayList<DataDTO> getSalesMoney() {
        return salesMoney;
    }

    public void setSalesMoney(ArrayList<DataDTO> salesMoney) {
        this.salesMoney = salesMoney;
    }

    public ArrayList<DataDTO> getSalesUGK() {
        return salesUGK;
    }

    public void setSalesUGK(ArrayList<DataDTO> salesUGK) {
        this.salesUGK = salesUGK;
    }

    public ArrayList<ManagerDTO> getManagerDTO() {
        return managerDTO;
    }

    public void setManagerDTO(ArrayList<ManagerDTO> managerDTO) {
        this.managerDTO = managerDTO;
    }

    public ArrayList<BranchDTO> getBranchDTO() {
        return branchDTO;
    }

    public void setBranchDTO(ArrayList<BranchDTO> branchDTO) {
        this.branchDTO = branchDTO;
    }

    public ArrayList<BusinessDirectionDTO> getBusinessDirectionDTO() {
        return businessDirectionDTO;
    }

    public void setBusinessDirectionDTO(ArrayList<BusinessDirectionDTO> businessDirectionDTO) {
        this.businessDirectionDTO = businessDirectionDTO;
    }
}
