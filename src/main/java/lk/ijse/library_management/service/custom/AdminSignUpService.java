package lk.ijse.library_management.service.custom;

import lk.ijse.library_management.dto.AdminDto;
import lk.ijse.library_management.service.SuperService;

import java.sql.SQLException;

public interface AdminSignUpService extends SuperService {
    void sendEmail ( String... data);

    boolean saveAdmin(AdminDto adminDto) throws SQLException;

    boolean updateAdmin(AdminDto dto);
}
