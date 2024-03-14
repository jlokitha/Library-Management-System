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
        BRANCH, SIGNIN, SIGNUP, ADMINPROFILE, BOOK, MEMBER, MEMBERPROFILE, MEMBERSIGNUP, MEMBERSIGNIN, TRANSACTION, DASHBOARD
    }

    public SuperService getService (ServiceType type) {
        switch (type) {
            case BRANCH:
                return new BranchServiceImpl();
            case SIGNUP:
                return new AdminSignUpServiceImpl();
            case ADMINPROFILE:
                return new AdminProfileServiceImpl();
            case SIGNIN:
                return new AdminSignInServiceImpl();
            case BOOK:
                return new BookServiceImpl();
            case MEMBER:
                return new MemberServiceImpl();
            case MEMBERPROFILE:
                return new MemberProfileServiceImpl();
            case MEMBERSIGNUP:
                return new MemberSignUpServiceImpl();
            case MEMBERSIGNIN:
                return new MemberSignInServiceImpl();
            case TRANSACTION:
                return new TransactionServiceImpl();
            case DASHBOARD:
                return new DashboardServiceImpl();
            default:
                return null;
        }
    }
}
