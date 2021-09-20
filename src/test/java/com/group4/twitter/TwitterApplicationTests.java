package com.group4.twitter;

import com.group4.twitter.Controllers.HomeController;
import com.group4.twitter.Controllers.MessageController;
import com.group4.twitter.Controllers.TweetsController;
import com.group4.twitter.Controllers.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class TwitterApplicationTests {
	@Autowired
	public HomeController home;
	@Autowired
	public UserController user;
	@Autowired
	public TweetsController tweet;
	@Autowired
	public MessageController message;

	@Test
	void checkHomeController(){
		assertThat(home).isNotNull();
	}
	@Test
	void checkUserController(){
		assertThat(user).isNotNull();
	}
	@Test
	void checkTweetController(){
		assertThat(tweet).isNotNull();
	}
	@Test
	void checkMessageController(){
		assertThat(message).isNotNull();
	}

}
