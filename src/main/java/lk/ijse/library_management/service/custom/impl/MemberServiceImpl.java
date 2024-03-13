package lk.ijse.library_management.service.custom.impl;

import lk.ijse.library_management.dto.MemberDto;
import lk.ijse.library_management.entity.Member;
import lk.ijse.library_management.repository.RepositoryFactory;
import lk.ijse.library_management.repository.custom.MemberRepository;
import lk.ijse.library_management.repository.custom.impl.MemberRepositoryImpl;
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
    public boolean deleteMember(int id) {
        MemberDto dto = getMemberData(id);

        session = SessionFactoryConfig.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        try {

            memberRepository.setSession(session);

            memberRepository.delete(dto.toEntity());

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
