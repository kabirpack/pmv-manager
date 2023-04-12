package com.app.pmvmanager.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class AuthenticationService {

    @Autowired
    PmvUserRepository userRepository;

    public AuthenticationResponseDto authenticate(AuthenticationRequestDto authenticationRequestDto) throws NoSuchAlgorithmException {

      PmvUser user = userRepository.findByUserName(authenticationRequestDto.getUserName());
      String passwordToAuth = authenticationRequestDto.getPassword();
      String hash = user.getPassword().toUpperCase();
      MessageDigest md = MessageDigest.getInstance("MD5");
      md.update(passwordToAuth.getBytes());
      byte[] digest = md.digest();
      String myHash = DatatypeConverter
              .printHexBinary(digest).toUpperCase();
      if(myHash.equals(hash)){
          return new AuthenticationResponseDto(user.getUserId(), user.getUserName(), user.getUserRole());
      }

      return errorMessage("User Not Found");
    }

    public AuthenticationResponseDto errorMessage(String errorMsg) {

        AuthenticationResponseDto errorDto = new AuthenticationResponseDto();
        errorDto.setErrorMessage(errorMsg);
        return errorDto;
    }

    public int[] getDriverIdList(){
        return userRepository.findDriverIds();
    }
}
