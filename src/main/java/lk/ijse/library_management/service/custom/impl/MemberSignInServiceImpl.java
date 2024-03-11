package lk.ijse.library_management.service.custom.impl;

import lk.ijse.library_management.repository.RepositoryFactory;
import lk.ijse.library_management.repository.custom.MemberRepository;
import lk.ijse.library_management.repository.custom.impl.MemberRepositoryImpl;
import lk.ijse.library_management.service.custom.MemberSignInService;
import lk.ijse.library_management.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MemberSignInServiceImpl implements MemberSignInService {

    private Session session;

    private final MemberRepository memberRepository =
            (MemberRepositoryImpl) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.MEMBER);

    @Override
    public int getIdFromUsernamePassword(String username, String password) {
        session = SessionFactoryConfig.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        try {

            memberRepository.setSession(session);
            int id = memberRepository.getIdFormUsernamePassword(username, password);
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
}
