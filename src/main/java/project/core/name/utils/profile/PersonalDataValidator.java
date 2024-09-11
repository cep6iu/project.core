package project.core.name.utils.profile;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import project.core.name.dto.identification.PersonalDataDTO;

@Component
public class PersonalDataValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return PersonalDataDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PersonalDataDTO personalData = (PersonalDataDTO) target;

        if (!isPhoneNumberValid(personalData.getPhoneNumber())) {
            errors.rejectValue("phoneNumber", null, "Phone number is invalid");
        }
    }

    public static boolean isPhoneNumberValid(String phone) {
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        Phonenumber.PhoneNumber phoneNumber = null;

        try {
            phoneNumber = phoneNumberUtil.parse(phone, "IN");
        } catch (NumberParseException e) {
            e.printStackTrace();
        }

        return phoneNumberUtil.isValidNumber(phoneNumber);
    }
}
