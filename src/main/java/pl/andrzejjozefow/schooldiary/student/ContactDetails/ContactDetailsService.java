package pl.andrzejjozefow.schooldiary.student.ContactDetails;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ContactDetailsService {

  private final ContactDetailsRepository contactDetailsRepository;

  public ContactDetailsService(ContactDetailsRepository contactDetailsRepository) {
    this.contactDetailsRepository = contactDetailsRepository;
  }

  public void addContactDetails(ContactDetails contactDetails){
    contactDetailsRepository.save(contactDetails);
  }

  public ContactDetails getContactDetails(Integer id){
    return contactDetailsRepository.findOne(id);
  }

  public List<ContactDetails> getAllContactsDetails() {
    List<ContactDetails> contactsDetails = new ArrayList<>();
    contactDetailsRepository.findAll().forEach(contactsDetails::add);
    return contactsDetails;
  }
}
