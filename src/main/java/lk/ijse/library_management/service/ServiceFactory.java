package lk.ijse.library_management.service;

import lk.ijse.library_management.service.custom.impl.*;

public class ServiceFactory {
    public static ServiceFactory factory;

    public ServiceFactory () {

    }

    public static ServiceFactory getInstance() {
        return (factory == null) ? factory = new ServiceFactory() : factory;
    }

    public enum ServiceType {
        BRANCH, SIGNIN, SIGNUP, PROFILE, BOOK
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
            case BOOK:
                return new BookServiceImpl();
            default:
                return null;
        }
    }
}
