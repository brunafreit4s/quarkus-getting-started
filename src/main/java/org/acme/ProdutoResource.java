package org.acme;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/produtos")
@Produces (MediaType.APPLICATION_JSON)
@Consumes (MediaType.APPLICATION_JSON)
public class ProdutoResource {
    
    /**
     * Retorna todos os produtos cadastrados
     * @return Lista de produtos
    */
    @GET
    public List<Produto> bucarTodos() {
        return Produto.listAll();
    }
}
