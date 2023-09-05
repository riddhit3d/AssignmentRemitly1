package com.cybage.LoginT;

import static org.junit.Assert.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.cybage.entity.User;
import com.cybage.repo.UserRepository;

	


	@SpringBootTest
	@AutoConfigureMockMvc
	class Test {


	    @Autowired
	    private MockMvc mockMvc;

	    @Autowired
	    private UserRepository userRepository;

	    @org.junit.jupiter.api.Test
	    public void testRegisterUser_Success(String firstname, String password) throws Exception {

	        // Act & Assert
	        mockMvc.perform(MockMvcRequestBuilders.post("/register")
//	                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
	                .param("firstName", firstname)
	                .param("password", password))
	                .andExpect(MockMvcResultMatchers.status().isOk());

	        User registeredUser = userRepository.findByfirstName(firstname);
	        assertNotNull(registeredUser);
	    }
	}



	

//	    @Test
//	    public void testRegistration() throws Exception {
//	        User user = new User(null, null, null, null, null, null);
//	        user.setFirstName("testuser");
//	        user.setPasword("testpassword");
//
//	        Mock.perform(post("/register")
//	                .param("username", "testuser")
//	                .param("password", "testpassword"))
//	                .andExpect(status().is3xxRedirection())
//	                .andExpect(redirectedUrl("/login"));
//
//	        verify(userService, times(1)).save(user);
//	    }
	


