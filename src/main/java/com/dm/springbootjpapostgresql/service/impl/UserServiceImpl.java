package com.dm.springbootjpapostgresql.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.dm.springbootjpapostgresql.model.montaji.CompanyDetails;
import com.dm.springbootjpapostgresql.dto.montaji.UserCreateRequestDto;
import com.dm.springbootjpapostgresql.dto.montaji.UserCreateResponseDto;
import com.dm.springbootjpapostgresql.dto.montaji.UserFetchAllResponseDto;
import com.dm.springbootjpapostgresql.exception.ResourceNotFoundException;
import com.dm.springbootjpapostgresql.model.montaji.enumeration.IdType;
import com.dm.springbootjpapostgresql.model.montaji.Nationality;
import com.dm.springbootjpapostgresql.model.montaji.User;
import com.dm.springbootjpapostgresql.model.montaji.enumeration.Gender;
import com.dm.springbootjpapostgresql.repository.montaji.CompanyDetailsRepository;
import com.dm.springbootjpapostgresql.repository.montaji.NationalityRepository;
import com.dm.springbootjpapostgresql.repository.montaji.UserRepository;
import com.dm.springbootjpapostgresql.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
	private UserRepository userRepository;
    @Autowired
	private NationalityRepository nationalityRepository;   
    @Autowired
    CompanyDetailsRepository companyDetailsRepository;    

    @Override
    public List<UserFetchAllResponseDto> getAllUsers()
    {
        List<UserFetchAllResponseDto> userFetchAllResponseDtoList = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for(User user:users)
        {
            UserFetchAllResponseDto userFetchAllResponseDto=UserFetchAllResponseDto.builder()
                                                                                    .userId(user.getUserId())
                                                                                    .userName(user.getUserName())
                                                                                    .userType(user.getUserType())
                                                                                    .firstName(user.getFirstName())
                                                                                    .firstNameAr(user.getFirstNameAr())
                                                                                    .lastName(user.getLastName())
                                                                                    .lastNameAr(user.getLastNameAr())
                                                                                    .fullName(user.getFirstName()+' '+user.getLastName())
                                                                                    .fullNameAr(user.getFirstNameAr()+' '+user.getLastNameAr())
                                                                                    .emailId(user.getEmailId())
                                                                                    .mobileNo(user.getMobileNo())
                                                                                    .active(user.getActive())
                                                                                    .idType(user.getIdType().getSymbol())
                                                                                    .idTypeName(user.getIdType().getName())
                                                                                    .idNumber(user.getIdNumber())
                                                                                    .idExpiryDate(user.getIdExpiryDate())
                                                                                    .gender(user.getGender().getName())
                                                                                    .nationalityId(user.getNationality().getNationalityId())
                                                                                    .nationalityNameEn(user.getNationality().getNationalityNameEn())
                                                                                    .nationalityNameAr(user.getNationality().getNationalityNameAr())
                                                                                    .dob(user.getDob())
                                                                                    //.age()
                                                                                    .licenseNumber(user.getCompanyDetails().getLicenseNumber())
                                                                                    .companyName(user.getCompanyDetails().getCompanyName())
                                                                                    .build();

            userFetchAllResponseDtoList.add(userFetchAllResponseDto);

        }
        return userFetchAllResponseDtoList;
    }


    @Override
    public UserCreateResponseDto createUser(UserCreateRequestDto userCreateRequestDto) {
        System.out.println("Inside createUser service");

        Nationality nationality = nationalityRepository.findById(userCreateRequestDto.getNationalityId())
        .orElseThrow(() -> new ResourceNotFoundException("Nationality", "id", userCreateRequestDto.getNationalityId()));
        //IdType idType2 = IdType.fromSymbol(userCreateRequestDto.getIdType());

        //CompanyDetails companyDetails = companyDetailsRepository.findByLicenseNumber(userCreateRequestDto.getLicenseNumber()).orElse(null);
        CompanyDetails companyDetails = companyDetailsRepository.findByLicenseNumber(userCreateRequestDto.getLicenseNumber())
        .orElseThrow(()->new ResourceNotFoundException("CompanyDetails","licenseNumber",userCreateRequestDto.getLicenseNumber()));

        User user = User.builder()
                        .userName(userCreateRequestDto.getUserName())
                        .firstName(userCreateRequestDto.getFirstName())
                        .firstNameAr(userCreateRequestDto.getFirstNameAr())
                        .lastName(userCreateRequestDto.getLastName())
                        .lastNameAr(userCreateRequestDto.getLastNameAr())
                        .emailId(userCreateRequestDto.getEmailId())
                        .mobileNo(userCreateRequestDto.getMobileNo())
                        .active(true)
                        .idType(IdType.fromSymbol(userCreateRequestDto.getIdType()))
                        .idNumber(userCreateRequestDto.getIdNumber())
                        .idExpiryDate(userCreateRequestDto.getIdExpiryDate())
                        .gender(Gender.fromSymbol(userCreateRequestDto.getGender()))
                        .nationality(nationality)
                        .dob(userCreateRequestDto.getDob())
                        .companyDetails(companyDetails)
                        .build();
                        
        userRepository.save(user);

        UserCreateResponseDto userCreateResponseDto = UserCreateResponseDto.builder()
                                                        .isSuccess("true")
                                                        .errorCode("000")
                                                        .errorDescription("No error")
                                                        .build();
        
        System.out.println("End of createUser service");
        return userCreateResponseDto;
    }
    
}
