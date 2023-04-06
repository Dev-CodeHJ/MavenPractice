package org.mybatis.test.app.dao;

import org.mybatis.test.app.dto.MemberDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public MemberDao() {
        try{
            String dbURL = "jdbc:mysql://localhost:3306/tbl_board";
            String dbID = "root";
            String dbPassword = "0000";
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(dbURL,dbID,dbPassword);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public int login(String memberId, String pw) {
        String sql = "SELECT pw FROM member_dto WHERE member_id = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memberId);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                if(rs.getString(1).equals(pw)){
                    return 1;
                }else {
                    return 0;
                }
            }
            return -1;
        }catch(Exception e) {
            e.printStackTrace();
        }
        return -2; //database err
    }

    public int join(MemberDto member) {
        String sql = "INSERT INTO member VALUES(?,?,?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getMemberId());
            pstmt.setString(2, member.getPw());
            pstmt.setString(3, member.getName());
            pstmt.setString(4, member.getGender());
            pstmt.setString(5, member.getEmail());
            return pstmt.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
