package br.com.caelum.ingresso.helper;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.model.NotFoundException;
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

	public Optional<Token> getTokenFrom(String uuid) {
		return Optional.of(this.tokenDao.findByUuid(uuid)
				.orElseThrow(() -> new NotFoundException("Not Found")));
	}
}
