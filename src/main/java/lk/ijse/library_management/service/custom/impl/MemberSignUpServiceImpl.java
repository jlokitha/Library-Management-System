package lk.ijse.library_management.service.custom.impl;

import lk.ijse.library_management.dto.MemberDto;
import lk.ijse.library_management.repository.RepositoryFactory;
import lk.ijse.library_management.repository.custom.MemberRepository;
import lk.ijse.library_management.repository.custom.impl.MemberRepositoryImpl;
import lk.ijse.library_management.service.custom.MemberSignUpService;
import lk.ijse.library_management.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MemberSignUpServiceImpl implements MemberSignUpService {

    private Session session;

    private final MemberRepository memberRepository =
            (MemberRepositoryImpl) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.MEMBER);

    @Override
    public boolean saveMember(MemberDto memberDto) {
        session = SessionFactoryConfig.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        try {

            memberRepository.setSession(session);
            int id = memberRepository.save(memberDto.toEntity());
            transaction.commit();
            return id > 0;

        } catch (Exception e) {

            transaction.rollback();
            e.printStackTrace();
            return false;

        } finally {
            session.close();
        }
    }
}
