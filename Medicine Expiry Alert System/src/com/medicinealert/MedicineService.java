package com.medicinealert;

import java.sql.ResultSet;

public class MedicineService {

    private MedicineDAO dao = new MedicineDAOImpl();

    public void addMedicine(MedicineDTO dto) throws Exception {
        dao.addMedicine(dto);
    }

    public ResultSet getAllMedicines() throws Exception {
        return dao.getAllMedicines();
    }

    public ResultSet getExpiringMedicines(int days) throws Exception {
        return dao.getExpiringMedicines(days);
    }

    public ResultSet getExpiredMedicines() throws Exception {
        return dao.getExpiredMedicines();
    }

    public void deleteMedicine(int id) throws Exception {
        dao.deleteMedicine(id);
    }
}
