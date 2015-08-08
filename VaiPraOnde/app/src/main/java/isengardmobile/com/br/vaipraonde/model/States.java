package isengardmobile.com.br.vaipraonde.model;

import java.io.Serializable;

/**
 * Created by danilo on 08/08/15.
 */
public class States implements Serializable{

    private String objectId;
    private String uf;
    private String descricao;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
