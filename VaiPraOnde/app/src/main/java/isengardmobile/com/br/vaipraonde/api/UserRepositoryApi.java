package isengardmobile.com.br.vaipraonde.api;

import com.parse.ParseException;

import isengardmobile.com.br.vaipraonde.model.User;

/**
 * Created by danilo on 8/26/15.
 */
public interface UserRepositoryApi {

    void create(User user) throws ParseException;

}
