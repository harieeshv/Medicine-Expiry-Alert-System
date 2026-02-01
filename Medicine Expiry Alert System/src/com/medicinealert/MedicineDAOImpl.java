package com.medicinealert;

import java.sql.*;


public class MedicineDAOImpl implements MedicineDAO {

    @Override
    public void addMedicine(MedicineDTO dto) throws Exception {

        String sql =
          "INSERT INTO medicines(name,batch_no,quantity,expiry_date,supplier) VALUES(?,?,?,?,?)";

        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, dto.getName());
        ps.setString(2, dto.getBatchNo());
        ps.setInt(3, dto.getQuantity());
        ps.setDate(4, dto.getExpiryDate());
        ps.setString(5, dto.getSupplier());

        ps.executeUpdate();
    }

    @Override
    public ResultSet getAllMedicines() throws Exception {

        Connection con = DBConnection.getConnection();
        PreparedStatement ps =
                con.prepareStatement("SELECT * FROM medicines");

        return ps.executeQuery();
    }

    @Override
    public ResultSet getExpiringMedicines(int days) throws Exception {

        String sql =
        "SELECT * FROM medicines " +
        "WHERE expiry_date BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL ? DAY)";

        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, days);

        return ps.executeQuery();
    }

    @Override
    public ResultSet getExpiredMedicines() throws Exception {

        String sql =
        "SELECT * FROM medicines WHERE expiry_date < CURDATE()";

        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        return ps.executeQuery();
    }

    @Override
    public void deleteMedicine(int id) throws Exception {

        Connection con = DBConnection.getConnection();
        PreparedStatement ps =
                con.prepareStatement("DELETE FROM medicines WHERE id=?");

        ps.setInt(1, id);
        ps.executeUpdate();
    }
}
