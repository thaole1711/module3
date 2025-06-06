package com.example.quan_ly_san_pham.repository;

import com.example.quan_ly_san_pham.dto.PhoneDtoRepose;
import com.example.quan_ly_san_pham.model.Phone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneRepository implements IPhoneRepository {
    private final String SELECT_ALL = "select* from phones";
    private final String INSERT_INTO = "insert into phones(ten,gia,mo_ta,nha_san_xuat,id_loai) value (?,?,?,?,?);";
    private final String DELETE = "delete from phones where ma=?;";
    private final String UPDATE = "update phones set ten=?,gia=?,mo_ta=?,nha_san_xuat=?,id_loai=? where ma=?;";
    private final String SELECT_JOIN="select p.ma,p.ten,p.gia,p.mo_ta,p.nha_san_xuat,l.ten_loai from phones p join loai_phone l on p.id_loai=l.id_loai;";


    @Override
    public List<PhoneDtoRepose> findAll() {
        List<PhoneDtoRepose> phoneList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_JOIN);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int ma = resultSet.getInt("ma");
                String ten = resultSet.getString("ten");
                double gia = resultSet.getDouble("gia");
                String mo_ta = resultSet.getString("mo_ta");
                String nha_san_xuat = resultSet.getString("nha_san_xuat");
                String loai = resultSet.getString("ten_loai");
                phoneList.add(new PhoneDtoRepose(ma, ten, gia, mo_ta, nha_san_xuat, loai));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return phoneList;

    }
    public List<Phone> displayPhone() {
        List<Phone>  Phone = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int ma = resultSet.getInt("ma");
                String ten = resultSet.getString("ten");
                double gia = resultSet.getDouble("gia");
                String mo_ta = resultSet.getString("mo_ta");
                String nha_san_xuat = resultSet.getString("nha_san_xuat");
               int loai = resultSet.getInt("id_loai");
                Phone.add(new Phone(ma, ten, gia, mo_ta, nha_san_xuat, loai));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  Phone;

    }


    @Override
    public boolean add(Phone phone) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);) {
            preparedStatement.setString(1, phone.getTen());
            preparedStatement.setDouble(2, phone.getGia());
            preparedStatement.setString(3, phone.getMo_ta());
            preparedStatement.setString(4, phone.getNha_san_xuat());
            preparedStatement.setInt(5, phone.getLoai());
            int effectRow = preparedStatement.executeUpdate();
            return effectRow == 1;
        } catch (SQLException e) {
            System.out.println("lỗi kết nối database");
        }
        return false;

    }

    @Override
    public boolean update(Phone phone) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);) {
            preparedStatement.setString(1, phone.getTen());
            preparedStatement.setDouble(2, phone.getGia());
            preparedStatement.setString(3, phone.getMo_ta());
            preparedStatement.setString(4, phone.getNha_san_xuat());
            preparedStatement.setInt(5, phone.getLoai());
            preparedStatement.setInt(6, phone.getMa());
            int effectRow=preparedStatement.executeUpdate();
          return   effectRow==1;
        } catch (SQLException e) {
            System.out.println("lỗi kết nối database");
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE);) {
            preparedStatement.setInt(1, id);
            int effectRow = preparedStatement.executeUpdate();
            return effectRow == 1;

        } catch (SQLException e) {
            System.out.println("lỗi kết nối database");
        }
        return false;
    }

    @Override
    public Phone findPhoneById(int id) {
        List<Phone> list = displayPhone();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMa() == id) {
                return list.get(i);
            }

        }
        return null;
    }

    @Override
    public List<PhoneDtoRepose> search(String name) {
        List<PhoneDtoRepose> listPhones = findAll();
        List<PhoneDtoRepose> list = new ArrayList<>();
        for (int i = 0; i < listPhones.size(); i++) {
            if (listPhones.get(i).getTen().contains(name)) {
                list.add(listPhones.get(i));
            }
        }
        return list;
    }
}
