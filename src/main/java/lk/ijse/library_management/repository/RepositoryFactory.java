package lk.ijse.library_management.repository;

import lk.ijse.library_management.repository.custom.impl.AdminRepositoryImpl;
import lk.ijse.library_management.repository.custom.impl.BranchRepositoryImpl;

public class RepositoryFactory {
    public static RepositoryFactory factory;

    public RepositoryFactory () {

    }

    public static RepositoryFactory getInstance() {
        return (factory == null) ? factory = new RepositoryFactory() : factory;
    }

    public enum RepositoryType {
        BRANCH, ADMIN
    }

    public SuperRepository getRepository (RepositoryType type) {
        switch (type) {
            case BRANCH:
                return new BranchRepositoryImpl();
            case ADMIN:
                return new AdminRepositoryImpl();
            default:
                return null;
        }
    }
}
