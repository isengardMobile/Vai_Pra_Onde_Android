package isengardmobile.com.br.vaipraonde.impl;

import com.parse.ParseException;
import com.parse.ParseObject;

import isengardmobile.com.br.vaipraonde.api.UserRepositoryApi;
import isengardmobile.com.br.vaipraonde.model.User;

/**
 * Created by danilo on 8/26/15.
 */
public class UserRepositoryImpl implements UserRepositoryApi {
    @Override
    public void create(User user) throws ParseException {
        ParseObject parseObject = new ParseObject("User");

        parseObject.put("nome", user.getName());
        parseObject.put("sobrenome", user.getLastName());
        parseObject.put("celular", user.getCell());
        parseObject.put("email", user.getEmail());
        parseObject.put("sexo", user.getSex());
        parseObject.put("dataNascimento", user.getBirthday());
        parseObject.put("cidadeNatal", user.getCity());
        parseObject.put("password", user.getPass());

        parseObject.save();
    }
}
