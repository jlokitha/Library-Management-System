package lk.ijse.library_management.service.custom.impl;

import lk.ijse.library_management.dto.BookDto;
import lk.ijse.library_management.dto.MemberDto;
import lk.ijse.library_management.dto.TransactionDetailsDto;
import lk.ijse.library_management.dto.TransactionDto;
import lk.ijse.library_management.embedded.TransactionDetailPK;
import lk.ijse.library_management.entity.Book;
import lk.ijse.library_management.entity.Member;
import lk.ijse.library_management.entity.Transaction;
import lk.ijse.library_management.entity.TransactionDetails;
import lk.ijse.library_management.repository.RepositoryFactory;
import lk.ijse.library_management.repository.custom.BookRepository;
import lk.ijse.library_management.repository.custom.MemberRepository;
import lk.ijse.library_management.repository.custom.TransactionDetailRepository;
import lk.ijse.library_management.repository.custom.TransactionRepository;
import lk.ijse.library_management.repository.custom.impl.BookRepositoryImpl;
import lk.ijse.library_management.repository.custom.impl.MemberRepositoryImpl;
import lk.ijse.library_management.repository.custom.impl.TransactionDetailRepositoryImpl;
import lk.ijse.library_management.repository.custom.impl.TransactionRepositoryImpl;
import lk.ijse.library_management.service.custom.TransactionService;
import lk.ijse.library_management.util.SessionFactoryConfig;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {

    private Session session;

    private final BookRepository bookRepository =
            (BookRepositoryImpl) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.BOOK);

    private final TransactionRepository transactionRepository =
            (TransactionRepositoryImpl) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.TRANSACTION);

    private final TransactionDetailRepository transactionDetailRepository =
            (TransactionDetailRepositoryImpl) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.TRANSACTIONDETAILS);

    private final MemberRepository memberRepository =
            (MemberRepositoryImpl) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.MEMBER);

    @Override
    public List<String> getAllBookTitles() {
        session = SessionFactoryConfig.getInstance().getSession();

        try {

            bookRepository.setSession(session);
            List<String> titles = bookRepository.getAllTitles();
            return titles;

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        } finally {
            session.close();
        }
    }

    @Override
    public BookDto getBookDataFromTitle(String title) {
        session = SessionFactoryConfig.getInstance().getSession();

        try {

            bookRepository.setSession(session);
            Book book = bookRepository.getBookFormTitle(title);
            return book.toDto();

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        } finally {
            session.close();
        }
    }

    @Override
    public boolean saveTransaction(TransactionDto dto, MemberDto member, List<BookDto> books) {
        dto.setMember(member);
        Transaction entity = dto.toEntity();

        session = SessionFactoryConfig.getInstance().getSession();
        org.hibernate.Transaction transaction = session.beginTransaction();

        try {

            transactionRepository.setSession(session);
            int id = transactionRepository.save(entity);

            for (BookDto bookDto : books) {

                bookDto.setAvailability("Not Available");
                bookRepository.setSession(session);
                bookRepository.update(bookDto.toEntity());

                session.clear();

                transactionDetailRepository.setSession(session);
                TransactionDetailPK pk = transactionDetailRepository.save(new TransactionDetails(
                        new TransactionDetailPK(entity.getId(), bookDto.getId()),
                        entity,
                        bookDto.toEntity()
                ));
            }

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
    public MemberDto getMemberFromUsername(String username) {
        session = SessionFactoryConfig.getInstance().getSession();

        try {

            memberRepository.setSession(session);
            int id = memberRepository.getIdFormUsername(username);
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
    public String getBookAuthorFromTitle(String title) {
        session = SessionFactoryConfig.getInstance().getSession();

        try {

            bookRepository.setSession(session);
            String text = bookRepository.getAuthorFormTitle(title);
            return text;

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        } finally {
            session.close();
        }
    }

    @Override
    public List<TransactionDto> getAllTransactionData() {
        session = SessionFactoryConfig.getInstance().getSession();

        try {

            transactionRepository.setSession(session);
            List<Transaction> list = transactionRepository.getAll();

            List<TransactionDto> dto = new ArrayList<>();

            for (Transaction entity : list) {
                dto.add(entity.toDto());
            }

            return dto;

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        } finally {
            session.close();
        }
    }

    @Override
    public TransactionDto getTransactionData(int id) {
        session = SessionFactoryConfig.getInstance().getSession();

        try {

            transactionRepository.setSession(session);
            Transaction entity = transactionRepository.get(id);
            return entity.toDto();

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        } finally {
            session.close();
        }
    }

    @Override
    public List<TransactionDetailsDto> getTransactionDetails(TransactionDto dto) {
        session = SessionFactoryConfig.getInstance().getSession();

        try {

            transactionRepository.setSession(session);
            List<TransactionDetails> list = transactionRepository.getTransactionDetails(dto.toEntity());

            List<TransactionDetailsDto> dtos = new ArrayList<>();

            for (TransactionDetails detail : list) {
                dtos.add(detail.toDto());
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
    public boolean updateTransaction(int id) {

        TransactionDto transactionData = getTransactionData(id);
        List<TransactionDetailsDto> transactionDetails = getTransactionDetails(transactionData);

        session = SessionFactoryConfig.getInstance().getSession();
        org.hibernate.Transaction transaction = session.beginTransaction();

        try {

            transactionRepository.setSession(session);
            transactionData.setStatus("Returned");
            transactionRepository.update(transactionData.toEntity());

            for (TransactionDetailsDto transactionDetailsDto : transactionDetails) {

                transactionDetailsDto.getBook().setAvailability("Available");
                bookRepository.setSession(session);
                bookRepository.update(transactionDetailsDto.getBook().toEntity());
            }

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
    public List<TransactionDto> getAllTransactionDataToUsername(String username) {
        MemberDto member = getMemberFromUsername(username);

        session = SessionFactoryConfig.getInstance().getSession();

        try {

            transactionRepository.setSession(session);
            List<Transaction> list = transactionRepository.getAllToMember(member.toEntity());

            List<TransactionDto> dto = new ArrayList<>();

            for (Transaction entity : list) {
                dto.add(entity.toDto());
            }

            return dto;

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        } finally {
            session.close();
        }
    }

    @Override
    public void updateTransactionStatus(List<TransactionDto> updateList) {
        session = SessionFactoryConfig.getInstance().getSession();

        org.hibernate.Transaction transaction = session.beginTransaction();

        try {

            transactionRepository.setSession(session);

            for (TransactionDto transactionDto : updateList) {
                transactionRepository.update(transactionDto.toEntity());
            }

            transaction.commit();

        } catch (Exception e) {

            transaction.rollback();
            e.printStackTrace();

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
    public List<TransactionDto> getAllTransactionDataToId(int id) {
        MemberDto member = getMemberData(id);

        session = SessionFactoryConfig.getInstance().getSession();

        try {

            transactionRepository.setSession(session);
            List<Transaction> list = transactionRepository.getAllToMember(member.toEntity());

            List<TransactionDto> dto = new ArrayList<>();

            for (Transaction entity : list) {
                dto.add(entity.toDto());
            }

            return dto;

        } catch (Exception e) {

            e.printStackTrace();
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

            int id = memberRepository.getIdFormMobile(mobile);

            return id;

        } catch (Exception e) {

            e.printStackTrace();
            return -1;

        } finally {
            session.close();
        }
    }
}
