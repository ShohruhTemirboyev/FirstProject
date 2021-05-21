package com.example.myportfoliyaapp.security;

import com.example.myportfoliyaapp.entity.User;
import com.example.myportfoliyaapp.entity.enam.RoleName;
import com.example.myportfoliyaapp.payloat.ApiJwtRespons;
import com.example.myportfoliyaapp.payloat.ApiResponseModel;
import com.example.myportfoliyaapp.payloat.ReqUser;
import com.example.myportfoliyaapp.payloat.ResUser;
import com.example.myportfoliyaapp.repository.RoleRepository;
import com.example.myportfoliyaapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    public ApiJwtRespons saveUser(ReqUser reqUser){

        ApiJwtRespons response=new ApiJwtRespons();
        try {
            if (!userRepository.existsByPhoneNumber(reqUser.getPhoneNumber())){
                User user=new User();
                user.setPhoneNumber(reqUser.getPhoneNumber());
                user.setPassword(passwordEncoder.encode(reqUser.getPassword()));
                user.setUserfullName(reqUser.getUserName());
                user.setBirthDate(reqUser.getBirthDate());
                user.setRoles((Collections.singletonList(roleRepository.findByRoleName(RoleName.ROLE_USER))));
                userRepository.save(user);
                response.setMessage("User ro'yhatdan o'tkazildi");
                response.setSuccess(true);
                response.setUserId(user.getId());

        }
            else {
                response.setMessage("Bunday User mavjud");
                response.setSuccess(false);
            }
        }
        catch (Exception ex){
         response.setSuccess(false);
         response.setMessage("Userni Saqlashda xatolik!!!");
        }
        return response;
    }
    public ResUser getUser(User user){
        return new ResUser(
                user.getPhoneNumber(),
                user.getPassword(),
                user.getUserfullName(),
                user.getBirthDate()
        );
    }


    @Override
    public UserDetails loadUserByUsername(String number) throws UsernameNotFoundException {
        return userRepository.findByPhoneNumber(number);
    }

    public UserDetails loadUserByUserId(UUID id) {
    return userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User id no validate"));
    }
}
