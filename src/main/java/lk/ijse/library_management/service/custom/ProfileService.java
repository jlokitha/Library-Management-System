package lk.ijse.library_management.service.custom;

import lk.ijse.library_management.dto.AdminDto;
import lk.ijse.library_management.service.SuperService;

public interface ProfileService extends SuperService {
    AdminDto getAdminData();
}
