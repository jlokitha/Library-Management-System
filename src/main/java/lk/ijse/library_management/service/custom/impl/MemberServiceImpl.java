package lk.ijse.library_management.service.custom.impl;

import lk.ijse.library_management.dto.MemberDto;
import lk.ijse.library_management.entity.Member;
import lk.ijse.library_management.repository.RepositoryFactory;
import lk.ijse.library_management.repository.custom.MemberRepository;
import lk.ijse.library_management.repository.custom.TransactionRepository;
import lk.ijse.library_management.repository.custom.impl.MemberRepositoryImpl;
import lk.ijse.library_management.repository.custom.impl.TransactionRepositoryImpl;
import lk.ijse.library_management.service.custom.MemberService;
import lk.ijse.library_management.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MemberServiceImpl implements MemberService {

    private Session session;

    private final MemberRepository memberRepository =
            (MemberRepositoryImpl) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.MEMBER);

    private final TransactionRepository transactionRepository =
            (TransactionRepositoryImpl) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.TRANSACTION);

    @Override
    public MemberDto getMemberData(int id) {

        session = SessionFactoryConfig.getInstance().getSession();

        try {
            memberRepository.setSession(session);

            Member member = memberRepository.get(id);

            return member.toDto();

        } catch (Exception e) {

            return null;

        } finally {
            session.close();
        }
    }

    @Override
    public List<MemberDto> getAllMemberData() {
        session = SessionFactoryConfig.getInstance().getSession();

        try {
            memberRepository.setSession(session);

            List<Member> mData = memberRepository.getAll();

            List<MemberDto> dtos = new ArrayList<>();

            for (Member member : mData) {
                dtos.add(member.toDto());
            }
            return dtos;

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        } finally {
            session.close();
        }
    }

    @Override
    public boolean deleteTransactionsOfMember(Member member) {
        session = SessionFactoryConfig.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        try {
            transactionRepository.setSession(session);
            List<lk.ijse.library_management.entity.Transaction> allToMember = transactionRepository.getAllToMember(member);

            for (lk.ijse.library_management.entity.Transaction entity : allToMember) {
                transactionRepository.setSession(session);
                transactionRepository.delete(entity);
            }

            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean deleteMember(int id) {
        Member dto = getMemberData(id).toEntity();

        boolean isDelelted = deleteTransactionsOfMember(dto);

        session = SessionFactoryConfig.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        try {
            memberRepository.setSession(session);
            memberRepository.delete(dto);

            transaction.commit();

            return true;

        } catch (Exception e) {

            transaction.rollback();
            e.printStackTrace();
            return false;

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
}
