package backend.training_app.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import backend.training_app.domain.AppUser;
import backend.training_app.domain.AppUserRepository;

@Service 
public class UserDetailServiceImpl implements UserDetailsService {

    private final AppUserRepository aRepository;

    public UserDetailServiceImpl(AppUserRepository aRepository) {
        this.aRepository = aRepository;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser curruser = aRepository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username,curruser.getPasswordHash(),
		AuthorityUtils.createAuthorityList(curruser.getRole()));
		return user;
    }

}
