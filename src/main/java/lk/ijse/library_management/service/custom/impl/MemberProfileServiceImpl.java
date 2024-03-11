package lk.ijse.library_management.service.custom.impl;

import lk.ijse.library_management.dto.AdminDto;
import lk.ijse.library_management.dto.MemberDto;
import lk.ijse.library_management.entity.Admin;
import lk.ijse.library_management.entity.Member;
import lk.ijse.library_management.repository.RepositoryFactory;
import lk.ijse.library_management.repository.custom.MemberRepository;
import lk.ijse.library_management.repository.custom.impl.MemberRepositoryImpl;
import lk.ijse.library_management.service.custom.MemberProfileService;
import lk.ijse.library_management.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MemberProfileServiceImpl implements MemberProfileService {

    private Session session;

    private final MemberRepository memberRepository =
            (MemberRepositoryImpl) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.MEMBER);

    @Override
    public int getIdFromUsername(String username) {
        session = SessionFactoryConfig.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        try {

            memberRepository.setSession(session);
            int id = memberRepository.getIdFormUsername(username);
            transaction.commit();
            return id;

        } catch (Exception e) {

            transaction.rollback();
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

            Member member = memberRepository.get(id);

            return member.toDto();

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        } finally {
            session.close();
        }
    }

    @Override
    public int getIdFromUsernamePassword(String username, String password) {
        session = SessionFactoryConfig.getInstance().getSession();

        try {

            memberRepository.setSession(session);
            int id = memberRepository.getIdFormUsernamePassword(username, password);
            return id;

        } catch (Exception e) {

            e.printStackTrace();
            return -1;

        } finally {
            session.close();
        }
    }

    @Override
    public void deleteMember(int id) {
        MemberDto dto = getMemberData(id);

        session = SessionFactoryConfig.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        try {

            memberRepository.setSession(session);
            memberRepository.delete(dto.toEntity());
            transaction.commit();

        } catch (Exception e) {

            transaction.rollback();
            e.printStackTrace();

        } finally {
            session.close();
        }
    }

    @Override
    public boolean updateMemberPassword(int id, String currentPass, String newPass) {
        MemberDto dto = getMemberData(id);

        if (currentPass.equals(dto.getPassword())) {

            dto.setPassword(newPass);

            session = SessionFactoryConfig.getInstance().getSession();

            Transaction transaction = session.beginTransaction();

            try {

                memberRepository.setSession(session);
                memberRepository.update(dto.toEntity());
                transaction.commit();
                return true;

            } catch (Exception e) {

                transaction.rollback();
                e.printStackTrace();
                return false;

            } finally {
                session.close();
            }
        } else {
            return false;
        }
    }
}
