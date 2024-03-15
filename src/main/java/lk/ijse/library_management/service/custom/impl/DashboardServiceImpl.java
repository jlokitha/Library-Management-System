package lk.ijse.library_management.service.custom.impl;

import lk.ijse.library_management.dto.MemberDto;
import lk.ijse.library_management.entity.Member;
import lk.ijse.library_management.projection.AdminTransactionProjection;
import lk.ijse.library_management.projection.MemberTransactionProjection;
import lk.ijse.library_management.repository.RepositoryFactory;
import lk.ijse.library_management.repository.custom.BookRepository;
import lk.ijse.library_management.repository.custom.BranchRepository;
import lk.ijse.library_management.repository.custom.MemberRepository;
import lk.ijse.library_management.repository.custom.TransactionRepository;
import lk.ijse.library_management.repository.custom.impl.BookRepositoryImpl;
import lk.ijse.library_management.repository.custom.impl.BranchRepositoryImpl;
import lk.ijse.library_management.repository.custom.impl.MemberRepositoryImpl;
import lk.ijse.library_management.repository.custom.impl.TransactionRepositoryImpl;
import lk.ijse.library_management.service.custom.DashboardService;
import lk.ijse.library_management.util.SessionFactoryConfig;
import org.hibernate.Session;

import java.util.List;

public class DashboardServiceImpl implements DashboardService {

    private Session session;

    private final BookRepository bookRepository =
            (BookRepositoryImpl) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.BOOK);

    private final MemberRepository memberRepository =
            (MemberRepositoryImpl) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.MEMBER);

    private final TransactionRepository transactionRepository =
            (TransactionRepositoryImpl) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.TRANSACTION);

    private final BranchRepository branchRepository =
            (BranchRepositoryImpl) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.BRANCH);


    @Override
    public int getMemberCount() {
        session = SessionFactoryConfig.getInstance().getSession();

        try {

            memberRepository.setSession(session);
            int count = memberRepository.getCount();
            return count;

        } catch (Exception e) {

            e.printStackTrace();
            return -1;

        } finally {
            session.close();
        }
    }

    @Override
    public int getBookCount() {
        session = SessionFactoryConfig.getInstance().getSession();

        try {

            bookRepository.setSession(session);
            int count = bookRepository.getCount();
            return count;

        } catch (Exception e) {

            e.printStackTrace();
            return -1;

        } finally {
            session.close();
        }
    }

    @Override
    public int getDueTransactionCount() {
        session = SessionFactoryConfig.getInstance().getSession();

        try {

            transactionRepository.setSession(session);
            int count = transactionRepository.getDueCount();
            return count;

        } catch (Exception e) {

            e.printStackTrace();
            return -1;

        } finally {
            session.close();
        }
    }

    @Override
    public int getBranchCount() {
        session = SessionFactoryConfig.getInstance().getSession();

        try {

            branchRepository.setSession(session);
            int count = branchRepository.getCount();
            return count;

        } catch (Exception e) {

            e.printStackTrace();
            return -1;

        } finally {
            session.close();
        }
    }

    @Override
    public List<AdminTransactionProjection> getAllTransactions() {
        session = SessionFactoryConfig.getInstance().getSession();

        try {

            transactionRepository.setSession(session);
            List<AdminTransactionProjection> list = transactionRepository.getAllTransactionProjection();

            return list;

        } catch (Exception e) {

            return null;

        } finally {
            session.close();
        }
    }

    @Override
    public int getMemberIdFormMobile(String mobile) {
        session = SessionFactoryConfig.getInstance().getSession();

        try {
            memberRepository.setSession(session);

            int id  = memberRepository.getIdFormMobile(mobile);

            return id;

        } catch (Exception e) {

            e.printStackTrace();
            return -1;

        } finally {
            session.close();
        }
    }

    @Override
    public int getMemberIdFormUsername(String username) {
        session = SessionFactoryConfig.getInstance().getSession();

        try {
            memberRepository.setSession(session);

            int id  = memberRepository.getIdFormUsername(username);

            return id;

        } catch (Exception e) {

            e.printStackTrace();
            return -1;

        } finally {
            session.close();
        }
    }

    @Override
    public MemberDto getMemberData(int id) {
        session = SessionFactoryConfig.getInstance().getSession();

        try {
            memberRepository.setSession(session);

            Member entity  = memberRepository.get(id);

            return entity.toDto();

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        } finally {
            session.close();
        }
    }

    @Override
    public int getMemberReadBookCount(MemberDto dto) {
        session = SessionFactoryConfig.getInstance().getSession();

        try {
            transactionRepository.setSession(session);

            int count  = transactionRepository.getReturnBookCountOfMember(dto.toEntity());

            return count;

        } catch (Exception e) {

            e.printStackTrace();
            return -1;

        } finally {
            session.close();
        }
    }

    @Override
    public int getMemberReturnedCount(MemberDto dto) {
        session = SessionFactoryConfig.getInstance().getSession();

        try {
            transactionRepository.setSession(session);

            int count  = transactionRepository.getReturnedCountOfMember(dto.toEntity());

            return count;

        } catch (Exception e) {

            e.printStackTrace();
            return -1;

        } finally {
            session.close();
        }
    }

    @Override
    public int getMemberDueCount(MemberDto dto) {
        session = SessionFactoryConfig.getInstance().getSession();

        try {
            transactionRepository.setSession(session);

            int count  = transactionRepository.getDueCountOfMember(dto.toEntity());

            return count;

        } catch (Exception e) {

            e.printStackTrace();
            return -1;

        } finally {
            session.close();
        }
    }

    @Override
    public List<MemberTransactionProjection> getAllTransactionsOfMember(MemberDto dto) {
        session = SessionFactoryConfig.getInstance().getSession();

        try {

            transactionRepository.setSession(session);
            List<MemberTransactionProjection> list = transactionRepository.getAllTransactionProjectionOfMember(dto.toEntity());

            return list;

        } catch (Exception e) {

            return null;

        } finally {
            session.close();
        }
    }

    @Override
    public int getMemberBorrowBookCount(MemberDto dto) {
        session = SessionFactoryConfig.getInstance().getSession();

        try {
            transactionRepository.setSession(session);

            int count  = transactionRepository.getBorrowBookCountOfMember(dto.toEntity());

            return count;

        } catch (Exception e) {

            e.printStackTrace();
            return -1;

        } finally {
            session.close();
        }
    }
}
