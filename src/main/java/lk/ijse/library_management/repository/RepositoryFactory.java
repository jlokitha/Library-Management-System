package lk.ijse.library_management.repository;

import lk.ijse.library_management.repository.custom.impl.*;

public class RepositoryFactory {
    public static RepositoryFactory factory;

    public RepositoryFactory () {

    }

    public static RepositoryFactory getInstance() {
        return (factory == null) ? factory = new RepositoryFactory() : factory;
    }

    public enum RepositoryType {
        BRANCH, ADMIN, BOOK, MEMBER, TRANSACTION, TRANSACTIONDETAILS
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
            case TRANSACTION:
                return new TransactionRepositoryImpl();
            case TRANSACTIONDETAILS:
                return new TransactionDetailRepositoryImpl();
            default:
                return null;
        }
    }
}
