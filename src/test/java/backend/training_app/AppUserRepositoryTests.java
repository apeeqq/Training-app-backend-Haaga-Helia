package backend.training_app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import backend.training_app.domain.AppUser;
import backend.training_app.domain.AppUserRepository;

@DataJpaTest
public class AppUserRepositoryTests {

    @Autowired 
    private AppUserRepository appUserRepository;

     @Test 
    public void createNewUser() {
        AppUser testuser1 = new AppUser("testuser1", "$2a$10$tfnoGqssuL83icJV3mTR/OmwGQbH56PIkvGDLmH1bl0cc2USLzYoe", "testuser1@testuser1.com", "USER");
        AppUser testuser2 = new AppUser("testuser2", "$2a$10$AFxV7mcM8Vvc1.TTZ7v2xuY2scb2Aj8WB6j7S5nutwtPk93yVhpOe", "testuser2@testuser2.com", "ADMIN");
        appUserRepository.save(testuser1);
        appUserRepository.save(testuser2);
        assertThat(testuser1.getId()).isNotNull();
        assertThat(testuser2.getId()).isNotNull();
    }

    @Test 
    public void deleteUser() {
        AppUser testuser1 = new AppUser("testuser1", "$2a$10$tfnoGqssuL83icJV3mTR/OmwGQbH56PIkvGDLmH1bl0cc2USLzYoe", "testuser1@testuser1.com", "USER");
        AppUser testuser2 = new AppUser("testuser2", "$2a$10$AFxV7mcM8Vvc1.TTZ7v2xuY2scb2Aj8WB6j7S5nutwtPk93yVhpOe", "testuser2@testuser2.com", "ADMIN");
        appUserRepository.save(testuser1);
        appUserRepository.save(testuser2);
        assertThat(testuser1.getId()).isNotNull();
        assertThat(testuser2.getId()).isNotNull();
        appUserRepository.deleteById(testuser1.getId());
        appUserRepository.deleteById(testuser2.getId());
        assertThat(appUserRepository.findById(testuser1.getId())).isEmpty();
        assertThat(appUserRepository.findById(testuser2.getId())).isEmpty();
    }

    @Test 
    public void searchUser() {
        AppUser appUser1 = appUserRepository.findByUsername("admin");
        AppUser appUser2 = appUserRepository.findByUsername("typical-guy");

        assertThat(appUser1.getUsername()).isEqualTo("admin");
        assertThat(appUser2.getUsername()).isEqualTo("typical-guy");
    }

}
