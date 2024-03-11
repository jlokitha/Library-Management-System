package lk.ijse.library_management.repository;

import lk.ijse.library_management.repository.custom.impl.AdminRepositoryImpl;
import lk.ijse.library_management.repository.custom.impl.BookRepositoryImpl;
import lk.ijse.library_management.repository.custom.impl.BranchRepositoryImpl;
import lk.ijse.library_management.repository.custom.impl.MemberRepositoryImpl;

public class RepositoryFactory {
    public static RepositoryFactory factory;

    public RepositoryFactory () {

    }

    public static RepositoryFactory getInstance() {
        return (factory == null) ? factory = new RepositoryFactory() : factory;
    }

    public enum RepositoryType {
        BRANCH, ADMIN, BOOK, MEMBER
    }

    public SuperRepository getRepository (RepositoryType type) {
        switch (type) {
            case BRANCH:
                return new BranchRepositoryImpl();
            case ADMIN:
                return new AdminRepositoryImpl();
            case BOOK:
                return new BookRepositoryImpl();
            case MEMBER:
                return new MemberRepositoryImpl();
            default:
                return null;
        }
    }
}
