package br.com.caelum.livraria.tx;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import java.io.Serializable;

@Transacional
@Interceptor
public class GerenciadorDeTransacao implements Serializable {

    @Inject
    EntityManager manager;

    @AroundInvoke
    public Object executaTx(InvocationContext context) throws Exception {
        // abre transacao
        manager.getTransaction().begin();

        // chama os daos que precisam de uma TX
        Object result = context.proceed();

        // commita a transacao
        manager.getTransaction().commit();

        return result;
    }
}
