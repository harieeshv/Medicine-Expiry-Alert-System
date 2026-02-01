package com.medicinealert;

import java.sql.ResultSet;

public interface MedicineDAO {

    void addMedicine(MedicineDTO dto) throws Exception;

    ResultSet getAllMedicines() throws Exception;

    ResultSet getExpiringMedicines(int days) throws Exception;

    ResultSet getExpiredMedicines() throws Exception;

    void deleteMedicine(int id) throws Exception;
}
