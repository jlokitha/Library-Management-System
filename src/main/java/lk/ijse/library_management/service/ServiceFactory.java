package lk.ijse.library_management.service;

import lk.ijse.library_management.service.custom.impl.ProfileServiceImpl;
import lk.ijse.library_management.service.custom.impl.SignInServiceImpl;
import lk.ijse.library_management.service.custom.impl.SignUpServiceImpl;
import lk.ijse.library_management.service.custom.impl.BranchServiceImpl;

public class ServiceFactory {
    public static ServiceFactory factory;

    public ServiceFactory () {

    }

    public static ServiceFactory getInstance() {
        return (factory == null) ? factory = new ServiceFactory() : factory;
    }

    public enum ServiceType {
        BRANCH, SIGNIN, SIGNUP, PROFILE
    }

    public SuperService getService (ServiceType type) {
        switch (type) {
            case BRANCH:
                return new BranchServiceImpl();
            case SIGNUP:
                return new SignUpServiceImpl();
            case PROFILE:
                return new ProfileServiceImpl();
            case SIGNIN:
                return new SignInServiceImpl();
            default:
                return null;
        }
    }
}
