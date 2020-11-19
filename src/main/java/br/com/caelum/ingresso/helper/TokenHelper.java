package br.com.caelum.ingresso.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.caelum.ingresso.auth.Token;
import br.com.caelum.ingresso.dao.TokenDao;

@Component
public class TokenHelper {

	@Autowired
	private TokenDao tokenDao;

	public Token generateFrom(String email) {
		Token token = new Token(email);

		this.tokenDao.save(token);
		return token;
	}
}
