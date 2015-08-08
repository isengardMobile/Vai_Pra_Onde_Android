package isengardmobile.com.br.vaipraonde.impl;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import isengardmobile.com.br.vaipraonde.api.StatesRepositoryApi;
import isengardmobile.com.br.vaipraonde.model.States;

/**
 * Created by danilo on 08/08/15.
 */
public class StasteRepositoryApiImpl implements StatesRepositoryApi{
    @Override
    public List<States> findAll() {

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Estados");
        List<ParseObject> estadosParse = new ArrayList<ParseObject>();
        List<States> estados = new ArrayList<States>();
        try {
            estadosParse = query.find();
            for(ParseObject estadoParse : estadosParse){
                States estado = new States();
                estado.setObjectId(estadoParse.getObjectId());
                estado.setDescricao(estadoParse.getString("Descricao"));
                estado.setUf(estadoParse.getString("UF"));

                estados.add(estado);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return estados;
    }
}
