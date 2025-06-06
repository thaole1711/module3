package com.example.quan_ly_san_pham.repository;

import com.example.quan_ly_san_pham.model.LoaiPhone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoaiPhoneRepository implements ILoaiPhoneRepository {
    private final String SELECT_ALL = "select * from loai_phone";

    @Override
    public List<LoaiPhone> findAll() {
        List<LoaiPhone> loaiPhones = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int ma = resultSet.getInt("id_loai");
                String tenLoai = resultSet.getString("ten_loai");
                loaiPhones.add(new LoaiPhone(ma, tenLoai));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return loaiPhones;
    }
}
