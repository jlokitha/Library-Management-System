package lk.ijse.library_management.service.custom.impl;

import lk.ijse.library_management.dto.MemberDto;
import lk.ijse.library_management.entity.Member;
import lk.ijse.library_management.repository.RepositoryFactory;
import lk.ijse.library_management.repository.custom.MemberRepository;
import lk.ijse.library_management.repository.custom.impl.MemberRepositoryImpl;
import lk.ijse.library_management.service.custom.MemberSignInService;
import lk.ijse.library_management.util.SendEmail;
import lk.ijse.library_management.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.mail.MessagingException;

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

    @Override
    public int getIdFormUsername(String username) {
        session = SessionFactoryConfig.getInstance().getSession();

        try {

            memberRepository.setSession(session);
            int id = memberRepository.getIdFormUsername(username);
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
    public void sendEmail(String... data) {
        SendEmail sendEmail = new SendEmail ();
        new Thread(()->{
            try {
                sendEmail.sendEmail(data[0], data[1], data[2], data[3]);
            } catch ( MessagingException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
